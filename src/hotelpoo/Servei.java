/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelpoo;

/**
 *
 * @author Alan Arrua
 */
public class Servei {
    
    private int idServei;
    private String descripcio;
    private double preuServei;

    public Servei(int idServei, String descripcio, double preuServei) {
        this.idServei = idServei;
        this.descripcio = descripcio;
        this.preuServei = preuServei;
    }

    public int getIdServei() {
        return idServei;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public double getPreuServei() {
        return preuServei;
    }

    public void setIdServei(int idServei) {
        this.idServei = idServei;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public void setPreuServei(double preuServei) {
        this.preuServei = preuServei;
    }

    @Override
    public String toString() {
        return "Servei{" + "idServei=" + idServei + ", descripcio=" + descripcio + ", preuServei=" + preuServei + '}';
    }
    
    
    
}
