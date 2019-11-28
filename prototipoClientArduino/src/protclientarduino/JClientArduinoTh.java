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
public class JClientArduinoTh extends Thread{
    
    
    private JClientArduino clientArduino;

    public JClientArduinoTh() {
        
        clientArduino = new JClientArduino();
    }
    
    @Override
    public void run() {      
        while(!isInterrupted())
        {
            clientArduino.sendArduinoDataToTheServer();
        }  
    }
    
    
    
}
