package Eines;

import Model.Paraula;

public class Matrius {

    public Matrius(){}
    
    public int sizeText(String[][]t,int iT){
    	int size=0;
    	  for(int i = 0;i<iT; i++)size+=t[i].length;
    	  return size;
    }

    //METODE 3--> Matrius
   public Paraula[] recompteParaules(String[][]t,int iT){
	   Paraula[] arrayParaules = new Paraula[sizeText(t,iT)];
	   String paraula;
	   int fPar=0,cPar=0;
	   int nAp=0;
	   int iParaula=0;
	   
	   int finF = iT, finC =t[iT-1].length;
	   paraula = t[fPar][cPar];
	   while(!(fPar==finF && cPar==finC)){
		   boolean trobat = false;

		   //Comprovem que la paraula que anem a comptar no estigui en l'array de paraules.
		  
		   if(fPar!=finF){
			   for(int i=0;i<iParaula;i++){
				   if(t[fPar][cPar].equals(arrayParaules[i].getNom())){
					   trobat=true;
					   break;
				   }
			   }
		   }
		   //Si la paraula ja es troba saltem a la seguent sino comptem el numero d'aparicions.
		   if(!trobat){
			   nAp = 0;
			   for(int i = 0;i<iT; i++){
					int col=t[i].length;
					for(int j=0;j<col;j++){
						if(cPar>col)break;
						if(paraula.equals(t[i][j]))nAp++;
					}
			   }
			   //System.out.println("##"+paraula+"#"+nAp+"##");
			   arrayParaules[iParaula]=new Paraula(paraula,nAp);
			   iParaula++;
		   }
		   if(!(fPar==finF)&&cPar==(t[fPar].length)-1){
			   fPar++;
			   cPar=0;
			   try{
				   paraula = t[fPar][cPar];
			   }catch(IndexOutOfBoundsException e){
				   break;
			   }
		   }else {
			   cPar++;
			   try{
				   paraula = t[fPar][cPar];
			   }catch(IndexOutOfBoundsException e){
				   break;
			   }
		   }
		   
	   }
	   
	   return arrayParaules;
   }
   public Paraula[] selectionSort(Paraula[] arr,int mode) {
	      if(mode == 1){
	    	  int i, j, minIndex,iParaula=0;
		      Paraula tmp;
		      int iAux =0;
		      while(arr[iAux]!=null){
		    	  iParaula++;
		    	  iAux++;
		      }
	
		      int n = iParaula;
		      for (i = 0; i < n - 1; i++) {
		            minIndex = i;
		            for (j = i + 1; j < n; j++) 
		                	if (arr[j].getnAp() < arr[minIndex].getnAp())
		                        minIndex = j;
		                
		            if (minIndex != i) {
		                  tmp = new Paraula(arr[i].getNom(),arr[i].getnAp());
		                  arr[i].replace(arr[minIndex]);
		                  arr[minIndex].replace(tmp);
		            }
		      }
		      return arr;
	      }else{
	    	  int i, j, minIndex,iParaula=0;
		      Paraula tmp;
		      int iAux =0;
		      while(arr[iAux]!=null){
		    	  iParaula++;
		    	  iAux++;
		      }
	
		      int n = iParaula;
		      for (i = 0; i < n - 1; i++) {
		            minIndex = i;
		            for (j = i + 1; j < n; j++) 
		                	if (arr[j].compare(arr[j].getNom(), arr[minIndex].getNom())<0)
		                        minIndex = j;
		                
		            if (minIndex != i) {
		                  tmp = new Paraula(arr[i].getNom(),arr[i].getnAp());
		                  arr[i].replace(arr[minIndex]);
		                  arr[minIndex].replace(tmp);
		            }
		      }
		      return arr;
	      }
	}
   
   public Paraula[] ordenaNap(Paraula[] aux){
	   Paraula[] paraules = new Paraula[aux.length];
	   paraules=selectionSort(aux,1);
	   int iAux =0;
	   int iParaula = 0;
	   while(aux[iAux]!=null){
		   iParaula++;
		   iAux++;
	   }

	   iAux=0;
	   while(iAux<iParaula){
		   System.out.println("## "+aux[iAux].getNom()+" , "+aux[iAux].getnAp()+" ##");
		   iAux++;
	   }
	   return paraules;
   }
   public Paraula[] ordenaAlfabeticament(Paraula[] aux){
	   Paraula[] paraules = new Paraula[aux.length];
	   paraules=selectionSort(aux,2);
	   int iAux =0;
	   int iParaula = 0;
	   while(aux[iAux]!=null){
		   iParaula++;
		   iAux++;
	   }

	   iAux=0;
	   System.out.println("@@"+iParaula);
	   while(iAux<iParaula){
		   System.out.println("## "+aux[iAux].getNom()+" , "+aux[iAux].getnAp()+" ##");
		   iAux++;
	   }
	   return paraules;
   }
  
}

