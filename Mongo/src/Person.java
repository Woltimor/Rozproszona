
public class Person {
    private String Name;
    private String Surname;
    private String Address;


    public Person(String Name, String Surname, String Address) {
        this.Name = Name;
        this.Surname = Surname;
        this.Address = Address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }
    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    
    public String toString() {
        return "Car [Marka=" + Name + ", Model=" + Surname + ", Address=" + Address + "]";
    }

}


