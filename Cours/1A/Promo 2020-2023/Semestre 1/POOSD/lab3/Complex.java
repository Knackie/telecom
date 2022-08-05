package dipole;

public class Complex {

    private static final double EPSILON = 1e-5;

    private double real, imaginary;

    public Complex() {
        this.real = 0.;
        this.imaginary = 0.;
    }

    public Complex(double re, double im) {
        this.real = re;
        this.imaginary = im;
    }

    public double real() {
        return this.real;
    }

    public double imaginary() {
        return this.imaginary;
    }

    public Complex add(Complex c) {
        assert c != null;

        this.real = this.real + c.real;
        this.imaginary = this.imaginary + c.imaginary;
        return this;
    }

    public Complex inverse() {
        assert Math.abs(real()) > 0.0001 || Math.abs(imaginary()) > 0.0001;

        double m = this.real * this.real + this.imaginary * this.imaginary;
        this.real = this.real / m;
        this.imaginary = -this.imaginary / m;
        return this;
    }

    public String toString() {
        return (this.real + " + " + this.imaginary + "i");
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Complex))
            return false;
        Complex c = (Complex) o;
        if (Math.abs(c.real - this.real) > EPSILON) {
            return false;
        }
        if (Math.abs(c.imaginary - this.imaginary) > EPSILON)
            return false;
        return true;
    }
}
