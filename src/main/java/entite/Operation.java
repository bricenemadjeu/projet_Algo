package entite;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.security.auth.login.CredentialException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Operation {

    private ArrayList<Forfait> list = new ArrayList<Forfait>();
    private JSONParser parser = new JSONParser();

    /***
     * Liste de forfait de Mango
      * @return list
     * @throws IOException
     * @throws ParseException
     */
    public ArrayList<Forfait> list_forfait_Mango() throws IOException, ParseException {
        Object obj = parser.parse(new FileReader("E:\\projet_Algo\\src\\main\\resources\\forfaits_M_H.json"));
        JSONObject jsonObject =  (JSONObject) obj;
        JSONArray mango = (JSONArray) jsonObject.get("forfait_mango");
        for(Object f : mango){
            JSONObject o = (JSONObject) f;
            Forfait forfait = new Forfait((Long) o.get("id"), (String) o.get("nom"), (Long) o.get("sms"),(Long) o.get("appels"),(Long) o.get("data"),(Long) o.get("validite"),(Long) o.get("prix"));
            list.add(forfait);
        }

        return list;
    }


    /***
     * Liste de forfait de Hemle
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public ArrayList<Forfait> list_forfait_Hemle() throws IOException, ParseException {
        Object obj = parser.parse(new FileReader("E:\\projet_Algo\\src\\main\\resources\\forfaits_M_H.json"));
        JSONObject jsonObject =  (JSONObject) obj;
        JSONArray mango = (JSONArray) jsonObject.get("forfait_hemle");
        for(Object f : mango){
            JSONObject o = (JSONObject) f;
            Forfait forfait = new Forfait((Long) o.get("id"), (String) o.get("nom"), (Long) o.get("sms"),(Long) o.get("appels"),(Long) o.get("data"),(Long) o.get("validite"),(Long) o.get("prix"));
            list.add(forfait);
        }

        return list;
    }


    public ArrayList meilleur_forfait(long somme, long jour, long sms, long appels, long data) throws IOException, ParseException {
        ArrayList<Object> list_pack = new ArrayList<Object>();
        ArrayList list_p[];
        //ArrayList<Object> list_c = new ArrayList<Object>(); //Liste de forfaits combines
        long p[] = {sms,appels,data}; //Tableau de priorites
        long s;
        ArrayList<Forfait> list_f = list_forfait_Mango();


        //Trier list_f en fonction des priorites
        for (int i=0; i<=2; i++){

            if(i==0){   // SMS
                ArrayList<Forfait> l = new ArrayList<Forfait>();
                if(p[i]==0){
                    for (Forfait f: list_f){ // Trier avec SMS==0
                        if((f.getSms()==0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                            l.add(f);
                        }
                    }
                    list_f = l;
                }
                else if(p[i]==1){
                    for (Forfait f: list_f){ // Trier avec SMS>0 decroissant
                        if((f.getPrix()<=somme) && (f.getValidite()==jour)){
                            l.add(f);
                        }
                    }
                    list_f = l;
                }
                else if(p[i]==2){
                    for (Forfait f: list_f){ // Trier avec SMS>0 decroissant
                        if((f.getSms()>0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                            l.add(f);
                        }
                    }
                    Collections.sort(l,Forfait.ComparatoSMS);
                    list_f = l;
                }
                else if(p[i]==3){
                    for (Forfait f: list_f){ // Trier avec SMS>0 decroissant
                        if((f.getSms()>0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                            l.add(f);
                        }
                    }
                    Collections.sort(l,Forfait.ComparatoSMS);
                    list_f = l;

                }
            }//Fin si SMS
           else if(i==1){  //Appels
                ArrayList<Forfait> l1 = new ArrayList<Forfait>();
                if(p[i]==0){
                    //l.clear();
                    for (Forfait f: list_f){ // Trier avec Appels=0
                        if((f.getAppel()==0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                            l1.add(f);
                        }
                    }
                    list_f = l1;

                }
                else if(p[i]==2){

                    if(p[i-1]==3){ //Prioriser les SMS

                        for (Forfait f: list_f){ // Trier avec Appels>0
                            if((f.getAppel()>0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                l1.add(f);
                            }
                        }
                        Collections.sort(l1,Forfait.ComparatoAppels);
                        Collections.sort(l1,Forfait.ComparatoSMS);
                        list_f = l1;
                    }
                    else {

                        for (Forfait f: list_f){ // Trier avec Appels>0
                            if((f.getAppel()>0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                l1.add(f);
                            }
                        }
                        Collections.sort(l1,Forfait.ComparatoAppels);
                        list_f = l1;
                    }
                }
                else if(p[i]==3){
                    for (Forfait f: list_f){  // Trier avec Appels>0
                        if((f.getAppel()>0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                            l1.add(f);
                        }
                    }

                    Collections.sort(l1,Forfait.ComparatoAppels);
                    list_f = l1;

                }

            }//Fin si Appels

            else if(i==2){  // Data
                ArrayList<Forfait> l2 = new ArrayList<Forfait>();
                if(p[i]==0){
                    for (Forfait f: list_f){ // Trier avec Data=0
                        if((f.getData()==0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                            l2.add(f);
                        }
                    }
                    list_f = l2;

                }
                else if(p[i]==2) {
                    if (p[i - 1] == 2) {
                        if (p[i - 2] == 3) {
                            for (Forfait f : list_f) { // Prioriser les SMS
                                if ((f.getAppel() > 0) && (f.getPrix() <= somme) && (f.getValidite() == jour)) {
                                    l2.add(f);
                                }
                            }
                            Collections.sort(l2, Forfait.ComparatoAppels);
                            Collections.sort(l2, Forfait.ComparatoSMS);
                            list_f = l2;

                        }
                    } else if (p[i - 1] == 3) {
                        if(p[i-2]==3){
                            for (Forfait f: list_f){ // Prioriser les SMS et Data
                                if((f.getData()>0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                    l2.add(f);
                                }
                            }
                            Collections.sort(l2,Forfait.ComparatoData);
                            Collections.sort(l2, Forfait.ComparatoAppels);
                            Collections.sort(l2,Forfait.ComparatoSMS);
                            list_f = l2;
                        }
                        else {
                            for (Forfait f : list_f) { // Prioriser les Appels
                                if ((f.getData() > 0) && (f.getPrix() <= somme) && (f.getValidite() == jour)) {
                                    l2.add(f);
                                }
                            }
                            Collections.sort(l2, Forfait.ComparatoData);
                            Collections.sort(l2, Forfait.ComparatoAppels);
                            list_f = l2;
                        }
                    }
                    else {
                        for (Forfait f: list_f){ // Prioriser les SMS et Data
                            if((f.getData()>0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                l2.add(f);
                            }
                        }
                        Collections.sort(l2,Forfait.ComparatoData);
                        list_f = l2;
                    }
                }
                else if(p[i]==3){
                        for (Forfait f: list_f){ // Prioriser les SMS
                            if((f.getData()>0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                l2.add(f);
                            }
                        }
                        Collections.sort(l2,Forfait.ComparatoData);
                        list_f = l2;
                }

            }//Fin si Data

        }//Fin pour

        //Faire les combinaisons de pack de forfaits
        for (int i=0; i<list_f.size();i++){
            s = list_f.get(i).getPrix();
            ArrayList<Object> list_c = new ArrayList<Object>();
            list_c.add(list_f.get(i));
            for (int j=0;j<list_f.size();j++){
                if(list_f.get(j).getId()!=list_f.get(i).getId()){
                    s = s + list_f.get(j).getPrix();
                    if(s<=somme){
                        list_c.add(list_f.get(j));
                    }
                }
            }
            list_pack.add(list_c);
        }

        return list_pack;
    }


}
