/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protclientarduino;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samue
 */
public class JArduinoSenderReceiverManager {

    private static JSerialManager sM;
    private static JUdpSender UDPSender;
    private static JUdpReceiver UDPReceiver;
    
    private String className;

    public JArduinoSenderReceiverManager() {

        try {
            sM = new JSerialManager();
            InetAddress IPServer = InetAddress.getLocalHost();
            UDPSender = new JUdpSender(IPServer, 6000);
            UDPReceiver = new JUdpReceiver(6001);
            
            className = this.getClass().getName();

        } catch (Exception ex) {
            Logger.getLogger(JArduinoSenderReceiverManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean sendArduinoDataToTheServer() {
        try {
            String stringToSend;
            stringToSend = sM.readLine(6);
  
            UDPSender.sendArduinoData(stringToSend);
            System.out.println(className + ": Stringa inviata al server: " + stringToSend );
            return true; //Dati inviati correttamente
        } catch (Exception e) {
            return false; //Invio dati fallito
        }
    }

    public void chkComandsFromTheServer() {

        String receivedMessage;
        try {
            receivedMessage = UDPReceiver.getReceivedMessage();
            if (receivedMessage.equals("lon")) {
                turnOnTheLed();
            } else if(receivedMessage.equals("lof"))
                turnOffTheLed();

        } catch (IOException ex) {
            Logger.getLogger(JArduinoSenderReceiverManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean turnOnTheLed() { //Invia il segnale di accensione del Led

        if (sM.sendString("lOn")) {
            System.out.println(className + ": Led acceso");
            return true;
        } else {
            return false;
        }

    }

    private boolean turnOffTheLed() { //Invia il segnale di accensione del Led

        if (sM.sendString("lOf")) {
            System.out.println(className + ": Led spento");
            return true;
        } else {
            return false;
        }

    }

}
