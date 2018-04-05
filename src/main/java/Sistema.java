import java.time.LocalDateTime;
import java.util.Date;
/**
 * Clase que contiene la ejecucion del sistema
 * @author Germam Rojo Arce </garojar@hotmail.com>
 * @version 1.0
 *
 */
public class Sistema {

    private Tragamoneda machine;

    public static void main(String[] args){

        LocalDateTime date = LocalDateTime.now();

        System.out.println(date.getHour());
        System.out.println(date.getMinute());
    }
}
