/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelpoo;
import java.time.LocalDate;

/**
 *
 * @author Alan Arrua
 */
public class Client {
    private String NIF;
    private String nom;
    private String localitat;
    private LocalDate DataNaix;
    private boolean deutor;

    public Client(String NIF, String nom, String localitat, LocalDate DataNaix, boolean deutor) {
        this.NIF = NIF;
        this.nom = nom;
        this.localitat = localitat;
        this.DataNaix = DataNaix;
        this.deutor = deutor;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalitat() {
        return localitat;
    }

    public void setLocalitat(String localitat) {
        this.localitat = localitat;
    }

    public LocalDate getDataNaix() {
        return DataNaix;
    }

    public void setDataNaix(LocalDate DataNaix) {
        this.DataNaix = DataNaix;
    }

    public boolean isDeutor() {
        return deutor;
    }

    public void setDeutor(boolean deutor) {
        this.deutor = deutor;
    }

    @Override
    public String toString() {
        return "Client{" + "NIF=" + NIF + ", nom=" + nom + ", localitat=" + localitat + ", DataNaix=" + DataNaix + ", deutor=" + deutor + '}';
    }
}