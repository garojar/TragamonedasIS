import java.time.LocalDateTime;
import java.util.Date;


/**
 * Clase que representa el Tragamonedas junto a sus
 * funciones especificas
 * @author Germam Rojo Arce </garojar@hotmail.com>
 * @version 1.0
 *
 */
public class Tragamoneda {

    /**
     * Atributo que representa cada numero aleatorio a generar de la rueda
     */
    private int numRandom1,numRandom2,numRandom3;

    /**
     * Representa el valor del premio obtenido en cada iteracion de juego
     */
    private int premio;

    /**
     * con LocalDateTime se obtendra la hora y minuto actual del usuario ,
     * el cual servira para generar el saludo correspondiente
     */
    private LocalDateTime hora;


    /**
     * Metodo que representa el ciclo de juego del tragamonedas
     * continuando en un bucle hasta que la apuesta sea 0 o el jugador
     * se quede sin saldo
     */
    public void iniciarJuego(){


    }

    /**
     * Genera numeros aleatorios en cada numero de la rueda (0-9)
     */
    private void generarRueda(){}

    /**
     * Despliega en consola los numeros aleatorios generados
     * previamente , en caso de que un numRandom sea 0 este lo muestra como un *
     */
    private void desplegarRueda(){}

    /**
     * Analiza los numRandom generados en busca de un posible premio
     */
    private void generarPremio(){}

    /**
     * Obtiene la hora y minuto actual para desplegar el mensaje correcto
     */
    private void generarSaludoInicio(){
    }


}
