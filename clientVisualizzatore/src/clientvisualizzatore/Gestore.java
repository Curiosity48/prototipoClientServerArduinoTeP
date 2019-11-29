/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientvisualizzatore;

import java.io.IOException;
import java.net.SocketException;

/**
 *
 * @author mariani_luca
 */
public class Gestore {

    private Lettore l;
    private Scrittore s;
    private SocketUDP so;

    public Gestore(Lettore l, Scrittore s, SocketUDP so) throws SocketException {
        this.l = l;
        this.s = s;
        this.so = so;
    }

    public void gestisciLettura() throws IOException {
        String temperaturaDaAggiungere = "";
        temperaturaDaAggiungere = so.ricevi();
        l.aggiungiTemperatura(temperaturaDaAggiungere);
    }
    
    public void gestisciScrittura(){
        
    }
}
