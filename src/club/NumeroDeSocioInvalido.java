package club;

public class NumeroDeSocioInvalido extends RuntimeException {

	private static final long serialVersionUID = 8610367328291300571L;

	public NumeroDeSocioInvalido(String mensaje) {
		super(mensaje);
	}
}
