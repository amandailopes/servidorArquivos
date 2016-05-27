/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorarquivos;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amanda
 */
public class Servidor {

    public Servidor() {

    }

    public static void main(String[] args) {
        ServerSocket servidor;
        DataInputStream dados;
        try {
            servidor = new ServerSocket(12345);
            while (true) {
                Socket cliente = servidor.accept();
                dados = new DataInputStream(cliente.getInputStream());
                System.out.println(dados.readUTF());
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
