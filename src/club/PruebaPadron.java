package club;

import org.junit.Test;

import java.time.LocalDate;

import org.junit.Assert;

public class PruebaPadron {

	private Padron padron = new Padron();
	
	@Test
	public void inicialmenteNoTieneSocios() {
		
		Assert.assertEquals(0, padron.contar());
		
		for (int i = 0; i < Padron.CANTIDAD_MAXIMA; i++) {
			
			int numeroSocio = Padron.PRIMER_NUMERO + i;
			Assert.assertFalse(padron.existe(numeroSocio));
		}
	}
	
	@Test
	public void afiliarPrimerSocio() {
		
		int numero = Padron.PRIMER_NUMERO;
		Socio martin = new Socio(numero, "Martín G", LocalDate.now());
		
		padron.afiliar(martin);
		
		Assert.assertEquals(1, padron.contar());
		Assert.assertEquals(martin, padron.obtener(numero));
		Assert.assertTrue(padron.existe(numero));
	}
	
	@Test(expected = NumeroDeSocioInvalido.class)
	public void noSePuedeAfiliarSocioConNumeroMenorAlMinimo() {
		
		int numeroInvalido = Padron.PRIMER_NUMERO - 1;
		
		padron.afiliar(new Socio(numeroInvalido, "Juan U", LocalDate.now()));
	}
	
	@Test(expected = NumeroDeSocioInvalido.class)
	public void noSePuedeAfiliarSocioConNumeroMayorAlMaximo() {
		
		int numeroInvalido = Padron.PRIMER_NUMERO + Padron.CANTIDAD_MAXIMA + 1;
		
		padron.afiliar(new Socio(numeroInvalido, "Laura O", LocalDate.now()));
	}

	@Test(expected = NumeroDeSocioInvalido.class)
	public void noSePuedeAfiliarDosSociosConElMismoNumero() {
		
		Socio socioOriginal = new Socio(4050, "Juan", LocalDate.now());
		padron.afiliar(socioOriginal);

		padron.afiliar(new Socio(4050, "Alberto", LocalDate.now()));
	}
	
	@Test
	public void afiliarUltimoSocio() {
		
		int numero = Padron.ULTIMO_NUMERO;
		Socio victoria = new Socio(numero, "Victoria L", LocalDate.now());
		
		padron.afiliar(victoria);
		
		Assert.assertEquals(1, padron.contar());
		Assert.assertEquals(victoria, padron.obtener(numero));
		Assert.assertTrue(padron.existe(numero));
	}
	
	@Test
	public void afiliarCuatroSocios() {
		
		Socio rocio = new Socio(4003, "Rocio I", LocalDate.now());
		Socio javier = new Socio(4078, "Javier R", LocalDate.now());
		Socio marcos = new Socio(4023, "Marco T", LocalDate.now());
		Socio laura = new Socio(4005, "Laura M", LocalDate.now());
		
		padron.afiliar(rocio);
		padron.afiliar(javier);
		padron.afiliar(marcos);
		padron.afiliar(laura);
		
		Assert.assertEquals(4, padron.contar());
		Assert.assertEquals(rocio, padron.obtener(4003));
		Assert.assertEquals(laura, padron.obtener(4005));
		Assert.assertEquals(marcos, padron.obtener(4023));
		Assert.assertEquals(javier, padron.obtener(4078));
	}
}
