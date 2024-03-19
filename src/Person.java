public class Person {
    private String name;
    private String surname;
    private String email;

    public Person(String pname, String sname, String email)
    {
        this.name= pname;
        this.surname= sname;
        this.email= email;
    }

    //getters & setters
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname= surname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email= email;
    }

    public void printInfo()
    {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
    }
}
