
package sample;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import domain.Academia;
import domain.Administrador;
import domain.Curso;
import domain.Direccion;
import services.AcademiaService;
import services.AdministradorService;
import services.CursoService;

@ContextConfiguration(locations = {
	"classpath:spring/junit.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class AdministradorServiceTest {

	@Autowired
	private AdministradorService	administradorService;

	@Autowired
	private CursoService			cursoService;

	@Autowired
	private AcademiaService			academiaService;


	@Test
	public void testSaveAdministrador() {
		final Administrador actor = new Administrador();

		final Direccion direccion = new Direccion();
		direccion.setCodigoPostal(10001);
		direccion.setDireccion("Calle del Alba nº12");

		actor.setNombre("Juan Alberto");
		actor.setApellidos("Dominguez Vazquez");
		actor.setEmail("juan@gmail.com");
		actor.setTelefono("+34123456789");
		actor.setDireccion(direccion);

		final Administrador saved = this.administradorService.save(actor);

		final Collection<Administrador> administradores = this.administradorService.findAll();
		Assert.isTrue(administradores.contains(saved));
	}

	@Test
	public void testCalcularMedia() {
		final Collection<Curso> cursos = this.cursoService.findAll();
		final Collection<Academia> academias = this.academiaService.findAll();

		final float media = this.administradorService.calcularMediaCursosPorAcademia(cursos, academias);
		Assert.isTrue(media == 3);
	}

	@Test
	public void testCalcularMax() {
		final Collection<Curso> cursos = this.cursoService.findAll();
		final Collection<Academia> academias = this.academiaService.findAll();

		final int max = this.administradorService.calcularMaxCursosPorAcademia(cursos, academias);
		Assert.isTrue(max == 3);
	}

	@Test
	public void testCalcularMin() {
		final Collection<Curso> cursos = this.cursoService.findAll();
		final Collection<Academia> academias = this.academiaService.findAll();

		final int min = this.administradorService.calcularMinCursosPorAcademia(cursos, academias);
		Assert.isTrue(min == 3);
	}

	@Test
	public void testCalcularDesviacion() {
		final Collection<Curso> cursos = this.cursoService.findAll();
		final Collection<Academia> academias = this.academiaService.findAll();

		final float desviacion = this.administradorService.calcularDesviacionCursosPorAcademia(cursos, academias);
		Assert.isTrue(desviacion == 0);
	}
}
