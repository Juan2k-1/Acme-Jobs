
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Curso;
import services.CursoService;

@Controller
@RequestMapping("/course")
public class CourseController extends AbstractController {

	@Autowired
	private CursoService cursoService;


	@RequestMapping(value = "/gestionCursos", method = RequestMethod.GET)
	public ModelAndView listCourses() {
		final ModelAndView result = new ModelAndView("course/gestionCursos");
		final Collection<Curso> cursos = this.cursoService.findAll();
		result.addObject("cursos", cursos);
		return result;
	}

	@RequestMapping(value = "/DatosCursos", method = RequestMethod.GET)
	public ModelAndView oneCourse(@RequestParam("id") final int id) {
		final ModelAndView result = new ModelAndView("course/DatosCursos");
		final Curso curso = this.cursoService.findOne(id);
		result.addObject("curso", curso);
		return result;
	}

}
