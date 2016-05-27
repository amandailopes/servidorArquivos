/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorarquivos;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Amanda
 */
public class Cliente {

    public static void main(String[] args) {
        Socket s_cliente;
        try {
            s_cliente = new Socket("192.168.0.3", 12348);
            System.out.println("Conexion OK");
        } catch (IOException ex) {
            System.err.println("E agora jose?");
        }
    }

    public Cliente() {

    }

}
