package controllers;

import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import domain.Alumno;
import domain.Curso;
import domain.RegisteredFor;
import security.LoginService;
import security.UserAccount;
import domain.Estado;
//import services.AlumnoService;
import services.CursoService;
import services.RegisteredForService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController extends AbstractController {

    //@Autowired
    //private AlumnoService alumnoService;
    
    @Autowired
    private CursoService cursoService;
    
    @Autowired
    private RegisteredForService registeredForService;

    // Solicitar un curso
    @RequestMapping(value = "/solicitarCurso", method = RequestMethod.GET)
    public ModelAndView solicitarCurso() {
        ModelAndView result;
        Collection<Curso> cursos = cursoService.findAll();
        result = new ModelAndView("alumno/solicitarCurso");
        result.addObject("cursos", cursos);
        result.addObject("registeredFor", new RegisteredFor());
        return result;
    }

    @RequestMapping(value = "/solicitarCurso", method = RequestMethod.POST)
    public ModelAndView solicitarCurso(@Valid @ModelAttribute("registeredFor") RegisteredFor registeredFor, BindingResult bindingResult) {
        ModelAndView result;
        
        if (bindingResult.hasErrors()) {
            result = new ModelAndView("alumno/solicitarCurso");
            result.addObject("cursos", cursoService.findAll());
        } else {
        	final UserAccount userAccount = LoginService.getPrincipal();
            registeredFor.setAlumno(registeredForService.findAlumno(userAccount.getId()));
            registeredFor.setMomento(new Date());
            registeredFor.setEstado(Estado.PENDIENTE);
            registeredForService.save(registeredFor);
            result = new ModelAndView("redirect:/alumno/misSolicitudes.do");
        }
        
        return result;
    }

    // Listar solicitudes del alumno
    @RequestMapping(value = "/misSolicitudes", method = RequestMethod.GET)
    public ModelAndView misSolicitudes() {
        ModelAndView result;
        final UserAccount userAccount = LoginService.getPrincipal();
        int idCuentaAlumno = registeredForService.findIDAlumno(userAccount.getId());
        Collection<RegisteredFor> solicitudes = registeredForService.findByAlumnoId(idCuentaAlumno);
        result = new ModelAndView("alumno/misSolicitudes");
        result.addObject("solicitudes", solicitudes);
        return result;
    }
}
