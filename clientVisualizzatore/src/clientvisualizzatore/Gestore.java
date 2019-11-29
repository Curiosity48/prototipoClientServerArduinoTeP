/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientvisualizzatore;

import java.net.SocketException;

/**
 *
 * @author mariani_luca
 */
public class Gestore {
    private Lettore l;
    private Scrittore s;
    private SocketUDP so;
    
    public Gestore() throws SocketException{
        l = new Lettore();
        s = new Scrittore();
        so = new SocketUDP();
    }
    
    public void gestisciLettura(){
        
    }
}
