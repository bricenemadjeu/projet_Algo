package controlleur;

import entite.Operation;
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
        Operation operation = new Operation();

        ArrayList list_m = null;
        ArrayList list_h = null;

        try {
            list_h = operation.meilleur_forfait_Hemle(somme,jour,sms,appels,data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            list_m = operation.meilleur_forfait_Mango(somme,jour,sms,appels,data);
        } catch (ParseException e) {
            e.printStackTrace();
        }





        request.setAttribute("pack_m",list_m);
        request.setAttribute("pack_h",list_h);
        this.getServletContext().getRequestDispatcher("/forfaits.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
