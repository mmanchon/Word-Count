package Eines;

import Model.Paraula;

public class ArbreBinari {
	private NodeArbre primer;
	private NodeArbre actual;
	int size =0;
	
	public ArbreBinari(){
		primer = new NodeArbre();
		actual = primer;
	}
	
	public void insertFillE(String nom,int valor){
		NodeArbre node = new NodeArbre();
		node.setKey(nom);
		node.setValor(valor);
		node.setPare(actual);
		actual.setFillE(node);
		actual = node;
		actual = primer;
	}
	
	public void insertFillD(String nom,int valor){
		NodeArbre node = new NodeArbre();
		node.setKey(nom);
		node.setValor(valor);
		node.setPare(actual);
		actual.setFillD(node);
		actual = node;
		actual = primer;
	}
	
	public NodeArbre getActual(){
		return actual;
	}
	
	public void setActual(NodeArbre actual){
		this.actual = actual;
	}
	
	public void setPrimer(NodeArbre primer){
		this.primer = primer;
	}
	
	public NodeArbre getPrimer(){
		return primer;
	}
	
	public void first(){
		actual=primer;
	}
	
	public int sizeText(String[][] text, int files){
		int recompte = 0;
		for(int i=0;i<files;i++){
			recompte += text[i].length;
		}
		return recompte;
	}
	
	
	public ArbreBinari recompteParaules(String[][] text, int files){
		this.size = sizeText(text,files);
		Paraula[] array = new Paraula[size];
		Paraula paraula;
		int index =0;
		for(int i=0;i<files;i++){
			for(int j=0;j<text[i].length;j++){
				//if(!text[i][j].equals("")&&!text[i][j].equals(" ")&&!text[i][j].equals("\n")){
					paraula = new Paraula(text[i][j],0);
					array[index] = paraula;
					index++;
				//}
			}
		}
		ArbreBinari ab = new ArbreBinari();
		ab = omple(array,ab);		
		return ab;
	}
	
	public ArbreBinari omple(Paraula[] array,ArbreBinari ab){
		String nom = new String();
		int repe=0;
		boolean trobat=false;

		//Entrem a la array feta de paraules i l'anem consultant
		for(int i=0;i<array.length;i++){
			
			nom = array[i].getNom();
						
			if(ab.getPrimer().getKey().equals("")){
				ab.getPrimer().setKey(nom);
				ab.getPrimer().setValor(1);
				ab.first();
			}else{
				while(!trobat){
					if(ab.getActual().getKey().compareTo(nom)<0){
						if(ab.getActual().getfillE()==null){
							ab.insertFillE(nom,1);
							trobat = true;
						}else{
							ab.setActual(ab.getActual().getfillE());
						}
					}else{
						if(ab.getActual().getKey().compareTo(nom)>0){
							if(ab.getActual().getFillD()==null){
								ab.insertFillD(nom,1);
								trobat = true;
							}else{
								ab.setActual(ab.getActual().getFillD());
							}
						}else{
							if(ab.getActual().getKey().equals(nom)){
								ab.getActual().setValor(ab.getActual().getValor()+1);
								ab.first();
								trobat=true;
							}
						}
					}
				}
			}
			trobat = false;
		}
		
		ab.first();
		//inordre(ab.getActual());
		return ab;
	}
	
	public NodeArbre mesPetit(ArbreBinari ab){
		while(ab.getActual().getfillE()!=null){
			ab.setActual(ab.getActual().getfillE());
		}
		return ab.getActual();
	}
	
	public void inordre(NodeArbre node){
		if(node.getfillE()==null && node.getFillD()==null){
			//System.out.println(node.getKey()+" "+node.getValor());
		}else{
			if(node.getfillE()!=null){
				inordre(node.getfillE());
			//	System.out.println(node.getKey()+" "+node.getValor());
				if(node.getFillD()!=null){
					inordre(node.getFillD());
				}
			}else{
				inordre(node.getFillD());
				//System.out.println(node.getKey()+" "+node.getValor());
			}
		}
	}
	
	public ArbreBinari ordenaNumercament(ArbreBinari ab){
		ArbreBinari aux = new ArbreBinari();
		ab.first();
		aux = inordreNumeric(ab.getActual(),aux);
		inordre(aux.getPrimer());
		return aux;
	}
	
	public ArbreBinari inordreNumeric(NodeArbre node,ArbreBinari aux){
		if(node.getfillE()==null && node.getFillD()==null){
			aux = inserirValor(aux,node);
		}else{
			if(node.getfillE()!=null){
				aux = inordreNumeric(node.getfillE(),aux);
				aux = inserirValor(aux,node);
				if(node.getFillD()!=null){
					aux = inordreNumeric(node.getFillD(),aux);
				}
			}else{
				aux = inordreNumeric(node.getFillD(),aux);
				aux = inserirValor(aux,node);
			}
		}
		//System.out.println(node.getKey()+posicio);
		
		return aux;
	}
	
	public ArbreBinari inserirValor(ArbreBinari ab,NodeArbre node){
		boolean trobat = false;
		if(ab.getPrimer().getKey().equals("")){
			ab.setPrimer(node);
			ab.first();
		}else{
			while(!trobat){
				if(ab.getActual().getValor()>=node.getValor()){
					if(ab.getActual().getfillE()==null){
						ab.insertFillE(node.getKey(),node.getValor());
						trobat = true;
					}else{
						ab.setActual(ab.getActual().getfillE());
					}
				}else{
					if(ab.getActual().getValor()<node.getValor()){
						if(ab.getActual().getFillD()==null){
							ab.insertFillD(node.getKey(),node.getValor());
							trobat = true;
						}else{
							ab.setActual(ab.getActual().getFillD());
						}
					}
				}
			}
		}
		return ab;
	}
	
	public ArbreBinari ordenaAlfabeticament(ArbreBinari estructura) {
		inordre(estructura.getPrimer());
		return (ArbreBinari)estructura;
	}
}
