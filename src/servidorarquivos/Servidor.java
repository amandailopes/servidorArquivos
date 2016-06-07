/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorarquivos;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class Servidor {

    private ArrayList<usuario> usuarios = new ArrayList<>();
    private ArrayList<usuario> usuariosLogados = new ArrayList<>();

    private void receberLogin(String readUTF) {
        String[] split = readUTF.split(";");
        String login = split[1];
        String Senha = split[2];
        for (usuario u : usuarios) {
            if (u.login.equals(login) && u.senha.equals(Senha)) {
                System.out.println(login + "conectado!");
            }
        }
    }

    public Servidor() throws IOException {
        ServerSocket servidor;
        DataInputStream dados;
        servidor = new ServerSocket(12345);

        while (true) {
            Socket cliente = servidor.accept();
            dados = new DataInputStream(cliente.getInputStream());
            String readUTF = dados.readUTF();
            String[] split = readUTF.split(";");
            Integer c = new Integer(split[0]);
            switch (c) {
                case 1:
                    receberLogin(readUTF);
                    break;
                case 2:
                    receberArquivo(readUTF);
                    break;
                case 3:
                    cadastrarUsuario(readUTF);
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Servidor s = new Servidor();
    }

    private void receberArquivo(String readUTF) {
        String[] split = readUTF.split(";");
        String descricao = split[0];
        String palavraChave = split[1];
        String arquivo = split[2];
        System.out.println(descricao + palavraChave + arquivo);
    }

    private void cadastrarUsuario(String readUTF) {
        String[] split = readUTF.split(";");
        String nome = split[0];
        String login = split[1];
        String Senha = split[2];
        usuarios.add(new usuario(nome, login, Senha));
    }

    class usuario {

        protected String login;
        protected String senha;
        protected String nome;

        public usuario(String nome, String login, String senha) {
            this.login = login;
            this.senha = senha;
            this.nome = nome;
        }

    }
}
