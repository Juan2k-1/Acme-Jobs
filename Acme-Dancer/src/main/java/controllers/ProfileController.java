/*
 * ProfileController.java
 *
 * Copyright (C) 2018 Universidad de Sevilla
 *
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Administrador;
import domain.Alumno;
import domain.Direccion;
import domain.TarjetaCredito;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import services.AcademiaService;
import services.ActorService;
import services.AdministradorService;
import services.AlumnoService;
import services.TarjetaCreditoService;
import services.UserAccountService;

@Controller
@RequestMapping("/profile")
public class ProfileController extends AbstractController {

	@Autowired
	LoginService			service;

	@Autowired
	AcademiaService			academiaService;

	@Autowired
	AlumnoService			alumnoService;

	@Autowired
	TarjetaCreditoService	tarjetaCreditoService;

	@Autowired
	UserAccountService		userService;

	@Autowired
	ActorService			actorService;

	@Autowired
	AdministradorService	adminitradorService;


	@RequestMapping(value = "/editarDatos", method = RequestMethod.GET)
	public ModelAndView editarDatos() {
		final ModelAndView modelAndView = new ModelAndView("profile/editarDatos");
		final UserAccount userAccount = LoginService.getPrincipal();

		if (userAccount == null) {
			modelAndView.setViewName("error");
			modelAndView.addObject("message", "User is not authenticated.");
			return modelAndView;
		}

		final Collection<Authority> authorities = userAccount.getAuthorities();
		for (final Authority authority : authorities)
			if (authority.getAuthority().equalsIgnoreCase("ALUMNO")) {
				final int alumnoId = this.alumnoService.findId(userAccount.getId());
				final Alumno alumno = this.alumnoService.findOne(alumnoId);
				modelAndView.addObject("actor", alumno);
			} else if (authority.getAuthority().equalsIgnoreCase("ACADEMIA")) {
				final int academiaId = this.academiaService.findId(userAccount.getId());
				final Academia academia = this.academiaService.findOne(academiaId);
				modelAndView.addObject("actor", academia);
			} else {
				final int adminId = this.adminitradorService.findId(userAccount.getId());
				final Administrador administrador = this.adminitradorService.findOne(adminId);
				modelAndView.addObject("actor", administrador);
			}

		return modelAndView;
	}

	@RequestMapping(value = "/editarDatos", method = RequestMethod.POST)
	public ModelAndView editarDatosSave(final HttpServletRequest request) {

		// Obtener los parámetros del formulario directamente desde HttpServletRequest
		final String nombre = request.getParameter("nombre");
		final String apellidos = request.getParameter("apellidos");
		final String email = request.getParameter("email");
		final String telefono = request.getParameter("telefono");
		final String direccion = request.getParameter("direccion");
		final String codigoPostal = request.getParameter("codigoPostal");
		int codigoP;
		if (codigoPostal != null)
			codigoP = Integer.parseInt(codigoPostal);
		else
			codigoP = 0;

		final String titular = request.getParameter("titular");
		final String marca = request.getParameter("marca");
		final String numero = request.getParameter("numero");

		final String mesString = request.getParameter("mes");
		int mes;
		if (mesString != null)
			mes = Integer.parseInt(mesString);
		else
			mes = 0;

		final String añoString = request.getParameter("año");
		int año;
		if (añoString != null)
			año = Integer.parseInt(añoString);
		else
			año = 0;

		final String codigoCVV = request.getParameter("codigoCVV");
		final String nombreComercial = request.getParameter("nombreComercial");

		final Direccion dir = new Direccion();
		dir.setDireccion(direccion);
		dir.setCodigoPostal(codigoP);

		final UserAccount userAccount = LoginService.getPrincipal();
		final Collection<Authority> authorities = userAccount.getAuthorities();
		for (final Authority authority : authorities)
			if (authority.getAuthority().equalsIgnoreCase("ALUMNO")) {
				final int alumnoId = this.alumnoService.findId(userAccount.getId());
				final Alumno alumno = this.alumnoService.findOne(alumnoId);

				alumno.setNombre(nombre);
				alumno.setApellidos(apellidos);
				alumno.setEmail(email);
				alumno.setTelefono(telefono);
				alumno.setDireccion(dir);

				if (titular != "") {
					final TarjetaCredito tarjeta = this.tarjetaCreditoService.findByName(alumno.getTarjetaCredito().getTitular());
					tarjeta.setNumero(numero);
					tarjeta.setTitular(titular);
					tarjeta.setMarca(marca);

					if (año != 0)
						tarjeta.setAño(año);

					if (mes != 0)
						tarjeta.setMes(mes);

					tarjeta.setCodigoCVV(codigoCVV);
					final TarjetaCredito tarjetaSaved = this.tarjetaCreditoService.update(tarjeta);
					alumno.setTarjetaCredito(tarjetaSaved);
				}

				if (userAccount != null)
					alumno.setCuentaUsuario(userAccount);
				this.alumnoService.update(alumno);

			} else if (authority.getAuthority().equalsIgnoreCase("ACADEMIA")) {
				final int academiaId = this.academiaService.findId(userAccount.getId());
				final Academia academia = this.academiaService.findOne(academiaId);

				if (!nombreComercial.equalsIgnoreCase(""))
					academia.setNombreComercial(nombreComercial);

				academia.setNombre(nombre);
				academia.setApellidos(apellidos);
				academia.setEmail(email);
				academia.setTelefono(telefono);
				academia.setDireccion(dir);

				if (userAccount != null)
					academia.setCuentaUsuario(userAccount);
				this.academiaService.update(academia);

			} else {
				final int adminId = this.adminitradorService.findId(userAccount.getId());
				final Administrador administrador = this.adminitradorService.findOne(adminId);

				administrador.setNombre(nombre);
				administrador.setApellidos(apellidos);
				administrador.setEmail(email);
				administrador.setTelefono(telefono);
				administrador.setDireccion(dir);

				if (userAccount != null)
					administrador.setCuentaUsuario(userAccount);
				this.adminitradorService.update(administrador);
			}

		final ModelAndView modelAndView = new ModelAndView("redirect:/welcome/index.do");
		return modelAndView;

	}
}
