package systemDesign.easy;

public class Car {
    private String make;
    private String model;
    private int speed;

    public Car(String make, String model, int speed) {
        this.make = make;
        this.model = model;
        this.speed = speed;
    }

    public int accelerate(int increment) {
        speed += increment;
        return speed;
    }
    public int brake(int decrement) {
        speed -= decrement;
        if (speed < 0) {
            speed = 0;
        }

        //or  speed = Math.max(0, speed - decrement);
        return speed;
    }

    public int getSpeed() {
        return speed;
    }

    public String describe() {
        return "Car make: " + make + ", model: " + model + ", speed: " + speed + " km/h";
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 0);
        System.out.println(car.describe());

        car.accelerate(50);
        System.out.println("After accelerating: " + car.getSpeed() + " km/h");

        car.brake(20);
        System.out.println("After braking: " + car.getSpeed() + " km/h");

        car.brake(40);
        System.out.println("After braking: " + car.getSpeed() + " km/h");
    }
}
