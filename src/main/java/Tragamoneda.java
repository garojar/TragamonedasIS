import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;


/**
 * Clase que representa el Tragamonedas junto a sus
 * funciones especificas
 * @author Germam Rojo Arce </garojar@hotmail.com>
 * @version 1.0
 *
 */
@Builder
public class Tragamoneda {

    /**
     * Atributo que representa cada numero aleatorio a generar de la rueda
     */
    private int [] numRandom;

    /**
     * Representa el valor del premio obtenido en cada iteracion de juego
     */
    private int premio;

    /**
     * Contador de asteriscos
     */
    private int contAst;

    /**
     * con LocalDateTime se obtendra la hora y minuto actual del usuario ,
     * el cual servira para generar el saludo correspondiente
     */
    private LocalDateTime hora;

    /**
     * Jugador del Tragamonedas
     */
    private Jugador jugador;





    /**
     * Metodo que representa el ciclo de juego del tragamonedas
     * continuando en un bucle hasta que la apuesta sea 0 o el jugador
     * se quede sin saldo
     */
    public void iniciarJuego(){
        jugador = Jugador.builder().apuesta(0).saldoDisponible(1000).build();
        this.numRandom = new int [3];
        while(true){

            if(jugador.getSaldoDisponible() == 0){
                System.out.println("Muchas gracias por jugar. Mejor suerte la proxima vez");
                break;
            }

            System.out.println("Bienvenido al Tragamonedas Ingenieria de SW");
            System.out.println("===========================================");

            System.out.println("Su saldo actual es de $"+jugador.getSaldoDisponible()
            +". ¿Cuanto desea apostar?");

            jugador.setApuesta(validarInput());
            if(jugador.getApuesta()==0){
                break;
            }else{
                jugador.setSaldoDisponible(jugador.getSaldoDisponible()-jugador.getApuesta());
            }
            generarRueda();
            desplegarRueda();
            generarPremio();

            if(this.premio !=0){
                System.out.println("Usted obtiene $"+this.premio);
                this.jugador
                        .setSaldoDisponible(this.jugador.getSaldoDisponible()+this.premio);
            }

        }
    }

    /**
     * Genera numeros aleatorios en cada numero de la rueda (0-9)
     */
    private void generarRueda(){
        this.contAst=0;
        this.premio=0;
        for(int x=0;x<3;x++){
            this.numRandom[x] = (int)(Math.random()*10);
            System.out.println(x);
        }
    }

    /**
     * Despliega en consola los numeros aleatorios generados
     * previamente , en caso de que un numRandom sea 0 este lo muestra como un *
     */
    private void desplegarRueda(){
        System.out.println("+---+---+---+");
        System.out.print("| ");
        for(int i=0 ; i<3 ; i++){
            if(this.numRandom[i]==0){
                this.contAst++;
                System.out.print("*");
            }else{
                System.out.print(this.numRandom[i]);
            }
            System.out.print(" | ");
        }

        System.out.println("\n"+"+---+---+---+");
    }

    /**
     * Analiza los numRandom generados en busca de un posible premio
     */
    private void generarPremio(){

        if(this.contAst>0) {

            switch (this.contAst) {
                case 1:
                    this.premio = 50;
                    break;

                case 2:
                    this.premio = 300;
                    break;

                case 3:
                    this.premio = 500;
                    break;

            }
        }else if((this.numRandom[0] == this.numRandom[1]) && this.numRandom[0] == this.numRandom[2]){
                this.premio = this.numRandom[0]*this.jugador.getApuesta();
        }
    }

    /**
     * Obtiene la hora y minuto actual para desplegar el mensaje correcto
     */
    private void generarSaludoInicio(){
    }


    private int validarInput(){
        Scanner scan =  new Scanner(System.in);
        int num=0;
        while(true) {

            String valor = scan.nextLine();

            boolean isNumeric=true;

            try {
                num = Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un valor numerico");
                isNumeric = false;
            }

            if(isNumeric && num>jugador.getSaldoDisponible()){
                System.out.println("Saldo Insuficiente, ingrese monto menor");
            }else if(isNumeric && num<0){
                System.out.println("Ingrese un monto positivo");
            }else if(isNumeric){
                break;
            }

        }
        return num;

    }


}
