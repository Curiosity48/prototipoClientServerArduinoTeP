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
public class JClientArduinoSenderTh extends Thread{
    
    
    private JArduinoSenderReceiverManager clientArduino;

    public JClientArduinoSenderTh(JArduinoSenderReceiverManager clientArduino) {
        this.clientArduino = clientArduino;
    }

   
    
    @Override
    public void run() {      
        while(!isInterrupted())
        {
            clientArduino.sendArduinoDataToTheServer();
        }  
    }
    
    
    
}
