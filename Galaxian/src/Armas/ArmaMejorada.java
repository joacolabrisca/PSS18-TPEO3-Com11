package Armas;

import Disparos.Disparo;
import Entidades.*;
import Disparos.DisparoMejorado;

public class ArmaMejorada extends Arma {
	
	public ArmaMejorada(Jugador j) {
		super(j);
		this.tiempoHastaProximoDisparoDisponible=0;
		this.tiempoParaDisparar=17;
		this.cantBalas = 20;
	}
	
	public Disparo generarDisparo() {
		DisparoMejorado disp=null;
		if(tiempoHastaProximoDisparoDisponible<=0) {
			disp= new DisparoMejorado(5,0,0);
			tiempoHastaProximoDisparoDisponible= tiempoParaDisparar;
			cantBalas--;
		}
		if(cantBalas==0) {
			propietario.setArma(new ArmaBasicaJugador(propietario));
		}
		return disp;
	}
	
	public void actualizar() {
		tiempoHastaProximoDisparoDisponible--;
	}
}
