/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraClases;

import static com.pooespol.proyectopoo_2p_murillo_suarez.OpcionesPController.tests;
import generalClases.Paciente;
import generalClases.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
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
    public Paciente usuarioPaciente;
    public String direccion;
    public String fecha;
    public String hora;
    public Double ubicacionX;
    public Double ubicacionY;
    public Double totalPagar;
    public int codigo;
    //lista de pruebas

    public Solicitud( Paciente usuarioPaciente, String direccion, String fecha, String hora, Double ubicacionX, Double ubicacionY, Double totalPagar) {
        Random rand = new Random();
        this.idSolicitud = rand.nextInt(1000000);//creo se genera no se pide
        this.usuarioPaciente = usuarioPaciente;
        this.direccion = direccion;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacionX = ubicacionX;
        this.ubicacionY = ubicacionY;
        this.totalPagar = totalPagar;
        this.codigo = rand.nextInt(10000);
    }

    public Solicitud(int idSolicitud, Paciente usuarioPaciente, String direccion, String fecha, String hora, Double ubicacionX, Double ubicacionY, Double totalPagar) {
        this.idSolicitud = idSolicitud;
        this.usuarioPaciente = usuarioPaciente;
        this.direccion = direccion;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacionX = ubicacionX;
        this.ubicacionY = ubicacionY;
        this.totalPagar = totalPagar;
        this.codigo = codigoSol(idSolicitud);
    }
    
    

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Paciente getUsuarioPaciente() {
        return usuarioPaciente;
    }

    public void setUsuarioPaciente(Paciente usuarioPaciente) {
        this.usuarioPaciente = usuarioPaciente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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

    public int getCodigo() {
        return codigo;
    }
    
    
    public void escribirArchivo(){
        try
        {
        FileWriter escribir=new FileWriter("src/main/resources/docs/contratatacionesPruebas.txt",true);
        escribir.write(this.idSolicitud+","+this.usuarioPaciente.getUsuario()+","+this.direccion+","+this.fecha+","+this.hora+","+this.ubicacionX+","+this.ubicacionY+","+this.totalPagar+"\n");
        
        escribir.close();
        }catch(Exception e)
        {
        System.out.println("Error al escribir");
        }
    
    }
    
    public ArrayList<Solicitud> leerSolicitudes(){
        ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
        ArrayList<Paciente> pacientes = Paciente.leerPacientes();
        
        try ( BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/docs/contratatacionesPruebas.txt"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] line = linea.split(",");
                
                for (int i = 0; i < pacientes.size(); i++) {
                    if(line[1].equals(pacientes.get(i).getUsuario())){
                        solicitudes.add(new Solicitud(Integer.parseInt(line[0]), pacientes.get(i), line[2], line[3], line[4], Double.parseDouble(line[5]), Double.parseDouble(line[6]), Double.parseDouble(line[7])));
                        break;
                    }
                }
                
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        
        return solicitudes;
    }
    
    public static int codigoSol(int id){
        int codSol=0;
        try ( BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/docs/detallesSolicitudes.txt"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] line = linea.split(",");
                if(id==Integer.parseInt(line[0])){
                    codSol = Integer.parseInt(line[1]);
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        return codSol;
    }
    
    public void detallarArchivo(Prueba p){
        try
        {
        FileWriter escribir=new FileWriter("src/main/resources/docs/detallesSolicitudes.txt",true);
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
            String nombres ="";
            for (Prueba p: tests){
                int k = 0;
                if(k==0){
                    nombres.concat("  "+p.getNombrePrueba());
                    k++;
                }else{
                nombres.concat(", "+p.getNombrePrueba());
                }
            }
            message.setText("FECHA: "+this.fecha+"\n" +
                            "HORA; "+this.hora+"\n" +
                           "PRUEBAS SOLICITADAS;"+nombres+"\n" +
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
