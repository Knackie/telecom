package iot;

import iot.Color;

public class ColoredLight extends Light {

    private Color color;
    private int intensity;

    public ColoredLight() {
        super();
        setColor(new Color(0, 0, 0));
        setIntensity(50);
    }

    public ColoredLight(boolean state) {
        super(state);
        setColor(new Color(0, 0, 0));
        setIntensity(50);
    }

    public ColoredLight(Color color) {
        setColor(color);
        setIntensity(50);
    }

    public ColoredLight(boolean state, Color color) {
        super(state);
        setColor(color);
        setIntensity(50);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color.changeColor(color);
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        if (intensity < 0) this.intensity = intensity;
        else this.intensity = Math.min(intensity, 100);
    }
}
