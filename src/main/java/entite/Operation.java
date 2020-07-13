package entite;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Operation {


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
            Forfait forfait = new Forfait((Long) o.get("id"), (String) o.get("nom"), (Long) o.get("sms"),(Long) o.get("appels"),(Long) o.get("data"),(Long) o.get("validite"),(Long) o.get("prix"));
            list.add(forfait);
        }

        return list;
    }


    //--------------------------------------------------Fonction de tri------------------------------------------------------------------------------

    /***
     * Trier la liste ou SMS = 0
     * @param list
     * @param somme
     * @param jour
     * @return
     */
    private ArrayList<Forfait> smsEgaleZero(ArrayList<Forfait> list, long somme, long jour){
        ArrayList<Forfait> l = new ArrayList<Forfait>();
        for (Forfait f: list){ // Trier avec SMS==0
            if((f.getSms()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                l.add(f);
            }
        }
        return l;
    }

    /***
     * Trier avec SMS>=0 decroissant
     * @param list
     * @param somme
     * @param jour
     * @return
     */
    private ArrayList<Forfait> supInfZero(ArrayList<Forfait> list, long somme, long jour){
        ArrayList<Forfait> l = new ArrayList<Forfait>();
        for (Forfait f: list){ // Trier avec SMS>=0 decroissant
            if((f.getPrix()<=somme) && (f.getValidite()==jour)){
                l.add(f);
            }
        }
        return l;
    }

    /***
     * Trier avec SMS>0 decroissant
     * @param list
     * @param somme
     * @param jour
     * @return
     */
    private ArrayList<Forfait> smsSupZero(ArrayList<Forfait> list, long somme, long jour){   //Modifier
        ArrayList<Forfait> l = new ArrayList<Forfait>();
        for (Forfait f: list){ // Trier avec SMS>0 decroissant
            if((f.getSms()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                l.add(f);
            }
        }
        Collections.sort(l,Forfait.ComparatoSMS);
        return l;
    }

    /***
     * Trier avec Appels=0
     * @param list
     * @param somme
     * @param jour
     * @return
     */
    private ArrayList<Forfait> appelsEgaleZero(ArrayList<Forfait> list, long somme, long jour){
        ArrayList<Forfait> l = new ArrayList<Forfait>();
        for (Forfait f: list){ // Trier avec Appels=0
            if((f.getAppel()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                l.add(f);
            }
        }
        return l;
    }

    /***
     * Trier avec Appels>0
     * @param list
     * @param somme
     * @param jour
     * @return
     */
    private ArrayList<Forfait> appelsSupZero(ArrayList<Forfait> list, long somme, long jour){    //Modifier
        ArrayList<Forfait> l = new ArrayList<Forfait>();
        for (Forfait f: list){  // Trier avec Appels>0
            if((f.getAppel()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                l.add(f);
            }
        }
        return l;
    }

    /***
     * Trier data > 0
     * @param list
     * @param somme
     * @param jour
     * @return
     */
    private ArrayList<Forfait> dataSupZero(ArrayList<Forfait> list, long somme, long jour){ //Modifier
        ArrayList<Forfait> l = new ArrayList<Forfait>();
        for (Forfait f: list){
            if((f.getData()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                l.add(f);
            }
        }
        return l;
    }
    //---------------------------------------------------------------------------------------------------------------------------------


    /***
     * Pack des meilleurs forfaits Mango
     * @param somme
     * @param jour
     * @param sms
     * @param appels
     * @param data
     * @return Pack de liste de forfaits Mango
     * @throws IOException
     * @throws ParseException
     */
    public ArrayList meilleur_forfait(long somme, long jour, long sms, long appels, long data, int key) throws IOException, ParseException {
        ArrayList<Object> list_pack = new ArrayList<Object>();
        ArrayList<Forfait> list_f;
        long p[] = {sms,appels,data}; //Tableau de priorites
        if(key==1){
           list_f = list_forfait(1); //Forfait Mongo
        }else {
           list_f = list_forfait(2); //Forfait Hemle
        }


        //Trier list_f en fonction des priorites
        for (int i=0; i<=2; i++){

            if(i==0){   // SMS
                ArrayList<Forfait> l = new ArrayList<Forfait>();

                if(p[i]==0){ // Trier avec SMS >= 0
                    Collections.sort(l,Forfait.ComparatoSMS);
                    list_f = smsEgaleZero(list_f,somme,jour);
                }

                else if(p[i]==1){ // Trier avec SMS>=0 decroissant
                    l = supInfZero(list_f,somme,jour);
                    Collections.sort(l,Forfait.ComparatoSMS);
                    list_f = l;
                }

                else if(p[i]==2){  // Trier avec SMS>0 decroissant
                    list_f = smsSupZero(list_f,somme,jour);
                }

                else if(p[i]==3){
                    list_f = smsSupZero(list_f,somme,jour);
                }

            }//Fin si SMS

           else if(i==1){  //Appels
                ArrayList<Forfait> l1 = new ArrayList<Forfait>();
                if(p[i]==0){ // Trier avec Appels
                    Collections.sort(l1,Forfait.ComparatoAppels);
                    list_f = appelsEgaleZero(list_f,somme,jour);
                }

                else if(p[i]==1){
                    if(p[i-1]>1){
                        l1=supInfZero(list_f,somme,jour);
                        Collections.sort(l1,Forfait.ComparatoAppels);
                        Collections.sort(l1,Forfait.ComparatoSMS);
                        list_f = l1;
                    }
                    else {
                        l1=supInfZero(list_f,somme,jour);
                        Collections.sort(l1,Forfait.ComparatoAppels);
                        list_f = l1;
                    }
                }
                //fin
                else if(p[i]==2){

                    if(p[i-1]>2){ //Prioriser les SMS
                        l1= appelsSupZero(list_f,somme,jour);
                        Collections.sort(l1,Forfait.ComparatoAppels);
                        Collections.sort(l1,Forfait.ComparatoSMS);
                        list_f = l1;
                    }

                    else {
                        l1= appelsSupZero(list_f,somme,jour);
                        Collections.sort(l1,Forfait.ComparatoAppels);
                        list_f = l1;
                    }
                }
                else if(p[i]==3){
                    l1= appelsSupZero(list_f,somme,jour);
                    Collections.sort(l1,Forfait.ComparatoAppels);
                    list_f = l1;

                }

            }//Fin si Appels

            else if(i==2){  // Data
                ArrayList<Forfait> l2 = new ArrayList<Forfait>();
                if(p[i]==0){
                    if(p[i-1]==1 || p[i-1]==2){
                        if (p[i-2]>2){
                            //Prioriser les SMS
                            for (Forfait f: list_f){ // Trier avec Data=0
                                if((f.getData()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                    l2.add(f);
                                }
                            }
                            Collections.sort(l2,Forfait.ComparatoData);
                            Collections.sort(l2, Forfait.ComparatoAppels);
                            Collections.sort(l2, Forfait.ComparatoSMS);
                            list_f = l2;
                        }
                        else {
                            //pririser les Appels
                            for (Forfait f: list_f){
                                if((f.getData()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                    l2.add(f);
                                }
                            }
                            Collections.sort(l2,Forfait.ComparatoData);
                            Collections.sort(l2, Forfait.ComparatoAppels);
                            list_f = l2;
                        }
                    }

                }
                else if(p[i]==1){
                    if(p[i-1]==2){
                        if(p[i-2]>2){
                            //Prioriser les SMS
                            for (Forfait f: list_f){ // Trier avec Data=0
                                if((f.getData()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                    l2.add(f);
                                }
                            }
                            Collections.sort(l2,Forfait.ComparatoData);
                            Collections.sort(l2, Forfait.ComparatoAppels);
                            Collections.sort(l2, Forfait.ComparatoSMS);
                            list_f = l2;
                        }
                        else {
                            //Prioriser les appels
                            for (Forfait f: list_f){
                                if((f.getData()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                    l2.add(f);
                                }
                            }
                            Collections.sort(l2,Forfait.ComparatoData);
                            Collections.sort(l2, Forfait.ComparatoAppels);
                            list_f = l2;
                        }
                    }
                    else if(p[i-1]==3){
                        for (Forfait f: list_f){
                            if((f.getData()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                l2.add(f);
                            }
                        }
                        Collections.sort(l2,Forfait.ComparatoData);
                        Collections.sort(l2, Forfait.ComparatoAppels);
                        list_f = l2;
                    }
                    else if(p[i-1]==1){
                        if(p[i-2]>1){
                            //Prioriser les SMS
                            for (Forfait f: list_f){ // Trier avec Data=0
                                if((f.getData()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                    l2.add(f);
                                }
                            }
                            Collections.sort(l2,Forfait.ComparatoData);
                            Collections.sort(l2, Forfait.ComparatoAppels);
                            Collections.sort(l2, Forfait.ComparatoSMS);
                            list_f = l2;
                        }
                        else {
                            //Prioriser les SMS
                            for (Forfait f: list_f){ // Trier avec Data=0
                                if((f.getData()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                    l2.add(f);
                                }
                            }
                            Collections.sort(l2,Forfait.ComparatoData);
                            Collections.sort(l2, Forfait.ComparatoAppels);
                            list_f = l2;
                        }
                    }
                    else if (p[i-1]==0){
                        if(p[i-2]>0){
                            //Prioriser les SMS
                            for (Forfait f: list_f){ // Trier avec Data=0
                                if((f.getData()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                    l2.add(f);
                                }
                            }
                            Collections.sort(l2,Forfait.ComparatoData);
                            Collections.sort(l2, Forfait.ComparatoAppels);
                            Collections.sort(l2, Forfait.ComparatoSMS);
                            list_f = l2;
                        }
                        else {
                            for (Forfait f: list_f){
                                if((f.getData()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                    l2.add(f);
                                }
                            }
                            Collections.sort(l2,Forfait.ComparatoData);
                            list_f = l2;
                        }

                    }
                    else {
                        for (Forfait f: list_f){
                            if((f.getData()>=0) && (f.getPrix()<=somme) && (f.getValidite()==jour)){
                                l2.add(f);
                            }
                        }
                        Collections.sort(l2,Forfait.ComparatoData);
                        list_f = l2;
                    }

                }

                else if(p[i]==2) {
                    if (p[i - 1] == 2) {
                        if (p[i - 2] == 3) {
                            l2 = dataSupZero(list_f,somme,jour);
                            Collections.sort(l2,Forfait.ComparatoData);
                            Collections.sort(l2, Forfait.ComparatoAppels);
                            Collections.sort(l2, Forfait.ComparatoSMS);
                            list_f = l2;

                        }
                        else {
                            l2 = dataSupZero(list_f,somme,jour);
                            Collections.sort(l2,Forfait.ComparatoData);
                            list_f = l2;
                        }
                    } else if (p[i - 1] == 3) {
                        if(p[i-2]==3){
                            l2 = dataSupZero(list_f,somme,jour);
                            Collections.sort(l2,Forfait.ComparatoData);
                            Collections.sort(l2, Forfait.ComparatoAppels);
                            Collections.sort(l2,Forfait.ComparatoSMS);
                            list_f = l2;
                        }
                        else {
                            l2 = dataSupZero(list_f,somme,jour);
                            Collections.sort(l2, Forfait.ComparatoData);
                            Collections.sort(l2, Forfait.ComparatoAppels);
                            list_f = l2;
                        }
                    }
                    else {
                        l2 = dataSupZero(list_f,somme,jour);
                        Collections.sort(l2,Forfait.ComparatoData);
                        list_f = l2;
                    }
                }
                else if(p[i]==3){
                        l2 = dataSupZero(list_f,somme,jour);
                        Collections.sort(l2,Forfait.ComparatoData);
                        list_f = l2;
                }
                else {
                    for (Forfait f: list_f){
                        if((f.getPrix()<=somme) && (f.getValidite()==jour)){
                            l2.add(f);
                        }
                    }
                    Collections.sort(l2,Forfait.ComparatoData);
                    list_f = l2;
                }

            }//Fin si Data

        }//Fin pour

        //Faire les combinaisons de pack de forfaits
        list_pack = packForfait(list_f,somme);
        return list_pack;
    }




    /***
     * Pack final des meilleurs forfaits
     * @param list
     * @param somme
     * @return
     */
    private ArrayList packForfait(ArrayList<Forfait> list, long somme){
        ArrayList l = new ArrayList();
        ArrayList li = new ArrayList();
        /*long s;
        //Faire les combinaisons de pack de forfaits
        for (int i=0; i<list.size();i++){
            s = list.get(i).getPrix();
            ArrayList<Object> list_c = new ArrayList<Object>();
            list_c.add(list.get(i));
            for (int j=0;j<list.size();j++){
                if(list.get(j).getId()!=list.get(i).getId()){
                    s = s + list.get(j).getPrix();
                    if(s<=somme){
                        list_c.add(list.get(j));
                    }
                }
            }

            l.add(list_c);
        }*/
        l.add(list);
        l.add(forfaitP(list,somme,0,li,0,0));
        return l;
    }


    private ArrayList forfaitP(ArrayList<Forfait> list, long som, long  s, ArrayList tab, int j, int k){
        int t[] = new int[2];
        int i=0;
        if (list.get(j) != null){
            while (s<som){
                s = s + list.get(j).getPrix();
                if(s<som){
                    i=i+1;
                }
            }
            t[0]= (int) list.get(j).getId();
            t[1] = i;
            tab.add(t);
            if(s<som){
                return forfaitP(list,som,s,tab,j+1,k+1);
            }
            else {
                return tab;
            }
        }
        else {
            return tab;
        }

    }


}
