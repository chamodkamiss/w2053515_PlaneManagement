import java.util.Scanner;

public class Seatbooking {
    private static char[][] seats = {
            {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'}
    };

    public static void buySeat() {
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
            seatIndex = seatNumber - 1;

            if (seats[row][seatIndex] == '0') {
                seats[row][seatIndex] = 'X';
                System.out.println("Seat " + rowLetter + seatNumber + " booked successfully.");
            } else {
                System.out.println("Seat " + rowLetter + seatNumber + " is already booked. Please choose another seat.");
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
            default:
                System.out.println("Invalid row.");
                return -1;
        }
    }

    public static void main(String[] args) {
        buySeat();
    }
}

