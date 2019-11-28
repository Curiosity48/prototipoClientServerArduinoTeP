/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protclientarduino;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peduzzi_samuele
 */
public class JUdpReceiver {

    private int porta;
    private DatagramSocket serverSocket;
    private byte[] bufferIN;	// buffer spedizione e ricezione

    private boolean active;

    private String className;

    public JUdpReceiver(int porta) throws SocketException {
        
        startListener(porta);
        bufferIN = new byte[1024];
        className = this.getClass().getName();
    }

    public void stopListener() {

        serverSocket.close();
        active = false;
    }
    
    
    public void startListener(int porta) {
        
        try {
            this.porta = porta;
            serverSocket = new DatagramSocket(porta);
            active = true;
            System.out.println(className + ": Avviato");
        } catch (SocketException ex) {
            Logger.getLogger(JUdpReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public String getReceivedMessage() throws IOException {

        if (active) {
            int numCaratteri;
            DatagramPacket receivePacket
                    = new DatagramPacket(bufferIN, bufferIN.length);

            // analisi del pacchetto ricevuto
            // definizione del datagramma
            receivePacket
                    = new DatagramPacket(bufferIN, bufferIN.length);
            // attesa della ricezione dato dal client
            serverSocket.receive(receivePacket);
            // analisi del pacchetto ricevuto
            String ricevuto = new String(receivePacket.getData());
            numCaratteri = receivePacket.getLength();
            ricevuto = ricevuto.substring(0, numCaratteri);	// elimina i caratteri in eccesso

            return ricevuto;
        }
        else 
            return "";

    }

}
