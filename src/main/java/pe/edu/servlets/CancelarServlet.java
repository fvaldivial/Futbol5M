/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.servlets;

import edu.pe.clases.PartidosDAO;
import edu.pe.clases.PartidosIF;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.bean.UsuarioBean;

/**
 *
 * @author GooMoonRyong
 */
public class CancelarServlet extends HttpServlet {

    //viene de usuario cuando quiere cancelar un partido
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Paso 1: recuperar sesion
        HttpSession s = request.getSession(true);
        
        PartidosIF p = new PartidosDAO();
        
        p.cancelarPartido(request.getParameter("partido"));
        System.out.println("partido id : " + request.getParameter("partido"));
        
        UsuarioBean u = (UsuarioBean) s.getAttribute("usuario");
        u.setPartidos(p.listarPartidosXUsuario(u.getUsuario()));
        s.setAttribute("usuario", u);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");    
        rd.forward(request, response);
       
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    
}
