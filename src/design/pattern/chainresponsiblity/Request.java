package design.pattern.chainresponsiblity;

public class Request {
    private int number;

    public Request(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
