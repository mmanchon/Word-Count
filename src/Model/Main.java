package Model;

import View.Terminal;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.print.attribute.Size2DSyntax;

import Eines.ArbreBinari;
import Eines.DynamicList;
import Eines.Fitxer;
import Eines.HTML;
import Eines.Matrius;
import Eines.NodeTaula;
import Eines.TaulaHash;

public class Main {
	
	

	public static void main(String []args) throws IOException, URISyntaxException{
    	String[][] libro =null;
    	DynamicList dynList=null;
    	Matrius matrius = null;
    	TaulaHash taula = null;
    	ArbreBinari ab=null;
    	NodeTaula[] nodes = null;
    	int tipusEstructura=0,metodeOrdenacio = 0,sizeRows = 0;
    	Object estructura = null;
        String fileName = null;
        Fitxer f = new Fitxer();
        boolean op1= false,exit = false;
        Scanner sc = new Scanner(System.in);
        long time_start, time_end;
        double time_final=0;
        long time_start2, time_end2;
        double time_final2=0;
        DecimalFormat decimals = new DecimalFormat("0.000");
        
        //Benvinguda al sistema.
        Terminal.messages(0);

        while(!exit) {
            //Cridem al menu.
            Terminal.messages(1);
            int opMenu = sc.nextInt();
            
            switch (opMenu) {
                case 1:
                    Terminal.messages(2);
                    sc.nextLine();
                    fileName = sc.nextLine();
                    
                    f.llegeixFitxer(fileName);
                    
                    libro= f.getText();
                    sizeRows=f.getiText();
                    
                    op1=true;
                    break;
                case 2:
                    if(op1) {
                        //Modes de recompte.
                        Terminal.menu(2);
                        tipusEstructura = sc.nextInt();
                        time_start = System.currentTimeMillis();
                        switch(tipusEstructura){
                        case 1:
                    		ab = new ArbreBinari();
                    		estructura = (ArbreBinari)ab.recompteParaules(libro, sizeRows);
                    		break;
                        case 2:
                        	taula = new TaulaHash();
                        	estructura = (NodeTaula[])taula.recompteParaules(libro,sizeRows);
                        	break;
                        case 3:
                        	dynList=new DynamicList();
                        	estructura = (DynamicList)dynList.recompteParaules(libro,sizeRows);
                        	break;
                        case 4:
                        	matrius = new Matrius();
                        	estructura = (Paraula[])matrius.recompteParaules(libro,sizeRows);
                        	break;
                        }
                        time_end = System.currentTimeMillis();
                        time_final =( time_end - time_start)* 0.001;
                        System.out.println("El temps total en guardar a set de "+decimals.format(time_final)+"s.");
                        		
                    }else{
                        Terminal.messages(4);
                    }
                    break;
                case 3:
                    if(op1) {
                        //Modes de visualitzacio.
                        Terminal.menu(3);
                        metodeOrdenacio= sc.nextInt();
                		HTML html = new HTML();
                		time_start2 = System.currentTimeMillis();
                        switch(metodeOrdenacio){
                        case 1://Ordenacio per numero d'aparicions.
                        	switch(tipusEstructura){
                        	case 1:
                        		ab = ab.ordenaNumercament((ArbreBinari)estructura);
                        		html.html(0,ab);
                        		break;
                        	case 2:
                        		nodes = taula.ordenaNumericament((NodeTaula[])estructura);
                        		html.html(1,nodes);
                        		break;
                            case 3:  
                            	estructura = (DynamicList)dynList.ordenaNaparicions((DynamicList)estructura);
                        		html.html(2,estructura);
                            	break;
                            case 4:  
                            	estructura = (Paraula[])matrius.ordenaNap((Paraula[])estructura);
                        		html.html(3,estructura);
                            	break;

                            default:
                            	System.out.println("Estructura introduida invalida.");
                        	}
                        	break;
                        case 2://Ordre per ordre alfabetic d'aparicions.
                        	switch(tipusEstructura){
                        	case 1:
                        		 ab=ab.ordenaAlfabeticament((ArbreBinari)estructura);
                        		html.html(0,ab);
                        		break;
                        	case 2:
                        		nodes = taula.ordenaAlfabeticament((NodeTaula[])estructura);
                        		html.html(1,nodes);
                        		break;
                        	case 3:
                            	estructura = (DynamicList)dynList.ordenaAlfabeticament((DynamicList)estructura);
                        		html.html(2,estructura);
                            	break;
                            case 4:  
                            	estructura = (Paraula[])matrius.ordenaAlfabeticament((Paraula[])estructura);
                        		html.html(3,estructura);
                        		break;

                            default:
                            	System.out.println("Estructura introduida invalida.");
                        	}
                        	break;
                        default:
                        	System.out.println("Opcio introduida invalida.");
                        }
                        time_end2 = System.currentTimeMillis();
                        time_final2 =( time_end2 - time_start2)* 0.001;
                       
                        System.out.println("El temps total en ordenar a set de "+decimals.format(time_final2)+"s.");
                        		
                    }else{
                        Terminal.messages(4);
                    }
                    break;
                case 4:
                    Terminal.messages(3);
                    exit = true;
                    break;
            }
        }
    }
}
