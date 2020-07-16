package entite;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException, ParseException {

        DynamiqueOperation dynamique = new DynamiqueOperation();
        ArrayList<Forfait> list = dynamique.list_forfait(2);
        ArrayList<Forfait> list_valeur = dynamique.valeurPondere(list,100,1,3,1,2);

        for (Forfait f: list_valeur){
            System.out.println(f.toString());
        }

        double[] value = dynamique.knapsack(100,list_valeur);
        int[] s = dynamique.knapsacksol(100,value,list_valeur);
        System.out.println("value = "+value[100]);
        for (int i=0;i<s.length;i++){
            System.out.println(s[i]);
        }

    }


}
