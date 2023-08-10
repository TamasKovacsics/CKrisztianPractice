import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Season {

    private List<Vehicle> vehicles;
    private List<Track> tracks;

    public Season(List<Vehicle> vehicle, List<Track> tracks) {
        this.vehicles = vehicle;
        this.tracks = tracks;
    }

    public List<Vehicle> getVehicle() {
        return vehicles;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicles = vehicle;
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
                "\n1# = " + vehicles.get(0) +
                "\n2# = " + vehicles.get(1) +
                "\n3# = " + vehicles.get(2) +
                "\n4# = " + vehicles.get(3) +
                "\n5# = " + vehicles.get(4) +
                "\n6# = " + vehicles.get(5) +
                '}';
    }

    public List<Vehicle> runSeason () {

        for(int i = 0; i<tracks.size(); i++)
        {
            tracks.get(i).verseny(vehicles);
        }

        Collections.sort(getVehicle(), new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o2.getPoints() - o1.getPoints();
            }
        });

        return vehicles;
    }
}
