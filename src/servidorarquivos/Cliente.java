/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorarquivos;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amanda
 */
public class Cliente {
    Socket s_cliente;

    public Cliente() {
        try {
            this.s_cliente = new Socket("127.0.0.1", 12345);
            System.out.println("Conexion OK");
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
}
