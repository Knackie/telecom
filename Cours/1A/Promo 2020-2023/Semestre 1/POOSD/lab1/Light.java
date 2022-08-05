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

    public void inverseState() {
        this.state = !this.state;
    }

    public void switchOn() {
        this.state = true;
    }

    public void switchOff() {
        this.state = false;
    }

    public void printState() {
        if (this.state) System.out.println("Etat de la lampe : allumée");
        else System.out.println("Etat de la lampe : éteinte");
    }

}
