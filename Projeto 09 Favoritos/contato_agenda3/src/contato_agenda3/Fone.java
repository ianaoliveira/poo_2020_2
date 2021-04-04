package contato_agenda3;

public class Fone {
    private String id, number = null;

    public Fone() {}

    public Fone(String id, String number) {
        setId(id);
        setNumber(number);
    }

    public Fone(String serial) {
        String[] data = serial.split(":");

        setId(data[0]);
        setNumber(data[1]);
    }

    public static boolean validate(String number) {
        return number.matches("^[0-9.()]+");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Fone [id=" + id + ", number=" + number + "]";
    }

}