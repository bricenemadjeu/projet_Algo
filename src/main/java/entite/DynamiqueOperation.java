package entite;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DynamiqueOperation {

    public DynamiqueOperation() {
    }


    /***
     * Liste de forfait de Mango
     * @return list
     * @throws IOException
     * @throws ParseException
     */
    public ArrayList<Forfait> list_forfait(int key) throws IOException, ParseException {
        ArrayList<Forfait> list = new ArrayList<Forfait>();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("E:\\projet_Algo\\src\\main\\resources\\forfaits_M_H.json"));
        JSONObject jsonObject =  (JSONObject) obj;
        JSONArray mango;
        if(key==1){
            mango = (JSONArray) jsonObject.get("forfait_mango");
        } else {
            mango = (JSONArray) jsonObject.get("forfait_hemle");
        }
        for(Object f : mango){
            JSONObject o = (JSONObject) f;
            Forfait forfait = new Forfait((Long) o.get("id"), (String) o.get("nom"), (Long) o.get("sms"),(Long) o.get("appels"),(Long) o.get("data"),(Long) o.get("validite"),(Long) o.get("prix"),0);
            list.add(forfait);
        }

        return list;
    }

    /***
     * Trier la liste par jour et somme
     * @param forfaits
     * @param somme
     * @param jour
     * @return
     */
    private ArrayList<Forfait> triForfait(ArrayList<Forfait> forfaits, long somme, long jour){
        ArrayList<Forfait> l = new ArrayList<Forfait>();
        for (Forfait f: forfaits){ // Trier avec SMS>=0 decroissant
            if((f.getPrix()<=somme) && (f.getValidite()==jour)){
                l.add(f);
            }
        }
        return l;
    }


    /***
     * Max des SMS
     * @param forfaits
     * @return
     */
    private long maxSMS(ArrayList<Forfait> forfaits){
        long max_sms = forfaits.get(0).getSms();
        for (Forfait f: forfaits){
            if(max_sms < f.getSms()){
                max_sms = f.getSms();
            }
        }
        return max_sms;
    }

    /***
     * Max des Appels
     * @param forfaits
     * @return
     */
    private long maxAppels(ArrayList<Forfait> forfaits){
        long max_appel = forfaits.get(0).getAppel();
        for (Forfait f: forfaits){
            if(max_appel < f.getAppel()){
                max_appel = f.getAppel();
            }
        }
        return max_appel;
    }


    /***
     * Max des Data
     * @param forfaits
     * @return
     */
    private long maxData(ArrayList<Forfait> forfaits){
        long max_data = forfaits.get(0).getData();
        for (Forfait f: forfaits){
            if(max_data < f.getData()){
                max_data = f.getData();
            }
        }

        return max_data;
    }

    /***
     * Tableau contenant les pourcentages de SMS, Appels, Data
     * @param forfaits
     * @return
     */
    private ArrayList<Pourcentage> poucentage_sms_Appel_Data(ArrayList<Forfait> forfaits){
        ArrayList<Pourcentage> list_pourcentage = new ArrayList();
        if(!forfaits.isEmpty()) {
            double max_appel = maxAppels(forfaits);
            if (max_appel == 0) {
                max_appel = 1;
            }
            double max_sms = maxSMS(forfaits);
            if (max_sms == 0) {
                max_sms = 1;
            }
            double max_data = maxData(forfaits);
            if (max_data == 0) {
                max_data = 1;
            }
            for (int i = 0; i < forfaits.size(); i++) {
                double f_appel = forfaits.get(i).getAppel();
                double f_sms = forfaits.get(i).getSms();
                double f_data = forfaits.get(i).getData();

                double sms = (f_sms / max_sms) * 100;
                double appel = (f_appel / max_appel) * 100;
                double data = (f_data / max_data) * 100;

                Pourcentage p = new Pourcentage(sms, appel, data);
                list_pourcentage.add(new Pourcentage(sms, appel, data));
            }
        }

        return list_pourcentage;
    }

    /***
     * Ajouter les valeur dans la liste de forfait de depart
     * @return
     */
    public ArrayList<Forfait> valeurPondere(ArrayList<Forfait> list_f, long somme, long jour, long sms, long appel, long data){
        ArrayList<Forfait> list = new ArrayList<Forfait>();
        if (!list_f.isEmpty()) {
            list = triForfait(list_f, somme, jour); // Trier la liste
            ArrayList<Pourcentage> pourcentage = poucentage_sms_Appel_Data(list);
            for (int i = 0; i < pourcentage.size(); i++) {
                float valeur = (float) (((sms * pourcentage.get(i).getSms()) + (appel * pourcentage.get(i).getAppel()) + (data * pourcentage.get(i).getData())) / (sms + appel + data));
                list.get(i).setValeur(valeur);

            }
            Collections.sort(list, Forfait.ComparatoValeur);
        }
        return list;
    }




    public double[] knapsack(long somme, ArrayList<Forfait> forfaits){
        double value[] = new double[(int) somme+1];
        value[0]=0;
        for(int w=1;w<=value.length-1;w++){
            value[w] = 0;
            for (Forfait f: forfaits){
                if(f.getPrix()<=w){
                    double val = value[(int) (w-f.getPrix())] + f.getValeur();
                    if (val >  value[w]){
                        value[w] = val;
                    }
                }
            }
        }
        return value;

    }


    public int[] knapsacksol(long somme,double[] value, ArrayList<Forfait> t){
        int n = t.size();
        int[] s = new int[n];
        double v = value[value.length-1];
        long w = somme;
        while (v>0){
            for (int i=0;i<n;i++){
                if((t.get(i).getPrix() <= w) && (v - t.get(i).getValeur())==value[(int) (w-t.get(i).getPrix())]){
                    s[i]+=1;
                    v-=t.get(i).getValeur();
                    w-=t.get(i).getPrix();
                }
            }
        }

        return s;
    }

    public ArrayList meilleurForfait(long somme, long jour, long sms, long appel, long data,int key) throws IOException, ParseException {
        ArrayList list = new ArrayList();
        double m =0;
        ArrayList<Forfait> l = list_forfait(key);
            l = triForfait(l, somme, jour); // Trier les forfaits
        if (!l.isEmpty()) {
            ArrayList<Forfait> list_pondere = valeurPondere(l, somme, jour, sms, appel, data);
            list.add(list_pondere);

            double[] value = knapsack(somme, list_pondere);
            int[] s = knapsacksol(somme, value, list_pondere);
            list.add(s);

            double[] max_val = knapsack(somme, l);
            m = max_val[max_val.length - 1];
            list.add(m);
        }
        return list;
    }

}
