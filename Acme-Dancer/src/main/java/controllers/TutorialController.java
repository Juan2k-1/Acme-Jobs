
package controllers;

import java.util.Collection;

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
import domain.Tutorial;
import security.LoginService;
import security.UserAccount;
import services.AcademiaService;
import services.TutorialService;

@Controller
@RequestMapping("/tutorial")
public class TutorialController {

	@Autowired
	private TutorialService	tutorialService;
	@Autowired
	private AcademiaService	academiaService;


	@RequestMapping(value = "/mostrarTutoriales", method = RequestMethod.GET)
	public ModelAndView listStyles() {
		final ModelAndView result = new ModelAndView("tutorial/mostrarTutoriales");
		final UserAccount userAccount = LoginService.getPrincipal();
		final int academia_id = this.academiaService.findId(userAccount.getId());
		final Collection<Tutorial> tutoriales = this.tutorialService.findByAcademia(academia_id);
		result.addObject("tutoriales", tutoriales);
		result.addObject("nuevoTutorial", new Tutorial());
		return result;
	}

	@RequestMapping(value = "/guardarTutorial", method = RequestMethod.POST)
	public ModelAndView guardarEstilo(@Valid final Tutorial tutorial, final BindingResult bindingResult) {
		final ModelAndView result;

		final UserAccount userAccount = LoginService.getPrincipal();
		final int academia_id = this.academiaService.findId(userAccount.getId());
		final Academia academia = this.academiaService.findOne(academia_id);

		if (bindingResult.hasErrors())
			result = new ModelAndView("redirect:/tutorial/mostrarTutoriales.do");
		else {
			tutorial.setAcademia(academia);
			this.tutorialService.save(tutorial);
			this.tutorialService.flush();
			result = new ModelAndView("redirect:/tutorial/mostrarTutoriales.do");
		}
		return result;
	}

	@RequestMapping(value = "/editarTutorial", method = RequestMethod.GET)
	public ModelAndView editarEstilo(@RequestParam("id") final int id) {
		final ModelAndView result;
		final UserAccount userAccount = LoginService.getPrincipal();
		final int academia_id = this.academiaService.findId(userAccount.getId());
		final Academia academia = this.academiaService.findOne(academia_id);
		boolean exite = false;
		for (final Tutorial tutorial : academia.getTutoriales())
			if (tutorial.getId() == id)
				exite = true;
		if (exite == true) {
			final Tutorial tutorial = this.tutorialService.findOne(id);

			result = new ModelAndView("tutorial/editarTutorial");
			result.addObject("tutorial", tutorial);
			return result;
		} else {

			result = new ModelAndView("redirect:/tutorial/mostrarTutoriales.do");
			return result;
		}

	}
	@RequestMapping(value = "/eliminarTutorial", method = {
		RequestMethod.GET, RequestMethod.POST
	})
	public ModelAndView eliminarTutorial(@RequestParam("id") final int id) {
		final ModelAndView mav = new ModelAndView("redirect:/tutorial/mostrarTutoriales.do");
		final Tutorial tutorial = this.tutorialService.findOne(id);
		this.tutorialService.delete(tutorial);
		return mav;
	}

	@RequestMapping(value = "/crearTutorial", method = RequestMethod.POST)
	public ModelAndView crearTutorial(@Valid @ModelAttribute("nuevoEstilo") final Tutorial tutorial, final BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			final ModelAndView result = new ModelAndView("tutorial/mostrarTutoriales");
			final UserAccount userAccount = LoginService.getPrincipal();
			final int academia_id = this.academiaService.findId(userAccount.getId());
			final Collection<Tutorial> tutoriales = this.tutorialService.findByAcademia(academia_id);
			result.addObject("tutoriales", tutoriales);
			return result;
		}
		final UserAccount userAccount = LoginService.getPrincipal();
		final int academia_id = this.academiaService.findId(userAccount.getId());
		final Academia academia = this.academiaService.findOne(academia_id);
		tutorial.setAcademia(academia);
		tutorial.setNumReproducciones(0);
		this.tutorialService.save(tutorial);
		return new ModelAndView("redirect:/tutorial/mostrarTutoriales.do");
	}

	@RequestMapping(value = "/verTutorial", method = RequestMethod.GET)
	public ModelAndView verTutorial(@RequestParam("id") final int id) {

		final Tutorial tutorial = this.tutorialService.findOne(id);
		final ModelAndView result = new ModelAndView("tutorial/verTutorial");
		final int numReproducciones = tutorial.getNumReproducciones() + 1;
		tutorial.setNumReproducciones(numReproducciones);
		this.tutorialService.save(tutorial);
		result.addObject("tutorial", tutorial);
		return result;
	}

}
