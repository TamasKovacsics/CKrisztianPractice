import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Track {

    private int hossz;
    private int kanyarhossz;

    public int getKanyarhossz() {
        return kanyarhossz;
    }

    public void setKanyarhossz(int kanyarhossz) {
        this.kanyarhossz = kanyarhossz;
    }

    public int getHossz() {
        return hossz;
    }

    public void setHossz(int hossz) {
        this.hossz = hossz;
    }

    public Track(int hossz, int kanyarhossz) {
        this.hossz = hossz;
        this.kanyarhossz = kanyarhossz;
    }

    public List<Car> verseny (List<Car> cars) {
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.futamIdo(Track.this) - o2.futamIdo(Track.this);
            }
        });

        for(int i = 0; i<cars.size(); i++)
        {
            if(i == 0)
                cars.get(i).addPoints(5);
            else if(i == 1)
                cars.get(i).addPoints(3);
            else
                cars.get(i).addPoints(1);
        }

        return cars;
    }

}
