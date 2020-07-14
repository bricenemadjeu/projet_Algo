package entite;

import java.util.Comparator;

public class Forfait {
    private Long id;
    private String nomForfait;
    private long sms;
    private long appel;
    private long data;
    private long validite;
    private long prix;
    private float valeur;

    public Forfait() {
    }

    public Forfait(Long id, String nomForfait, long sms, long appel, long data, long validite, long prix, float valeur) {
        this.id = id;
        this.nomForfait = nomForfait;
        this.sms = sms;
        this.appel = appel;
        this.data = data;
        this.validite = validite;
        this.prix = prix;
        this.valeur = valeur;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomForfait() {
        return nomForfait;
    }

    public void setNomForfait(String nomForfait) {
        this.nomForfait = nomForfait;
    }

    public long getSms() {
        return sms;
    }

    public void setSms(long sms) {
        this.sms = sms;
    }

    public long getAppel() {
        return appel;
    }

    public void setAppel(long appel) {
        this.appel = appel;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public long getValidite() {
        return validite;
    }

    public void setValidite(long validite) {
        this.validite = validite;
    }

    public long getPrix() {
        return prix;
    }

    public void setPrix(long prix) {
        this.prix = prix;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Forfait{" +
                "id=" + id +
                ", nomForfait='" + nomForfait + '\'' +
                ", sms=" + sms +
                ", appel=" + appel +
                ", data=" + data +
                ", validite=" + validite +
                ", prix=" + prix +
                ", valeur=" + valeur +
                '}';
    }

    public static Comparator<Forfait> ComparatoSMS = new Comparator<Forfait>() {
        @Override
        public int compare(Forfait o1, Forfait o2) {
            return (int) (o2.getSms()-o1.getSms());
        }
    };

    public static Comparator<Forfait> ComparatoAppels = new Comparator<Forfait>() {
        @Override
        public int compare(Forfait o1, Forfait o2) {
            return (int) (o2.getAppel()-o1.getAppel());
        }
    };

    public static Comparator<Forfait> ComparatoData = new Comparator<Forfait>() {
        @Override
        public int compare(Forfait o1, Forfait o2) {
            return (int) (o2.getData()-o1.getData());
        }
    };

    public static Comparator<Forfait> ComparatoValeur = new Comparator<Forfait>() {
        @Override
        public int compare(Forfait o1, Forfait o2) {
            return (int) (o2.getValeur()-o1.getValeur());
        }
    };

}
