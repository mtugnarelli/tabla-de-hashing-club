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

	/**
	 * @pre 'nuevoSocio' tiene un número en el rango 
	 *      [PRIMER_NUMERO, ULTIMO_NUMERO].
	 *      
	 * @post el 'nuevoSocio' queda formando parte del Padrón.
	 * 
	 * @param nuevoSocio
	 */
	public void afiliar(Socio nuevoSocio) {

		int numeroDeSocio = nuevoSocio.obtenerNumero();
		int posicion = posicionar(numeroDeSocio);
		
		if (socios[posicion] != null) {
			throw new NumeroDeSocioInvalido("Ya existe");
		}
		
		socios[posicion] = nuevoSocio;
	}
	
	/**
	 * @pre 'numeroDeSocio' está en el rango 
	 *      [PRIMER_NUMERO, ULTIMO_NUMERO].
	 * 
	 * @param numeroDeSocio
	 * 
	 * @return Socio identificado por 'numeroDeSocio' 
	 *         o null si no existe.
	 */
	public Socio obtener(int numeroDeSocio) {

		int posicion = posicionar(numeroDeSocio);

		return socios[posicion];
	}

	/**
	 * @pre 'numeroDeSocio' está en el rango 
	 *      [PRIMER_NUMERO, ULTIMO_NUMERO].
	 * 
	 * @param numeroDeSocio
	 * @return si existe el Socio identificado por 'numeroDeSocio'.
	 */
	public boolean existe(int numeroDeSocio) {

		return (obtener(numeroDeSocio) != null);
	}

	private int posicionar(int numeroDeSocio) {

		if ((numeroDeSocio < PRIMER_NUMERO) || (numeroDeSocio > ULTIMO_NUMERO)) {
			throw new NumeroDeSocioInvalido("Fuera de rango");
		}
		
		return numeroDeSocio - PRIMER_NUMERO;
	}
}
