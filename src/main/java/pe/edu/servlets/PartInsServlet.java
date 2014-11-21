/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.servlets;

import edu.pe.clases.PartidosDAO;
import edu.pe.clases.PartidosIF;
import edu.pe.clases.UsuarioDAO;
import edu.pe.clases.UsuarioIF;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.bean.PartidoBean;
import pe.edu.bean.UsuarioBean;

/**
 *
 * @author GooMoonRyong
 */
public class PartInsServlet extends HttpServlet {

    //inscripcion solidaria
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession s = request.getSession(true);
                
        UsuarioBean u = (UsuarioBean) s.getAttribute("usuario");
        String usuario = u.getUsuario();
        boolean esta = false;
        
        PartidosIF a = new PartidosDAO();
        
        List l = a.obtenerSolidario();
//        List l = new ArrayList();
        
        l.add("yainscrito");
        
        for(int i = 0;i<l.size();i++){
            System.out.println();
            if(l.get(i) == usuario ){
                   esta = true;
            }
        }
        
        if(esta == true){
//         Pagina de no puedes intentalo nuevamente
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>!!!Ya estas inscrito!!!</title>");
            out.println("<link href=\"css/landing-page.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"intro-header\">");
            out.println("<h1> Ya estabas inscrito en la lista solidaria :/ </h1>");
            out.println("<a href= 'usuario.jsp'>Te avisaremos cuando haya partidos</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }else{
        
        
//        a.anadirSolidario(usuario);
        PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>!!!Felicidades estas inscrito!!!</title>");
            out.println("<link href=\"css/landing-page.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"intro-header\">");
            out.println("<h1> Ya estas inscrito en la lista solidaria </h1>");
            out.println("<a href= 'usuario.jsp'>Te avisaremos cuando halla partidos</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");      
        
        
        }
 
            
    }

    //El metodo DAO tiene que sacar la lista de jugadores para saber si ya esta inscrito y no inscribir doble
    //El metodo DAO(otro) tambien tiene que poder dejar inscribirlo
    //Te lo manda desde lista partido al hacer click en inscribirse
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //aca comienza
        HttpSession s = request.getSession(true);
        
        PartidoBean p = (PartidoBean) request.getAttribute("partido");
        
        UsuarioBean u = (UsuarioBean) s.getAttribute("usuario");
        String usuario = u.getUsuario();
        boolean inscrito = false;
        
        PartidosIF pa = new PartidosDAO();
        
        //aca debe ir el metodo del DAO que saque una lista con los usuarios inscritos para el partido
//        List l = pa.getUsuarios();
        
        List l = new ArrayList();
        l.add("pelucas");
        l.add("loco");
        l.add("charito9000");
        
        for(int i = 0 ; i < l.size() ; i++){
            if(l.get(i).equals(usuario)){
                inscrito = true;
            }
        }
        
        if(inscrito == false){
            //Usando el metodo del DAO que inscribe al partido
//            a.inscribir(u.getUsuario());
            //luego lo mandas a su pagina
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>!!!Ya estas inscrito!!!</title>");
            out.println("<link href=\"css/landing-page.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"intro-header\">");
            out.println("<h1> Ya estas inscrito en este partido Disfrutalo con tus patas </h1>");
            out.println("<a href= 'usuario.jsp'>No te olvides de ir en la fecha programada</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }else{
            //Pagina de no puedes intentalo nuevamente
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>!!!Ya estas inscrito!!!</title>");
            out.println("<link href=\"css/landing-page.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"intro-header\">");
            out.println("<h1> Ya estas inscrito en este partido y no puedes inscribirte nuevamente </h1>");
            out.println("<a href= 'usuario.jsp'>No te olvides de ir en la fecha programada</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
        
        
        
        
        
    }

}
