
package sample;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import domain.Alumno;
import domain.TarjetaCredito;
import services.AlumnoService;
import services.TarjetaCreditoService;

@ContextConfiguration(locations = {
	"classpath:spring/junit.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TarjetaCreditoTest {

	@Autowired
	private TarjetaCreditoService	tarjetaCreditoService;

	@Autowired
	private AlumnoService			alumnoService;


	@Test
	public void testSaveTarjetaCredito() {
		final TarjetaCredito tarjetaCredito = new TarjetaCredito();
		final Alumno alumno = this.alumnoService.findByName("Carlos");
		tarjetaCredito.setAlumno(alumno);
		tarjetaCredito.setAño(2030);
		tarjetaCredito.setCodigoCVV("987");
		tarjetaCredito.setMarca("Visa");
		tarjetaCredito.setMes(12);
		tarjetaCredito.setNumero("4539578763621486");
		tarjetaCredito.setTitular(alumno.getNombre());

		final TarjetaCredito saved = this.tarjetaCreditoService.save(tarjetaCredito);

		final Collection<TarjetaCredito> tarjetas = this.tarjetaCreditoService.findAll();
		Assert.isTrue(tarjetas.contains(saved));
	}
}
