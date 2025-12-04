package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
    static Scanner s = new Scanner(System.in);

    public static int ingresarEntero(int MIN, int MAX){
        int numero = 0;
        boolean valido = false;

        while(!valido){
            try{
                numero = s.nextInt();
                if (numero < MIN || numero > MAX){
                    System.out.println("El número que ingresaste esta fuera del rango");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("El tipo de valor ingresado no es un numero entero");
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado");
            }
            s.nextLine();
        }
        return numero;
    }
}