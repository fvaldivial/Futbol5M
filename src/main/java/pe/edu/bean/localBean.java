
package pe.edu.bean;

import java.io.Serializable;


public class localBean  implements Serializable{
    public String id;
    public String nombre;
    public String direccion;
    public int telf;
    public String correo;
    public int precioh;
    public int preciohl;

    public localBean(String id, String nombre, String direccion, int telf, String correo, int precioh, int preciohl) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telf = telf;
        this.correo = correo;
        this.precioh = precioh;
        this.preciohl = preciohl;
    }

    public localBean() {
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPrecioh() {
        return precioh;
    }

    public void setPrecioh(int precioh) {
        this.precioh = precioh;
    }

    public int getPreciohl() {
        return preciohl;
    }

    public void setPreciohl(int preciohl) {
        this.preciohl = preciohl;
    }
    
    
    
    
}
