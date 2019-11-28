/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protclientarduino;

/**
 *
 * @author samue
 */
public class JClientArduino {
    
    private JArduinoSenderReceiverManager Manager;
    private JClientArduinoReceiverTh recTh;
    private JClientArduinoSenderTh sendTh;

    public JClientArduino() {
        
        Manager = new JArduinoSenderReceiverManager();
        recTh = new JClientArduinoReceiverTh(Manager);
        sendTh = new JClientArduinoSenderTh(Manager);
        
    }
    
    public void startArduinoClient() {
        
        recTh.start();
        sendTh.start();
        
    }
    
    public void stopArduinoClient() {
        
        recTh.interrupt();
        sendTh.interrupt();
    }
    
    
    
    
    
    
    
    
    
    
    
}
