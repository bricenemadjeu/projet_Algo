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
            Forfait forfait = new Forfait((Long) o.get("id"), (String) o.get("nom"), (Long) o.get("sms"),(Long) o.get("appels"),(Long) o.get("data"),(Long) o.get("validite"),(Long) o.get("prix"),0);
            list.add(forfait);
        }

        return list;
    }


    //--------------------------------------------------Fonction de tri------------------------------------------------------------------------------




}
