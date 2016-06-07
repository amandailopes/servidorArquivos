/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorarquivos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amanda
 */
public class Cliente {

    String IP = "192.168.0.7";
    int porta = 12345;

    public void enviarInfo(String codigo, String... d) {
        try {
            String info = codigo;
            for (int i = 0; i < d.length; i++) {
                info += ";" + d[i];
            }
            info += ";";
            Socket s_client = new Socket(IP, porta);
            DataOutputStream dados = new DataOutputStream(s_client.getOutputStream());
            dados.writeUTF(info);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void login(String login, String Password) {
        String d[] = new String[2];
        d[0] = login;
        d[1] = Password;
        enviarInfo("3", d);
    }

    public void novoLogin(String nome, String login, String Password) {
        String d[] = new String[3];
        d[0] = nome;
        d[1] = login;
        d[2] = Password;
        enviarInfo("1", d);
    }

    public void enviarArquivo(String descricao, String palavraChave, File f) {
        try {
            String d[] = new String[3];
            d[0] = descricao;
            d[1] = palavraChave;
            FileInputStream fileStream;
            fileStream = new FileInputStream(f.getName());
            int length = (int) f.length();
            byte[] buffer = new byte[length];
            int nBytes;
            while ((nBytes = fileStream.read(buffer)) != -1) {
                d[3] = new String(buffer, "UTF-8");
            }
            enviarInfo("2", d);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) throws InterruptedException, IOException {
//        try {
//            Socket s_cliente;
//            DataOutputStream dados;
//            String filename = "arquivoParaTransferencia";
//            s_cliente = new Socket("192.168.0.4", 12345);
//            dados = new DataOutputStream(s_cliente.getOutputStream());
//            dados.writeUTF(filename);
//            Thread.sleep(1000);
//
//            s_cliente = new Socket("192.168.0.4", 12345);
//            dados = new DataOutputStream(s_cliente.getOutputStream());
//            FileInputStream fileStream = new FileInputStream(filename);
//            File file = new File(filename);
//            int length = (int) file.length();
//            byte[] buffer = new byte[length];
//            int nBytes;
//            while ((nBytes = fileStream.read(buffer)) != -1) {
//                String msgDecode = new String(buffer, "UTF-8");
//                dados.writeUTF(msgDecode);
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Cliente c = new Cliente();
        c.novoLogin("Kennedy", "kenreurison", "minhaSenha");
        c.login("kenreurison", "minhaSenha");
        c.enviarArquivo("Um arquivo pra recordar", "uapr", new File("arquivoParaTransferencia"));
    }
}
