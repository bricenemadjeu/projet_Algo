package entite;

public class Pourcentage {
    private double sms;
    private double appel;
    private double data;

    public Pourcentage() {
    }

    public Pourcentage(double sms, double appel, double data) {
        this.sms = sms;
        this.appel = appel;
        this.data = data;
    }

    public double getSms() {
        return sms;
    }

    public void setSms(double sms) {
        this.sms = sms;
    }

    public double getAppel() {
        return appel;
    }

    public void setAppel(double appel) {
        this.appel = appel;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Pourcentage{" +
                "sms=" + sms +
                ", appel=" + appel +
                ", data=" + data +
                '}';
    }
}
