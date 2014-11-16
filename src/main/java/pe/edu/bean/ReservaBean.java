
package pe.edu.bean;

import java.io.Serializable;


public class ReservaBean  implements Serializable{
    public String fecha;
    public int turno;

    public ReservaBean(String fecha, int turno) {
        this.fecha = fecha;
        this.turno = turno;
    }

    public ReservaBean() {
    }
    
    
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    
    
    
}
