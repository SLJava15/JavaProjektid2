package Block2.SingletonExample;

public class Singleton {

    private static Singleton car;
    protected String colour;

    private Singleton(){}

    public String setColour(String colour){
        this.colour = colour;
        return colour;
    }

    public static Singleton getCar(){

        if (car == null){
            car = new Singleton();
        }
        return car;
    }

}