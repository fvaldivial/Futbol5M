package edu.pe.clases;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.bean.CanchaBean;
import pe.edu.bean.PartidoBean;

public class PartidosDAO implements PartidosIF {

    MongoClient mc = null;
    DB DB = null;
    DBCollection partidos = null;
    DBCollection canchas = null;
    DBCollection solidario = null;
    MongoCredential credential = null;

    private void inicializar() throws UnknownHostException {

        credential = MongoCredential.createMongoCRCredential("futbol5", "futbol5", "futbol5".toCharArray());
        mc = new MongoClient(new ServerAddress("ds047800.mongolab.com", 47800), Arrays.asList(credential));

        DB = mc.getDB("futbol5");
        partidos = DB.getCollection("partidos");
        canchas = DB.getCollection("canchas");
        solidario = DB.getCollection("solidario");
        //System.out.println("okokok");
    }

    @Override
    public List<PartidoBean> normal() {
        List l = new ArrayList<PartidoBean>();
        PartidoBean p = null;
        int nump = 0;

        try {
            //conexion con base de datos
            inicializar();
            //sacar las cosas de la bd
        } catch (UnknownHostException ex) {
            Logger.getLogger(PartidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        //poner los datos a cada partidoBean
        //poner un contador para saber cuantos partidos hay
        for (int i = 0; i <= nump; i++) {
            l.add(p);
        }

        return l;
    }

    public void crearPartido(PartidoBean pb) {
        try {
            inicializar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(PartidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        BasicDBObject partido = new BasicDBObject();
        //verificar si la lista de jugadores se inserta correctamente
        partido.append("cancha", pb.getCancha()).append("admin", pb.getAdmin()).append("turno", pb.getTurno()).append("fechai", pb.getFechai()).append("pago", pb.getPago());
        partidos.insert(partido);
    }

    public List listarPartidos() {
        try {
            inicializar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(PartidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<PartidoBean> PB = new ArrayList<PartidoBean>();

        DBCursor cursor = partidos.find();
        try {
            while (cursor.hasNext()) {
                DBObject partido = new BasicDBObject();
                partido = cursor.next();
                PartidoBean u = new PartidoBean();
                u.setAdmin((String) partido.get("admin"));
                u.setCancha((String) partido.get("cancha"));
                //u.setCont(Integer.parseInt((String) partido.get("cont")));
                u.setFechai((String) partido.get("fechai"));
                u.setFechap((String) partido.get("fechap"));
                u.setId("" + partido.get("_id"));
                PB.add(u);
            }
        } finally {
            cursor.close();
        }

        return PB;
    }

    public List obtenerJugadores(String id) {
        try {
            inicializar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(PartidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<PartidoBean> usuarios = new ArrayList<PartidoBean>();

        BasicDBObject query = new BasicDBObject("_id", id);

        DBCursor cursor = partidos.find(query);

        try {
            while (cursor.hasNext()) {
                cursor.next().get("jugadores");
            }
        } finally {
            cursor.close();
        }

        return PB;
    }

    public List listarPartidosXUsuario(String admin) {
        try {
            inicializar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(PartidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<PartidoBean> PB = new ArrayList<PartidoBean>();

        BasicDBObject query = new BasicDBObject("admin", admin);

        DBCursor cursor = partidos.find(query);
        try {
            while (cursor.hasNext()) {
                DBObject partido = new BasicDBObject();
                partido = cursor.next();
                PartidoBean u = new PartidoBean();
                u.setAdmin((String) partido.get("admin"));
                u.setCancha((String) partido.get("cancha"));
                //u.setCont(Integer.parseInt((String) partido.get("cont")));
                u.setFechai((String) partido.get("fechai"));
                u.setFechap((String) partido.get("fechap"));
                u.setId("" + partido.get("_id"));
                PB.add(u);

            }
        } finally {
            cursor.close();
        }

        return PB;

    }

    @Override
    public void cancelarPartido(String id) {
        try {
            //como se va a determinar que partido se cancela? bajo que pk?
            inicializar();
            BasicDBObject query = new BasicDBObject();
            query.put("_id", id);
            partidos.remove(query);
        } catch (UnknownHostException ex) {
            Logger.getLogger(PartidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List buscarCanchas() {
        try {
            inicializar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(PartidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<CanchaBean> PB = new ArrayList<CanchaBean>();

        DBCursor cursor = canchas.find();
        try {
            while (cursor.hasNext()) {
                DBObject partido = new BasicDBObject();
                partido = cursor.next();
                CanchaBean u = new CanchaBean();
                u.setId(partido.get("_id") + "");
                u.setLocal((String) partido.get("local"));
                PB.add(u);

            }
        } finally {
            cursor.close();
        }

        return PB;
    }

    public void anadirSolidario(String dni) {
        try {
            inicializar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(PartidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date ahora = new Date();

        BasicDBObject solidario = new BasicDBObject();
        solidario.append("_id", dni).append("fecha", ahora);

    }

    public List obtenerSolidario() {

        List lista = new ArrayList();

        BasicDBObject sortFecha = new BasicDBObject();
        sortFecha.put("fecha", -1);

        DBCursor cur = solidario.find().sort(sortFecha);

        int i = 0;
        while (cur.hasNext() && i < cur.length()) {
            lista.add(cur.next().get("dni"));

        }

        return lista;
    }

}
