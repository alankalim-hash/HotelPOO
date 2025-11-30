/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelpoo;

/**
 *
 * @author Alan Arrua
 */
public class Habitacion {
    
    private int numHabi;
    private Double preuPerNit;
    private Boolean lliure;

    public Habitacion(int numHabi, Double preuPerNit) {
        this.numHabi = numHabi;
        this.preuPerNit = preuPerNit;
        this.lliure = true;
    }

    public int getNumHabi() {
        return numHabi;
    }

    public Double getPreuPerNit() {
        return preuPerNit;
    }

    public Boolean getLliure() {
        return lliure;
    }

    public void setNumHabi(int numHabi) {
        this.numHabi = numHabi;
    }

    public void setPreuPerNit(Double preuPerNit) {
        this.preuPerNit = preuPerNit;
    }

    public void setLliure(Boolean lliure) {
        this.lliure = lliure;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "numHabi=" + numHabi + ", preuPerNit=" + preuPerNit + ", lliure=" + lliure + '}';
    }

    boolean lliure() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
