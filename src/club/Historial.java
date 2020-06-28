package club;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Historial {

	private List<Socio>[] socios;
	private int cantidad;
	
	@SuppressWarnings("unchecked")
	public Historial(int capaciadadInicial) {
		
		socios = new List[50];
		
		for (int i = 0; i < socios.length; i++) {
			socios[i] = new LinkedList<Socio>();
		}

		cantidad = 0;
	}
	
	public void agregar(Socio socio) {
		
		int numeroDeSocio = socio.obtenerNumero();
		int posicion = posicionar(numeroDeSocio);

		List<Socio> grupo = socios[posicion];
		
		if (grupo.contains(socio)) {
			throw new NumeroDeSocioInvalido("Ya existe en el Historial");
		}
		
		grupo.add(socio);
		
		cantidad++;
	}
	
	public int contar() {
		
		return cantidad;
	}
	
	public Socio obtener(int numeroDeSocio) {
		
		int posicion = posicionar(numeroDeSocio);

		Iterator<Socio> iterador = socios[posicion].iterator();
		Socio socio = null;
		
		while (iterador.hasNext() && socio == null) {
			
			Socio socioActual = iterador.next();
			if (socioActual.tiene(numeroDeSocio)) {
				socio = socioActual;
			}
		}
		
		return socio;
	}
	
	private int posicionar(int numeroDeSocio) {
		
		return (numeroDeSocio % socios.length);
	}
}
