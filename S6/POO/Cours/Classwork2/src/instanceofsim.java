package src;

public class instanceofsim {

    public static void main(String[] args) {
        class Animal {

        }
        ;

        class Canard extends Animal {
        }
        ;

        Animal c = new Canard();
        Animal a = new Animal();

        boolean flag = true;
        try {
            Object o = (Canard) a;
        } catch(ClassCastException e) {
            flag = false;
        }

        System.out.println(flag);
    }
}
