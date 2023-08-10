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

    public List<Vehicle> verseny (List<Vehicle> vehicles) {
        Collections.sort(vehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.futamIdo(Track.this) - o2.futamIdo(Track.this);
            }
        });

        for(int i = 0; i<vehicles.size(); i++)
        {
            if(i == 0)
                vehicles.get(i).addPoints(5);
            else if(i == 1)
                vehicles.get(i).addPoints(3);
            else
                vehicles.get(i).addPoints(1);
        }

        return vehicles;
    }

}
