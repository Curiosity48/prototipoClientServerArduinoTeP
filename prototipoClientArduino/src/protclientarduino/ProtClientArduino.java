/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protclientarduino;

import java.io.IOException;



/**
 *
 * @author peduzzi_samuele
 */
public class ProtClientArduino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        JClientArduino clientArduino = new JClientArduino();
        clientArduino.startArduinoClient();
        
        //System.in.available();
        
        //clientArduino.stopArduinoClient();
        
        
        

    }
    
}
