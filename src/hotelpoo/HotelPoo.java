/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelpoo;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


/**
 *
 * @author Alan Arrua
 */
public class HotelPoo {

    public static void main(String[] args) {
        ArrayList<Habitacion> habitacions = new ArrayList<>();
        ArrayList<Servei> serveis = new ArrayList<>();
        ArrayList<Estada> estadas = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean sortir = false;
        
        //añadir servicios con dinero
        
        serveis.add(new Servei(1, "Bugaderia", 20.0));
        serveis.add(new Servei(2, "Esmorzar", 15.0));
        serveis.add(new Servei(3, "Dinar", 25.0));
        serveis.add(new Servei(4, "Sopar", 22.0));
        
         //añadir habitaciones gracias por el codigo xevi
        for (int i = 101; i <= 110; i++) {
            habitacions.add(new Habitacion(i, 50.0));
        }
        for (int i = 201; i <= 210; i++) {
            habitacions.add(new Habitacion(i, 70.0));
        }
        for (int i = 301; i <= 310; i++) {
            habitacions.add(new Habitacion(i, 90.0));
        }
        
        while (!sortir) {
            System.out.println("========== MENÚ DE GESTORIA ==========");
            System.out.println("1. Alta nou client");
            System.out.println("2. Llistar clients");
            System.out.println("3. Modificar dades client");
            System.out.println("4. Client submenú (Check-in/Serveis)");
            System.out.println("5. Alta habitació");
            System.out.println("6. Llistar habitacions");
            System.out.println("7. Modificar habitació");
            System.out.println("8. Nou servei");
            System.out.println("9. Llistar serveis");
            System.out.println("10. Modificar servei");
            System.out.println("11. Sortir del sistema");
            System.out.print("Escull una opció: ");
            
            int opcio = sc.nextInt();
            sc.nextLine();
            
            switch (opcio) {
                case 1:
                    altaNouClient(sc, clients);
                    break;
                    
                case 2:
                    llistarClients(clients);
                    break;
                    
                case 3:
                    modificarClient(sc, clients);
                    break;
                    
                case 4:
                    submenuClient(sc, clients, habitacions, serveis, estadas);
                    break;
                    
                case 5:
                    altaHabitacio(sc, habitacions);
                    break;
                    
                case 6:
                    llistarHabitacions(habitacions);
                    break;
                    
                case 7:
                    modificarHabitacio(sc, habitacions);
                    break;
                    
                case 8:
                    nouServei(sc, serveis);
                    break;
                    
                case 9:
                    llistarServeis(serveis);
                    break;
                    
                case 10:
                    modificarServei(sc, serveis);
                    break;
                    
                case 11: 
                    System.out.println("Sortin del sistema, adeu andreu");
                    sortir = true;
                    break;
                    
                default:
                    System.out.println("En quin moment existeix aquesta opcio?");
            }
        }
        sc.close();
    }
    private static void altaNouClient(Scanner sc, ArrayList<Client> clients) {
        System.out.print("Introdueix el NIF del client: ");
        String NIF = sc.nextLine();
        
        for (Client i : clients) {
            if (i.getNIF().equals(NIF)) {
                System.out.println("ERROR: Ja existeix un client amb aquest NIF!");
                return;
            }
        }
        
        System.out.print("Introdueix el nom: ");
        String nom = sc.nextLine();
        System.out.print("Introdueix la localitat: ");
        String localitat = sc.nextLine();
        System.out.print("Introdueix la data de naixement (yyyy-MM-dd): ");
        String dataNaix = sc.nextLine();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(dataNaix, formatter);
        
        clients.add(new Client(NIF, nom, localitat, dateTime, false));
        System.out.println("Client afegit correctament!");
    }
    //METODOS Q HAY FUERA DEL MAIN DASJDSADSADSA
    private static void llistarClients(ArrayList<Client> clients) {
        if (clients.isEmpty()) {
            System.out.println("No hi ha clients registrats.");
            return;
        }
        System.out.println("========== LLISTA DE CLIENTS ==========");
        for (Client i : clients) {
            System.out.println(i);
        }
    }
    
    private static void modificarClient(Scanner sc, ArrayList<Client> clients) {
        System.out.print("Introdueix el NIF del client a modificar: ");
        String NIF = sc.nextLine();
        
        Client client = buscarClient(NIF, clients);
        if (client == null) {
            System.out.println("ERROR: Client no trobat");
            return;
        }
        
        System.out.println("Client trobat: " + client);
        System.out.print("Nou nom:  ");
        String nouNom = sc.nextLine();
        if (!nouNom.isEmpty()) {
            client.setNom(nouNom);
        }
        
        System.out.print("Nova localitat:  ");
        String novaLocalitat = sc.nextLine();
        if (!novaLocalitat.isEmpty()) {
            client.setLocalitat(novaLocalitat);
        }
        
        System.out.println("Client modificat correctament");
    }
    
    private static void altaHabitacio(Scanner sc, ArrayList<Habitacion> habitacions) {
        System.out.print("Número d'habitació: ");
        int num = sc.nextInt();
        System.out.print("Preu per nit: ");
        double preu = sc.nextDouble();
        sc.nextLine();
        
        habitacions.add(new Habitacion(num, preu));
        System.out.println("Habitació afegida correctament!");
    }
    
    private static void llistarHabitacions(ArrayList<Habitacion> habitacions) {
        if (habitacions.isEmpty()) {
            System.out.println("No hi ha habitacions registrades.");
            return;
        }
        System.out.println("========== LLISTA D'HABITACIONS ==========");
        for (Habitacion i : habitacions) {
            System.out.println(i);
        }
    }
    
    private static void modificarHabitacio(Scanner sc, ArrayList<Habitacion> habitacions) {
        System.out.print("Número d'habitació a modificar: ");
        int num = sc.nextInt();
        sc.nextLine();
        
        Habitacion hab = buscarHabitacio(num, habitacions);
        if (hab == null) {
            System.out.println("ERROR: Habitació no trobada!");
            return;
        }
        
        System.out.print("Nou preu per nit: ");
        double nouPreu = sc.nextDouble();
        sc.nextLine();
        hab.setPreuPerNit(nouPreu);
        System.out.println("Habitació modificada correctament!");
    }
    
    private static void nouServei(Scanner sc, ArrayList<Servei> serveis) {
        System.out.print("ID del servei: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Descripció: ");
        String desc = sc.nextLine();
        System.out.print("Preu: ");
        double preu = sc.nextDouble();
        sc.nextLine();
        
        serveis.add(new Servei(id, desc, preu));
        System.out.println("Servei afegit correctament");
    }
    
    private static void llistarServeis(ArrayList<Servei> serveis) {
        if (serveis.isEmpty()) {
            System.out.println("No hi ha serveis registrats.");
            return;
        }
        System.out.println("========== LLISTA DE SERVEIS ==========");
        for (Servei i : serveis) {
            System.out.println(i);
        }
    }
    
    private static void modificarServei(Scanner sc, ArrayList<Servei> serveis) {
        System.out.print("ID del servei a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        Servei servei = buscarServei(id, serveis);
        if (servei == null) {
            System.out.println("ERROR: Servei no trobat!");
            return;
        }
        
        System.out.print("Nou preu: ");
        double nouPreu = sc.nextDouble();
        sc.nextLine();
        servei.setPreuServei(nouPreu);
        System.out.println("Servei modificat correctament!");
    }
    
//aca hago el submenu
    
    private static void submenuClient(Scanner sc, ArrayList<Client> clients, 
                                     ArrayList<Habitacion> habitacions, 
                                     ArrayList<Servei> serveis, 
                                     ArrayList<Estada> estadas) {
        boolean sortirSM = false;
        
        while (!sortirSM) {
            System.out.println("========== SUBMENÚ CLIENT ==========");
            System.out.println("1. Check-in");
            System.out.println("2. Servei Bugaderia");
            System.out.println("3. Servei Esmorzar");
            System.out.println("4. Servei Dinar");
            System.out.println("5. Servei Sopar");
            System.out.println("6. Consultar import actual");
            System.out.println("7. Check-out");
            System.out.println("8. Tornar al menú principal");
            System.out.print("Escull una opció: ");
            
            int opcio = sc.nextInt();
            sc.nextLine();
            
            switch (opcio) {
                case 1:
                    checkin(sc, clients, habitacions, estadas);
                    break;
                case 2:
                    afegirServei(sc, estadas, serveis, "Bugaderia");
                    break;
                case 3:
                    afegirServei(sc, estadas, serveis, "Esmorzar");
                    break;
                case 4:
                    afegirServei(sc, estadas, serveis, "Dinar");
                    break;
                case 5:
                    afegirServei(sc, estadas, serveis, "Sopar");
                    break;
                case 6:
                    consultarImport(sc, estadas);
                    break;
                case 7:
                    checkout(sc, estadas, habitacions);
                    break;
                case 8:
                    sortirSM = true;
                    break;
                default:
                    System.out.println("Opció no vàlida!");
            }
        }
    }
    
    private static void checkin(Scanner sc, ArrayList<Client> clients, 
                               ArrayList<Habitacion> habitacions, 
                               ArrayList<Estada> estadas) {
        System.out.print("Introdueix el NIF del client: ");
        String NIF = sc.nextLine();
        
        Client client = buscarClient(NIF, clients);
        if (client == null) {
            System.out.println("Aquest client no te alta, li fem una");
        
            System.out.print("Introdueix el nom: ");
            String nom = sc.nextLine();
            System.out.print("Introdueix la localitat: ");
            String localitat = sc.nextLine();
            System.out.print("Introdueix la data de naixement (yyyy-MM-dd): ");
            String dataNaix = sc.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateTime = LocalDate.parse(dataNaix, formatter);

            client = new Client(NIF, nom, localitat, dateTime, false);
            clients.add(client);
            System.out.println("Client creat correctament!");
        }
        
        for (Estada i : estadas) {
            if (i.getNIF().equals(NIF) && i.getSortida() == null) {
                System.out.println("ERROR: Aquest client ja té una estada activa!");
                return;
            }
        }
        
        // Mostrar habitacions lliures
        System.out.println("Habitacions lliures:");
        boolean hiHaLliures = false;
        for (Habitacion i : habitacions) {
            if (i.getLliure()) {
                System.out.println(i);
                hiHaLliures = true;
            }
        }
        
        if (!hiHaLliures) {
            System.out.println("ERROR: No hi ha habitacions lliures");
            return;
        }
        
        System.out.print("Número de habitació: ");
        int numHab = sc.nextInt();
        sc.nextLine();
        
        Habitacion hab = buscarHabitacio(numHab, habitacions);
        if (hab == null || !hab.getLliure()) {
            System.out.println("ERROR: Habitació no disponible");
            return;
        }
        
        // Crear estada
        Estada novaEstada = new Estada(NIF, numHab);
        estadas.add(novaEstada);
        hab.setLliure(false);
        
        System.out.println("Check-in realitzat correctament");
        System.out.println("Client: " + client.getNom());
        System.out.println("Habitació: " + numHab);
        System.out.println("Data entrada: " + novaEstada.getEntrada());
    }
    
    private static void afegirServei(Scanner sc, ArrayList<Estada> estadas, 
                                    ArrayList<Servei> serveis, String tipusServei) {
        System.out.print("Introdueix el NIF del client: ");
        String NIF = sc.nextLine();
        
        Estada estada = buscarEstadaActiva(NIF, estadas);
        if (estada == null) {
            System.out.println("ERROR: El client no té cap estada activa!");
            return;
        }
        
        // Buscar el servei
        Servei servei = null;
        for (Servei s : serveis) {
            if (s.getDescripcio().equalsIgnoreCase(tipusServei)) {
                servei = s;
                break;
            }
        }
        
        if (servei == null) {
            System.out.println("ERROR: Servei no trobat!");
            return;
        }
        
        estada.afegirServei(servei);
        System.out.println("Servei '" + tipusServei + "' afegit correctament!");
        System.out.println("Import: " + servei.getPreuServei() + "€");
    }
    
    private static void consultarImport(Scanner sc, ArrayList<Estada> estadas) {
        System.out.print("Introdueix el NIF del client: ");
        String NIF = sc.nextLine();
        
        Estada estada = buscarEstadaActiva(NIF, estadas);
        if (estada == null) {
            System.out.println("ERROR: El client no té cap estada activa!");
            return;
        }
        
        System.out.println("\n========== IMPORT ACTUAL ==========");
        System.out.println("Client NIF: " + estada.getNIF());
        System.out.println("Habitació: " + estada.getNumHabi());
        System.out.println("Serveis contractats: " + estada.getServeis().size());
        System.out.println("Import serveis: " + estada.getImportActual() + "€");
    }
    
    private static void checkout(Scanner sc, ArrayList<Estada> estadas, 
                                ArrayList<Habitacion> habitacions) {
        System.out.print("Introdueix el NIF del client: ");
        String NIF = sc.nextLine();
        
        Estada estada = buscarEstadaActiva(NIF, estadas);
        if (estada == null) {
            System.out.println("ERROR: El client no té cap estada activa");
            return;
        }
        
        // Registrar sortida
        estada.setSortida(LocalDateTime.now());
        
        
        long nits = ChronoUnit.DAYS.between(estada.getEntrada(), estada.getSortida());
        if (nits == 0) nits = 1;
        
        // Buscar habitació
        Habitacion hab = buscarHabitacio(estada.getNumHabi(), habitacions);
        double costHabitacio = nits * hab.getPreuPerNit();
        
        // Calcular factura
        double importServeis = estada.getImportActual();
        double subtotal = costHabitacio + importServeis;
        double iva = subtotal * 0.16;
        double total = subtotal + iva;
        
        estada.setFacturaFinal(total);
        estada.setPagat(true);
        hab.setLliure(true);
        
        System.out.println("========== FACTURA FINAL ==========");
        System.out.println("Client NIF: " + estada.getNIF());
        System.out.println("Habitació: " + estada.getNumHabi());
        System.out.println("Nits d'estada: " + nits);
        System.out.println("Cost habitació: " + costHabitacio + "€");
        System.out.println("Cost serveis: " + importServeis + "€");
        System.out.println("Subtotal: " + subtotal + "€");
        System.out.println("IVA (16%): " + iva + "€");
        System.out.println("TOTAL: " + total + "€");
        System.out.println("===================================");
    }
    
    private static Client buscarClient(String NIF, ArrayList<Client> clients) {
        for (Client i : clients) {
            if (i.getNIF().equals(NIF)) {
                return i;
            }
        }
        return null;
    }
    
    private static Habitacion buscarHabitacio(int num, ArrayList<Habitacion> habitacions) {
        for (Habitacion i : habitacions) {
            if (i.getNumHabi() == num) {
                return i;
            }
        }
        return null;
    }
    
    private static Servei buscarServei(int id, ArrayList<Servei> serveis) {
        for (Servei i : serveis) {
            if (i.getIdServei() == id) {
                return i;
            }
        }
        return null;
    }
    
    private static Estada buscarEstadaActiva(String NIF, ArrayList<Estada> estadas) {
        for (Estada i : estadas) {
            if (i.getNIF().equals(NIF) && i.getSortida() == null) {
                return i;
            }
        }
        return null;
    }
}