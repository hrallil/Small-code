public class App {
    public static void main(String[] args) throws Exception {
        Animal a2,a3;
        //a1 = new Animal();
        a2 = new Dog();
        a3 = new Puppy();
        //a1.sound();
        a2.sound();
        a3.sound();
    }
}


abstract class Animal{
    abstract void sound();
}

class Dog extends Animal{
    @Override
    void sound(){
        System.out.println("arf arf");
    }
}

class Puppy extends Dog{
    @Override
    void sound(){
        System.out.println("woof woof");
    }
}