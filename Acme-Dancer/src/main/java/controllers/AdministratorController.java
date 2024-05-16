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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Curso;
import domain.RegisteredFor;
import domain.Tutorial;
import services.AcademiaService;
import services.AdministradorService;
import services.CursoService;
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


	// Constructors -----------------------------------------------------------

	public AdministratorController() {
		super();
	}

	// Action-1 ---------------------------------------------------------------

	@RequestMapping(value = "/estadisticas", method = RequestMethod.GET)
	public ModelAndView mostrarEstadisticas() {
		final ModelAndView result;

		/*
		 * Map<String, Double> statistics;
		 * statistics = this.shoutService.computeStatistics();
		 * result = new ModelAndView("administrator/action-1");
		 * result.addObject("statistics", statistics);
		 */
		Map<String, Float> estadisticas;

		final Collection<Academia> academias = this.academiaService.findAll();
		final Collection<Tutorial> tutoriales = this.tutorialService.findAll();
		final Collection<Curso> cursos = this.cursoService.findAll();
		final Collection<RegisteredFor> registeredFor = this.registeredForService.findAll();
		estadisticas = this.administradorService.calcularEstadisticas(cursos, academias, tutoriales, registeredFor);

		result = new ModelAndView("administrator/estadisticas");
		result.addObject("estadisticas", estadisticas);

		return result;
	}

	// Action-2 ---------------------------------------------------------------

	@RequestMapping("/action-2")
	public ModelAndView action2() {
		ModelAndView result;

		result = new ModelAndView("administrator/action-2");

		return result;
	}

}
