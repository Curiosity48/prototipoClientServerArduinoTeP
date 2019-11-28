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

/**
 *
 * @author peduzzi_samuele
 */
public class JUdpReceiver {
    
    private int porta;
    private DatagramSocket serverSocket;
    private boolean attivo;				// per la ripetizione
    private byte[] bufferIN;	// buffer spedizione e ricezione
    
    
    
    public JUdpReceiver(int porta) throws SocketException {
        this.porta = porta;
        serverSocket = new DatagramSocket(porta);
        attivo = true;
        bufferIN = new byte[1024];
    }
    
    
    public void startServer() throws IOException {
        
        System.out.println("In attesa di rispostadalServer");
        
        
        int numCaratteri;
        DatagramPacket receivePacket
                = new DatagramPacket(bufferIN, bufferIN.length);
        // attesa della ricezione dato dal client
        serverSocket.receive(receivePacket);
        // analisi del pacchetto ricevuto
        
        
        
        
        
        
        while (attivo) {
            // definizione del datagramma
            receivePacket
                    = new DatagramPacket(bufferIN, bufferIN.length);
            // attesa della ricezione dato dal client
            serverSocket.receive(receivePacket);
            // analisi del pacchetto ricevuto
            String ricevuto = new String(receivePacket.getData());
            numCaratteri = receivePacket.getLength();
            ricevuto = ricevuto.substring(0, numCaratteri);	// elimina i caratteri in eccesso
            
            String outputLine = "RICEVUTO: " + ricevuto;
            
            System.out.println(outputLine);
            
//			}
        }
        serverSocket.close();
        
    }
    
    
    
    
    
}
