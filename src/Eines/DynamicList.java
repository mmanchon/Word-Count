package Eines;

import java.io.Serializable;

import Model.Node;
import Model.Paraula;

/**
 * Implementa una llista dinamica destudiants.
 */
public class DynamicList{
	private Node first;
	private Node previous;
	private int size;

	/**
	 * Crea una llista dinamica buida.
	 */
	public DynamicList() {
		first = new Node();
		// Tambe podriem fer el seguent, pero no es necessari
		// donat que els atributs son de tipus referencia i
		// automaticament son inicialitzats a null
		// 		first.setElement(null);
		// 		first.setNext(null);
		
		// Posem lanterior sobre el fantasma
		previous = first;
		setSize(0);
		// Una altra opcio seria:
		//		first = new Node(null, null);
		//		previous = first;
	}

	/**
	 * Insereix un estudiant a la posicio del PDI.
	 */
	public void insert(Paraula element) {
		Node n = new Node();
		n.setElement(element);
		n.setNext(previous.getNext());
		previous.setNext(n);
		previous = n;
		setSize(getSize() + 1);
		
		// Tambe podriem fer:
		// 		Node n = new Node(element, previous.getNext());
		// 		previous.setNext(n);
		// 		previous = n;
	}
	public void insertOrd(DynamicList l,Paraula element,int mode) {
		switch(mode){
		case 1:
			l.first();
			
			while(!l.end()&&l.get().getnAp()<element.getnAp()){
					l.next();
				}
				l.insert(element);
			break;
		case 2:
			l.first();
			
			while(!l.end()&&l.get().compare(l.get().getNom(), element.getNom())<0){
					l.next();
				}
				l.insert(element);
			break;
		}
	}
	/**
	 * Retorna lelement apuntat per el PDI.
	 */
	public Paraula get() {
		if (previous.getNext() != null) {
			return previous.getNext().getElement();
		}
		return null;
		// Tambe podriem fer
		// 		return previous.getNext()!=null ? previous.getNext().getElement():null;
	}

	/**
	 * Elimina lelement apuntat per el PDI.
	 */
	public boolean delete() {
		if (previous.getNext() != null) {
			previous.setNext(previous.getNext().getNext());
			setSize(getSize() - 1);
			return true;
		}
		return false;
	}

	/**
	 * Elimina tots els elements de la llista.
	 */
	public void deleteAll() {
		first.setNext(null);
		previous = first;
		setSize(0);
	}

	/**
	 * Situa el PDI a linici de la llista.
	 */
	public void first() {
		previous = first;
	}
	
	/**
	 * Avanca el PDI.
	 */
	public boolean next() {
		if (!end()) {
			previous = previous.getNext();
			return true;
		}
		return false;
	}

	/**
	 * Comprovem si el PDI esta al final.
	 */
	public boolean end() {
		return previous.getNext() == null;
	}

	/**
	 * Comprova si la llista esta buida.
	 */
	public boolean empty() {
		return first.getNext() == null;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	public DynamicList convert(String[][] preAux,int iFiles){
		DynamicList aux = new DynamicList();
		for(int i=0;i<iFiles;i++){
			int col = preAux[i].length;
			for(int j=0;j<col;j++){
				if(!preAux[i][j].equals(" ")&&!preAux[i][j].equals("")){
					aux.insert(new Paraula(preAux[i][j],0));
				}
					//System.out.println(preAux[i][j]);
			}
		}
		return aux;
	}
	
	public void insercioDynamicList(String cadena, DynamicList aux){
		   String[] arCad = cadena.split(" ");
		   for(int i=0;i<arCad.length;i++)aux.insert(new Paraula(arCad[i],1));
	   }
   public DynamicList recompteParaules(String[][] preAux,int iFiles){
	   //Possem totes les paraules en la llista dynamica sense tenir en compte les repeticions
	   DynamicList aux = convert(preAux,iFiles);
	   
	   DynamicList paraules = new DynamicList();
	   //Col·loquem el PDI en la primerea posicio
	   paraules.first();
	   //Printem paraula i les vegades que surt
	  /* while(!paraules.end()){
		   System.out.println(paraules.get().getNom()+" "+paraules.get().getnAp());
		   paraules.next();
	   }*/
	   while(!aux.empty()){
		   aux.first();
		   //Crec que aqui fa falta un aux.next() o estem contant una repeticio de més
		   Paraula master = aux.get();
		   int nAp=0;
		   while(!aux.end()){
			   
			   if(master.equals(aux.get())){
				   nAp++;
				   aux.delete();
			   }else{
				   aux.next();
			   }
		   }
		   master.setnAp(nAp);
		   
		   paraules.insert(master);
		   aux.first();
	   }
	   return paraules;
   }
   
   public Paraula get(DynamicList list, int i ){
	   list.first();
	   for(int j=0;j<i-1;j++)list.next();
	   return list.get();
   }
   public DynamicList ordenaAlfabeticament(DynamicList list){
	   DynamicList paraules = new DynamicList();
	   list.first();
	   while(!list.end()){
		   paraules.insertOrd(paraules, list.get(),2);
		   list.next();
	   }
	   /*paraules.first();
	   while(!paraules.end()){
		   System.out.println("## "+paraules.get().getNom()+" , "+paraules.get().getnAp()+" ##");
		   paraules.next();
	   }*/
	  // System.out.println("## "+paraules.get().getNom()+" , "+paraules.get().getnAp()+" ##");
	   return paraules;
   }
   public DynamicList ordenaNaparicions(DynamicList list){
	   DynamicList paraules = new DynamicList();
	   list.first();
	   while(!list.end()){
		   paraules.insertOrd(paraules, list.get(),1);
		   list.next();
	   }
	   /*paraules.first();
	   while(!paraules.end()){
		   System.out.println("## "+paraules.get().getNom()+" , "+paraules.get().getnAp()+" ##");
		   paraules.next();
	   }*/
	  // System.out.println("## "+paraules.get().getNom()+" , "+paraules.get().getnAp()+" ##");
	   return paraules;
   }
	
}
