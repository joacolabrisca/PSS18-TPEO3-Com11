package Principal;

import java.util.LinkedList;
import Entidades.*;

public class MapaNivel2 extends Mapa {
	public MapaNivel2(Juego j) {
		this.enemigos= new LinkedList<Enemigo>();
		this.obstaculos= new LinkedList<Entidad>();
		int x= 50;
		int y= 50;
		
		for(int i=0;i<4;i++){
			EnemigoPierdeArma enem= new EnemigoPierdeArma(7,x,y);
			enem.setJuego(j);
			enemigos.add(enem);
			x+= 70;
		}
		
		x=100;
		y+=100;
		for(int i=0;i<4;i++){
			EnemigoMareado enem= new EnemigoMareado(7,x,y);
			enem.setJuego(j);
			enemigos.add(enem);
			x+= 70;
		}
		
		x=100;
		y+=100;
		
		for(int i=0;i<4;i++){
			EnemigoBase enem= new EnemigoBase(7,x,y);
			enem.setJuego(j);
			enemigos.add(enem);
			x+= 70;
		}
		
		
		obstaculos.add(new ObstaculoBasico(200,350));
		obstaculos.add(new ObstaculoBasico(400,350));
		
		GeneradorPowerUp generador = new GeneradorPowerUp(j);
		for(Enemigo e: enemigos) {
			e.setPowerUpAlDestruir(generador.getPowerUpAleatorio());
		}
	}
}
