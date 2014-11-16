/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pe.clases;

import com.mongodb.DBObject;
import pe.edu.bean.UsuarioBean;

/**
 *
 * @author GooMoonRyong
 */
public interface UsuarioIF {
        
    public void registrar(UsuarioBean u,String pass);
    
    public DBObject getInfo(UsuarioBean u);
    
    public UsuarioBean getInfo2(String username);
    
    public DBObject login (UsuarioBean u);
}
