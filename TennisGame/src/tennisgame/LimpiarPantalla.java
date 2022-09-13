/*
 Esta clase se encargara de limpiar la pantalla para evitar que la consola se cargue de informacion.
 Aqui tenemos dos formas de limpiar, apretando la tecla enter o sin necesidad de hacerlo
 */
package tennisgame;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 *
 * @author Sanat
 */
public class LimpiarPantalla {

    public static void limpiarConAviso() {
        try {
            System.out.println("Presione enter para continuar.");
            new java.util.Scanner(System.in).nextLine();

            Robot limpiador = new Robot();
            limpiador.keyPress(KeyEvent.VK_CONTROL);
            limpiador.keyPress(KeyEvent.VK_L);
            limpiador.keyRelease(KeyEvent.VK_CONTROL);
            limpiador.keyRelease(KeyEvent.VK_L);
            limpiador.delay(100);

        } catch (AWTException ex) {
            System.out.println("" + ex.getMessage());
        }
    }

    public static void limpiarSinAviso() {
        try {
            Robot limpiador = new Robot();
            limpiador.keyPress(KeyEvent.VK_CONTROL);
            limpiador.keyPress(KeyEvent.VK_L);
            limpiador.keyRelease(KeyEvent.VK_CONTROL);
            limpiador.keyRelease(KeyEvent.VK_L);
            limpiador.delay(100);

        } catch (AWTException ex) {
            System.out.println("" + ex.getMessage());
        }
    }
}

