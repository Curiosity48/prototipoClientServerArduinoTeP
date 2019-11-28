/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protclientarduino;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.*;

/**
 *
 * @author peduzzi_samuele
 */
public class JSerialManager {

    private SerialPort sP;
    private String className;

    public void JSerialManager(String portName) {
        
        className = this.getClass().getName().toUpperCase();

        try {
            sP = new SerialPort(portName);
            sP.openPort();
            sP.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            if (sP.openPort()) {
                System.out.print(className + ": Porta aperta");
            } else {
                System.out.print(className + ": Impossibile aprire la porta");
            }
        } catch (SerialPortException ex) {
            Logger.getLogger(JSerialManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JSerialManager() {
        
        JSerialManager(portSelector());
    }
    
    
    
    
    
    private String portSelector() {

        String[] portNames = SerialPortList.getPortNames();
        Scanner scanner = new Scanner(System.in);
        String portName = "COM1";

        if (portNames.length == 0) {
            System.out.println("Non ci sono porte disponibili");
        } else {
            for (int i = 0; i < portNames.length; i++) {
            System.out.println(portNames[i]);
            }
            System.out.println("Seleziona una porta");
            portName = scanner.nextLine();
        }
        
        return portName;
        
    }
    
    public String readLine(int lenghtOfStringToRead) {
        
        String receivedStr = "";
        
        try {
            if(sP.isOpened())
                receivedStr =  sP.readString(lenghtOfStringToRead);
            
        } catch (SerialPortException ex) {
            Logger.getLogger(JSerialManager.class.getName()).log(Level.SEVERE, null, ex);                                                          
        }
        
        
        return receivedStr;
    }
    
    
    public boolean sendString(String stringToSend) {

        try {
            sP.writeString(stringToSend);
            return true;
        } catch (SerialPortException ex) {
            Logger.getLogger(JSerialManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    
    
    
    }
