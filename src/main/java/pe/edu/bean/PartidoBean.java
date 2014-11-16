

package pe.edu.bean;

import java.io.Serializable;


public class PartidoBean  implements Serializable{
    public String id;
    public String cancha;
    public String admin;
    public int[] jugadores;
    public int turno;
    public String fechai;
    public String fechap;
    public int pago; //si pago 1, si no pago 0
    public int idpago;
    //public int cont; //contador de dias

    public PartidoBean(String id, String cancha, String admin, int[] jugadores, int turno, String fechai, String fechap, int pago, int cont) {
        this.id = id;
        this.cancha = cancha;
        this.admin = admin;
        this.jugadores = jugadores;
        this.turno = turno;
        this.fechai = fechai;
        this.fechap = fechap;
        this.pago = pago;
        //this.cont = cont;
    }

    public PartidoBean() {
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCancha() {
        return cancha;
    }

    public void setCancha(String cancha) {
        this.cancha = cancha;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public int[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(int[] jugadores) {
        this.jugadores = jugadores;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String getFechai() {
        return fechai;
    }

    public void setFechai(String fechai) {
        this.fechai = fechai;
    }

    public String getFechap() {
        return fechap;
    }

    public void setFechap(String fechap) {
        this.fechap = fechap;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

//    public int getCont() {
//        return cont;
//    }
//
//    public void setCont(int cont) {
//        this.cont = cont;
//    }
//    
    
    
}
