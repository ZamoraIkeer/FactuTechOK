/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.factutech;

import com.mycompany.factutech.models.Bossa;
import com.mycompany.factutech.models.Funda;
import com.mycompany.factutech.models.Productes;
import com.mycompany.factutech.models.Samarreta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arnau
 */
public class FactuTech {
    private static List<Productes> productes = new ArrayList<>();
    private static AskData ask;
    
    public static void main(String[] args) {
        ask = new AskData();
        int acabar = 1;

        while (acabar == 1) {
            mostrarMenu();
            int select = ask.askInt("Que vols fer? ", "Has d'escollir una opció entre 1 i 9", 1, 9);
            
            switch (select) {
                case 1 -> afegirProducte();
                case 2 -> veureStock();
                case 3 -> acabar++;
            }
        }
    }
     private static void mostrarMenu() {
        System.out.println("=== Gestió de facturació ===");
        System.out.println("1. Afegir producte");
        System.out.println("2. Veure stock");
        System.out.println("3. Sortir");
    
    }

    private static void afegirProducte() {
        System.out.println("Selecciona el tipus de producte:");
        System.out.println("1. Samarreta");
        System.out.println("2. Funda");
        System.out.println("3. Bossa");

        int tipus = ask.askInt("Opció: ", "Introdueix un número entre 1 i 3", 1, 3);
        Productes nouProducte = new Productes(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        if (tipus == 1) {
            String talla = ask.askString("Introdueix la talla: ");
            double preu = ask.askDouble("Introdueix el preu: ");
            nouProducte.getSamarretes().add(new Samarreta(talla, preu));
        } 
        if (tipus == 2) {
            boolean esMobil = ask.askBoolean("De quin tipus de dispositiu es la finda, mòbil o tablet?: ");
            String model = ask.askString("Introdueix el model: ");
            double preu = ask.askDouble("Introdueix el preu: ");
            nouProducte.getFundes().add(new Funda(esMobil, model, preu));
        } 
        if (tipus == 3) {
            double preu = ask.askDouble("Introdueix el preu: ");
            nouProducte.getBosses().add(new Bossa(preu));
        }

        productes.add(nouProducte);
        System.out.println("Producte afegit correctament!");
    }

   private static void veureStock() {
    System.out.println("Vols veure el stock de:");
    System.out.println("1. Un producte concret");
    System.out.println("2. Tots els productes");

    int opcio = ask.askInt("Opció: ", "Introdueix 1 o 2", 1, 2);

    if (opcio == 1) {
        System.out.println("Selecciona el tipus de producte:");
        System.out.println("1. Samarreta");
        System.out.println("2. Funda");
        System.out.println("3. Bossa");

        int tipus = ask.askInt("Opció: ", "Introdueix un número entre 1 i 3", 1, 3);
        
        if (tipus == 1) {
            System.out.println("Stock de Samarretes:");
            for (Productes p : productes) {
                for (Samarreta s : p.getSamarretes()) {
                    System.out.println("Talla: " + s.getTalla() + ", Preu: " + s.getPreu());
                }
            }
        } 
        if (tipus == 2) {
            System.out.println("Stock de Fundes:");
            for (Productes p : productes) {
                for (Funda f : p.getFundes()) {
                    String tipusFunda = f.isTipus() ? "Mòbil" : "Tablet";
                    System.out.println("Model: " + f.getModel() + ", Tipus: " + tipusFunda + ", Preu: " + f.getPreu());
                }
            }
        } 
        if (tipus == 3) {
            System.out.println("Stock de Bosses:");
            for (Productes p : productes) {
                for (Bossa b : p.getBosses()) {
                    System.out.println("Preu: " + b.getPreu());
                }
            }
        }
    } 

    if (opcio == 2) {
        System.out.println("Stock complet:");
        for (Productes p : productes) {
            for (Samarreta s : p.getSamarretes()) {
                System.out.println("Samarreta - Talla: " + s.getTalla() + ", Preu: " + s.getPreu());
            }
            for (Funda f : p.getFundes()) {
                String tipusFunda = f.isTipus() ? "Mòbil" : "Tablet";
                System.out.println("Funda - Model: " + f.getModel() + ", Tipus: " + tipusFunda + ", Preu: " + f.getPreu());
            }
            for (Bossa b : p.getBosses()) {
                System.out.println("Bossa - Preu: " + b.getPreu());
            }
        }
    }
}
}
    
