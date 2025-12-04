package entidades;

import java.util.ArrayList;
import java.util.Random;

import entidades.Carta;

public class Crupier extends Jugador {

    ArrayList<Carta> mazo = new ArrayList<>();

    public Crupier() {
        crearMaso();
    }

    public void crearMaso(){
        mazo.clear();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Carta carta = new Carta(j+1, i);
                mazo.add(carta);
            }
        }
    }

    public void repartirCartas(int cantidadARepartir, Jugador jugador){
        Random r = new Random();
        for(int i = 0; i < cantidadARepartir; i++){
            int cartaRandom = r.nextInt(mazo.size());
            Carta cartaObtenida = mazo.get(cartaRandom);
            jugador.getMano().add(cartaObtenida);
            mazo.remove(cartaObtenida);
        }
    }
}

