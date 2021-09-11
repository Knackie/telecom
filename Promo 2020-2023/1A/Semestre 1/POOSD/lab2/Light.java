package iot;

public class Light {

    private boolean state;

    public Light() {
        this.state = false;
    }

    public Light(boolean state) {
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void turnOn() {
        this.state = true;
    }

    public void turnOff() {
        this.state = false;
    }

    public void turnOnOff() {
        this.state = !this.state;
    }

    public void print() {
        if (this.state) System.out.println("Lampe allumée.");
        else System.out.println("Lampe éteinte");
    }

}
