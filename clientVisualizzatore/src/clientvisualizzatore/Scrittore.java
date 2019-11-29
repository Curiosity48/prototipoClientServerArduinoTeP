/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientvisualizzatore;

import event.Listener;
import java.util.Vector;

/**
 *
 * @author mariani_luca
 */
public class Scrittore {

    private Vector<Listener> vect;
    private String daScrivere;
    private Lettore l;

    public Scrittore() {
        vect = new Vector<>();
        daScrivere = "";
        l = new Lettore();
    }
    
    public void scrivi(){
        daScrivere = l.getTemperatura();
        notifica(daScrivere);
    }
    
    public void aggiungiListener(Listener li){
        vect.add(li);
    }
    
    public void rimuoviListener(Listener li){
        vect.remove(li);
    }
    
    public void notifica(String msg){
        for (int i = 0; i < 10; i++) {
            vect.elementAt(i).receive(msg);
        }
    }
}
