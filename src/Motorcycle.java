public class Motorcycle extends Vehicle{

    private String marka;
    private String tipus;
    private int sebesseg;
    private int points;

    public Motorcycle(String marka, String tipus, int sebesseg, int points) {
        this.marka = marka;
        this.tipus = tipus;
        this.sebesseg = sebesseg;
        this.points = points;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getSebesseg() {
        return sebesseg;
    }

    public void setSebesseg(int sebesseg) {
        this.sebesseg = sebesseg;
    }

    @Override
    public void addPoints(int points) {
        this.points = this.points + points;
    }

    @Override
    public int futamIdo(Track track) {
        return track.getHossz()/sebesseg;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "marka='" + marka + '\'' +
                ", tipus='" + tipus + '\'' +
                ", sebesseg=" + sebesseg +
                ", points=" + points +
                '}';
    }
}
