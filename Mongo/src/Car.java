public class Car {
    private String Marka;
    private String Model;

    public Car(String Marka, String Model) {
        this.Marka = Marka;
        this.Model = Model;
    }

    public String getMarka() {
        return Marka;
    }

    public void setName(String Marka) {
        this.Marka = Marka;
    }


    public String getModel() {
        return Model;
    }

    public void setAuthor(String Model) {
        this.Model = Model;
    }

    
    public String toString() {
        return "Car [Marka=" + Marka + ", Model=" + Model + "]";
    }

}


