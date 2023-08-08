import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Car c1 = new Car("McLaren", "750S", generateRandom(), generateRandomKanyar(),0);
        Car c2 = new Car("Lamborghini", "Aventador", generateRandom(), generateRandomKanyar(),0);
        Car c3 = new Car("Ferrari", "F8", generateRandom(), generateRandomKanyar(),0);

        List<Car> cars = new ArrayList<>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

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

        Season s1 = new Season(cars, tracks);

        System.out.print("" + s1);

    }

    static int generateRandom () {
        return (int)(100+250*Math.random());
    }

    static int generateRandomKanyar () {
        return (int)(50+150*Math.random());
    }
}