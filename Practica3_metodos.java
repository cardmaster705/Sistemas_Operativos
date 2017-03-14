package nuevo;

import java.util.Random;

public class Practica3_metodos {
int ultima_posicion=0;
String []buffer=new String[20];
int c1=0;
int c2=0;
int t1=0;
int t2=0;
String []letra={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};


public void random(){
	
	do{
		Random random = new Random();
		int randomInteger = random.nextInt(3) + 1;
	    System.out.println("el numero es: "+randomInteger);
	    	switch(randomInteger){
	    	case 1:
	    		if(ultima_posicion<20){
	    		if(c1<20){
	    		numeroBuffer();
	    		c1=c1+1;
	    		t1=0;
	    		ultima_posicion=ultima_posicion+1;
	    		System.out.println("contador :"+c1);
	    		System.out.println("posicion :"+ultima_posicion);
	    		
	    		}else{
	    			System.out.println("Proceso terminado");
	    			t1=1;
	    		}
	    		}else{
	    			System.out.println("Buffer lleno");
	    		}
	    		
	    		break;
	    	case 2:
	    		if(ultima_posicion<20){
	    		if(c2<20){
	    		letraBuffer();
		    	c2=c2+1;
		    	t2=0;
	    		ultima_posicion=ultima_posicion+1;
	    		System.out.println("contador :"+c2);
	    		System.out.println("posicion :"+ultima_posicion);
	    		
	    		}else{
	    			System.out.println("Proceso terminado");
	    			t2=1;
	    		}
	    		}else{
	    			System.out.println("Buffer lleno");
	    		}
	    		
	    		break;
	    	case 3:
	    		
	    		
	    	
	    		borraBuffer();
	    		if(ultima_posicion>0){
	    			ultima_posicion=ultima_posicion-1;
	    		
	    		System.out.println("posicion : "+ultima_posicion);	
	    		}else{
	    			System.out.println("ya te encuentras en la posicion 0");
	    			System.out.println("posicion : "+ultima_posicion);
	    		}
	    		break;
	    	}//fin del switch
		}while(t1==0||t2==0);

	
	}
public void numeroBuffer(){
	Random random = new Random();
	int randomInteger = random.nextInt(9)+1;
	buffer[ultima_posicion]=String.valueOf(randomInteger);
	for(int i=0;i<buffer.length;i++){
	
	System.out.println("posicion del buffer: "+i+" "+"Elemento del buffer: "+buffer[i]);
	}
}
public void letraBuffer(){
	Random random = new Random();
	int randomInteger = random.nextInt(25)+1;
	String letra_actual=letra[randomInteger];
	buffer[ultima_posicion]=letra_actual;
	for(int i=0;i<buffer.length;i++){
	
	System.out.println("posicion del buffer: "+i+" "+"Elemento del buffer: "+buffer[i]);
	}
}
public void borraBuffer(){
	if(ultima_posicion>0){
	buffer[ultima_posicion-1]="";
	for(int i=0;i<buffer.length;i++){
		
		System.out.println("posicion del buffer: "+i+" "+"Elemento del buffer: "+buffer[i]);
		}
			}
	}
}
