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
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    //Viene de login.html
    //el if verifica si devolvio algo el id de usuario y si es que la contraseña corresponde a la guardada
    //1. Envia a usuario.jsp
    //2. Envia a pagina de error y luego de regreso.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
        
        
       System.out.println("mira debajo de esto hermano");
        System.out.println(d != null);
        System.out.println( Utilitarios.password(pass, u, d));

        if (d != null && Utilitarios.password(pass, u, d)) {

            u = Utilitarios.rellenarUsuario(d);            
            u.setPartidos( p.listarPartidosXUsuario(u.getUsuario()));
            
            s.setAttribute("usuario", u);
            System.out.println("dni : " + u.getDni());
            System.out.println("usuario : " + u.getUsuario());

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

    
    //Debe venir de los botones regresar en la lista de partidos o la creacion de partidos
    //Asi tambien debe venir despues de la correcta inscripcion de partido o creacion de este
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Paso 1: recuperar sesion
        HttpSession s = request.getSession(true);

        //Paso 2: recuperar datos
        UsuarioBean u = new UsuarioBean();
        u.setUsuario((String) request.getAttribute("usuario"));

        //Paso 3: logica

        UsuarioIF ui = new UsuarioDAO();
        u = ui.getInfo2((String) request.getAttribute("usuario"));
        
        PartidosDAO p = new PartidosDAO();
        u.setPartidos( p.listarPartidosXUsuario(u.getUsuario()));

       //System.out.println(Utilitarios.password(pass,u,d));
//            u.setDni((String) d.get("dni"));
//            u.setEmail((String) d.get("email"));
//            u.setNombre((String) d.get("nombre"));
//            u.setTelefono((String) d.get("telf"));
//            u.setDireccion((String) d.get("direccion"));
            //String[] a = {"1", "2"};
            //u.setPartidos(a);

            request.setAttribute("usuario", u);

            System.out.println(u.getDni());
            System.out.println(u.getUsuario());
            System.out.println(u.getTelefono());


            RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
            rd.forward(request, response);
            

    }
}
