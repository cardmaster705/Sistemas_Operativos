package nuevo;

public class Hilo extends Thread {
	private String nombre="";
	private int numeroInstrucciones=0;
	private int prioridad=0;
	private int error=0;
	private int bloqueo=0;
	private int color=0;
	
	
	private int contadorDesbloq=0;
	private boolean ejecutando=true, bloqueado=false;
	
	public Hilo( String nombre, int numeroInstrucciones, int prioridad, int error, int bloqueo, int color) {
		this.nombre=nombre;
		this.numeroInstrucciones=numeroInstrucciones;
		this.prioridad=prioridad;
		this.error=error;
		this.bloqueo=bloqueo;
		this.color=color;
	}//constructor
	

	public String getNombre() {
		return nombre;
	}

	public int getNumeroInstrucciones() {
		return numeroInstrucciones;
	}

	public void setNumeroInstrucciones(int numeroInstrucciones) {
		this.numeroInstrucciones = numeroInstrucciones;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public int getError() {
		return error;
	}

	public int getBloqueo() {
		return bloqueo;
	}

	public int getContadorDesbloq() {
		return contadorDesbloq;
	}

	public void setContadorDesbloq(int contadorDesbloq) {
		this.contadorDesbloq = contadorDesbloq;
	}
	
	public int getColor() {
		return color;
	}
	
	public boolean estaEjecutando() {
		return ejecutando;
	}
	
	public boolean estaBloqueado() {
		return bloqueado;
	}
	
	public void pausar() {
		ejecutando=false;
	}//pausar
	
	private synchronized void pausarSyn() {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//try{}catch{}
	}//pausarSyn()

	public synchronized void continuar() {
		ejecutando=true;
		notify();
	}//continuar
	
	public void bloquear() {
		bloqueado=true;
	}//bloquear
	
	public synchronized void desbloquear() {
		bloqueado=false;
		notify();
	}//desbloquear
	
	public void imprimirAtributos() {
		System.out.println(nombre+" "+numeroInstrucciones+" "+prioridad+" "+error+" "+bloqueo);
	}//imprimirAtributos
	
	public void run() {
		while (numeroInstrucciones >= 0 && numeroInstrucciones != error) {
			if (!ejecutando) {
				pausarSyn();
			} else if (bloqueado) {
				pausarSyn();
			}//if{}else if{}
		}//while
		ejecutando=false;
	}//run

}
