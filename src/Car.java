public class Car extends Vehicle {

    private String marka;
    private String tipus;
    private int sebesseg;
    private int kanyarSebesseg;
    private int points;
    public int getPoints() {
        return points;
    }

    @Override
    public void addPoints(int points) {
        this.points = this.points + points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getKanyarSebesseg() {
        return kanyarSebesseg;
    }

    public void setKanyarSebesseg(int kanyarSebesseg) {
        this.kanyarSebesseg = kanyarSebesseg;
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

    public int getSebesseg() {
        return sebesseg;
    }

    public void setSebesseg(int sebesseg) {
        this.sebesseg = sebesseg;
    }

    public Car (String marka, String tipus, int sebesseg, int kanyarSebesseg, int points)
    {
        this.marka = marka;
        this.tipus = tipus;
        this.sebesseg = sebesseg;
        this.kanyarSebesseg = kanyarSebesseg;
        this.points = points;

    }

    @Override
    public int futamIdo(Track track) {

        return track.getHossz()/sebesseg + track.getKanyarhossz()/kanyarSebesseg;
    }

    @Override
    public String toString() {
        return "Car{" +
                "marka='" + marka + '\'' +
                ", tipus='" + tipus + '\'' +
                ", sebesseg=" + sebesseg +
                ", sebessegKanyar=" + kanyarSebesseg +
                ", points=" + points +
                '}';
    }
}
