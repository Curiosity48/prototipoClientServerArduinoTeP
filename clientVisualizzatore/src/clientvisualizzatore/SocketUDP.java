/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientvisualizzatore;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author mariani_luca
 */
public class SocketUDP {

    private byte[] bufferIN;
    private byte[] bufferOUT;
    private DatagramSocket socket;
    private DatagramPacket ultimoPacchettoRicevuto;

    public SocketUDP() throws SocketException, SocketException {
        bufferIN = new byte[1024];
        bufferOUT = new byte[1024];

        socket = new DatagramSocket();
    }

    public void spedisci(String messaggio, String indirizzoIP, int porta) throws UnknownHostException, IOException {
        //prepara il buffer di spedizione:
        bufferOUT = messaggio.getBytes();

        //prepara il pacchetto da spedire:
        DatagramPacket pacchettoDaSpedire = new DatagramPacket(bufferOUT, bufferOUT.length, InetAddress.getByName(indirizzoIP), porta);

        //invia il pacchetto
        socket.send(pacchettoDaSpedire);
    }

    public String ricevi() throws IOException {
        //Crea l'allocazione del pacchetto da ricevere:
        ultimoPacchettoRicevuto = new DatagramPacket(bufferIN, bufferIN.length);

        //Aspetta il pacchetto:
        socket.receive(ultimoPacchettoRicevuto);
        String ricevuto = new String(ultimoPacchettoRicevuto.getData());

        //Elabora i dati ricevuti eliminando quelli in eccesso:
        String elaborazione = ricevuto.substring(0, ultimoPacchettoRicevuto.getLength());

        return elaborazione;
    }

    public void chiudiComunicazione() {
        socket.close();
    }
}
