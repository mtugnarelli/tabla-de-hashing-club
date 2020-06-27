package club;

/**
 * Padrón de Socios del Club.
 *
 */
public class Padron {

	public static final int PRIMER_NUMERO = 4001;
	public static final int CANTIDAD_MAXIMA = 100;
	public static final int ULTIMO_NUMERO = PRIMER_NUMERO + CANTIDAD_MAXIMA - 1;

	private Socio[] socios;

	/**
	 * @post Padrón del Club sin Socios.
	 */
	public Padron() {

		socios = new Socio[CANTIDAD_MAXIMA];
	}

}
