package in;

import java.util.LinkedList;
import java.util.List;

public class Main {
    // a is a
    //composition vs inheritance
    // a vs has a
    public interface MyInterface {
        void doSomething();
        int calculate(int a, int b);
        // More method signatures can be added
    }

    public class MyClass<Dependency> implements MyInterface {

        private final Dependency dependency;

        public MyClass(Dependency dependency) {
            this.dependency = dependency;
        }
        public void doSomething(Dependency dependency) {
            // Perform an operation using the provided dependency
        }


        @Override
        public void doSomething() {
            // Provide the implementation for the doSomething() method
        }

        @Override
        public int calculate(int a, int b) {
            // Provide the implementation for the calculate() method
            return a + b;
        }
    }




    public static void main(String[] args) {

        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        animal.move();
//        flier.move();
//        tracked.move();

//        flier.takeOff();
//        flier.fly();
//        tracked.track();
//        flier.land();

        inFlight(flier);
        inFlight(new Jet());
        Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled %.2f km or %.2f miles%n",
                kmsTraveled, milesTraveled);

        LinkedList<FlightEnabled> fliers = new LinkedList<>();
        fliers.add(bird);

        List<FlightEnabled> betterFliers = new LinkedList<>();
        betterFliers.add(bird);

        triggerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);

        triggerFliers(betterFliers);
        flyFliers(betterFliers);
        landFliers(betterFliers);
    }

    private static void inFlight(FlightEnabled flier) {

        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

    private static void triggerFliers(List<FlightEnabled> fliers) {

        for (var flier : fliers) {
            flier.takeOff();
        }
    }

    private static void flyFliers(List<FlightEnabled> fliers) {

        for (var flier : fliers) {
            flier.fly();
        }
    }

    private static void landFliers(List<FlightEnabled> fliers) {

        for (var flier : fliers) {
            flier.land();
        }
    }
}
