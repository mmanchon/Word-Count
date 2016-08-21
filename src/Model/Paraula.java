package Model;

import java.io.Serializable;

public class Paraula{
	private int nAp;
	private String nom;
	public Paraula(String nom, int ap){
		this.nAp=ap;
		this.nom=nom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getnAp() {
		return nAp;
	}
	public void setnAp(int nAp) {
		this.nAp = nAp;
	}
	public boolean equals(Paraula aux){
		return nom.equals(aux.getNom());
	}
	public void replace(Paraula p){
		this.nom=p.getNom();
		this.nAp=p.getnAp();
	}
	public int compare(String p1, String p2){
		return p1.compareTo(p2);
	}
}
