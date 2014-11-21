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
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import pe.edu.bean.CanchaBean;
import pe.edu.bean.UsuarioBean;
import sun.misc.BASE64Encoder;

/**
 *
 * @author GooMoonRyong
 */
public class Utilitarios {

    public static String makePasswordHash(String password, String salt) {
        try {
            String saltedAndHashed = password + "," + salt;
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(saltedAndHashed.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            byte hashedBytes[] = (new String(digest.digest(), "UTF-8")).getBytes();
            return encoder.encode(hashedBytes) + "," + salt;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 is not available", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 unavailable?  Not a chance", e);
        }
    }

    public static boolean password(String pass, UsuarioBean u, DBObject db) {

        String hashedAndSalted = (String) db.get("password");

        String salt = hashedAndSalted.split(",")[1];

        if (!hashedAndSalted.equals(Utilitarios.makePasswordHash(pass, salt))) {
            System.out.println(Utilitarios.makePasswordHash(pass, salt));
            return false;
        } else {
            return true;
        }
    }

    public static void crearCanchas(CanchaBean c) throws UnknownHostException {

        MongoClient mc = null;
        DB DB = null;
        DBCollection canchas = null;
        MongoCredential credential = null;
        
        credential = MongoCredential.createMongoCRCredential("futbol5", "futbol5", "futbol5".toCharArray());
       mc = new MongoClient(new ServerAddress("ds047800.mongolab.com", 47800), Arrays.asList(credential));

        //mc = new MongoClient("localhost", 27017);
        DB = mc.getDB("futbol5");
        canchas = DB.getCollection("canchas");
        BasicDBObject partido = new BasicDBObject();
        //verificar si la lista de jugadores se inserta correctamente
        partido.append("_id",c.getId()).append("local",c.getLocal());
        canchas.insert(partido);

    }
    
    public static UsuarioBean rellenarUsuario(DBObject d){
             
        UsuarioBean u = new UsuarioBean();
        
        u.setUsuario((String) d.get("_id"));
        u.setDni((String) d.get("dni"));
        u.setEmail((String) d.get("email"));
        u.setNombre((String) d.get("nombre"));
        u.setTelefono((String) d.get("telf"));
        u.setDireccion((String) d.get("direccion"));
        
        return u;
    }
    
    
}
