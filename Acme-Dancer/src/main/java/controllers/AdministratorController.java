/*
 * AdministratorController.java
 *
 * Copyright (C) 2018 Universidad de Sevilla
 *
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Actor;
import domain.Curso;
import domain.Estilo;
import domain.RegisteredFor;
import domain.Tutorial;
import services.AcademiaService;
import services.ActorService;
import services.AdministradorService;
import services.CursoService;
import services.EstiloService;
import services.RegisteredForService;
import services.TutorialService;

@Controller
@RequestMapping("/administrator")
public class AdministratorController extends AbstractController {

	@Autowired
	private AdministradorService	administradorService;

	@Autowired
	private AcademiaService			academiaService;

	@Autowired
	private TutorialService			tutorialService;

	@Autowired
	private CursoService			cursoService;

	@Autowired
	private RegisteredForService	registeredForService;

	@Autowired
	private EstiloService			estiloService;

	@Autowired
	private ActorService			actorService;


	// Constructors -----------------------------------------------------------

	public AdministratorController() {
		super();
	}

	// Action-1 ---------------------------------------------------------------

	@RequestMapping(value = "/estadisticas", method = RequestMethod.GET)
	public ModelAndView mostrarEstadisticas() {
		final ModelAndView result;

		Map<String, Float> estadisticas;

		final Collection<Academia> academias = this.academiaService.findAll();
		final Collection<Tutorial> tutoriales = this.tutorialService.findAll();
		final Collection<Curso> cursos = this.cursoService.findAll();
		final Collection<RegisteredFor> registeredFor = this.registeredForService.findAll();
		final Collection<Actor> actores = this.actorService.findAll();
		estadisticas = this.administradorService.calcularEstadisticas(cursos, academias, tutoriales, registeredFor, actores);

		result = new ModelAndView("administrator/estadisticas");
		result.addObject("estadisticas", estadisticas);

		return result;
	}

	// Action-2 ---------------------------------------------------------------

	@RequestMapping(value = "/gestionEstilos", method = RequestMethod.GET)
	public ModelAndView listStyles() {
		final ModelAndView result = new ModelAndView("administrator/gestionEstilos");
		final Collection<Estilo> estilos = this.estiloService.findAll();
		result.addObject("estilos", estilos);
		result.addObject("nuevoEstilo", new Estilo());
		return result;
	}

	@RequestMapping(value = "/editarEstilo", method = RequestMethod.GET)
	public ModelAndView editarEstilo(@RequestParam("id") final int id) {
		final ModelAndView result;
		final Estilo estilo = this.estiloService.findOne(id);

		result = new ModelAndView("administrator/editarEstilo");
		result.addObject("estilo", estilo);
		return result;
	}

	@RequestMapping(value = "/guardarEstilo", method = RequestMethod.POST)
	public ModelAndView guardarEstilo(@Valid final Estilo estilo) {

		final Collection<Curso> cursos = this.cursoService.findByEstilo(estilo.getNombre());
		estilo.setCursos(cursos);
		this.estiloService.save(estilo);
		final ModelAndView result = new ModelAndView("redirect:/administrator/gestionEstilos.do");
		return result;
	}

	@RequestMapping(value = "/crearEstilo", method = RequestMethod.POST)
	public ModelAndView crearEstilo(@Valid @ModelAttribute("nuevoEstilo") final Estilo estilo, final BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			final ModelAndView result = new ModelAndView("administrator/gestionEstilos");
			final Collection<Estilo> estilos = this.estiloService.findAll();
			result.addObject("estilos", estilos);
			result.addObject("nuevoEstilo", estilo);
			return result;
		}
		this.estiloService.save(estilo);
		return new ModelAndView("redirect:/administrator/gestionEstilos.do");
	}

	@RequestMapping(value = "/eliminarEstilo", method = {
		RequestMethod.GET, RequestMethod.POST
	})
	public ModelAndView eliminarEstilo(@RequestParam("id") final int id) {
		final ModelAndView mav = new ModelAndView("redirect:/administrator/gestionEstilos.do");
		final Estilo estilo = this.estiloService.findOne(id);
		this.estiloService.delete(estilo);
		return mav;
	}

}
