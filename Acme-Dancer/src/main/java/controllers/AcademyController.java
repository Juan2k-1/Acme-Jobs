
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Curso;
import domain.Estado;
import domain.RegisteredFor;
import services.AcademiaService;
import services.CursoService;
import services.RegisteredForService;;

@Controller
@RequestMapping("/academy")
public class AcademyController extends AbstractController {

	@Autowired
	private AcademiaService			academiaService;
	@Autowired
	private CursoService			cursoService;
	@Autowired
	private RegisteredForService	registeredForService;


	@RequestMapping(value = "/gestionAcademia", method = RequestMethod.GET)
	public ModelAndView listCourses() {
		final ModelAndView result = new ModelAndView("academy/gestionAcademia");
		final Collection<Academia> academias = this.academiaService.findAll();
		result.addObject("academias", academias);
		return result;
	}

	@RequestMapping(value = "/gestionAcademia2", method = RequestMethod.GET)
	public ModelAndView oneCourse(@RequestParam("id") final int id) {
		final ModelAndView result = new ModelAndView("academy/gestionAcademia");
		final Curso curso = this.cursoService.findOne(id);
		result.addObject("curso", curso);
		return result;
	}

	@RequestMapping(value = "/gestionSolicitudes", method = RequestMethod.GET)
	public ModelAndView gestionSolicitudes() {
		final ModelAndView result = new ModelAndView("academy/gestionSolicitudes");
		final Collection<RegisteredFor> solicitudes = this.registeredForService.findAll();
		result.addObject("solicitudes", solicitudes);
		return result;
	}

	@RequestMapping(value = "/aceptarSolicitud", method = RequestMethod.POST)
	public ModelAndView aceptarSolicitud(@RequestParam("id") final int id) {
		final RegisteredFor solicitud = this.registeredForService.findOne(id);
		solicitud.setEstado(Estado.ACEPTADO);
		this.registeredForService.save(solicitud);
		return new ModelAndView("redirect:/academy/gestionSolicitudes.do");
	}

	@RequestMapping(value = "/rechazarSolicitud", method = RequestMethod.POST)
	public ModelAndView rechazarSolicitud(@RequestParam("id") final int id) {
		final RegisteredFor solicitud = this.registeredForService.findOne(id);
		solicitud.setEstado(Estado.RECHAZADO);
		this.registeredForService.save(solicitud);
		return new ModelAndView("redirect:/academy/gestionSolicitudes.do");
	}

}
