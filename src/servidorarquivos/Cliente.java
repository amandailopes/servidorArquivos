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

    public static void main(String[] args) {
        try {
            Socket s_cliente;
            DataOutputStream dados;
            s_cliente = new Socket("192.168.0.3", 12345);
            dados = new DataOutputStream(s_cliente.getOutputStream());
            FileInputStream file = new FileInputStream("arquivoParaTransferencia");
            File f = new File("arquivoParaTransferencia");
            int length = (int) f.length();
            byte[] buffer = new byte[length];
            int nBytes;
            while ((nBytes = file.read(buffer)) != -1) {
                String msgDecode = new String(buffer, "UTF-8");
                dados.writeUTF(msgDecode);
            }
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
