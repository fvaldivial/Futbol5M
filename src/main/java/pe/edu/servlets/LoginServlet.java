/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.servlets;

import com.mongodb.DBObject;
import edu.pe.clases.PartidosDAO;
import edu.pe.clases.UsuarioDAO;
import edu.pe.clases.UsuarioIF;
import edu.pe.clases.Utilitarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.bean.CanchaBean;
import pe.edu.bean.UsuarioBean;


@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    //Este sirve para salir de todo
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               //Paso 1: recuperar sesion
        HttpSession s = request.getSession(true);

        //Paso 2: recuperar datos
        

        //Paso 3: logica

            s.setAttribute("sesion", null);

            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
                   
    }

    

    //Viene de login.jsp
    //el if verifica si devolvio algo el id de usuario y si es que la contraseña corresponde a la guardada
    //1. Envia a usuario.jsp
    //2. Envia a pagina de error y luego de regreso.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
            //Paso 1: recuperar sesion
        HttpSession s = request.getSession(true);

        //Paso 2: recuperar datos
        UsuarioBean u = new UsuarioBean();
        String pass = request.getParameter("password");

        //Paso 3: logica

        UsuarioIF ui = new UsuarioDAO();
        DBObject d = ui.getInfo(request.getParameter("usuario"));

        PartidosDAO p = new PartidosDAO();
        
        
//       System.out.println("mira debajo de esto hermano");
//        System.out.println(d != null);
//        System.out.println( Utilitarios.password(pass, u, d));

        if (d != null && Utilitarios.password(pass, u, d)) {

            u = Utilitarios.rellenarUsuario(d);            
            u.setPartidos( p.listarPartidosXUsuario(u.getUsuario()));
            
                
            s.setAttribute("sesion", "escribi algo");
            s.setAttribute("usuario", u);
//            System.out.println("dni : " + u.getDni());
//            System.out.println("usuario : " + u.getUsuario());

            RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
            rd.forward(request, response);

        } else{ 

            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>!!!Error!!!</title>");
            out.println("<link href=\"css/landing-page.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"intro-header\">");
            out.println("<h1> Ingreso mal la contraseña o el usuario </h1>");
            out.println("<h1> Intentelo nuevamente </h1>");
            out.println("<a href= 'loguin.html'>Intentarlo de nuevo</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        }        
            

    }
}
