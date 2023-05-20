import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Booking newBook = new Booking();

        while(true){
            System.out.println("1. Book \n2. Cancel \n3. Print \n4. Available \n5. Exit");
            String option = in.next();
            if(option.startsWith("5")){
                break;
            }
            else if(option.startsWith("1")){
                System.out.println("Enter your name:");
                String name = in.next();
                System.out.println("Enter your age:");
                int age = in.nextInt();
                System.out.println("Enter your berth preference: LB (lower) or MB (middle) or UB (upper)");
                String berthInfo = in.next();
                if(berthInfo.equals("LB")||berthInfo.equals("MB")||berthInfo.equals("UB")) {
                    Passenger p = new Passenger(name, age);
                    newBook.book(p, berthInfo);
                }
                else{
                    System.out.println("Invalid Response!!!");
                }
            }
            else if(option.startsWith("2")){
                System.out.println("Do you know your passenger ID? (Y/N)");
                String checking = in.next();
                if(checking.equals("N")){
                    System.out.println("Enter 3 to check all passenger");
                    continue;
                }
                else if(checking.equals("Y")){
                    System.out.println("Enter your passenger ID:");
                    int p_id = in.nextInt();
                    newBook.cancel(p_id);
                }
                else{
                    System.out.println("Invalid Response!!!");
                }
            }
            else if(option.startsWith("3")){
                newBook.print();
            }
            else if(option.startsWith("4")){
                newBook.availableTickets();
            }
            else{
                System.out.println("Invalid Response!!! \nEnter 5 to exit.");
            }
            System.out.println("     *****");
        }
    }
}