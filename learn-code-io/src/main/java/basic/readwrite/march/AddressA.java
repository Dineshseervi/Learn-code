package main.java.basic.readwrite.march;

public class AddressA {
    private String address;
    private String roadumber;
    private static final int pin=99999;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoadumber() {
        return roadumber;
    }

    public void setRoadumber(String roadumber) {
        this.roadumber = roadumber;
    }

    public int getPin() {
        return pin;
    }
}
