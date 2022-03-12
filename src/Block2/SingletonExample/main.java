package Block2.SingletonExample;

public class main {

    private static Singleton car1;
    private static Singleton car2;
    private static Singleton car3;

    public static void main(String[] args) {

        // Instantiating Singleton class with variables
        car1 = Singleton.getCar();
        car2 = Singleton.getCar();
        car3 = Singleton.getCar();

        // Printing the hash code for variables as declared
        System.out.println("Hashcode of car1 is " + car1.hashCode());
        System.out.println("Hashcode of car2 is " + car2.hashCode());
        System.out.println("Hashcode of car3 is " + car3.hashCode());

        // Condition check
        if (car1 == car2 && car2 == car3){
            System.out.println("Three cars point to the same memory location (to the same object) \n");
        } else {
            System.out.println("Three objects DO NOT point to the same memory location\n");
        }

        //Set different colours to all cars
        car1.setColour("Red");
        car2.setColour("Blue");
        car3.setColour("Green");

        //Print out colours of different cars
        System.out.println(car1.colour);
        System.out.println(car2.colour);
        System.out.println(car3.colour);

        //Condition check
        if (car1.colour.equals(car2.colour) && car2.colour.equals(car3.colour)){
            System.out.println("All cars have same colour -> those cars are the same Object");
        } else {
            System.out.println("As the cars have different colours, seems they are different objects");
        }

    }
}