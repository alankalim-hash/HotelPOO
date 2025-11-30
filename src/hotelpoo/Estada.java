package hotelpoo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Estada {
    
    private String NIF;
    private int numHabi;
    private LocalDateTime entrada = LocalDateTime.now();
    private LocalDateTime sortida = null;
    private ArrayList<Servei> serveis = new ArrayList<>();
    private double importActual = 0;
    private double facturaFinal = 0;
    private boolean pagat = false;

    public Estada(String NIF, int numHabi) {
        this.NIF = NIF;
        this.numHabi = numHabi;
    }

    public String getNIF() {
        return NIF;
    }

    public int getNumHabi() {
        return numHabi;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getSortida() {
        return sortida;
    }

    public void setSortida(LocalDateTime sortida) {
        this.sortida = sortida;
    }

    public ArrayList<Servei> getServeis() {
        return serveis;
    }

    public double getImportActual() {
        return importActual;
    }

    public void setFacturaFinal(double facturaFinal) {
        this.facturaFinal = facturaFinal;
    }

    public void setPagat(boolean pagat) {
        this.pagat = pagat;
    }

    @Override
    public String toString() {
        return "Estada{" + "NIF=" + NIF + ", numHabi=" + numHabi +  ", entrada=" + entrada + ", sortida=" + sortida + ", serveis=" + serveis + ", importActual=" + importActual + ", facturaFinal=" + facturaFinal + ", pagat=" + pagat + '}';
    }

    public void afegirServei(Servei servei) {
        serveis.add(servei);
        importActual += servei.getPreuServei();
    }
}
