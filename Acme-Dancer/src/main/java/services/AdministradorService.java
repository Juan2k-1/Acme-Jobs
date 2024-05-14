
package services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Academia;
import domain.Administrador;
import domain.Curso;
import repositories.AdministradorRepository;

@Service
@Transactional
public class AdministradorService {

	@Autowired
	private AdministradorRepository administradorRepository;


	public Collection<Administrador> findAll() {
		Collection<Administrador> result;
		result = this.administradorRepository.findAll();
		return result;
	}

	public Administrador save(final Administrador admin) {
		Assert.notNull(admin);

		Administrador result;

		result = this.administradorRepository.save(admin);

		return result;
	}

	public void delete(final Administrador admin) {
		Assert.notNull(admin);
		Assert.isTrue(admin.getId() != 0);
		Assert.isTrue(this.administradorRepository.exists(admin.getId()));

		this.administradorRepository.delete(admin);
	}

	public Administrador findOne(final int administradorId) {
		Assert.isTrue(administradorId != 0);

		Administrador result;

		result = this.administradorRepository.findOne(administradorId);
		Assert.notNull(result);

		return result;
	}

	public Administrador findByName(final String nombre) {
		Assert.isTrue(nombre != "");

		Administrador result;

		result = this.administradorRepository.findByName(nombre);
		Assert.notNull(result);

		return result;
	}

	public float calcularMediaCursosPorAcademia(final Collection<Curso> cursos, final Collection<Academia> academias) {
		if (academias.isEmpty())
			return 0;

		// Mapa para contar cursos por academia
		final Map<Academia, Integer> cursosPorAcademia = new HashMap<>();

		for (final Curso curso : cursos) {
			final Academia academia = curso.getAcademia();
			if (academia != null)
				cursosPorAcademia.put(academia, cursosPorAcademia.getOrDefault(academia, 0) + 1);
		}

		// Calcula la suma de cursos por academia
		int sumaCursos = 0;
		for (final int count : cursosPorAcademia.values())
			sumaCursos += count;

		// Calcula la media de cursos por academia
		return (float) sumaCursos / cursosPorAcademia.size();
	}

	public int calcularMaxCursosPorAcademia(final Collection<Curso> cursos, final Collection<Academia> academias) {
		if (academias.isEmpty() || cursos.isEmpty())
			return 0;

		// Mapa para contar cursos por academia
		final Map<Academia, Integer> cursosPorAcademia = new HashMap<>();

		for (final Curso curso : cursos) {
			final Academia academia = curso.getAcademia();
			if (academia != null && academias.contains(academia))
				cursosPorAcademia.put(academia, cursosPorAcademia.getOrDefault(academia, 0) + 1);
		}

		// Encontrar el máximo número de cursos por academia
		int maxCursos = 0;
		for (final int count : cursosPorAcademia.values())
			if (count > maxCursos)
				maxCursos = count;

		return maxCursos;
	}

	public int calcularMinCursosPorAcademia(final Collection<Curso> cursos, final Collection<Academia> academias) {
		if (academias.isEmpty() || cursos.isEmpty())
			return 0;

		// Mapa para contar cursos por academia
		final Map<Academia, Integer> cursosPorAcademia = new HashMap<>();

		for (final Curso curso : cursos) {
			final Academia academia = curso.getAcademia();
			if (academia != null && academias.contains(academia))
				cursosPorAcademia.put(academia, cursosPorAcademia.getOrDefault(academia, 0) + 1);
		}

		// Encontrar el minimo número de cursos por academia
		int minCursos = Integer.MAX_VALUE; // Inicializar con el máximo valor posible
		for (final int count : cursosPorAcademia.values())
			if (count < minCursos)
				minCursos = count;

		// Manejar el caso en que no haya cursos para evitar retornar el valor inicializado
		return minCursos == Integer.MAX_VALUE ? 0 : minCursos;
	}

	public float calcularDesviacionCursosPorAcademia(final Collection<Curso> cursos, final Collection<Academia> academias) {
		if (academias.isEmpty() || cursos.isEmpty())
			return 0;

		// Mapa para contar cursos por academia
		final Map<Academia, Integer> cursosPorAcademia = new HashMap<>();

		for (final Curso curso : cursos) {
			final Academia academia = curso.getAcademia();
			if (academia != null && academias.contains(academia))
				cursosPorAcademia.put(academia, cursosPorAcademia.getOrDefault(academia, 0) + 1);
		}

		// Calcular la media de cursos por academia
		final float media = this.calcularMediaCursosPorAcademia(cursos, academias);

		// Calcular la suma de los cuadrados de las diferencias respecto a la media
		double sumaCuadradosDiferencias = 0;
		for (final int count : cursosPorAcademia.values())
			sumaCuadradosDiferencias += Math.pow(count - media, 2);

		// Calcular la varianza
		final double varianza = sumaCuadradosDiferencias / cursosPorAcademia.size();

		// Calcular la desviación típica
		return (float) Math.sqrt(varianza);
	}
}
