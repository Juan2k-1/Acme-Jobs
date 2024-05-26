
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Estilo;
import services.EstiloService;

@Controller
@RequestMapping("/style")
public class StyleController extends AbstractController {

	@Autowired
	private EstiloService estiloService;


	@RequestMapping(value = "/gestionEstilos", method = RequestMethod.GET)
	public ModelAndView listStyles() {
		final ModelAndView result = new ModelAndView("style/gestionEstilos");
		final Collection<Estilo> estilos = this.estiloService.findAll();
		result.addObject("estilos", estilos);
		return result;
	}

}
