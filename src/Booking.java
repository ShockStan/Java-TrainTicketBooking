import java.util.*;
public class Booking {

    private int id=1;
    private int lowerBerth = 60; //total no of lower berth seats available
    private int middleBerth = 60; //total no of middle berth seats available
    private int upperBerth = 60; //total no of upper berth seats available
    private int racTickets = 20; //total no of rac seats available
    private int waitingList = 10; //total waiting list
    private int totalTickets = lowerBerth + middleBerth + upperBerth + racTickets + waitingList; //total no of tickets
    List<Passenger> total = new ArrayList<Passenger>(); //list of all passengers
    List<Passenger> LB = new ArrayList<Passenger>(); //list of passengers in lower berth
    List<Passenger> MB = new ArrayList<Passenger>(); //list of passengers in middle berth
    List<Passenger> UB = new ArrayList<Passenger>(); //list of passengers in upper berth
    Queue<Passenger> RAC = new ArrayDeque<Passenger>(); //list of passengers in rac
    Queue<Passenger> WL = new ArrayDeque<Passenger>(); //list of passengers in waiting list
    public void book(Passenger p, String berthInfo){
        //book ticket
        if(total.size()<totalTickets) {
            p.setId(id);
            id+=1;
            if (berthInfo.equals("LB")) {
                if (LB.size() < lowerBerth) {
                    p.setBerth("LB");
                    LB.add(p);
                    System.out.println("You got your preferred berth!!!");
                } else if (MB.size() < middleBerth) {
                    p.setBerth("MB");
                    MB.add(p);
                    System.out.println("The berth you asked is full. So booked available berth");
                } else if (UB.size() < upperBerth) {
                    p.setBerth("UB");
                    UB.add(p);
                    System.out.println("The berth you asked is full. So booked available berth");
                } else if (RAC.size() < racTickets) {
                    p.setBerth("RAC");
                    RAC.add(p);
                    System.out.println("ALl berths are full. You are in RAC");
                } else if (WL.size() < waitingList) {
                    p.setBerth("WL");
                    WL.add(p);
                    System.out.println("ALl berths are full & RAC is also full. You are in WL");
                }
            }
            else if (berthInfo.equals("MB")) {
                if (MB.size() < middleBerth) {
                    p.setBerth("MB");
                    MB.add(p);
                    System.out.println("You got your preferred berth!!!");
                } else if (LB.size() < lowerBerth) {
                    p.setBerth("LB");
                    LB.add(p);
                    System.out.println("The berth you asked is full. So booked available berth");
                } else if (UB.size() < upperBerth) {
                    p.setBerth("UB");
                    UB.add(p);
                    System.out.println("The berth you asked is full. So booked available berth");
                } else if (RAC.size() < racTickets) {
                    p.setBerth("RAC");
                    RAC.add(p);
                    System.out.println("ALl berths are full. You are in RAC");
                } else if (WL.size() < waitingList) {
                    p.setBerth("WL");
                    WL.add(p);
                    System.out.println("ALl berths are full & RAC is also full. You are in WL");
                }
            } else if(berthInfo.equals("UB")){
                if (UB.size() < upperBerth) {
                    p.setBerth("UB");
                    UB.add(p);
                    System.out.println("You got your preferred berth!!!");
                } else if (LB.size() < lowerBerth) {
                    p.setBerth("LB");
                    LB.add(p);
                    System.out.println("The berth you asked is full. So booked available berth");
                } else if (MB.size() < middleBerth) {
                    p.setBerth("MB");
                    MB.add(p);
                    System.out.println("The berth you asked is full. So booked available berth");
                } else if (RAC.size() < racTickets) {
                    p.setBerth("RAC");
                    RAC.add(p);
                    System.out.println("ALl berths are full. You are in RAC");
                } else if (WL.size() < waitingList) {
                    p.setBerth("WL");
                    WL.add(p);
                    System.out.println("ALl berths are full & RAC is also full. You are in WL");
                }
            }
            total.add(p);
            System.out.println("Ticket Booked Successfully\n"+p.toString());
        }
        else{
            System.out.println("No tickets available");
        }
    }
    public void availableTickets(){
        //show total no of available tickets in each berth
        System.out.println("Tickets available:");
        System.out.println("Lower Berth: "+(lowerBerth-LB.size())+
                "\nMiddle Berth: "+(middleBerth-MB.size())+
                "\nUpper Berth: "+(upperBerth-UB.size())+
                "\nRAC: "+(racTickets-RAC.size())+
                "\nWL: "+(waitingList-WL.size()));
    }
    public void print(){
        //print all details of passengers
        System.out.println("Total passengers count - "+total.size());
        for(Passenger p:total){
            System.out.println(p.toString());
            System.out.println("     xxxxx");
        }
    }
    public void cancel(int p_id){
        //cancel booked ticket
        int berth = 0;
        boolean cancelled = false;
        for(Passenger p:total){
            if(p.getId()==p_id){
                total.remove(p);
                if(p.getBerth().equals("LB")){
                    LB.remove(p);
                    berth = 1;
                }
                else if(p.getBerth().equals("MB")){
                    MB.remove(p);
                    berth = 2;
                }
                else {
                    UB.remove(p);
                    berth = 3;
                }
                cancelled = true;
                System.out.println("Ticket cancelled\n"+p.toString());
                break;
            }
        }
        if(cancelled) {
            if (RAC.size() > 0) {
                Passenger inRAC = RAC.poll();
                String[] berthList = {"LB","MB","UB"};
                if (berth == 1) {
                    inRAC.setBerth(berthList[berth-1]);
                    LB.add(inRAC);
                } else if (berth == 2) {
                    inRAC.setBerth(berthList[berth-1]);
                    MB.add(inRAC);
                } else {
                    inRAC.setBerth(berthList[berth-1]);
                    UB.add(inRAC);
                }
                System.out.println("Passenger upgraded to "+berthList[berth-1]+" from RAC");
            }
            if(WL.size()>0){
                Passenger inWL = WL.poll();
                inWL.setBerth("RAC");
                RAC.add(inWL);
                System.out.println("Passenger upgraded to RAC from WL");
            }
        }
        if(!cancelled){
            System.out.println("No passenger with id "+p_id);
        }
    }
}
