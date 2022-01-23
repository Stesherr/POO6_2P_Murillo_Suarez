/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraClases;

import generalClases.Usuario;
import java.util.Date;

/**
 *
 * @author josem
 */
public class Solicitud {
    public int idSolicitud;
    public Usuario usuarioPaciente;
    public String direccion;
    public Date fecha;
    public String hora;
    public Double ubicacionX;
    public Double ubicacionY;
    public Double totalPagar;

    public Solicitud(int idSolicitud, Usuario usuarioPaciente, String direccion, Date fecha, String hora, Double ubicacionX, Double ubicacionY, Double totalPagar) {
        this.idSolicitud = idSolicitud;//creo se genera no se pide
        this.usuarioPaciente = usuarioPaciente;
        this.direccion = direccion;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacionX = ubicacionX;
        this.ubicacionY = ubicacionY;
        this.totalPagar = totalPagar;
    }
    
    public void escribirArchivo(){
        //escritura de archivo
    }
    
    public void detallarArchivo(){
        //escritura del archivo de detalles de las solicitudes
    }
    
    public void enviarCorreo(){
        //envio de correo al maill del usuario
    }
}
