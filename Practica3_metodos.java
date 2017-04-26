package nuevo;

import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Practica3_metodos {
int ultima_posicion=0;
String []buffer=new String[20];
int c1=0;
int c2=0;
int t1=0;
int t2=0;
int t3=0;
int contadorF;
String []letra={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
int cf=1;

public void random(){
	
	do{
		
		Random random = new Random();
		int randomInteger = random.nextInt(3) + 1;
	    System.out.println("el numero es: "+randomInteger);
	    	switch(randomInteger){
	   
	    	case 1:
	    		if(ultima_posicion<20){   
	    		if(c1<20){
	    			c1=c1+1;
	    			numeroBuffer();
	    		
	    		t1=0;
	    		ultima_posicion=ultima_posicion+1;
	    		//System.out.println("contador :"+c1);
	    		//System.out.println("posicion :"+ultima_posicion);
	    		//System.out.println("");
	    		
	    		}else{
	    			//System.out.println("Proceso terminado");
	    			//System.out.println("");
	    			t1=1;
	    		}
	    		}else{
	    			//System.out.println("Buffer lleno");
	    		}
	    		
	    		break;
	    	case 2:
	    		if(ultima_posicion<20){
	    		if(c2<20){
	    			c2=c2+1;
	    			letraBuffer();
		    	
		    	t2=0;
	    		ultima_posicion=ultima_posicion+1;
	    		//System.out.println("contador :"+c2);
	    		//System.out.println("posicion :"+ultima_posicion);
	    		//System.out.println("");
	    		
	    		}else{
	    			//System.out.println("Proceso terminado");
	    			//System.out.println("");
	    			t2=1;
	    		}
	    		}else{
	    			//System.out.println("Buffer lleno");
	    		}
	    		
	    		break;
	    	case 3:
	    			
	    		
	    	
	    		borraBuffer();
	    		if(ultima_posicion>0){
	    			ultima_posicion=ultima_posicion-1;
	    		
	    		//System.out.println("posicion : "+ultima_posicion);	
	    		//System.out.println("");
	    		}else{
	    			//System.out.println("ya te encuentras en la posicion 0");
	    			//System.out.println("posicion : "+ultima_posicion);
	    			//System.out.println("");
	    		}
	    		break;
	    	}//fin del switch
	    	cf=cf+1;
		}while(t1==0||t2==0);//termina de escribir 20 veces el proceso 1 y 2
	do{
		Random random = new Random();
		int randomInteger = random.nextInt(3) + 1;
	    System.out.println("el numero es: "+randomInteger);
	    	switch(randomInteger){
	    	case 1:
	    		if(ultima_posicion>0){
	    		t3=0;
	    		//System.out.println("Proceso terminado");
	    		//System.out.println("Posicion actual: "+ultima_posicion);
	    		//System.out.println("");
	    		}else{
	    			//System.out.println("Buffer vacio");
	    			t3=1;
	    		}       
	    		break;
	    	case 2:
	    		if(ultima_posicion>0){
	    		t3=0;
	    		//System.out.println("Proceso terminado");
	    		//System.out.println("Posicion actual: "+ultima_posicion);
	    		//System.out.println("");
	    		}else{
	    			//System.out.println("Buffer vacio");
	    			t3=1;
	    		}
	    		break;
	    	case 3:
	    		if(ultima_posicion>0){
	    		t3=0;
	    		borraBuffer();
	    		
	    		ultima_posicion=ultima_posicion-1;
	    		
	    		//System.out.println("posicion : "+ultima_posicion);	
	    		//System.out.println("");
	    		}else{
	    			//System.out.println("Buffer vacio");
	    			//System.out.println("posicion : "+ultima_posicion);
	    			t3=1;
	    		}
	    	
	    		
	    		break;
	    	}//fin del switch
	    	cf=cf+1;
		}while(t3==0);
	
	}//fin del metodo
public void numeroBuffer(){
	
	Random random = new Random();
	int randomInteger = random.nextInt(9)+1;
	buffer[ultima_posicion]=String.valueOf(randomInteger);
	imprimir();
	/*for(int i=0;i<buffer.length;i++){
	
	System.out.println("posicion del buffer: "+i+" "+"Elemento del buffer: "+buffer[i]);
	}*/

}
public void imprimir(){
	

	//        System.out.println(buffer[0]+" "+buffer[1]+" "+buffer[2]+" "+buffer[3]+" "+buffer[4]+" "+buffer[5]+" "+buffer[6]+" "+buffer[7]+" "+buffer[8]+" "+buffer[9]+" "+buffer[10]+" "+buffer[11]+" "+buffer[12]+" "+buffer[13]+" "+buffer[14]+" "+buffer[15]+" "+buffer[16]+" "+buffer[17]+" "+buffer[17]+" "+buffer[18]+" "+buffer[19]+"\r\n");
	JOptionPane.showMessageDialog(null,buffer[0]+" "+buffer[1]+" "+buffer[2]+" "+buffer[3]+" "+buffer[4]+" "+buffer[5]+" "+buffer[6]+" "+buffer[7]+" "+buffer[8]+" "+buffer[9]+" "+buffer[10]+" "+buffer[11]+" "+buffer[12]+" "+buffer[13]+" "+buffer[14]+" "+buffer[15]+" "+buffer[16]+" "+buffer[17]+" "+buffer[17]+" "+buffer[18]+" "+buffer[19]
+"\n"+"Proceso 1:"+c1+"\nProceso 2: "+c2+"\n ultima posicion :"+ultima_posicion+"\n contador final:"+cf);
	
	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void letraBuffer(){

	Random random = new Random();
	int randomInteger = random.nextInt(25)+1;
	String letra_actual=letra[randomInteger];
	buffer[ultima_posicion]=letra_actual;
	imprimir();
	/*for(int i=0;i<buffer.length;i++){
	
	System.out.println("posicion del buffer: "+i+" "+"Elemento del buffer: "+buffer[i]);
	}*/
	
}
public void borraBuffer(){
	if(ultima_posicion>0){
	buffer[ultima_posicion-1]="";
	imprimir();
	/*for(int i=0;i<buffer.length;i++){
		
		System.out.println("posicion del buffer: "+i+" "+"Elemento del buffer: "+buffer[i]);
		}*/
			}
	}
}