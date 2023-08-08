import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Season {

    private List<Car> cars;
    private List<Track> tracks;

    public Season(List<Car> car, List<Track> tracks) {
        this.cars = car;
        this.tracks = tracks;
    }

    public List<Car> getCar() {
        return cars;
    }

    public void setCar(List<Car> car) {
        this.cars = car;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        runSeason();
        return "Season{" +
                "\n1# = " + cars.get(0) +
                "\n2# = " + cars.get(1) +
                "\n3# = " + cars.get(2) +
                '}';
    }

    public List<Car> runSeason () {

        for(int i = 0; i<tracks.size(); i++)
        {
            tracks.get(i).verseny(cars);
        }

        Collections.sort(getCar(), new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getPoints() - o1.getPoints();
            }
        });

        return cars;
    }
}
