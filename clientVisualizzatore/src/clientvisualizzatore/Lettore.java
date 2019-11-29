/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientvisualizzatore;

import java.util.Vector;

/**
 *
 * @author mariani_luca
 */
public class Lettore {
    private Vector<String> v;
    
    public Lettore(){
        v = new Vector<>();
    }
    
    public void aggiungiTemperatura(String t){
        v.add(t);
    }
    
    public String getTemperatura(){
        return "";
    }
}
