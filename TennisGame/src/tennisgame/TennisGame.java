/*
  En el main procederemos a cargar los datos de cada jugador y el nombre del torneo.
*/
package tennisgame;

import java.util.Scanner;

/**
 *
 * @author EmaS7
 */
public class TennisGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        Validaciones v = new Validaciones();
        v.bannerBienvenida();
        //Cargamos Datos
        
        System.out.println("Ingresar nombre del primer jugador: "); String player1 = read.nextLine();
        
        System.out.println("\nIngresar nombre del segundo jugador:"); String player2 = read.nextLine();
        
        System.out.println("\nIngresar nombre del Torneo:"); String tournament = read.nextLine();
        
        //Crea contrsuctor
       Game game = new Game(); 
       
       //Llama al metodo
       game.juego(player1, player2, tournament);
       
       v.bannerTermina();

    }
    
}
