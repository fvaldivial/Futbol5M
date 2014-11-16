/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pe.clases;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.bean.UsuarioBean;

/**
 *
 * @author GooMoonRyong
 */
public class UsuarioDAO implements UsuarioIF {

    MongoClient mc = null;
    DB DB = null;
    DBCollection usuarios = null;
    MongoCredential credential = null;

    private void inicializar() throws UnknownHostException {

        credential = MongoCredential.createMongoCRCredential("futbol5", "futbol5", "futbol5".toCharArray());
        mc = new MongoClient(new ServerAddress("ds047800.mongolab.com", 47800), Arrays.asList(credential));

        //mc = new MongoClient("localhost", 27017);
        DB = mc.getDB("futbol5");
        usuarios = DB.getCollection("users");
        //System.out.println("okokokk");
    }

    @Override
    public void registrar(UsuarioBean u, String pass) {
        try {
            inicializar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        Random randito = new SecureRandom();
        String passwordHash = Utilitarios.makePasswordHash(pass, Integer.toString(randito.nextInt()));

//            String passwordHash = pass;
        BasicDBObject user = new BasicDBObject();

        user.append("_id", u.getUsuario()).append("dni", u.getDni()).append("password", passwordHash).append("nombre", u.getNombre()).append("telf", u.getTelefono()).append("email", u.getEmail()).append("direccion", u.getDireccion());

        if (u.getEmail() != null && !u.getEmail().equals("")) {
            // Si es que el email no esta en blanco, lo graba
            user.append("email", u.getEmail());
        }

        usuarios.insert(user);

    }

    @Override
    public DBObject getInfo(String usuario) {
        try {
            inicializar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        DBObject d = usuarios.findOne(new BasicDBObject("_id", usuario));
       
        return d;
    }

    @Override
    public UsuarioBean getInfo2(String username) {
        try {
            inicializar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        UsuarioBean u = new UsuarioBean();

        DBObject d = usuarios.findOne(new BasicDBObject("_id", username));

        u.setUsuario((String) d.get("_id"));
        u.setDni((String) d.get("dni"));
        u.setEmail((String) d.get("email"));
        u.setNombre((String) d.get("nombre"));
        u.setTelefono((String) d.get("telf"));
        u.setDireccion((String) d.get("direccion"));

        return u;
    }

    @Override
    public DBObject login(UsuarioBean u) {
        try {
            inicializar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
