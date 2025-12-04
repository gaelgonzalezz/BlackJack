package entidades;

public class Carta {

    private int numero = 0;
    private Palo palo;

    public Carta(int numero, int palo){
        this.numero = numero;
        this.palo = Palo.values()[palo];
    }

    public void mostrar(){
        System.out.println(traducir() + " de " + palo);
    }

    public int getValor(){
        return numero;
    }

    public String traducir(){
        if(numero == 1){
            return "As";
        } else if(numero == 11){
            return "J";
        } else if (numero == 12){
            return "Q";
        } else if(numero == 13) {
            return "K";
        } else {
            return String.valueOf(numero);
        }
    }

}
