package src;

public class Test {

    class Animal {
    }

    class Canard extends Animal {
    }

    class TestInstanceOf {

        public static void main(String args[]) {
            Object c = new Canard();
            Animal a = new Animal();
            System.out.println("c est une instance de Canard : " + (c instanceof Canard));
            System.out.println("c est une instance de Animal : " + (c instanceof Animal));
            System.out.println("c est une instance de Object : " + (c instanceof Object));
            System.out.println("c est une instance de Integer : " + (c instanceof Integer));
            System.out.println("a est une instance de Canard : " + (a instanceof Canard));
            System.out.println("a est une instance de Animal : " + (a instanceof Animal));
            System.out.println("a est une instance de Object : " + (a instanceof Object));
            System.out.println("a est une instance de Integer : " + (a instanceof Integer));
        }
    }
}
