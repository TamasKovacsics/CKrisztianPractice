import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Car c1 = new Car("McLaren", "750S", generateRandom(), generateRandomKanyar(),0);
        Car c2 = new Car("Lamborghini", "Aventador", generateRandom(), generateRandomKanyar(),0);
        Car c3 = new Car("Ferrari", "F8", generateRandom(), generateRandomKanyar(),0);
        Motorcycle m1 = new Motorcycle("Yamaha", "YZF-R6", generateMotor(), 0);
        Motorcycle m2 = new Motorcycle("Suzuki", "GSX-R1000", generateMotor(), 0);
        Motorcycle m3 = new Motorcycle("Honda", "CBR-1000RR", generateMotor(), 0);

        List<Vehicle> vehicle = new ArrayList<>();
        vehicle.add(c1);
        vehicle.add(c2);
        vehicle.add(c3);
        vehicle.add(m1);
        vehicle.add(m2);
        vehicle.add(m3);

        Track t1 = new Track(50000, 10000);
        Track t2 = new Track(40000, 20000);
        Track t3 = new Track(80000, 5000);
        Track t4 = new Track(20000, 10000);
        Track t5 = new Track(10000, 9000);

        List<Track> tracks = new ArrayList<>();
        tracks.add(t1);
        tracks.add(t2);
        tracks.add(t3);
        tracks.add(t4);
        tracks.add(t5);

        Season s1 = new Season(vehicle, tracks);

        System.out.print("" + s1);

    }

    static int generateMotor () {
        return (int)(100+100*Math.random());
    }

    static int generateRandom () {
        return (int)(100+250*Math.random());
    }

    static int generateRandomKanyar () {
        return (int)(50+150*Math.random());
    }
}