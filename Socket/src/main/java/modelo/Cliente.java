package modelo;

/**
 *
 * @author spart
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Cliente {
    static String HOST = "localhost";
    static int PUERTO = 5000;
    Socket sc;
    DataOutputStream salida;
    DataInputStream entrada;
    String mensajeRecibido;

    public void initCliente(){
        Scanner teclado = new Scanner(System.in);
        try{
            sc = new Socket(HOST, PUERTO);
            salida = new DataOutputStream(sc.getOutputStream());
            entrada = new DataInputStream(sc.getInputStream());
            String msn = "";
            while(!msn.equals("x")){
                System.out.println("Escriba un msn para enviar");
                msn = teclado.nextLine();
                salida.writeUTF(msn);//enviamos mensaje
                mensajeRecibido = entrada.readUTF();//Leemos respuesta
                System.out.println(mensajeRecibido);
            }
            
            sc.close();
        }catch(Exception e){

        }
    }

    public static void main(String[] args){
        Cliente o = new Cliente();
        o.initCliente();
    }

}