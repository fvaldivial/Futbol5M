package edu.pe.clases;

import java.util.List;
import pe.edu.bean.PartidoBean;


public interface PartidosIF {
    
    public List<PartidoBean> normal();
    
    public void crearPartido(PartidoBean pb);
    
    public List listarPartidos();
    
    public List listarPartidosXUsuario(String admin);
    
    public void cancelarPartido(String id);
    
    public List buscarCanchas();
    
    public void anadirSolidario(String dni);
    
    public List obtenerSolidario();
}
