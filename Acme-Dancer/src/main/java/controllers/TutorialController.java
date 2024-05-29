
package controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		for (final Tutorial o : tutoriales)
			System.out.println(o.getTitulo());
		result.addObject("tutoriales", tutoriales);
		return result;
	}

	@RequestMapping(value = "/guardarTutorial", method = RequestMethod.POST)
	public ModelAndView guardarEstilo(@ModelAttribute("tutorial") final Tutorial tutorial) {
		final UserAccount userAccount = LoginService.getPrincipal();
		final int academia_id = this.academiaService.findId(userAccount.getId());
		final Academia academia = this.academiaService.findOne(academia_id);
		tutorial.setAcademia(academia);
		final Collection<String> video = new ArrayList<String>();
		video.add("VideoCambio");
		tutorial.setVideo(video);
		this.tutorialService.save(tutorial);
		final ModelAndView result = new ModelAndView("redirect:/tutorial/mostrarTutoriales.do");
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
			final Tutorial tutorial = this.tutorialService.findOne(id);

			result = new ModelAndView("tutorial/editarTutorial");
			result.addObject("tutorial", tutorial);
			return result;
		}

	}

}
