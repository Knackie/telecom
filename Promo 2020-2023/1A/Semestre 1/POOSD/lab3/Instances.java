package dipole;

public class Instances {

	public static Dipole dip1() {
		return new Parallel(new Capacitor(9e-4), new Parallel(new Resistor(100), new Serial(new Coil(5e-5), new Resistor(12e3))));
	}

	public static Dipole dip2() {
		Serial d1 = new Serial(new Resistor(1000), new Coil(5e-2));
		Serial d2 = new Serial(new Capacitor(9e-4), new Capacitor(1e-5));
		Serial d3 = new Serial(new Resistor(1000), new Coil(2e-1));
		NParallel d4 = new NParallel();
		d4.addDipole(d1);
		d4.addDipole(new Capacitor(9e-3));
		d4.addDipole(d2);
		Serial d5 = new Serial(d4, new Resistor(330));
		Parallel d6 = new Parallel(d3, d5);
		NSerial d7 = new NSerial();
		d7.addDipole(new Resistor(100));
		d7.addDipole(d6);
		d7.addDipole(new Capacitor(1e-6));
		return d7;
	}
}
