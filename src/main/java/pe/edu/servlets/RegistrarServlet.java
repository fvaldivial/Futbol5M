/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.servlets;

import edu.pe.clases.UsuarioDAO;
import edu.pe.clases.UsuarioIF;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.bean.UsuarioBean;


public class RegistrarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

   
    //el que viene de inscripcion
    //1. Envia a pagina de felicilitacion y pasa al index
    //2. Envia a pagina de error y regreso     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Paso 1: recuperar sesion
        HttpSession s = request.getSession(true);
        
        
        //Paso 2: recuperar datos
        
        UsuarioBean u = new UsuarioBean();
        
        u.setDni(request.getParameter("first_name"));
        u.setTelefono(request.getParameter("last_name"));
        u.setNombre(request.getParameter("display_name"));
        u.setEmail(request.getParameter("email"));
        u.setDireccion(request.getParameter("direccion"));
        u.setUsuario(request.getParameter("usuario"));
        u.setFoto(request.getParameter("foto"));
               
        String pass = request.getParameter("password");
        String passc = request.getParameter("password_confirmation");
        
         UsuarioIF ui = new UsuarioDAO();
            
         if(pass.equals(passc) && ui.getInfo(u.getUsuario()) == null){         
           
            ui.registrar(u,pass);
            
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>!!!Felicidades!!!</title>");
            out.println("<link href=\"css/landing-page.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"intro-header\">");
            out.println("<h1> Usuario creado correctamente </h1>");
            out.println("<a href= 'loguin.jsp'>Ya puedes comenzar</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
        }else{
             PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>!!!Error!!!</title>");
            out.println("<link href=\"css/landing-page.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"intro-header\">");
            out.println("<h1> Error al crear usuario </h1>");
            out.println("<h1> Intentelo nuevamente </h1>");
            out.println("<a href= 'Inscripcion.html'>Intentarlo de nuevo</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
        
        
        
    }

  
}
