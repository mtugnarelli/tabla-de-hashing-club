package club;

/**
 * Padrón de Socios del Club.
 *
 */
public class Padron {

	public static final int CANTIDAD_MAXIMA = 100;

	private Socio[] socios;
	
	private int cantidad;

	/**
	 * @post Padrón del Club sin Socios.
	 */
	public Padron() {

		socios = new Socio[CANTIDAD_MAXIMA];
		cantidad = 0;
	}

	/**
	 * @post el 'nuevoSocio' queda formando parte del Padrón.
	 * 
	 * @param nuevoSocio
	 */
	public void afiliar(Socio nuevoSocio) {

		int numeroDeSocio = nuevoSocio.obtenerNumero();
		int posicion = posicionar(numeroDeSocio);

		while (socios[posicion] != null) {
			
			if (socios[posicion].tiene(numeroDeSocio)) {
				throw new NumeroDeSocioInvalido("Ya existe");
			}
			
			posicion = incrementar(posicion);
		}
		
		socios[posicion] = nuevoSocio;
		cantidad++;
	}
	
	private int incrementar(int posicion) {
		
		return (posicion + 1) % socios.length;
	}
	
	/**
	 * @param numeroDeSocio
	 * 
	 * @return Socio identificado por 'numeroDeSocio' 
	 *         o null si no existe.
	 */
	public Socio obtener(int numeroDeSocio) {

		int posicion = posicionar(numeroDeSocio);

		while ((socios[posicion] != null) && 
				! socios[posicion].tiene(numeroDeSocio)) {
			
			posicion = incrementar(posicion);
		}
		
		return socios[posicion];
	}

	/**
	 * @param numeroDeSocio
	 * @return si existe el Socio identificado por 'numeroDeSocio'.
	 */
	public boolean existe(int numeroDeSocio) {

		return (obtener(numeroDeSocio) != null);
	}

	/**
	 * @return devuelve la cantidad de Socios afiliados.
	 */
	public int contar() {
		
		return cantidad;
	}
	
	private int posicionar(int numeroDeSocio) {

		return (numeroDeSocio % socios.length);
	}
}
