/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.servlets;

import edu.pe.clases.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DAMR
 */
@WebServlet(name = "PartidoServlet", urlPatterns = {"/PartidoServlet"})
public class PartidoServlet extends HttpServlet {
    
    //viene de inscripcion
    //redirije a lista partidos
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession s = request.getSession(true);
          
        PartidosDAO p = new PartidosDAO();
              
        List l = p.listarPartidos();
        
        request.setAttribute("usuario", request.getParameter("usuario"));
        System.out.println("este es el usuario " +request.getParameter("usuario"));
        request.setAttribute("partidos", l);
        
        RequestDispatcher rd = request.getRequestDispatcher("listapartidos.jsp");
        rd.forward(request, response);
             
    }

   //
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession s = request.getSession(true);
          
        PartidosDAO p = new PartidosDAO();
              
        List l = p.listarPartidos();
        
        request.setAttribute("usuario", request.getParameter("usuario"));
        System.out.println("este es el usuario " +request.getParameter("usuario"));
        request.setAttribute("partidos", l);
        
        RequestDispatcher rd = request.getRequestDispatcher("listapartidos.jsp");
        rd.forward(request, response);
        
    }

    

}
