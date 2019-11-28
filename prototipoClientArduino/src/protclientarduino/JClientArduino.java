/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protclientarduino;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samue
 */
public class JClientArduino {

    private JSerialManager sM;
    private JClient client;

    public JClientArduino() {

        try {
            sM = new JSerialManager("COM4");
            InetAddress IPServer = InetAddress.getLocalHost();
            client = new JClient(IPServer, 6000);

        } catch (UnknownHostException ex) {
            Logger.getLogger(JClientArduino.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public boolean sendArduinoDataToTheServer() {
        try {
            String stringToSend;
            stringToSend = sM.readLine();
            client.sendArduinoData(stringToSend);
            return true; //Dati inviati correttamente
        } catch(Exception e) {
            return false; //Invio dati fallito
        } 
    } 
    
    
    
    

}
