package nuevo;

public class RoundRobin extends Thread {
	Interfaz interfaz=null;
	Hilo[] h=null;
	int quantum=0;
	boolean bandera=true;
	int cantidadListos=0;
	int cantidadBloqueados=0;
	int cantidadTerminados=0;

	
	public RoundRobin(Hilo[] h, int quantum, Interfaz interfaz) {
		this.h=h;
		this.quantum=quantum;
		this.interfaz=interfaz;
		cantidadListos=h.length;
	}//constructor
	
	public void realizarQuantum() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//quantum
	
	public void run() {
		/**
		 * Inicializar los procesos
		 */
		for (int i=0;i<h.length;i++) {
			h[i].start();
			h[i].pausar();
		}//for
		
		while (bandera) {
			for (int i=0; i < h.length; i++) {
				if (!h[i].estaEjecutando()) {
					h[i].continuar();
					//Mostrar en la ejecucion
					interfaz.lblEjecutandoNombre.setText(h[i].getNombre());
					interfaz.lblEjecutandoInstrucciones.setText(String.valueOf(h[i].getNumeroInstrucciones()));
					interfaz.cambiarColorEtiqueta(interfaz.lblEjecutandoNombre, h[i].getColor());
					interfaz.cambiarColorEtiqueta(interfaz.lblEjecutandoInstrucciones, h[i].getColor());
					//Decrementar el numero total de los procesos en Listo
					cantidadListos--;
					/**
					 * Acomodar los procesos en la lista de LISTOS despues de ser ejecutado un proceso
					 */
					int z=0;
					for (; z < cantidadListos;z++){
						interfaz.lblListoNombre[z].setText(interfaz.lblListoNombre[z+1].getText());
						interfaz.lblListoInstrucciones[z].setText(interfaz.lblListoInstrucciones[z+1].getText());
						interfaz.lblListoNombre[z].setForeground(interfaz.lblListoNombre[z+1].getForeground());
						interfaz.lblListoInstrucciones[z].setForeground(interfaz.lblListoInstrucciones[z+1].getForeground());
					}//for
					interfaz.lblListoNombre[z].setText("");
					interfaz.lblListoInstrucciones[z].setText("");
					/**
					 * Empezar la planificacion con quantums
					 */
					for (int j = 0; j < quantum; j++) {
						interfaz.lblEjecutandoNombre.setText(h[i].getNombre());
						interfaz.lblEjecutandoInstrucciones.setText(String.valueOf(h[i].getNumeroInstrucciones()));
						//Si el proceso esta en la instruccion bloqueo mientras aun esta vivo
						if (h[i].getNumeroInstrucciones() <= 0 || h[i].getNumeroInstrucciones() == h[i].getError()) {
							//Agrega este proceso a la lista de terminados
							interfaz.lblTerminadoNombre[cantidadTerminados].setText(h[i].getNombre());
							interfaz.lblTerminadoInstrucciones[cantidadTerminados].setText(String.valueOf(h[i].getNumeroInstrucciones()));
							interfaz.cambiarColorEtiqueta(interfaz.lblTerminadoNombre[cantidadTerminados], h[i].getColor());
							interfaz.cambiarColorEtiqueta(interfaz.lblTerminadoInstrucciones[cantidadTerminados++], h[i].getColor());
							interfaz.lblEjecutandoNombre.setText("");
							interfaz.lblEjecutandoInstrucciones.setText("");
							realizarQuantum();
							break;
						} else if (h[i].getNumeroInstrucciones() == h[i].getBloqueo() && h[i].getNumeroInstrucciones() > 0) {
							//Si termino de ejecutarse las instrucciones entonces
							//Agregar proceso a lista de bloqueados, bloquear el proceso y quitar de la lsita de ejecucion
							interfaz.lblBloqueadoNombre[cantidadBloqueados].setText(h[i].getNombre());
							interfaz.lblBloqueadoInstrucciones[cantidadBloqueados].setText(String.valueOf(h[i].getNumeroInstrucciones()));
							interfaz.lblBloqueadoContDesbloq[cantidadBloqueados].setText(String.valueOf(h[i].getContadorDesbloq()));
							interfaz.cambiarColorEtiqueta(interfaz.lblBloqueadoNombre[cantidadBloqueados], h[i].getColor());
							interfaz.cambiarColorEtiqueta(interfaz.lblBloqueadoInstrucciones[cantidadBloqueados], h[i].getColor());
							interfaz.cambiarColorEtiqueta(interfaz.lblBloqueadoContDesbloq[cantidadBloqueados++], h[i].getColor());
							interfaz.lblEjecutandoNombre.setText("");
							interfaz.lblEjecutandoInstrucciones.setText("");
							h[i].bloquear();
							realizarQuantum();
							break;	//Salir del ciclo para que no se ejecuten los quantums restantes 
						} else {
							//Decrementa el numero de instruccion del proceso
							h[i].setNumeroInstrucciones(h[i].getNumeroInstrucciones()-1);
							realizarQuantum();
							//Si el proceso esta en la instruccion bloqueo mientras aun esta vivo
							if (h[i].getNumeroInstrucciones() <= 0 || h[i].getNumeroInstrucciones() == h[i].getError()) {
								//Agrega este proceso a la lista de terminados
								interfaz.lblTerminadoNombre[cantidadTerminados].setText(h[i].getNombre());
								interfaz.lblTerminadoInstrucciones[cantidadTerminados].setText(String.valueOf(h[i].getNumeroInstrucciones()));
								interfaz.cambiarColorEtiqueta(interfaz.lblTerminadoNombre[cantidadTerminados], h[i].getColor());
								interfaz.cambiarColorEtiqueta(interfaz.lblTerminadoInstrucciones[cantidadTerminados++], h[i].getColor());
								interfaz.lblEjecutandoNombre.setText("");
								interfaz.lblEjecutandoInstrucciones.setText("");
								realizarQuantum();
								break;
							} else if (h[i].getNumeroInstrucciones() == h[i].getBloqueo() && h[i].getNumeroInstrucciones() > 0) {
								//Si termino de ejecutarse las instrucciones entonces
								//Agregar proceso a lista de bloqueados, bloquear el proceso y quitar de la lsita de ejecucion
								interfaz.lblBloqueadoNombre[cantidadBloqueados].setText(h[i].getNombre());
								interfaz.lblBloqueadoInstrucciones[cantidadBloqueados].setText(String.valueOf(h[i].getNumeroInstrucciones()));
								interfaz.lblBloqueadoContDesbloq[cantidadBloqueados].setText(String.valueOf(h[i].getContadorDesbloq()));
								interfaz.cambiarColorEtiqueta(interfaz.lblBloqueadoNombre[cantidadBloqueados], h[i].getColor());
								interfaz.cambiarColorEtiqueta(interfaz.lblBloqueadoInstrucciones[cantidadBloqueados], h[i].getColor());
								interfaz.cambiarColorEtiqueta(interfaz.lblBloqueadoContDesbloq[cantidadBloqueados++], h[i].getColor());
								interfaz.lblEjecutandoNombre.setText("");
								interfaz.lblEjecutandoInstrucciones.setText("");
								h[i].bloquear();
								realizarQuantum();
								break;	//Salir del ciclo para que no se ejecuten los quantums restantes
							}//if{}elseif{}
							
						}//if{}else if{} else{}
					}//for
					//Si el proceso no se bloqueo entonces detenlo por que ya se acabaron los 20 quantum
					if (!h[i].estaBloqueado() && h[i].getNumeroInstrucciones() > 0 && h[i].getNumeroInstrucciones() != h[i].getError()) {
						h[i].pausar();
						//Posiciona al final de la lista LISTO 
						interfaz.lblListoNombre[cantidadListos].setText(h[i].getNombre());
						interfaz.lblListoInstrucciones[cantidadListos].setText(String.valueOf(h[i].getNumeroInstrucciones()));
						interfaz.cambiarColorEtiqueta(interfaz.lblListoNombre[cantidadListos], h[i].getColor());
						interfaz.cambiarColorEtiqueta(interfaz.lblListoInstrucciones[cantidadListos++], h[i].getColor());
					}//if
				} else if (h[i].estaBloqueado()){
					realizarQuantum();
				}//if
			}//for
			aumentarContadorBloqueo();
			bandera=hilosVivos();
		}//while
		
	}//run
	
	public boolean hilosVivos() {
		boolean b=false;
		for (int i=0; i < h.length; i++) {
			if (h[i].isAlive() ) {
				b=true;
				break;
			}//if{}
		}//for{}
		return b;
	}//hilosVivos(){}
	
	public void aumentarContadorBloqueo() {
		int pos=0;
		for (int i=0; i < h.length; i++) {
			if (h[i].estaBloqueado()) {
				h[i].setContadorDesbloq(h[i].getContadorDesbloq()+1);
				pos=encontrarPosicionProceso(h[i].getNombre());
				interfaz.lblBloqueadoContDesbloq[pos].setText(String.valueOf(h[i].getContadorDesbloq()));
				
				if (!(h[i].getContadorDesbloq() < 10)) {
					h[i].setNumeroInstrucciones(h[i].getNumeroInstrucciones()-1);
					interfaz.lblBloqueadoNombre[pos].setText("");
					interfaz.lblBloqueadoInstrucciones[pos].setText("");
					interfaz.lblBloqueadoContDesbloq[pos].setText("");
					interfaz.lblListoNombre[cantidadListos].setText(h[i].getNombre());
					interfaz.lblListoInstrucciones[cantidadListos].setText(String.valueOf(h[i].getNumeroInstrucciones()));
					interfaz.cambiarColorEtiqueta(interfaz.lblListoNombre[cantidadListos], h[i].getColor());
					interfaz.cambiarColorEtiqueta(interfaz.lblListoInstrucciones[cantidadListos], h[i].getColor());
					h[i].desbloquear();
					cantidadBloqueados--;
					h[i].pausar();
					cantidadListos++;
					realizarQuantum();
				}//if{}
			}//if{}
		}//for{}
	}//aumentarContadorBloqueo
	
	public int encontrarPosicionProceso(String nombreProceso) {
		int i=0;
		for (; i < interfaz.lblBloqueadoContDesbloq.length; i++) {
			if (interfaz.lblBloqueadoNombre[i].getText().equals(nombreProceso)) {
				break;
			}//if{}
		}//for
		return i;
	}
	

}//RoundRobin
