package OOP.Basic;

/*
A class is a template definition of methods and variables
of a particular type of object.

In this example, Car class defines attributes(data members) and behaviours(methods)
common to all Car objects.
 */

public class Car {
    String company, modelName, serialNo;
    int modelYear, seatsCount;
    double speed;
    boolean isStart;

    Car(String company, String modelName, String serialNo, int modelYear, int seatsCount) {
        this.company = company;
        this.modelName = modelName;
        this.serialNo = serialNo;
        this.modelYear = modelYear;
        this.seatsCount = seatsCount;
        speed = 0.0;
        isStart = false;
    }

    void start() {
        isStart = true;
        System.out.println("Car started.");
    }

    void stop() {
        isStart = false;
    }

    /**
     * Increases the speed of the car
     */
    void accelerate() {
        if (isStart) {
            System.out.println("Accelerating...");
            speed = (speed == 0) ? 10 : speed * 1.1;
        }
        else {
            System.out.println("Start the car to accelerate.");
        }
    }

    /**
     * Decreases the speed of the car
     */
    void brake() {
        System.out.println("Applying brakes...");
        speed = (speed == 0)? 0 : speed * 0.6;
    }

    public static void main(String[] args) {
        Car car = new Car("Ford",
                "Figo",
                "FF2024PT",
                2024,
                5);

        System.out.println("Car speed: " + car.speed);

        // Accelerate car
        car.accelerate();

        car.start();

        car.accelerate();
        car.accelerate();
        System.out.println("Car speed: " + car.speed);

        // Slow down the car
        car.brake();
        car.brake();
        car.brake();

        System.out.println("Car speed: " + car.speed);
    }
}

// Classes can inherit other classes and add or modify their behaviour

// for example, RaceCar inherits Car class. RaceCar has all the features of a car
// along with some additional features

class RaceCar extends Car {
    int raceCarNumber;

    RaceCar(String company, String modelName, String serialNo, int modelYear, int seatsCount, int raceCarNumber) {
        super(company, modelName, serialNo, modelYear, seatsCount);
    }

    @Override
    void accelerate() {
        if (isStart) {
            // RaceCar accelerates faster
            speed = (speed == 0)? 50 : speed * 1.5;
            System.out.println("Accelerating...");
        }
        else  {
            System.out.println("Start the car to accelerate");
        }
    }
}


