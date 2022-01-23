/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalClases;

/**
 *
 * @author josem
 */
public class Usuario {
    protected String usuario;
    protected String tipo;
    protected String contraseña;
    
    public Usuario(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
        //revisar en la lista de usuarios que tipo concuerda
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
