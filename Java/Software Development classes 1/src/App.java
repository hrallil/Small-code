public class App {
    public static void main(String[] args) throws Exception {
        Dog dog = new Dog("max");
        Dog oldDog = dog;

        //pass "dog" to foo1
        foo1(dog);
        System.out.println("the name of dog: " + dog.getName());
        foo2(dog);
        System.out.println("the name of dog after foo  is: " + dog.getName());
    }

    public static void foo1(Dog d){
        d = new Dog("fifi");
        System.out.println("the dog d in foo is: " + d.getName());
    }

    public static void foo2(Dog d){
        d.setName("Fifi");
        System.out.println("dog d in foo2 is called: "+ d.getName());
    }
}

class Dog{
    String name;
    public Dog(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name = newName;
    }
}
