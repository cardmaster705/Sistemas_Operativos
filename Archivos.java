package nuevo;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class Archivos {
		
		String texto="";
		String temp;
		public String leerArchivos(){
		
			JFileChooser buscador= new JFileChooser();
			buscador.showOpenDialog(buscador);
			try{
				String patch= buscador.getSelectedFile().getAbsolutePath();
				BufferedReader bf = new BufferedReader(new FileReader(patch));
				String temp="";
				String bfRead;
				String file = patch.substring(27);
				System.out.println("Archivo:"+file);
				while((bfRead= bf.readLine())!= null){
					temp=temp+bfRead+"\n";
					texto=temp;
					
				}
				}catch(Exception e){
			System.err.println("el archivo no ha sido encontrado");
		}
		
			return texto;
		
			}
		
		public void cadenas(){
			StringTokenizer tokens = new StringTokenizer(texto,"\n");	

			while(tokens.hasMoreTokens()){
				
				temp=tokens.nextToken();
				//System.out.println(temp);
			}
			}
		
		public void split(String nuevacadena){
			String nueva[]=texto.split("\\s");
			System.out.println("N� de instrucciones :"+nueva[0]);
			System.out.println("N� de datos :"+nueva[1]);
			System.out.println("N� inicial de instrucciones :"+nueva[2]);
			System.out.println("N� inicial de datos :"+nueva[3]);
			System.out.println("INSTRUCCIONES");
			int tama�o=nueva.length;
			int instrucciones=Integer.parseInt(nueva[2]);
			int dato=Integer.parseInt(nueva[3]);
			int i;
			for(i=4;i<tama�o;i++){
				if ( nueva[i].charAt(0) != 48) {
					System.out.println(instrucciones+" "+"COD: "+nueva[i].charAt(0)+ " "+"Dir: "+nueva[i].charAt(1)+nueva[i].charAt(2)+nueva[i].charAt(3));
					instrucciones++;
				} else {
					break;
				}
			}
			
			System.out.println("Datos:");
			for (; i < tama�o;i++) {
				System.out.println(dato+"  "+"Valor: "+nueva[i]);
				dato++;
			}
		}



}