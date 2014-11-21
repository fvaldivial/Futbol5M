package pe.edu.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.bean.PartidoBean;

/**
 *
 * @author Rafael
 */
public class PagarServlet extends HttpServlet {

    //Viene de usuario.jsp
    //Se debera dar pase a pago.jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession s = request.getSession(true);

   
        request.setAttribute("partido", request.getAttribute("partido"));
        
        // Pasa el bean de usuario y de partido a la pagina siguiente
        
        System.out.println("partido de pago" + request.getAttribute("partido").getClass());
        
        RequestDispatcher rd = request.getRequestDispatcher("pago.jsp");
        rd.forward(request, response);  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            HttpSession s = request.getSession(true);
            
            PartidoBean p = (PartidoBean) request.getAttribute("partido");
            
            //tiene q haber un metodo DAO que setee el pago a 1 para que se sepa que ya se pago
            //el id del partido que se paga sale de la variable p de arriba
            
            //este mensaje deberia salir en el jsp de usuario
            String mensaje = "Pago realizado con éxito";
            
            request.setAttribute("mensaje", mensaje);
            
            
            RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
            rd.forward(request, response);
    }
}