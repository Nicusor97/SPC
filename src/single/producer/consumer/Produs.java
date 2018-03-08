/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single.producer.consumer;

/**
 *
 * @author nicol
 */
public class Produs {
    
    private String nume;
    private float pret;
    
    public Produs(String nume, float pret)
    {
        this.nume = nume;
        this.pret = pret;
    }
    
    public String GetName()
    {
        return nume;
    }
    public float GetPret()
    {
        return pret;
    }
    
}
