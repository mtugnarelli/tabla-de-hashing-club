package club;

import java.time.LocalDate;

public class Socio {

	private int numero;
	private String nombre;
	private LocalDate fechaIngreso;
	
	public Socio(int numero, String nombre, LocalDate fechaIngreso) {
		
		this.numero = numero;
		this.nombre = nombre;
		this.fechaIngreso = fechaIngreso;
	}
	
	public boolean tiene(int numero) {
		
		return (this.numero == numero);
	}
	
	public int obtenerNumero() {
		
		return this.numero;
	}
	
	public String obtenerNombre() {
		
		return this.nombre;
	}
	
	public LocalDate obtenerFechaIngreso() {
		
		return this.fechaIngreso;
	}
	
	@Override
	public boolean equals(Object otroObjeto) {

		boolean iguales = (this == otroObjeto);
		
		if (!iguales && otroObjeto instanceof Socio) {
			
			Socio otroSocio = (Socio) otroObjeto;
			iguales = (this.numero == otroSocio.numero);
		}
		
		return iguales;
	}
}
