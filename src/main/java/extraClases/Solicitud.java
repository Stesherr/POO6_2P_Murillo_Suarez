/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraClases;

import generalClases.Paciente;
import generalClases.Usuario;
import java.io.File;
import java.io.FileWriter;
import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;


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
    public int codigo;
    //lista de pruebas

    public Solicitud(int idSolicitud, Usuario usuarioPaciente, String direccion, Date fecha, String hora, Double ubicacionX, Double ubicacionY, Double totalPagar) {
        this.idSolicitud = idSolicitud;//creo se genera no se pide
        this.usuarioPaciente = usuarioPaciente;
        this.direccion = direccion;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacionX = ubicacionX;
        this.ubicacionY = ubicacionY;
        this.totalPagar = totalPagar;
        Random rand = new Random();
        this.codigo = rand.nextInt(10000);
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Usuario getUsuarioPaciente() {
        return usuarioPaciente;
    }

    public void setUsuarioPaciente(Usuario usuarioPaciente) {
        this.usuarioPaciente = usuarioPaciente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Double getUbicacionX() {
        return ubicacionX;
    }

    public void setUbicacionX(Double ubicacionX) {
        this.ubicacionX = ubicacionX;
    }

    public Double getUbicacionY() {
        return ubicacionY;
    }

    public void setUbicacionY(Double ubicacionY) {
        this.ubicacionY = ubicacionY;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }
    
    
    
    public void escribirArchivo(){
        try
        {File archivo=new File("contratatacionesPruebas.txt");
        FileWriter escribir=new FileWriter(archivo,true);
        escribir.write(this.idSolicitud+","+this.usuarioPaciente+","+this.direccion+","+this.fecha+","+this.hora+","+this.ubicacionX+","+this.ubicacionY+","+this.totalPagar+"\n");
        
        escribir.close();
        }catch(Exception e)
        {
        System.out.println("Error al escribir");
        }
    
    }
    
    public void detallarArchivo(Prueba p){
        try
        {File archivo=new File("detallesSolicitudes.txt");
        FileWriter escribir=new FileWriter(archivo,true);
        escribir.write(this.idSolicitud+","+p.codigoPrueba+"\n");
        
        escribir.close();
        }catch(Exception e)
        {
        System.out.println("Error al escribir");
        }
    }
    
    public void enviarCorreo(Paciente pa){
        final String remitente = "Vithaslabs@gmail.com";  //Para la dirección nomcuenta@gmail.com
        final String clave = "vithaslabs2022";
        
        
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(pa.getEmail()));   //Se podrían añadir varios de la misma manera
            message.setSubject("Información de su solicitud");
            message.setText("FECHA: "+this.fecha+"\n" +
                            "HORA; "+this.hora+"\n" +
                            "PRUEBAS SOLICITADAS; "+"\n" +
                            "CÓDIGO para consultar resultados posteriormente: "+this.codigo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
            System.out.println("error");
        }
    }
}