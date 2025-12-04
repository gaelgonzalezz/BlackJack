import entidades.Crupier;
import entidades.Usuario;
import utilidades.Util;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al BlackJack!\n");

        System.out.println("Decime cuanta plata le vas a cargar a tu cuenta:");
        int dineroDisponible = Util.ingresarEntero(5000, 100000);

        Usuario usuario = new Usuario(dineroDisponible);
        Crupier crupier = new Crupier();

        System.out.println("Que comience el juego!");

        int salir;
        do{
            salir = 0;

            System.out.println("Cuanto querés apostar?");
            int apuesta = Util.ingresarEntero(1, usuario.dineroDisponible);

            try {
                System.out.println("Repartiendo...");
                Thread.sleep(2000);
                crupier.repartirCartas(2, usuario);
                crupier.repartirCartas(2, crupier);
                System.out.println("Listo.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Tu mano es: " );
            usuario.mostrarMano();
            int puntajeUsuario = usuario.sumarCartas();
            int puntajeCrupier;
            System.out.println("Tu puntaje es: " + puntajeUsuario);

            System.out.println("Y al crupier le tocó: ");
            crupier.mostrarMano(1);

            if(puntajeUsuario > 21){
                System.out.println("Perdiste, te pasaste de 21.");
                usuario.dineroDisponible -= apuesta;
            } else{
                System.out.println("Pedís o te quedas? (0 quedarse, 1 pedir)");
                int pedir = Util.ingresarEntero(0, 1);

                while(pedir == 1){
                    try {
                        System.out.println("Repartiendo...");
                        Thread.sleep(1000);
                        crupier.repartirCartas(1, usuario);
                        System.out.println("Listo.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Ahora tu mano es: ");
                    usuario.mostrarMano();
                    puntajeUsuario = usuario.sumarCartas();
                    System.out.println("Tu puntaje es: " + puntajeUsuario);
                    if(puntajeUsuario > 21){
                        System.out.println("Perdiste, te pasaste de 21.");
                        usuario.dineroDisponible -= apuesta;
                        pedir = 0;
                    } else{
                        System.out.println("Pedís o te quedas? (0 quedarse, 1 pedir)");
                        pedir = Util.ingresarEntero(0, 1);
                    }
                }

                System.out.println("Y el crupier tiene:");
                crupier.mostrarMano(2);
                puntajeCrupier = crupier.sumarCartas();
                System.out.println("Su puntaje es: " + puntajeCrupier);

                if(puntajeCrupier < 17 && puntajeUsuario < 22){
                    System.out.println("El crupier para hasta tener al menos 17 puntos, asi que vamos a repartirle.");
                    while(puntajeCrupier < 17){
                        try {
                            System.out.println("Repartiendo...");
                            Thread.sleep(1000);
                            crupier.repartirCartas(1, crupier);
                            System.out.println("Listo.");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        puntajeCrupier = crupier.sumarCartas();
                        System.out.println("El puntaje del crupier es " + puntajeCrupier);
                    }
                }

                if(puntajeUsuario == 21 || puntajeUsuario > puntajeCrupier && puntajeUsuario < 22 || puntajeCrupier > 21){
                    System.out.println("GANASTE!");
                    usuario.dineroDisponible += apuesta*2;
                    System.out.println("Tu saldo ahora es de: " + usuario.dineroDisponible);
                } else if(puntajeCrupier == 21 || puntajeUsuario < puntajeCrupier && puntajeCrupier < 22 || puntajeUsuario > 21){
                    System.out.println("Perdiste...");
                    usuario.dineroDisponible -=apuesta;
                    System.out.println("Tu saldo ahora es de: " + usuario.dineroDisponible);
                } else{
                    System.out.println("Empate");
                }
            }

            if(usuario.dineroDisponible > 0) {
                System.out.println("Queres seguir jugando? (0 seguir, 1 irte)");
                salir = Util.ingresarEntero(0, 1);
            }

            puntajeUsuario = 0;
            puntajeCrupier = 0;
            usuario.getMano().clear();
            crupier.getMano().clear();
            crupier.crearMaso();

        } while(salir == 0 && usuario.dineroDisponible > 0);
    }
}