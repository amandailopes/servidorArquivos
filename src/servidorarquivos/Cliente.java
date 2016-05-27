/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorarquivos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amanda
 */
public class Cliente {

    public static void main(String[] args) throws InterruptedException {
        try {
            Socket s_cliente;
            DataOutputStream dados;
            String filename = "arquivoParaTransferencia";
            s_cliente = new Socket("192.168.0.3", 12345);
            dados = new DataOutputStream(s_cliente.getOutputStream());
            dados.writeUTF(filename);
            Thread.sleep(1000);
            
            s_cliente = new Socket("192.168.0.3", 12345);
            dados = new DataOutputStream(s_cliente.getOutputStream());
            FileInputStream fileStream = new FileInputStream(filename);
            File file = new File(filename);
            int length = (int) file.length();
            byte[] buffer = new byte[length];
            int nBytes;
            while ((nBytes = fileStream.read(buffer)) != -1) {
                String msgDecode = new String(buffer, "UTF-8");
                dados.writeUTF(msgDecode);
            }
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
