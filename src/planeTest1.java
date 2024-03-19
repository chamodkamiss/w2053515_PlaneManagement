import java.util.InputMismatchException;
import java.util.Scanner;

public class planeTest1 {
    public static Scanner input = new Scanner(System.in);
    private static char[][] seats = {
            {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'}
    };
    public static void main(String[] args)
    {

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
                }

            }catch (InputMismatchException e)
            {
                System.out.println("Please enter a valid integer.");
                input.nextLine();
                choice = -1;
            }

        }while (choice!= 0);
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
    public static void initializeSeats()
    {
        // Displaying the array
        for (int i = 0; i < seats.length; i++)
        {
            System.out.print((char) ('A' + i)+ " ");
            for (int j = 0; j < seats[i].length; j++)
            {
                if (seats[i][j] == 0)
            {

                System.out.print("O  ");
            }
                else {System.out.print(seats[i][j] + " ");}

            }

        }

        System.out.println(); // Move to the next line after printing each row
    }
public static void show_seating_plan()
{
    System.out.println("\nSeat Plan");
    initializeSeats();


}



    public static void buy_seat() {
        Scanner input = new Scanner(System.in);
        char rowLetter;
        int seatNumber;
        int row = -1;
        int seatIndex = -1;

        do {
            System.out.print("Enter row letter (A-E): ");
            String rowInput = input.next().toUpperCase();
            rowLetter = rowInput.charAt(0);

            if (rowLetter < 'A' || rowLetter > 'E') {
                System.out.println("Invalid row letter. Please enter a valid letter.");
                continue;
            }

            System.out.print("Enter seat number (1-14): ");
            seatNumber = input.nextInt();

            if (seatNumber < 1 || seatNumber > seats[0].length) {
                System.out.println("Invalid seat number. Please enter a valid seat number.");
                continue;
            }

            row = rowToIndex(rowInput);
            if (row == -1)
            {
                System.out.println("Invalid row.Please enter a valid row.");
                continue;
            }
            seatIndex = seatNumber - 1;

            if (seatIndex >= 0 && seatIndex < seats[row].length)
            {
                if (seats[row][seatIndex] == '0') {
                    seats[row][seatIndex] = 'X';
                    System.out.println("Seat " + rowLetter + seatNumber + " booked successfully.");
                } else {
                    System.out.println("Seat " + rowLetter + seatNumber + " is already booked. Please choose another seat.");
                }
            }
            else
            {
                System.out.println("Invalid seat number.");
            }


        } while (seats[row][seatIndex] != '0');
    }

    private static int rowToIndex(String rowInput) {
        switch (rowInput) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            default:
                return -1;
        }
    }

public static void cancel_seat()
{

    System.out.print("Enter row letter: " );
    System.out.print("\nEnter seat number: ");


}

public static void find_first_available()
{

}


}
