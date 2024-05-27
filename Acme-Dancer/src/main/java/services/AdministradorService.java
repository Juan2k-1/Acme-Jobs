
package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Academia;
import domain.Actor;
import domain.Administrador;
import domain.Curso;
import domain.RegisteredFor;
import domain.Tutorial;
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

	public Administrador update(final Administrador administrador) {
		Assert.notNull(administrador);
		Administrador result;

		result = this.administradorRepository.findOne(administrador.getId());

		if (result != null) {
			result.setNombre(administrador.getNombre());
			result.setApellidos(administrador.getApellidos());
			result.setEmail(administrador.getEmail());
			result.setDireccion(administrador.getDireccion());
			result.setCuentaUsuario(administrador.getCuentaUsuario());
			result.setComentarios(administrador.getComentarios());

			final Collection<Actor> publicadores = new ArrayList<>(administrador.getPublicadores());
			final Collection<Actor> subscriptores = new ArrayList<>(administrador.getSubscriptores());

			result.setPublicadores(publicadores);
			result.setSubscriptores(subscriptores);

			result.setTelefono(administrador.getTelefono());

			result = this.administradorRepository.save(result);
		}
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

	public int findId(final int userAccountId) {
		final int idAdmin = this.administradorRepository.findId(userAccountId);
		return idAdmin;
	}

	public Map<String, Float> calcularEstadisticas(final Collection<Curso> cursos, final Collection<Academia> academias, final Collection<Tutorial> tutoriales, final Collection<RegisteredFor> registeredFor, final Collection<Actor> actores) {
		// Inicializar el mapa para almacenar las estadísticas
		final Map<String, Float> estadisticas = new HashMap<>();

		// Calcular y agregar las estadísticas al mapa
		estadisticas.put("mediaCursosPorAcademia", this.calcularMediaCursosPorAcademia(cursos, academias));
		estadisticas.put("maxCursosPorAcademia", (float) this.calcularMaxCursosPorAcademia(cursos, academias));
		estadisticas.put("minCursosPorAcademia", (float) this.calcularMinCursosPorAcademia(cursos, academias));
		estadisticas.put("desviacionCursosPorAcademia", this.calcularDesviacionCursosPorAcademia(cursos, academias));
		estadisticas.put("mediaSolicitudesPorCurso", this.calcularMediasSolicitudesPorCurso(cursos, registeredFor));
		estadisticas.put("maxSolicitudesPorCurso", (float) this.calcularMaxSolicitudesPorCurso(cursos, registeredFor));
		estadisticas.put("minSolicitudesPorCurso", (float) this.calcularMinSolicitudesPorCurso(cursos, registeredFor));
		estadisticas.put("desviacionSolicitudesPorCurso", this.calcularDesviacionSolicitudesPorCurso(cursos, registeredFor));
		estadisticas.put("minTutorialesPorAcademia", (float) this.calcularMinTutorialesPorAcademia(academias, tutoriales));
		estadisticas.put("mediaTutorialesPorAcademia", this.calcularMediaTutorialesPorAcademia(academias, tutoriales));
		estadisticas.put("maxTutorialesPorAcademia", (float) this.calcularMaxTutorialesPorAcademia(academias, tutoriales));
		estadisticas.put("mediaComentariosPorActor", this.calcularMediaComentariosPorActor(actores));
		estadisticas.put("mediaSuscriptoresPorActor", this.calcularMediaSuscriptoresPorActor(actores));

		// Devolver el mapa de estadísticas
		return estadisticas;
	}

	//----------------------------  REQUISITOS ADMINISTRADOR NIVEL C -------------------------------------------------//

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

	public float calcularMediasSolicitudesPorCurso(final Collection<Curso> cursos, final Collection<RegisteredFor> registeredFor) {
		if (cursos.isEmpty() || registeredFor.isEmpty())
			return 0;

		// Mapa para contar solicitudes por curso
		final Map<Curso, Integer> solicitudesPorCurso = new HashMap<>();

		for (final RegisteredFor solicitud : registeredFor) {
			final Curso curso = solicitud.getCurso();
			if (curso != null && cursos.contains(curso))
				solicitudesPorCurso.put(curso, solicitudesPorCurso.getOrDefault(curso, 0) + 1);
		}

		// Suma total de solicitudes
		int sumaSolicitudes = 0;
		for (final int count : solicitudesPorCurso.values())
			sumaSolicitudes += count;

		// Calcular la media de solicitudes por curso
		return (float) sumaSolicitudes / cursos.size();
	}

	public int calcularMaxSolicitudesPorCurso(final Collection<Curso> cursos, final Collection<RegisteredFor> registeredFor) {
		if (cursos.isEmpty() || registeredFor.isEmpty())
			return 0;

		// Mapa para contar solicitudes por curso
		final Map<Curso, Integer> solicitudesPorCurso = new HashMap<>();

		for (final RegisteredFor solicitud : registeredFor) {
			final Curso curso = solicitud.getCurso();
			if (curso != null && cursos.contains(curso))
				solicitudesPorCurso.put(curso, solicitudesPorCurso.getOrDefault(curso, 0) + 1);
		}

		// Encontrar el máximo número de solicitudes por curso
		int maxSolicitudes = 0;
		for (final int count : solicitudesPorCurso.values())
			if (count > maxSolicitudes)
				maxSolicitudes = count;

		return maxSolicitudes;
	}

	public int calcularMinSolicitudesPorCurso(final Collection<Curso> cursos, final Collection<RegisteredFor> registeredFor) {
		if (cursos.isEmpty() || registeredFor.isEmpty())
			return 0;

		// Mapa para contar solicitudes por curso
		final Map<Curso, Integer> solicitudesPorCurso = new HashMap<>();

		for (final RegisteredFor solicitud : registeredFor) {
			final Curso curso = solicitud.getCurso();
			if (curso != null && cursos.contains(curso))
				solicitudesPorCurso.put(curso, solicitudesPorCurso.getOrDefault(curso, 0) + 1);
		}

		// Inicializar minSolicitudes con el mayor valor posible
		int minSolicitudes = Integer.MAX_VALUE;
		for (final Curso curso : cursos) {
			final int solicitudes = solicitudesPorCurso.getOrDefault(curso, 0);
			if (solicitudes < minSolicitudes)
				minSolicitudes = solicitudes;
		}

		// Manejar el caso en que no haya solicitudes (todos los cursos tienen 0 solicitudes)
		return minSolicitudes == Integer.MAX_VALUE ? 0 : minSolicitudes;
	}

	public float calcularDesviacionSolicitudesPorCurso(final Collection<Curso> cursos, final Collection<RegisteredFor> registeredFor) {
		if (cursos.isEmpty() || registeredFor.isEmpty())
			return 0;

		// Mapa para contar solicitudes por curso
		final Map<Curso, Integer> solicitudesPorCurso = new HashMap<>();

		for (final RegisteredFor solicitud : registeredFor) {
			final Curso curso = solicitud.getCurso(); // Asumiendo que RegisteredFor tiene un método getCurso()
			if (curso != null && cursos.contains(curso))
				solicitudesPorCurso.put(curso, solicitudesPorCurso.getOrDefault(curso, 0) + 1);
		}

		// Calcular la media de solicitudes por curso
		float sumaSolicitudes = 0;
		for (final int count : solicitudesPorCurso.values())
			sumaSolicitudes += count;
		final float media = sumaSolicitudes / cursos.size();

		// Calcular la suma de los cuadrados de las diferencias respecto a la media
		double sumaCuadradosDiferencias = 0;
		for (final int count : solicitudesPorCurso.values())
			sumaCuadradosDiferencias += Math.pow(count - media, 2);

		// Calcular la varianza
		final double varianza = sumaCuadradosDiferencias / cursos.size();

		// Calcular la desviación estándar
		return (float) Math.sqrt(varianza);
	}

	//---------------------------------------- REQUISITOS ADMINISTRADOR NIVEL B ---------------------------------------------------------------//

	public int calcularMinTutorialesPorAcademia(final Collection<Academia> academias, final Collection<Tutorial> tutoriales) {
		if (academias.isEmpty() || tutoriales.isEmpty())
			return 0;

		// Mapa para contar tutoriales por academia
		final Map<Academia, Integer> tutorialesPorAcademia = new HashMap<>();

		for (final Tutorial tutorial : tutoriales) {
			final Academia academia = tutorial.getAcademia();
			if (academia != null && academias.contains(academia))
				tutorialesPorAcademia.put(academia, tutorialesPorAcademia.getOrDefault(academia, 0) + 1);
		}

		// Inicializar minTutoriales con el mayor valor posible
		int minTutoriales = Integer.MAX_VALUE;
		for (final Academia academia : academias) {
			final int tutorialesCount = tutorialesPorAcademia.getOrDefault(academia, 0);
			if (tutorialesCount < minTutoriales)
				minTutoriales = tutorialesCount;
		}

		// Manejar el caso en que no haya tutoriales (todos las academias tienen 0 tutoriales)
		return minTutoriales == Integer.MAX_VALUE ? 0 : minTutoriales;
	}

	public float calcularMediaTutorialesPorAcademia(final Collection<Academia> academias, final Collection<Tutorial> tutoriales) {
		if (academias.isEmpty() || tutoriales.isEmpty())
			return 0;

		// Mapa para contar tutoriales por academia
		final Map<Academia, Integer> tutorialesPorAcademia = new HashMap<>();

		for (final Tutorial tutorial : tutoriales) {
			final Academia academia = tutorial.getAcademia();
			if (academia != null && academias.contains(academia))
				tutorialesPorAcademia.put(academia, tutorialesPorAcademia.getOrDefault(academia, 0) + 1);
		}

		// Suma total de tutoriales
		int sumaTutoriales = 0;
		for (final int count : tutorialesPorAcademia.values())
			sumaTutoriales += count;

		// Calcular la media de tutoriales por academia
		return (float) sumaTutoriales / academias.size();
	}

	public int calcularMaxTutorialesPorAcademia(final Collection<Academia> academias, final Collection<Tutorial> tutoriales) {
		if (academias.isEmpty() || tutoriales.isEmpty())
			return 0;

		// Mapa para contar tutoriales por academia
		final Map<Academia, Integer> tutorialesPorAcademia = new HashMap<>();

		for (final Tutorial tutorial : tutoriales) {
			final Academia academia = tutorial.getAcademia();
			if (academia != null && academias.contains(academia))
				tutorialesPorAcademia.put(academia, tutorialesPorAcademia.getOrDefault(academia, 0) + 1);
		}

		// Encontrar el máximo número de tutoriales por academia
		int maxTutoriales = 0;
		for (final int count : tutorialesPorAcademia.values())
			if (count > maxTutoriales)
				maxTutoriales = count;

		return maxTutoriales;
	}

	public float calcularMediaComentariosPorActor(final Collection<Actor> actores) {
		int totalComentarios = 0;
		for (final Actor actor : actores)
			totalComentarios += actor.getComentarios().size();
		return actores.isEmpty() ? 0 : (float) totalComentarios / actores.size();
	}

	public float calcularMediaSuscriptoresPorActor(final Collection<Actor> actores) {
		int totalSuscriptores = 0;
		for (final Actor actor : actores)
			totalSuscriptores += actor.getSubscriptores().size();
		return actores.isEmpty() ? 0 : (float) totalSuscriptores / actores.size();
	}
}
