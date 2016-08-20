package Eines;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Fitxer {
	
	private String[][] text= null;
	private int iText=0;
	
	public String[][] getText() {
		return text;
	}

	public void setText(String[][] text) {
		this.text = text;
	}

	public int getiText() {
		return iText;
	}

	public void setiText(int iText) {
		this.iText = iText;
	}
	
	public void llegeixFitxer(String path){
		String cadena=null;
		
		int sizeText = sizeFile(path);
		//Si el fitxer no s'obre correctament al calcular la mida del contingut sera 0 i no extraurem la informacio.
		if(sizeText!= 0){
			try {
				//Creem una matriu gran igual al nombre de files que te el text
				text = new String[sizeText][];
				FileReader f = new FileReader(path);
				BufferedReader b = new BufferedReader(f);
				iText = 0;
				cadena = b.readLine();
				
				while(cadena != null){
					//A cada fila que hem creat abans inserim el text separat per un espai
					text[iText]= cadena.split("[-+!?¿¡ \"]");
					iText++;
					cadena = b.readLine();
				}
				
				//Procediment per comprovar que tenim a la matriu del fitxer de text.
				//mostraContingut();
				
				b.close();
				
				//recompteParaules(text,iText);
			} catch (IOException e) {
				System.err.println("Fitxer no vàlid.");
			}
		}else{
			System.err.println("Comprovi el path introduit i torni a intentar-ho.");
		}
	}
	
	public int sizeFile(String path){
		   FileReader fAux;
		   int sizeText=0;
		   BufferedReader bAux= null;
		try {
			fAux = new FileReader(path);
			bAux = new BufferedReader(fAux);
			while (bAux.readLine()!= null)sizeText++;
			bAux.close();
			return sizeText;
		} catch (IOException e) {
			System.err.println("No s'ha pogut obrir el fitxer.");
			return sizeText;
		}
	   }
	
	   public void mostraContingut(){
			
		   for(int i = 0;i<iText; i++){
				int col=text[i].length;
				for(int j=0;j<col;j++){
					System.out.print(text[i][j]+" ");
				}
				System.out.println();	
		   }
	   }
}
