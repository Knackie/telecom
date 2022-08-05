package iot;

public class Color {

    private int red;
    private int green;
    private int blue;

    public Color(int red, int green, int blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        if (red < 0) this.red = 0;
        else this.red = Math.min(red, 255);
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        if (green < 0) this.green = 0;
        else this.green = Math.min(green, 255);
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        if (blue < 0) this.blue = 0;
        else this.blue = Math.min(blue, 255);
    }

    public void changeColor(Color color) {
        setRed(color.getRed());
        setGreen(color.getGreen());
        setBlue(color.getBlue());
    }
}
