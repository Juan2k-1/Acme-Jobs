
package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Curso;
import security.LoginService;
import security.UserAccount;
import services.AcademiaService;
import services.CursoService;

@Controller
@RequestMapping("/course")
public class CourseController extends AbstractController {

	@Autowired
	private CursoService	cursoService;
	@Autowired
	private AcademiaService	academiaService;


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

	@RequestMapping(value = "/CMCurso", method = RequestMethod.GET)
	public ModelAndView CrudCourse() {
		final ModelAndView result = new ModelAndView("course/CMCurso");
		final UserAccount userAccount = LoginService.getPrincipal();
		final int academiaId = this.academiaService.findId(userAccount.getId());
		final Academia academia = this.academiaService.findOne(academiaId);
		final Collection<Curso> cursos = academia.getCursos();
		result.addObject("cursos", cursos);
		return result;
	}

	@RequestMapping(value = "/guardarCurso", method = RequestMethod.POST)
	public ModelAndView guardarCurso(@Valid final Curso curso, final BindingResult bindingResult) {
		final ModelAndView result;

		// Por que si le pasamos como atributo hidden el campo academia al controlador, no funciona
		final UserAccount userAccount = LoginService.getPrincipal();
		final int academia_id = this.academiaService.findId(userAccount.getId());
		final Academia academia = this.academiaService.findOne(academia_id);

		if (bindingResult.hasErrors())
			result = new ModelAndView("redirect:/course/CMCurso.do");
		else {
			curso.setAcademia(academia);
			this.cursoService.save(curso);
			this.cursoService.flush();
			result = new ModelAndView("redirect:/course/gestionCursos.do");
		}
		return result;
	}

	@RequestMapping(value = "/editarCurso", method = RequestMethod.GET)
	public ModelAndView editarCurso(@RequestParam("id") final int id) {
		final ModelAndView result;
		final UserAccount userAccount = LoginService.getPrincipal();
		System.out.println(userAccount.getId());
		final int academia_id = this.academiaService.findId(userAccount.getId());
		final Academia academia = this.academiaService.findOne(academia_id);
		boolean exite = false;
		for (final Curso curso : academia.getCursos())
			if (curso.getId() == id)
				exite = true;
		if (exite == true) {
			final Curso curso = this.cursoService.findOne(id);

			result = new ModelAndView("course/editarCurso");
			result.addObject("curso", curso);
			return result;
		} else {
			result = new ModelAndView("redirect:/course/CMCurso.do");
			return result;
		}

	}
}
