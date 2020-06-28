package club;

import org.junit.Test;

import java.time.LocalDate;

import org.junit.Assert;

public class PruebaHistorial {

	private Historial historial = new Historial(50);
	
	@Test
	public void inicialmenteNoTieneSocios() {
		
		Assert.assertEquals(0, historial.contar());
	}
	
	@Test
	public void afiliarPrimerSocio() {
		
		int numero = 4001;
		Socio martin = new Socio(numero, "Martín G", LocalDate.now());
		
		historial.agregar(martin);
		
		Assert.assertEquals(1, historial.contar());
		Assert.assertEquals(martin, historial.obtener(numero));
	}

	@Test(expected = NumeroDeSocioInvalido.class)
	public void noSePuedeAfiliarDosSociosConElMismoNumero() {
		
		Socio socioOriginal = new Socio(4050, "Juan", LocalDate.now());
		historial.agregar(socioOriginal);

		historial.agregar(new Socio(4050, "Alberto", LocalDate.now()));
	}
	
	@Test
	public void afiliarUltimoSocio() {
		
		int numero = 4100;
		Socio victoria = new Socio(numero, "Victoria L", LocalDate.now());
		
		historial.agregar(victoria);
		
		Assert.assertEquals(1, historial.contar());
		Assert.assertEquals(victoria, historial.obtener(numero));
	}
	
	@Test
	public void afiliarCuatroSocios() {
		
		Socio rocio = new Socio(4003, "Rocio I", LocalDate.now());
		Socio javier = new Socio(4078, "Javier R", LocalDate.now());
		Socio marcos = new Socio(4023, "Marco T", LocalDate.now());
		Socio laura = new Socio(4005, "Laura M", LocalDate.now());
		
		historial.agregar(rocio);
		historial.agregar(javier);
		historial.agregar(marcos);
		historial.agregar(laura);
		
		Assert.assertEquals(4, historial.contar());
		Assert.assertEquals(rocio, historial.obtener(4003));
		Assert.assertEquals(laura, historial.obtener(4005));
		Assert.assertEquals(marcos, historial.obtener(4023));
		Assert.assertEquals(javier, historial.obtener(4078));
	}

	@Test
	public void afiliarSociosEnUnRangoMayorAlTamanioDelPadron() {
		
		
		Socio rocio = new Socio(4003, "Rocio I", LocalDate.now());
		Socio javier = new Socio(7020, "Javier R", LocalDate.now());
		Socio marcos = new Socio(9046, "Marcos T", LocalDate.now());
		
		historial.agregar(rocio);
		historial.agregar(javier);
		historial.agregar(marcos);
		
		Assert.assertEquals(3, historial.contar());
		Assert.assertEquals(rocio, historial.obtener(4003));
		Assert.assertEquals(javier, historial.obtener(7020));
		Assert.assertEquals(marcos, historial.obtener(9046));
	}
	
	@Test
	public void afiliarSociosConNumerosQueColisionan() {
		
		
		Socio marcos = new Socio(9046, "Marcos T", LocalDate.now());
		Socio laura = new Socio(5046, "Laura M", LocalDate.now());
		
		historial.agregar(marcos);
		historial.agregar(laura);
		
		Assert.assertEquals(2, historial.contar());
		Assert.assertEquals(laura, historial.obtener(5046));
		Assert.assertEquals(marcos, historial.obtener(9046));
	}
}
