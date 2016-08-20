package Eines;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

import Model.Paraula;

public class HTML {
	private	int numero =1;

	
	
	public void html(int opcio, Object estruc) throws IOException, URISyntaxException{
		String matriu = "MATRIU";
		String dynamicList = "DYNAMIC LIST";
		String binari ="ARBRE BINARI";
		String taula = "TAULA D'ADREÇAMENT OBERT";

		FileWriter fw = null;
		PrintWriter pw = null;
		
		try{
			fw = new FileWriter("fichero.html");
			pw = new PrintWriter(fw);
			
			switch(opcio){
			case 0:
				pw.println("<title>"+binari+"</title>");
				pw.println("<center><h1><font color =\"navy\">" + binari + "</font></h1></center>");
				pw.println("<TABLE BORDER=1 WIDTH=1000 HEIGHT=25>");
				pw.println("<TR>");
				
				for(int i=0; i<3; i++){
					pw.println("<TD WIDTH=225 Height=25>");
					switch(i){
					case 0: pw.println("NUMERO DE PARAULA</TD>");
					break;
					case 1: pw.println("PARAULA</TD>");
					break;
					case 2: pw.println("NUMERO D'APARICIONS</TD>");
					break;
					}
				}
				pw.println("</TR>");
				ArbreBinari ab = (ArbreBinari)estruc;
				writeHtmlBinari(pw, ab.getPrimer());
				
				break;
			case 1:
				pw.println("<title>"+taula+"</title>");
				pw.println("<center><h1><font color =\"navy\">" + taula + "</font></h1></center>");

				pw.println("<TABLE BORDER=1 WIDTH=1000 HEIGHT=25>");
				pw.println("<TR>");
				
				for(int i=0; i<3; i++){
					pw.println("<TD WIDTH=225 Height=25>");
					switch(i){
					case 0: pw.println("NUMERO DE PARAULA</TD>");
					break;
					case 1: pw.println("PARAULA</TD>");
					break;
					case 2: pw.println("NUMERO D'APARICIONS</TD>");
					break;
					}
				}
				pw.println("</TR>");
				
				NodeTaula[] nodes = (NodeTaula[])estruc;
				
				for(int i=0; i<nodes.length;i++){
					if(!nodes[i].getKey().equals("")){
						pw.println("<TR>");
						for(int j=0;j<3;j++){
							pw.println("<TD WIDTH=225 Height=25>");
							switch(j){
							case 0:
								pw.println(numero+"</TD>");
								break;
							case 1:
								pw.println(nodes[i].getKey()+"</TD>");
								break;
							case 2:
								pw.println(nodes[i].getRepes()+"</TD>");
								break;
							}
						}
					
						pw.println("</TR>");
						numero++;
					}
				}
				
				
				
				break;
			case 2:
				pw.println("<title>"+dynamicList+"</title>");
				pw.println("<center><h1><font color =\"navy\">" + dynamicList + "</font></h1></center>");

				DynamicList dl = (DynamicList)estruc;
				dl.first();
				
				pw.println("<TABLE BORDER=1 WIDTH=1000 HEIGHT=25>");
				pw.println("<TR>");
				
				for(int i=0; i<3; i++){
					pw.println("<TD WIDTH=225 Height=25>");
					switch(i){
					case 0: pw.println("NUMERO DE PARAULA</TD>");
					break;
					case 1: pw.println("PARAULA</TD>");
					break;
					case 2: pw.println("NUMERO D'APARICIONS</TD>");
					break;
					}
				}
				pw.println("</TR>");
				while(!dl.end()){
					pw.println("<TR>");
					for(int i=0;i<3;i++){
						pw.println("<TD WIDTH=225 Height=25>");
						switch(i){
						case 0:
							pw.println(numero+"</TD>");
							break;
						case 1:
							pw.println(dl.get().getNom()+"</TD>");
							break;
						case 2:
							pw.println(dl.get().getnAp()+"</TD>");
							break;
						}
					}
					pw.println("</TR>");
					numero++;
					dl.next();
				}
				
				break;
			case 3:
				pw.println("<title>"+matriu+"</title>");
				pw.println("<center><h1><font color =\"navy\">" + matriu + "</font></h1></center>");
				
				pw.println("<TABLE BORDER=1 WIDTH=1000 HEIGHT=25>");
				pw.println("<TR>");
				
				for(int i=0; i<3; i++){
					pw.println("<TD WIDTH=225 Height=25>");
					switch(i){
					case 0: pw.println("NUMERO DE PARAULA</TD>");
					break;
					case 1: pw.println("PARAULA</TD>");
					break;
					case 2: pw.println("NUMERO D'APARICIONS</TD>");
					break;
					}
				}
				pw.println("</TR>");
				
				Paraula[] mat = (Paraula[])estruc;
				for(int i=0; i<mat.length;i++){
					if(mat[i]!=null){
						pw.println("<TR>");
						for(int j=0;j<3;j++){
							pw.println("<TD WIDTH=225 Height=25>");
							switch(j){
							case 0:
								pw.println(numero+"</TD>");
								break;
							case 1:
								pw.println(mat[i].getNom()+"</TD>");
								break;
							case 2:
								pw.println(mat[i].getnAp()+"</TD>");
								break;
							}
						}
					
						pw.println("</TR>");
						numero++;
					}
				}
				break;
			}
			pw.close();
			try{
				File htmlFile = new File("fichero.html");
				Desktop.getDesktop().browse(htmlFile.toURI());
			} catch (Exception e) {} 
			
		}catch (FileNotFoundException e) {
			System.err.println("No s'ha pogut trobar el fitxer");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editHtml(String nom){
		File f = new File("fichero.html");
		if(f.exists() && !f.isDirectory()) { 
			
		}
	}
	
	public void writeHtmlBinari(PrintWriter pw,NodeArbre node){
		if(node.getfillE()==null && node.getFillD()==null){
			//System.out.println(node.getKey()+" "+node.getValor());
			pw.println("<TR>");
			for(int i=0;i<3;i++){
				pw.println("<TD WIDTH=225 Height=25>");
				switch(i){
				case 0:
					pw.println(numero+"</TD>");
					break;
				case 1:
					pw.println(node.getKey()+"</TD>");
					break;
				case 2:
					pw.println(node.getValor()+"</TD>");
					break;
				}
			}
			pw.println("</TR>");
			numero++;		
			
		}else{
			if(node.getfillE()!=null){
				writeHtmlBinari(pw, node.getfillE());
				//System.out.println(node.getKey()+" "+node.getValor());
				pw.println("<TR>");
				for(int i=0;i<3;i++){
					pw.println("<TD WIDTH=225 Height=25>");
					switch(i){
					case 0:
						pw.println(numero+"</TD>");
						break;
					case 1:
						pw.println(node.getKey()+"</TD>");
						break;
					case 2:
						pw.println(node.getValor()+"</TD>");
						break;
					}
				}
				pw.println("</TR>");
				numero++;	
				if(node.getFillD()!=null){
					writeHtmlBinari(pw, node.getFillD());
				}
			}else{
				writeHtmlBinari(pw, node.getFillD());
				//System.out.println(node.getKey()+" "+node.getValor());
				pw.println("<TR>");
				for(int i=0;i<3;i++){
					pw.println("<TD WIDTH=225 Height=25>");
					switch(i){
					case 0:
						pw.println(numero+"</TD>");
						break;
					case 1:
						pw.println(node.getKey()+"</TD>");
						break;
					case 2:
						pw.println(node.getValor()+"</TD>");
						break;
					}
				}
				pw.println("</TR>");
				numero++;	
			}
		}
	}

}
