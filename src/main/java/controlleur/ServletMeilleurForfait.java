package controlleur;

import entite.DynamiqueOperation;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "servletMeilleurForfait")
public class ServletMeilleurForfait extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int somme = Integer.parseInt(request.getParameter("som"));
        int jour = Integer.parseInt(request.getParameter("jour"));
        int sms = Integer.parseInt(request.getParameter("sms"));
        int appels = Integer.parseInt(request.getParameter("appels"));
        int data = Integer.parseInt(request.getParameter("data"));

        DynamiqueOperation operation  = new DynamiqueOperation();

        ArrayList list_m = null;
        ArrayList list_h = null;

        try {
            list_m = operation.meilleurForfait(somme,jour,sms,appels,data,1); // Forfait Mongo
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            list_h = operation.meilleurForfait(somme,jour,sms,appels,data,2); // Forfait Hemle
        } catch (ParseException e) {
            e.printStackTrace();
        }



        request.setAttribute("sms", sms);
        request.setAttribute("appel", appels);
        request.setAttribute("data", data);
        request.setAttribute("somme", somme);
        request.setAttribute("jour", jour);
        request.setAttribute("pack_m",list_m);
        request.setAttribute("pack_h",list_h);
        this.getServletContext().getRequestDispatcher("/forfaits.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
