import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa al jugador involucrado
 * en el Tragamonedas
 * @author Germam Rojo Arce </garojar@hotmail.com>
 * @version 1.0
 *
 */
@Builder
public class Jugador {
    /**
     * Saldo disponible del jugador en el momento fijo
     */
    @Getter
    @Setter
    private int saldoDisponible;


    /**
     * Monto que representa la apuesta del jugador
     */
    @Getter
    @Setter
    private int apuesta;






}
