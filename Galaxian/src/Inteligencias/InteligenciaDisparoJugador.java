package Inteligencias;

import Disparos.Disparo;


public class InteligenciaDisparoJugador extends Inteligencia{
	Disparo disp;
	
	public InteligenciaDisparoJugador(Disparo d) {
		disp= d;
	}
	
	public void mover() {
		disp.mover(2);
	}
}
