import java.io.*;

public class Ticket {
    private char rowLetter;
    private int seatNumber;
    private double price;
    private Person person;

    public Ticket(char rowLetter,int seatNumber, double price, Person person)
    {
        this.rowLetter= rowLetter;
        this.seatNumber= seatNumber;
        this.price=price;
        this.person= person;
    }

    public char getRow()
    {
        return rowLetter;
    }
    public void setRowLetter(char rowLetter)
    {
        this.rowLetter=rowLetter;
    }

    public int getSeat()
    {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice()
     {
         return price;
     }
     public void setPrice(double price)
     {
         this.price= price;
     }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person)
    {
        this.person=person;
    }

    public void printTicketInfo()
    {
            System.out.println("------------------------------");
            System.out.println("Ticket Information");
            System.out.println("Row: "+ rowLetter);
            System.out.println("Seat: "+ (seatNumber+1));
            System.out.println("Price: £"+price);
            System.out.println("\nPerson Information");
            person.printInfo();
            System.out.println("------------------------------");


    }

    public void save()
    {
        String fileName = String.format("%c%d.txt",rowLetter,(seatNumber+1));
        try {
            FileWriter file = new FileWriter(fileName);
            file.write("Ticket Information\n");
            file.write("\nRow: "+ rowLetter);
            file.write("\nSeat: "+ (seatNumber+1));
            file.write("\nPrice: £"+price);
            file.write("\n\nPerson Information");
            file.write("\nPassenger Name: "+ person.getName());
            file.write("\nPassenger Surname: "+ person.getSurname());
            file.write("\nPassenger Email: "+ person.getEmail());


            file.close();

        }catch (IOException e){
            System.out.println("Error while writing in a file.");
            e.printStackTrace();

        }

    }
    public void delete()
    {
        String fileName = String.format("%c%d.txt",rowLetter,(seatNumber+1));
        File file = new File(fileName);
        if (file.exists())
        {
            file.delete();
        }
    }


}
