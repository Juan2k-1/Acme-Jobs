
package sample;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import domain.Actor;
import domain.Alumno;
import domain.Direccion;
import services.ActorService;
import utilities.AbstractTest;

@ContextConfiguration(locations = {
	"classpath:spring/junit.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ActorServiceTest extends AbstractTest {

	@Autowired
	private ActorService actorService;


	@Test
	public void testSaveActor() {
		final Actor actor = new Alumno();

		final Direccion direccion = new Direccion();
		direccion.setCodigoPostal(10001);
		direccion.setDireccion("Calle del Alba nº12");

		actor.setNombre("Juan Alberto");
		actor.setApellidos("Dominguez Vazquez");
		actor.setEmail("juan@gmail.com");
		actor.setTelefono("123456789");
		actor.setDireccion(direccion);

		final Actor saved = this.actorService.save(actor);

		final Collection<Actor> actores = this.actorService.findAll();
		Assert.isTrue(actores.contains(saved));

		final Actor actor2 = this.actorService.findByName("Carlos");
		Assert.isTrue(actor2.getNombre().equals("Carlos"));
	}
}
