package View;

import java.time.Clock;

public class Terminal {
    public static void messages(int nMessage){
        switch(nMessage){
            case 0 :
                System.out.println("########## Benvingut a Word Counter ###########");
                break;
            case 1:
                System.out.println("Menu principal:");
                menu(1);
                System.out.print("--> ");
                break;
            case 2:
                System.out.println("Introdueixi nom del fitxer que desitja obrir:");
                System.out.print("--> ");
                break;
            case 3:
                System.out.println("Sortir.");
                break;
            case 4:
                System.err.println("No ha seleccionat el fitxer que desitja obrir.");
                break;
            case 5:
                System.out.println("");
                break;
        }
    }

    public static void menu(int nTipus){
        switch (nTipus) {
            case 1:
                System.out.println("Opcio 1--> Selccionar fitxer d'entrada.");
                System.out.println("Opcio 2--> Calcular aparicions.");
                System.out.println("Opcio 3--> Visualitzar resultats.");
                System.out.println("Opcio 4--> Sortir.");
                break;
            case 2:
                System.out.println("Modes de recompte:");
                System.out.println("Mode 1--> Arbres AVL");
                System.out.println("Mode 2--> Taula d'adrecament obert");
                System.out.println("Mode 3--> Llista dinamica.");
                System.out.println("Mode 4--> Matriu.");
                break;
            case 3:
                System.out.println("Modes de visualitzacio:");
                System.out.println("Mode 1--> Ordenacio per numero d'aparicions");
                System.out.println("Mode 2--> Ordenacio per ordre alfabetic.");
                break;
        }
    }
}
