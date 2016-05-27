/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorarquivos;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Amanda
 */
public class Cliente {

    public static void main(String[] args) {
        Socket s_cliente;
        DataOutputStream dados;
        try {
            s_cliente = new Socket("192.168.0.3", 12345);
            dados = new DataOutputStream(s_cliente.getOutputStream());
            dados.writeUTF("Hey, to aqui!");
        } catch (IOException ex) {
            System.err.println("E agora jose?");
        }
    }

}
