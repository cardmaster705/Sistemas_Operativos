package nuevo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.util.Random;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Finaltest extends JFrame {
	JLabel lblProceso = new JLabel("Proceso 1:");
	
	JLabel lblProceso_1 = new JLabel("Proceso 2:");
	
	JLabel lblContadorFinal = new JLabel("Contador final:");
	
	JTextArea contador1 = new JTextArea();
	
	JTextArea contador2 = new JTextArea();
	
	JTextArea contador_f = new JTextArea();
	
	JLabel lblBuffer = new JLabel("Buffer");
	
	JTextArea bufferf = new JTextArea();
	
	JButton btnIniciar = new JButton("iniciar");
	int ultima_posicion=0;
	String []buffer=new String[20];
	int c1=0;
	int c2=0;
	int t1=0;
	int t2=0;
	int t3=0;
	int contadorF;
	String []letra={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	int cf=0;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finaltest frame = new Finaltest();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public void random(){
		
		do{
			
			Random random = new Random();
			int randomInteger = random.nextInt(3) + 1;
		    System.out.println("el numero es: "+randomInteger);
		    	switch(randomInteger){
		   
		    	case 1:
		    	
		    		if(ultima_posicion<20){   
		    		if(c1<20){
		    			
		    			try {
							Thread.sleep(1000);
							c1=c1+1;
							contador1.setText(String.valueOf(c1));
							numeroBuffer();
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			
		    		
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
		String buf="";
		contador1.setText(String.valueOf(c1));
		contador1.setText("");
		for(int i=0;i<buffer.length;i++){
			buffer[i]=buf;
			bufferf.setText(buf+"vacio");
		}
		System.out.println(buffer[0]+" "+buffer[1]+" "+buffer[2]+" "+buffer[3]+" "+buffer[4]+" "+buffer[5]+" "+buffer[6]+" "+buffer[7]+" "+buffer[8]+" "+buffer[9]+" "+buffer[10]+" "+buffer[11]+" "+buffer[12]+" "+buffer[13]+" "+buffer[14]+" "+buffer[15]+" "+buffer[16]+" "+buffer[17]+" "+buffer[17]+" "+buffer[18]+" "+buffer[19]+"\r\n");
		//JOptionPane.showMessageDialog(null,buffer[0]+" "+buffer[1]+" "+buffer[2]+" "+buffer[3]+" "+buffer[4]+" "+buffer[5]+" "+buffer[6]+" "+buffer[7]+" "+buffer[8]+" "+buffer[9]+" "+buffer[10]+" "+buffer[11]+" "+buffer[12]+" "+buffer[13]+" "+buffer[14]+" "+buffer[15]+" "+buffer[16]+" "+buffer[17]+" "+buffer[17]+" "+buffer[18]+" "+buffer[19]
	//+"\n"+"Proceso 1:"+c1+"\nProceso 2: "+c2+"\n ultima posicion :"+ultima_posicion+"\n contador final:"+cf);
		
		contador_f.append(String.valueOf(cf));
		contador_f.setText("");
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
	/**
	 * Create the frame.
	 */
	public Finaltest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contador1.setText(String.valueOf(c1));
		contador2.setText(String.valueOf(c2));
		contador_f.setText(String.valueOf(cf));
		
		bufferf.setText(buffer[0]);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				random();
				for(int i=0;i<10;i++){
					bufferf.setText(buffer[i]);
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblContadorFinal)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(contador_f, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblProceso)
										.addComponent(lblProceso_1))
									.addGap(30)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(contador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(contador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(175)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnIniciar)
								.addComponent(lblBuffer)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(bufferf, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProceso)
						.addComponent(contador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProceso_1)
						.addComponent(contador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContadorFinal)
						.addComponent(contador_f, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblBuffer)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(bufferf, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnIniciar))
		);
		contentPane.setLayout(gl_contentPane);
	
	}
}
