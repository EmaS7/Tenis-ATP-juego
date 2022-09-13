/*
Esta clase se encarga mas que nada de realizar las validaciones correspondientes para que el juego pueda desarrollarse normalmente
 */
package tennisgame;

import java.util.Scanner;

/**
 *
 * @author EmaS7
 */
public class Validaciones {
    static Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    public static String validacionProbabilidad(String jugador){
        boolean banProb = false; //Bandera de probabilidades
        String prob = "";
        do{
            System.out.println("\nIndique las probabilidades de que " +jugador+ " gane el partido(1%-100%): ");
            prob = read.nextLine();
            try{
                int probInt = Integer.parseInt(prob);
                if(probInt>100){
                    System.out.println("Probabilidad muy alta, bajale un toque!");
                    banProb=false;
                }else if(probInt<1){
                    System.out.println("Probabilidad muy baja, tenele mas fe!");
                    banProb=false;
                }else{
                    System.out.println("Probabilidad guardada");
                    banProb = true;
                }
            }catch(Exception e){
                System.out.println("\nIngrese un numero entero");
                banProb=false;
            }
        }while(banProb==false);
       return prob;
    }
    
     public static String validacionSet(){
        boolean banSet = false; //Bandera de sets
        String sets = "";
        do{
            System.out.println("\nSeleccione la cantidad de sets a jugar (3 o 5): ");
            sets = read.nextLine();
            System.out.println("");

            try{
               int setsInt = Integer.parseInt(sets);
                if(setsInt == 3){
                    System.out.println("\n3 seleccionado!");
                    banSet = true;
                }
                else if(setsInt == 5){
                    System.out.println("\n5 seleccionado!");
                    banSet = true;
                }
                else{
                    System.out.println("\nSeleccione entre 3 y 5!");
                    banSet = false;
                }
            }catch(Exception e){
                System.out.println("\nIngrese un número!");
                banSet = false;
            }
        }while(banSet == false);
        
        //Fin validación sets
        return sets;
    }
     
     
     public static boolean validacionRevancha(){
        boolean banRevancha=false; //Bandera de revancha
        boolean loopValidacion=true; //bandera para continuar con el ciclo de validacion
        

        while(loopValidacion==true){
            System.out.println("¿Quiere jugar la revancha?(1/Si, 2/No)");
            String revanchaStr = read.nextLine();
            
            
            try{
                int revanchaInt = Integer.parseInt(revanchaStr);
                if(revanchaInt == 1){ //SI
                    banRevancha=true;
                    loopValidacion=false;               
                }
                else if(revanchaInt == 2){ //NO
                    banRevancha=false;
                    loopValidacion=false;
                }
                else{  //Opcion invalida
                    System.out.println("Esa no es una de las opciones");
                    loopValidacion=true;
                }
            }
            catch(Exception e){ //Excepcion
                System.out.println("Ese no es un número.");
                loopValidacion=true;
            }
        }
        return banRevancha;
    }  
     
     //Unos banners para darle "color" al programa
     public void bannerBienvenida(){  
        System.out.print("\n\n");
        System.out.println("               ######## ######## ##    ## ##    ## ####  ######  ");
        System.out.println("                  ##    ##       ###   ## ###   ##  ##  ##    ## ");
        System.out.println("                  ##    ##       ####  ## ####  ##  ##  ##       ");
        System.out.println("                  ##    ######   ## ## ## ## ## ##  ##   ######  ");
        System.out.println("                  ##    ##       ##  #### ##  ####  ##        ## ");
        System.out.println("                  ##    ##       ##   ### ##   ###  ##  ##    ## ");
        System.out.println("                  ##    ######## ##    ## ##    ## ####  ######  ");
        System.out.print("\n\n");
     }
    public void bannerTermina(){
        System.out.print("\n\n");
        System.out.println("                              ########  ##    ##    ##   ");
        System.out.println("                              ##        ##    ###   ##   ");
        System.out.println("                              ##        ##    ####  ##   ");
        System.out.println("                              ######    ##    ## ## ##   ");
        System.out.println("                              ##        ##    ##  ####   ");
        System.out.println("                              ##        ##    ##   ###   ");
        System.out.println("                              ##        ##    ##    ##   ");
        System.out.println("\n\n");
    } 
     
}
    

