/*
En esta clase es donde se daran las rondas de cada set y donde se definira el ganador del torneo
 */
package tennisgame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author EmaS7
 */
public class Game {

    static Scanner read = new Scanner(System.in).useDelimiter("\n");

    public void juego(String jugador1, String jugador2, String torneo) {
        //Revancha inicializada en false
        boolean revancha = false;
        do {
            Random r = new Random();  //Clase random para los puntos en base a las probabilidades de cada jugador
            boolean saqueJ1 = false;
            boolean saqueJ2 = false;
            int setsI = Integer.parseInt(Validaciones.validacionSet());  //
            String prob1 = Validaciones.validacionProbabilidad(jugador1);  //   Seteamos y validamos la cantidad de rondas y probabilidades    
            String prob2 = Validaciones.validacionProbabilidad(jugador2);
            LimpiarPantalla.limpiarSinAviso();
            int saqueRandom = r.nextInt(1 - 0);  //Se sortea quien saca primero

            if (saqueRandom == 1) {
                System.out.println("---Tiene el saque " + jugador1 + "---");
                saqueJ1 = true;
            } else {
                System.out.println("---Tiene el saque " + jugador2 + "---");
                saqueJ1 = true;
            }

            System.out.println("Presione enter para comenzar!");
            read.nextLine();
            LimpiarPantalla.limpiarSinAviso();  //Realiza una limpieza de pantalla(o consola) para que no este tan cargada

            //Comienza el partido
            int contadorSets = 0;
            int sets1 = 0;
            int sets2 = 0;
            ArrayList<String> partidoHistorial1 = new ArrayList<>();  // Listas para almacenar
            ArrayList<String> partidoHistorial2 = new ArrayList<>();  //             las rondas ganadas 
            boolean partido = false;  //booleano para inicializar el partido y poder finalizarlo

            do {

                int juegosContJ1 = 0;// Contador de rondas
                int juegosContJ2 = 0;// 6 rondas -> 1 set

                ArrayList<String> juegosHistorial1 = new ArrayList<>();  // listas para
                ArrayList<String> juegosHistorial2 = new ArrayList<>();  // rondas o juegos

                boolean set = false;  //booleano para saber si el set termino o no
                while (set == false) {
                    boolean juego = false; //booleano para la ronda que esta en juego

                    int puntajeJ1 = 0; //Para el tablero de puntos historicos en cada ronda
                    int puntajeJ2 = 0; // (Tambien sirve para el switch case)

                    int puntosTablero1 = 0; // Para el tablero de rondas 
                    int puntosTablero2 = 0; // con el formato de puntuacion de tenis

                    ArrayList<String> puntosHistorial1 = new ArrayList<>();  //Lista de historicos en cada
                    ArrayList<String> puntosHistorial2 = new ArrayList<>();  //         ronda

                    do {

                        int punto = punto(prob1, jugador1, prob2, jugador2);   //de aca sacamos para quien va cada punto

                        switch (punto) {
                            case 1:
                                puntajeJ1++;
                                break;
                            case 2:
                                puntajeJ2++;
                                break;
                        }

                        puntosTablero1 = puntajeTableroTenis(puntajeJ1, puntosTablero1); //
                        String strPuntosTablero1 = String.valueOf(puntosTablero1);       //

                        if (puntosTablero1 == 50) {                                      //
                            puntosHistorial1.add("SET");                                 //
                            juegosContJ1++;                                              //
                            juego = true;                                                //
                        } else {                                                         //
                            puntosHistorial1.add(strPuntosTablero1);                     //Configuramos la tabla para que quede con el fomato
                        }                                                                //             de los puntos de tenis
                        //
                        puntosTablero2 = puntajeTableroTenis(puntajeJ2, puntosTablero2); //
                        String strPuntosTablero2 = String.valueOf(puntosTablero2);       //
                        //
                        if (puntosTablero2 == 50) {                                      //
                            puntosHistorial2.add("SET");                                 //
                            juegosContJ2++;                                              //
                            juego = true;                                                //
                        } else {                                                         //
                            puntosHistorial2.add(strPuntosTablero2);                     //
                        }                                                                //

                        System.out.println("Parcial de " + jugador1 + ": " + puntosHistorial1 + " ");
                        System.out.println("Parcial de " + jugador2 + ": " + puntosHistorial2 + " "); // imprime resultados parciales de la ronda y las
                        System.out.println("-----------------------------------------------------"); // victorias obtenidas

                    } while (juego == false);

                    //Fin del juego o Set
                    System.out.println("\nRONDA COMPLETADA!");

                    System.out.println(jugador1 + " tiene " + juegosContJ1 + " Rondas ganadas.");
                    System.out.println(jugador2 + " tiene " + juegosContJ2 + " Rondas ganadas.");

                    saqueJ1 = !saqueJ1;  //invertimos el booleano 
                    saqueJ2 = !saqueJ2;  //  para que saque el jugador que le toca

                    if (saqueJ1 == true) {
                        System.out.println("----"+jugador1 + " tiene el saque----");
                    } else {
                        System.out.println("----"+jugador2 + " tiene el saque----");
                    }

                    String strJuegosContJ1 = String.valueOf(juegosContJ1);    //
                    juegosHistorial1.add(strJuegosContJ1);                    //Paso valores de rondas a la lista
                    String strJuegosContJ2 = String.valueOf(juegosContJ2);    //  de historicos
                    juegosHistorial2.add(strJuegosContJ2);                    //

                    if (juegosContJ1 == 6) {
                        set = true;
                        contadorSets++;
                        sets1++;
                        System.out.println("\n############");
                        System.out.println("El ganador del SET número " + contadorSets + " es " + jugador1 + "!");
                        System.out.println("Rondas de " + jugador1 + " en el set N°" + contadorSets + ": " + juegosHistorial1);
                        System.out.println("Rondas de " + jugador2 + " en el set N°" + contadorSets + ": " + juegosHistorial2);
                        System.out.println("############");
                    } else if (juegosContJ2 == 6) {
                        set = true;
                        contadorSets++;
                        sets2++;
                        System.out.println("\n############");
                        System.out.println("El ganador del SET número " + contadorSets + " es " + jugador1 + "!");
                        System.out.println("Rondas de " + jugador1 + " en el set N°" + contadorSets + ": " + juegosHistorial1);
                        System.out.println("Rondas de " + jugador2 + " en el set N°" + contadorSets + ": " + juegosHistorial2);
                        System.out.println("############");
                    } else {
                        set = false;
                    }
                    if (setsI != contadorSets) {
                        System.out.println("Presione enter para iniciar siguiente ronda");
                        read.nextLine();
                    }
                }
                if (contadorSets == setsI) {  //Si llegamos a la cantidad de sets definidos se termina el partido
                    partido = true;
                    System.out.println("\n----FIN DEL PARTIDO----");
                } else {
                    partido = false;
                }
                String strJuegosContJ1 = String.valueOf(juegosContJ1);
                partidoHistorial1.add(strJuegosContJ1);
                String strJuegosContJ2 = String.valueOf(juegosContJ2);
                partidoHistorial2.add(strJuegosContJ2);

            } while (partido == false);

            System.out.println(jugador1 + ": " + partidoHistorial1);                       //
            System.out.println(jugador2 + ": " + partidoHistorial2);                       //Imprime los resultados finales y ganadores
            System.out.println(resultadoFinal(jugador1, sets1, jugador2, sets2, torneo));  //
            System.out.println("---FIN---");                                               //

            revancha = Validaciones.validacionRevancha();
        } while (revancha == true);

    }

    public static int punto(String prob1, String player1, String prob2, String player2) {
        Random r = new Random();
        boolean empate = false;
        int punto = 0;

        do {
            //Jugador 1
            int max1 = Integer.parseInt(prob1);   //parseamos la probabilidad
            int resultado1 = r.nextInt(max1 - 0); // y hacemos que el punto sea random 

            //Jugador 2
            int max2 = Integer.parseInt(prob2);
            int resultado2 = r.nextInt(max2 - 0);

            if (resultado1 > resultado2) {  //validamos para quein haya sido el punto
                System.out.println("PUNTO PARA " + player1.toUpperCase());
                punto = 1;
                empate = false;
            } else if (resultado1 < resultado2) {
                System.out.println("PUNTO PARA " + player2.toUpperCase());
                punto = 2;
                empate = false;
            } else {
                empate = true;
                System.out.println("Empate");  //Si hay empate se repite hasta que haya un ganador
            }
        } while (empate == true);
        return punto;
    }

    public static int puntajeTableroTenis(int puntaje, int puntoTenis) {
        //Sistema puntaje del tenis
        switch (puntaje) {   //switch que recibe el punto en base a la ronda que se esta jugando
            case 1:
                puntoTenis = 15;
                break;
            case 2:
                puntoTenis = 30;
                break;
            case 3:
                puntoTenis = 40;
                break;
            case 4:
                //Set
                puntoTenis = 50;
                break;
        }
        return puntoTenis;  //retorna el punto con formato tenis para ponerlo en la lista
    }

    public static String resultadoFinal(String jugador1, int sets1, String jugador2, int sets2, String torneo) {  //Imprime los resultados totales y ganadores
        String resultado;
        if (sets1 > sets2) {
            resultado = "El ganador del " + torneo + " es " + jugador1 + "!";
        } else {
            resultado = "El ganador del " + torneo + " es " + jugador2 + "!";
        }

        return resultado;
    }
}
