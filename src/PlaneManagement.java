
import java.util.*;
public class PlaneManagement {
    public static Scanner input = new Scanner(System.in);

    private static int [][] seats = new int[4][];

    private static final char[] row_letters = {'A','B','C','D'};
    private static final int[] prices = {200,150,180};

    private static final Ticket[] tickets =new Ticket[52];
    public static void main(String[] args)
    {

        initializeSeats();
        System.out.println("Welcome to the Plane Management application\n");

        int choice;

        do {
            try {

                displayMenu();
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        buy_seat();
                        break;
                    case 2:
                        cancel_seat();
                        break;
                    case 3:
                        find_first_available();
                        break;
                    case 4:
                        show_seating_plan();
                        break;
                    case 5:
                        print_ticket_info();
                        break;
                    case 6:
                        search_ticket();
                        break;
                    case 0:
                        System.out.println("Program Existing!");
                        break;

                }

            }catch (InputMismatchException e)
            {
                System.out.println("Please enter a valid integer.");
                input.nextLine();
                choice = -1;
            }

        }while (choice!= 0);
    }

    private static void initializeSeats()
    {
        seats[0] = new int[14];
        seats[1] = new int[12];
        seats[2] = new int[12];
        seats[3] = new int[14];

        for (int i = 0; i< 4;i++)                                     //represents available seats
        {
            for (int j= 0 ; j < seats[i].length;j++)
            {
                seats[i][j]=0;
            }
        }
    }
    public static void displayMenu()
    {
        
        // menu
        System.out.println("\n************************************************");
        System.out.println("*            " + "     MENU OPTIONS               " + "  *");
        System.out.println("************************************************");

        System.out.println("  1) Buy a seat");
        System.out.println("  2) Cancel a seat");
        System.out.println("  3) Find first available seat");
        System.out.println("  4) Show seating plan");
        System.out.println("  5) Print tickets information and total sales");
        System.out.println("  6) Search ticket");
        System.out.println("  0) Quit");

        System.out.println("***********************************************");
        System.out.print("\nPlease select an option: ");


    }
    public static void show_seating_plan()
    {
        System.out.println("\nSeat Plan");
        System.out.println(" ");
        for (int j = 1; j <= 14; j++) {
            System.out.print(" ");
            System.out.print(j );
        }
        System.out.println();

        for (int i = 0; i < 4; i++) {
            System.out.print(row_letters[i] + "  ");
            for (int j = 0; j < seats[i].length; j++) {
                if(seats[i][j] == 0)
                {
                    System.out.print("O ");
                }
                else
                {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }


    }
    public static void buy_seat()
    {
        while (true) {


            System.out.print("Enter a row letter: ");
            char rowLetter = input.next().toUpperCase().charAt(0);

            int row = -1;
            for (int i = 0; i < 4; i++) {
                if (row_letters[i] == rowLetter) {
                    row = i;
                    break;
                }
            }
            if (row == -1) {
                System.out.println("Invalid row letter.");
                return;
            }

            System.out.print("Enter a seat number: ");
            int seatNumber = input.nextInt();

            //Adjusting  the indices for array
            seatNumber--;


            // validation of seat
            if (seatNumber < 0 || seatNumber >= seats[0].length || seatNumber >= seats[1].length) {
                System.out.println("Invalid seat number.");
            } else if (seats[row][seatNumber] == 1) {
                System.out.println("Sorry, that seat is already booked.");

            } else {

                System.out.print("Enter passenger name: ");
                String pname = input.next();
                System.out.print("Enter passenger surname: ");
                String sname = input.next();
                System.out.print("Enter your email: ");
                String email = input.next();

                //prices of tickets
                int price ;
                if (seatNumber>0 && seatNumber<6)
                {
                    price = prices[0];
                    System.out.println("Ticket price: £"+ price);
                }
                else if (seatNumber> 5 && seatNumber <10)
                {
                    price = prices[1];
                    System.out.println("Ticket price: £"+price);
                }
                else {
                    price = prices[2];
                    System.out.println("Ticket price: £"+price);
                }


                Person person = new Person(pname,sname,email);
                Ticket ticket = new Ticket(rowLetter,seatNumber,price,person);


                //Adding ticket to the array of tickets
                for (int i = 0; i < tickets.length;i++)
                {
                    if (tickets[i] == null)
                    {
                        tickets[i]=ticket;
                        break;
                    }
                }
                ticket.save();
                seats[row][seatNumber] = 1;
                System.out.println("Seat " + rowLetter + (seatNumber + 1) + " booked successfully.");


            }
            System.out.print("Do you want to book another seat(yes/no): ");
            String choice = input.next();
            if (!choice.equalsIgnoreCase("yes"))
            {
                break;
            }
        }

    }

    public static void cancel_seat()
    {
        System.out.print("Enter a row letter: ");
        char rowLetter = input.next().toUpperCase().charAt(0);

        int row = -1;
        for (int i = 0; i < 4;i++)
        {
            if (row_letters[i]==rowLetter)
            {
                row = i;
                break;
            }
        }
        if (row==-1)
        {
            System.out.println("Invalid row letter.");
            return;
        }

        System.out.print("Enter a seat number: ");
        int seatNumber = input.nextInt();

        //Adjusting  the indices for array
        seatNumber--;

        if (seatNumber< 0 || seatNumber >=seats[0].length )
        {
            System.out.println("Sorry, that seat is already booked.");
        }
        else if(seats[row][seatNumber]==0)
        {
            System.out.println("This seat is already available.No need to cancel.");
        }

        else {
            seats[row][seatNumber]=0;


            System.out.println("Seat "+ rowLetter+(seatNumber+1)+" has been cancelled." );


            //Removing ticket from array
            for (int i = 0; i<tickets.length;i++)
            {
                if (tickets[i] != null && tickets[i].getRow()== rowLetter && tickets[i].getSeat()== seatNumber+1)
                {
                    tickets[i] = null;
                    break;

                }
            }

        }

    }
    public static void find_first_available()
    {
        for (int i=0;i<4;i++)
        {
            for (int j = 0;j<seats[i].length;j++)
            {
                if (seats[i][j]==0)
                {
                    System.out.println("First available seat found at row "+row_letters[i]+" ,seat "+(j+1));
                    return;
                }
            }
        }
        System.out.println("Sorry, no available seats found.");

    }

    public static void print_ticket_info()
    {
        for (Ticket element: tickets)
        {
            System.out.println(element);
        }
        double totalPrice = 0.0;
        System.out.println("Information of sold Tickets");
        System.out.println();
        for (Ticket ticket:tickets)
        {
            if (ticket != null)
            {
                ticket.printTicketInfo();
                totalPrice += ticket.getPrice();
            }
        }
        System.out.println("Total price of tickets are £"+ totalPrice);


    }

    public static void search_ticket()
    {
        System.out.print("Search for Tickets");

        System.out.print("\nEnter a row letter: ");
        char rowLetter = input.next().toUpperCase().charAt(0);

        int row = -1;
        for (int i = 0; i < 4; i++) {
            if (row_letters[i] == rowLetter) {
                row = i;
                break;
            }
        }
        if (row == -1) {
            System.out.println("Invalid row letter.");
            return;
        }

        System.out.print("Enter a seat number: ");
        int seatNumber = input.nextInt();

        seatNumber--;


        // validation of seat
        if (seatNumber < 0 || seatNumber >= seats[0].length || seatNumber >= seats[1].length) {
            System.out.println("Invalid seat number.");
        } else if (seats[row][seatNumber] == 1) {
            Ticket ticket = tickets[0];
            System.out.println("\nTicket and Person Information");
            ticket.printTicketInfo();

        } else{
            System.out.println("This seat is available.");
        }

    }

}
