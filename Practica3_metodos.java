package nuevo;

import java.util.Random;

public class Practica3_metodos {
int ultima_posicion=0;
String []buffer=new String[20];
int c1=0;
int c2=0;


public void random(){
	do{
		Random random = new Random();
		int randomInteger = random.nextInt(3) + 1;
	    System.out.println("el numero es: "+randomInteger);
	    	switch(randomInteger){
	    	case 1:
	    		if(c1<20&&ultima_posicion<=20){
	    		numeroBuffer();
	    		c1=c1+1;
	    		ultima_posicion=ultima_posicion+1;
	    		System.out.println("contador :"+c1);
	    		System.out.println("posicion :"+ultima_posicion);
	    		}else{
	    			System.out.println("Ya se ha alcanzado el limite de 20 elementos escritos");
	    		}
	    		break;
	    	case 2:
	    		if(c2<20&&ultima_posicion<=20){
	    		letraBuffer();
		    	c2=c2+1;
	    		ultima_posicion=ultima_posicion+1;
	    		System.out.println("contador :"+c2);
	    		System.out.println("posicion :"+ultima_posicion);
	    		}else{
	    		System.out.println("Ya se ha alcanzado el limite de 20 elementos escritos");
	    		}
	    		break;
	    	case 3:
	    		
	    		
	    	
	    		
	    	
	    			ultima_posicion=ultima_posicion-1;
	    			borraBuffer();
	    		System.out.println("posicion : "+ultima_posicion);	
	    		
	    		break;
	    	}//fin del switch
		}while(ultima_posicion>0);
}
public void numeroBuffer(){
	
}
public void letraBuffer(){
	
}
public void borraBuffer(){
	
}
}
