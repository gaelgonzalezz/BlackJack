package entidades;

import java.util.ArrayList;

public abstract class Jugador {

    ArrayList<Carta> mano = new ArrayList<>();

    public ArrayList<Carta> getMano(){
        return mano;
    }

    public void mostrarMano(){
        for(int i = 0; i < mano.size(); i++){
            mano.get(i).mostrar();
        }
    }
    public void mostrarMano(int cartasAMostrar){
        for(int i = 0; i < cartasAMostrar; i++){
            mano.get(i).mostrar();
        }
    }

    public int sumarCartas(){
       int puntos = 0;
       for(int i = 0; i < mano.size(); i++){
           int valorASumar = mano.get(i).getValor();
           puntos += valorASumar;
       }
       return puntos;
    }
}
