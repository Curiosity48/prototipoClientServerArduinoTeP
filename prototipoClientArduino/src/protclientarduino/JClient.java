/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protclientarduino;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author peduzzi_samuele
 */
public class JClient {

    private byte[] bufferOUT;
    private InetAddress IPServer;
    private int portaServer;

    public JClient(InetAddress IPServer, int portaServer) {
        this.IPServer = IPServer;
        this.portaServer = portaServer;
        bufferOUT = new byte[1024];
    }

    public void sendArduinoData(String arduinoString) throws FileNotFoundException, SocketException, IOException {

        String daSpedire = arduinoString;

        // creazione del socket
        DatagramSocket clientSocket = new DatagramSocket();
        bufferOUT = daSpedire.getBytes();
        DatagramPacket sendPacket
                = new DatagramPacket(bufferOUT, bufferOUT.length, IPServer, portaServer);

        clientSocket.send(sendPacket);
        clientSocket.close();
    }

}
