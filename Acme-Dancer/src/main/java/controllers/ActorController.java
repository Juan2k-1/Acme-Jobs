
package controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Alumno;
import domain.Direccion;
import domain.TarjetaCredito;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import services.AcademiaService;
import services.ActorService;
import services.AlumnoService;
import services.TarjetaCreditoService;
import services.UserAccountService;

@Controller
@RequestMapping("/registerActor")
public class ActorController extends AbstractController {

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


	public ActorController() {
		super();
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegistrationForm() {
		final ModelAndView modelAndView = new ModelAndView("registerActor/register");
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(final HttpServletRequest request) {

		// Obtener los parámetros del formulario directamente desde HttpServletRequest
		final String nombre = request.getParameter("nombre");
		final String apellidos = request.getParameter("apellidos");
		final String email = request.getParameter("email");
		final String telefono = request.getParameter("telefono");
		final String direccion = request.getParameter("direccion");
		final String codigoPostal = request.getParameter("codigoPostal");
		final String actorType = request.getParameter("actorType");

		final String titular = request.getParameter("titular");
		final String marca = request.getParameter("marca");
		final String numero = request.getParameter("numero");

		final String mesString = request.getParameter("mes");
		int mes = 0;
		if (!mesString.equalsIgnoreCase(""))
			mes = Integer.parseInt(mesString);

		final String añoString = request.getParameter("año");
		int año = 0;
		if (!añoString.equalsIgnoreCase(""))
			año = Integer.parseInt(añoString);

		final String codigoCVV = request.getParameter("codigoCVV");
		final String nombreComercial = request.getParameter("nombreComercial");

		final Direccion dir = new Direccion();
		final int codigoP = Integer.parseInt(codigoPostal);
		dir.setDireccion(direccion);
		dir.setCodigoPostal(codigoP);

		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final String encodedPassword = this.encodePasswordMD5(password);

		final UserAccount userAccount = new UserAccount();
		userAccount.setUsername(username);
		userAccount.setPassword(encodedPassword);

		// Crear un nuevo objeto Authority basado en el valor de actorType
		final Authority authority = new Authority();
		authority.setAuthority(actorType);

		// Añadir la nueva autoridad a la colección de autoridades del usuario
		userAccount.getAuthorities().add(authority);

		// Realizar el registro del usuario aquí
		final UserAccount savedUserAccount = this.userService.save(userAccount);
		this.userService.flush();  // Asegurarte de que la transacción de la base de datos se complete

		if (actorType.equalsIgnoreCase("ALUMNO")) {
			final Alumno alumno = new Alumno();

			alumno.setNombre(nombre);
			alumno.setApellidos(apellidos);
			alumno.setEmail(email);
			alumno.setTelefono(telefono);
			alumno.setDireccion(dir);

			if (titular != "") {
				final TarjetaCredito tarjeta = new TarjetaCredito();
				tarjeta.setNumero(numero);
				tarjeta.setTitular(titular);
				tarjeta.setMarca(marca);

				if (año != 0)
					tarjeta.setAño(año);

				if (mes != 0)
					tarjeta.setMes(mes);

				tarjeta.setCodigoCVV(codigoCVV);
				final TarjetaCredito tarjetaSaved = this.tarjetaCreditoService.save(tarjeta);
				alumno.setTarjetaCredito(tarjetaSaved);
			}

			if (savedUserAccount != null)
				alumno.setCuentaUsuario(savedUserAccount);
			this.alumnoService.save(alumno);

		} else if (actorType.equalsIgnoreCase("ACADEMIA")) {
			final Academia academia = new Academia();

			if (!nombreComercial.equalsIgnoreCase(""))
				academia.setNombreComercial(nombreComercial);

			academia.setNombre(nombre);
			academia.setApellidos(apellidos);
			academia.setEmail(email);
			academia.setTelefono(telefono);
			academia.setDireccion(dir);

			if (savedUserAccount != null)
				academia.setCuentaUsuario(savedUserAccount);
			this.academiaService.save(academia);
		}
		final ModelAndView modelAndView = new ModelAndView("redirect:/security/login.do");
		return modelAndView;
	}

	private String encodePasswordMD5(final String password) {
		try {
			// Crear una instancia de MessageDigest para MD5
			final MessageDigest md = MessageDigest.getInstance("MD5");

			// Convertir la contraseña en bytes
			final byte[] passwordBytes = password.getBytes();

			// Calcular el hash de la contraseña
			final byte[] hashBytes = md.digest(passwordBytes);

			// Convertir el hash de bytes a una cadena hexadecimal
			final StringBuilder sb = new StringBuilder();
			for (final byte b : hashBytes)
				sb.append(String.format("%02x", b));

			return sb.toString();
		} catch (final NoSuchAlgorithmException e) {
			// Manejar la excepción si el algoritmo no está disponible
			e.printStackTrace(); // Otra forma de manejar la excepción según tus requerimientos
			return null;
		}
	}
}
