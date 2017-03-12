package nuevo;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Interfaz {
	
	Hilo[] hilo;
	
	JFileChooser fileChooser=null;

	private JFrame frmAdministradorDeProcesos;
	private JLabel numProceso;
	private JLabel algPlanificacion;
	private JPanel panel_1=null;

	public JLabel[] lblNuevoNombre=null;
	public JLabel[] lblNuevoInstrucciones=null;
	
	public JLabel[] lblListoNombre=null;
	public JLabel[] lblListoInstrucciones=null;
	
	public JLabel lblEjecutandoNombre = null;
	public JLabel lblEjecutandoInstrucciones = null;
	
	
	public JLabel[] lblBloqueadoNombre=null;
	public JLabel[] lblBloqueadoInstrucciones=null;
	public JLabel[] lblBloqueadoContDesbloq=null;
	
	public JLabel[] lblTerminadoNombre=null;
	public JLabel[] lblTerminadoInstrucciones=null;
	
	private String archivo="";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frmAdministradorDeProcesos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdministradorDeProcesos = new JFrame();
		frmAdministradorDeProcesos.setTitle("Planificador de procesos");
		frmAdministradorDeProcesos.setBounds(100, 100, 850, 430);
		frmAdministradorDeProcesos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdministradorDeProcesos.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		frmAdministradorDeProcesos.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmAbrirArchivo = new JMenuItem("Abrir archivo...");
		mntmAbrirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fileChooser=new JFileChooser();
				if ( fileChooser.showOpenDialog(menuBar) == JFileChooser.APPROVE_OPTION) {
					archivo=leerArchivo(fileChooser.getSelectedFile().getAbsolutePath());
					prepararEjecucion();
				}//if
			}
		});
		mnArchivo.add(mntmAbrirArchivo);
		
		JMenuItem mntmMostrarArchivo = new JMenuItem("Mostrar archivo..");
		mntmMostrarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (archivo.equals("")) {
					JOptionPane.showMessageDialog(frmAdministradorDeProcesos, "No hay archivos seleccionados", "", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frmAdministradorDeProcesos, archivo, "", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		mnArchivo.add(mntmMostrarArchivo);
		
		JMenu mnEjecutar = new JMenu("Ejecutar");
		menuBar.add(mnEjecutar);
		
		JMenuItem mntmEjecutar = new JMenuItem("Ejecutar..");
		mntmEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ejecutar();
			}
		});
		mnEjecutar.add(mntmEjecutar);
	}
	
	public void inicializarComponenetes() {
		JPanel panel = new JPanel();
		frmAdministradorDeProcesos.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel numProcesoLabel = new JLabel("Numero de procesos:");
		panel.add(numProcesoLabel);
		
		numProceso = new JLabel("0");
		panel.add(numProceso);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		
		JLabel algPlanificacionLabel = new JLabel("Algoritmo de planificacion:");
		panel.add(algPlanificacionLabel);
		
		algPlanificacion = new JLabel("none");
		panel.add(algPlanificacion);
		
		panel_1 = new JPanel();
		frmAdministradorDeProcesos.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNuevo = new JLabel("NUEVO");
		lblNuevo.setBounds(50, 27, 70, 15);
		panel_1.add(lblNuevo);
		
		JLabel lblListo = new JLabel("LISTO");
		lblListo.setBounds(200, 27, 70, 15);
		panel_1.add(lblListo);
		
		JLabel lblEjecutando = new JLabel("EJECUTANDO");
		lblEjecutando.setBounds(345, 27, 95, 15);
		panel_1.add(lblEjecutando);
		
		JLabel lblBloqueo = new JLabel("BLOQUEO");
		lblBloqueo.setBounds(530, 27, 70, 15);
		panel_1.add(lblBloqueo);
		
		JLabel lblTerminado = new JLabel("TERMINADO");
		lblTerminado.setBounds(720, 27, 87, 15);
		panel_1.add(lblTerminado);
		
		lblEjecutandoNombre = new JLabel("-");
		lblEjecutandoNombre.setBounds(355, 80, 70, 15);
		panel_1.add(lblEjecutandoNombre);
		
		lblEjecutandoInstrucciones = new JLabel("-");
		lblEjecutandoInstrucciones.setBounds(403, 80, 70, 15);
		panel_1.add(lblEjecutandoInstrucciones);	
	}
	
	private String leerArchivo(String rutaArchivo){
		StringBuilder sb = new StringBuilder();
		String ln="";
		
		try (FileReader fr = new FileReader(rutaArchivo);
			 BufferedReader br = new BufferedReader(fr);){
			sb.append(br.readLine());
			while ((ln = br.readLine()) != null){
				sb.append('\n');
				sb.append(ln);	
			}//while
		} catch (IOException e) {
			e.printStackTrace();
		}//catch
		return sb.toString();
	}//leerArchivo
	
	private void prepararEjecucion() {
		inicializarComponenetes();
		
		String[] split= archivo.split("\n");
		String alg="";
		int indiceHilo=0; 
		int numeroProcesos=Integer.parseInt(split[0]);
		hilo = new Hilo[numeroProcesos];
		numProceso.setText(split[0]);
		alg=split[1];
		for (int i=2; i < split.length; i++) {
			String s[]=split[i].split(":");
			hilo[indiceHilo++]=new Hilo(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), 
											Integer.parseInt(s[3]), Integer.parseInt(s[4]),
											Integer.parseInt(s[5]));
		}//for
		hilo[0].imprimirAtributos();
		hilo[1].imprimirAtributos();
		hilo[2].imprimirAtributos();
		hilo[3].imprimirAtributos();
		
		generarEtiquetasNuevo(numeroProcesos);
		
		switch (alg) {
		case "1":
			algPlanificacion.setText("Prioridad");
			//Burbuja
			for (int i=1; i < numeroProcesos ; i++) {
				for (int j=0; j < numeroProcesos-i; j++) {
					if (hilo[j].getPrioridad() < hilo[j+1].getPrioridad()) {
						Hilo aux=hilo[j];
						hilo[j]=hilo[j+1];
						hilo[j+1]=aux;
					}
				}//for
			}//for
			break;
			
		case "2":
			algPlanificacion.setText("FIFO");
			break;
			
		case "3":
			algPlanificacion.setText("SJF");
			//Burbuja
			for (int i = 1; i < numeroProcesos; i++) {
				for (int j = 0; j < numeroProcesos-i; j++) {
					if (hilo[j].getNumeroInstrucciones() > hilo[j+1].getNumeroInstrucciones()) {
						Hilo aux=hilo[j];
						hilo[j]=hilo[j+1];
						hilo[j+1]=aux;
					}//if
				}//for
			}//for
			break;
			
			default:
				algPlanificacion.setText("none");
				break;
		}//switch

		generarEtiquetasListo(numeroProcesos);
		generarEtiquetasBloqueado(numeroProcesos);
		generarEtiquetasTerminado(numeroProcesos);

	}//prepararEjecucion
	
	public void cambiarColorEtiqueta(JLabel lbl, int color) {
		switch (color) {
		case 1:
			lbl.setForeground(Color.RED);
			break;
		case 2:
			lbl.setForeground(Color.GREEN);
			break;
		case 3:
			lbl.setForeground(Color.YELLOW);
			break;
		case 4:
			lbl.setForeground(Color.BLUE);
			break;
		case 5:
			lbl.setForeground(Color.ORANGE);
			break;
		}
	}
	
	public void generarEtiquetasNuevo(int numEtiquetas) {		
		lblNuevoNombre = new JLabel[numEtiquetas];
		lblNuevoInstrucciones = new JLabel[numEtiquetas];
		int incrementoPixeles=250/numEtiquetas;
		int pixeles=80;
		for (int i=0; i < numEtiquetas; i++) {
			lblNuevoNombre[i] = new JLabel(hilo[i].getNombre());
			lblNuevoNombre[i].setBounds(30,pixeles,70,15);
			cambiarColorEtiqueta(lblNuevoNombre[i], hilo[i].getColor());
			panel_1.add(lblNuevoNombre[i]);
			
			lblNuevoInstrucciones[i] = new JLabel(String.valueOf(hilo[i].getNumeroInstrucciones()));
			lblNuevoInstrucciones[i].setBounds(80,pixeles,70,15);
			cambiarColorEtiqueta(lblNuevoInstrucciones[i], hilo[i].getColor());
			panel_1.add(lblNuevoInstrucciones[i]);
			pixeles=pixeles+incrementoPixeles;
		}//for		
	}//generarEtiquetasNuevo
	
	public void generarEtiquetasListo(int numEtiquetas) {		
		lblListoNombre = new JLabel[numEtiquetas];
		lblListoInstrucciones = new JLabel[numEtiquetas];
		int incrementoPixeles=250/numEtiquetas;
		int pixeles=80;
		for (int i=0; i < numEtiquetas; i++) {
			lblListoNombre[i] = new JLabel(hilo[i].getNombre());
			lblListoNombre[i].setBounds(180,pixeles,70,15);
			cambiarColorEtiqueta(lblListoNombre[i], hilo[i].getColor());
			panel_1.add(lblListoNombre[i]);
			
			lblListoInstrucciones[i] = new JLabel(String.valueOf(hilo[i].getNumeroInstrucciones()));
			lblListoInstrucciones[i].setBounds(230,pixeles,70,15);
			cambiarColorEtiqueta(lblListoInstrucciones[i], hilo[i].getColor());
			panel_1.add(lblListoInstrucciones[i]);
			pixeles=pixeles+incrementoPixeles;
		}//for		
	}//generarEtiquetasListo
	
	public void generarEtiquetasBloqueado(int numEtiquetas) {		
		lblBloqueadoNombre = new JLabel[numEtiquetas];
		lblBloqueadoInstrucciones = new JLabel[numEtiquetas];
		lblBloqueadoContDesbloq = new JLabel[numEtiquetas];
		int incrementoPixeles=250/numEtiquetas;
		int pixeles=80;
		for (int i=0; i < numEtiquetas; i++) {
			lblBloqueadoNombre[i] = new JLabel("");
			lblBloqueadoNombre[i].setBounds(520,pixeles,70,15);
			panel_1.add(lblBloqueadoNombre[i]);
			
			lblBloqueadoInstrucciones[i] = new JLabel("");
			lblBloqueadoInstrucciones[i].setBounds(570,pixeles,70,15);
			panel_1.add(lblBloqueadoInstrucciones[i]);
			
			lblBloqueadoContDesbloq[i] = new JLabel("");
			lblBloqueadoContDesbloq[i].setBounds(620,pixeles,70,15);
			panel_1.add(lblBloqueadoContDesbloq[i]);
			pixeles=pixeles+incrementoPixeles;
		}//for		
	}//generarEtiquetasBloqueado
	
	public void generarEtiquetasTerminado(int numEtiquetas) {		
		lblTerminadoNombre = new JLabel[numEtiquetas];
		lblTerminadoInstrucciones = new JLabel[numEtiquetas];
		int incrementoPixeles=250/numEtiquetas;
		int pixeles=80;
		for (int i=0; i < numEtiquetas; i++) {
			lblTerminadoNombre[i] = new JLabel("");
			lblTerminadoNombre[i].setBounds(730,pixeles,70,15);
			panel_1.add(lblTerminadoNombre[i]);
			
			lblTerminadoInstrucciones[i] = new JLabel("");
			lblTerminadoInstrucciones[i].setBounds(780,pixeles,70,15);
			panel_1.add(lblTerminadoInstrucciones[i]);
			pixeles=pixeles+incrementoPixeles;
		}//for		
	}//generarEtiquetasTerminado
	
	
	private void ejecutar() {
		RoundRobin rr = new RoundRobin(hilo,20,this);
		rr.start();
	}
}
