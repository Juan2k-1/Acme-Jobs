
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
import services.AcademiaService;
import services.CursoService;;

@Controller
@RequestMapping("/academy")
public class AcademyController extends AbstractController {

	@Autowired
	private AcademiaService	academiaService;
	@Autowired
	private CursoService	cursoService;


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

}
