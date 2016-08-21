package Eines;

import Model.Paraula;

public class TaulaHash {
	
	private int nombre;
			
	public int nombreParaules(String[][] llibre,int files){
		int nombre = 0;
		for(int i=0;i<files;i++){
			for(int j=0;j<llibre[i].length;j++){
				nombre++;
			}
		}
		return nombre;
	}
	
	public NodeTaula[] recompteParaules(String[][] preAux, int iFiles){
		nombre = nombreParaules(preAux,iFiles);
		NodeTaula[] taula = new NodeTaula[nombre*nombre];
		for(int i=0; i<taula.length;i++){
			taula[i] = new NodeTaula();
		}
		System.out.println(taula.length);
		//DynamicList dL = new DynamicList();
		//Omplim una llista dynamica per saber quina mida agafar per la taula de hash
		//dL = dL.convert(preAux, iFiles);
		//Pot ser es necessari fer la taula mes gran
		//taula.setSizeTaula(dL.getSize());
		//System.out.println(dL.getSize());
		//System.out.println(taula.getSizeTaula());
		//Omplim la taula de hash
		taula = omple(taula,preAux,iFiles);
		/*for(int i=0;i<taula.length;i++){
			System.out.println(taula[i].getKey()+ i);
		}*/
		
		return taula;
	}
	
	private NodeTaula[] omple(NodeTaula[] taula,String[][] text,int files){
		int index=0;
		boolean rehash = true;
		
		for(int i=0;i<files;i++){
			for(int j=0;j<text[i].length;j++){
				if(!text[i][j].equals(" ")&&!text[i][j].equals("")&&!text[i][j].equals("\n")){
					index = hash(taula,text[i][j]);
					//System.out.println(index+"Primer");
					while(rehash){
						
						NodeTaula node = taula[index];
						
						if(node.getKey().equals("")){
						
							node.setKey(text[i][j]);
							node.setLletra(text[i][j].charAt(0));
							node.setRepes(1);
							rehash = false;
						
						}else{
						
							if(node.getKey().equals(text[i][j])){
								node.setRepes(node.getRepes()+1);
								rehash= false;
	
							}else{
								index = rehash(index);
								rehash=true;
							}
							
						}
					}
				}
				rehash = true;
			}
		}
		
	return taula;
		
	}
	
	private int hash(NodeTaula[] taula, String paraula){
		String aux = paraula.toUpperCase();
		//System.out.println(aux);
		char lletra = aux.charAt(0);
		//System.out.println(lletra);
		int valor = (int)lletra;
		if(valor<65 || valor>90){
			valor=90;
		}
		//System.out.println(valor);
		return taula.length/25 * (valor-65);
	}
	
	private int rehash(int hash){
		return hash+1;
	}
	
	public NodeTaula[] ordenaAlfabeticament(NodeTaula[] taula){
		/*for(int i=0;i<taula.length;i++){
			NodeTaula node = taula[i];
			if(!node.getKey().equals("")){
				System.out.println(node.getKey()+", "+node.getRepes());
			}
		}*/
		return taula;
	}
	
	public NodeTaula[] ordenaNumericament(NodeTaula[] taula){
		NodeTaula[] aux = new NodeTaula[nombre*nombre];
		for(int i=0; i<taula.length;i++){
			aux[i] = new NodeTaula();
		}		
		
		NodeTaula node = new NodeTaula();
		int index =0;
		
		for(int i=0; i<taula.length;i++){
			if(!taula[i].getKey().equals("")){
				node = taula[i];
				index = hashNumeric(aux,node.getRepes());
				if(!aux[index].getKey().equals("")){
					while(!aux[index].getKey().equals("")){
						index = rehash(index);
					}
					aux[index] = node;
				}else{
					aux[index] = node;
				}
			}
		}
		aux = ordenaAlfabeticament(aux);
		return aux;
	}
	
	public int hashNumeric(NodeTaula[] taula,int valor){
		return taula.length/25 * valor-1;
	}

}
