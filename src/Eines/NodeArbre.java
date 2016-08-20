package Eines;

public class NodeArbre {
	private String key;
	private int valor;
	private NodeArbre fillE;
	private NodeArbre fillD;
	private NodeArbre pare;
	
	public NodeArbre(){
		this.key="";
		this.valor=0;
		fillE=null;
		fillD=null;
		pare = null;
	}
	
	public NodeArbre(String key, int valor){
		this.valor = valor;
		this.key = key;

	}
	
	public void setKey(String key){
		this.key = key;
	}
	
	public String getKey(){
		return key;
	}
	
	public void setValor(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return valor;
	}
	
	public void setFillE(NodeArbre fillE){
		this.fillE = fillE;
	}
	
	public NodeArbre getfillE(){
		return this.fillE;
	}
	
	public void setFillD(NodeArbre fillD){
		this.fillD = fillD;
	}
	
	public NodeArbre getFillD(){
		return this.fillD;
	}
	
	public void setPare(NodeArbre pare){
		this.pare = pare;
	}
	
	public NodeArbre getPare(){
		return this.pare;
	}
}
