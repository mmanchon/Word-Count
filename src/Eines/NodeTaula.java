package Eines;

public class NodeTaula {
	
	private String key = new String();
	private int repes=0;
	private char lletra;
	
	public void NodeTaula(){
		this.key = "";
		this.lletra = 'a';
		this.repes = 0;
	}
	
	public void ompleNodeTaula(String key, int repes, char lletra){
		this.key = key;
		this.repes = repes;
		this.lletra = lletra;
	}
	
	public String getKey(){
		return key;
	}
	
	public void setKey(String key){
		this.key = key;
	}
	
	public int getRepes(){
		return repes;
	}
	
	public void setRepes(int repes){
		this.repes=repes;
	}
	
	public char getLletra(){
		return lletra;
	}
	
	public void setLletra(char lletra){
		this.lletra=lletra;
	}
}
