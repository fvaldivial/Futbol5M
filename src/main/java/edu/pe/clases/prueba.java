/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pe.clases;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.bean.CanchaBean;
import pe.edu.servlets.LoginServlet;

/**
 *
 * @author GooMoonRyong
 */
public class prueba {
    
    public static void main(String[] args){
    
//               CanchaBean a;
//        for(int i = 0;i < 5; i++){
//                a = new CanchaBean(i + " " + Math.random(), "pepes " + i);
//            try {
//                Utilitarios.crearCanchas(a);
//            } catch (UnknownHostException ex) {
//                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        
        PartidosDAO p = new PartidosDAO();
        p.cancelarPartido("546937abf7858f73c6f410f0");
    
    }
    
}
