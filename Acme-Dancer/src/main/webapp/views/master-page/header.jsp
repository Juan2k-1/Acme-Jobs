<%--
 * header.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div>
	<a href="#"><img src="images/logo.png" alt="Acme Dancer Co., Inc." /></a>
</div>

<div>
	<ul id="jMenu">
		<!-- Do not forget the "fNiv" class for the first level links !! -->

		<security:authorize access="hasRole('ADMIN')">
			<li><a class="fNiv"><spring:message
						code="master.page.administrator" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="administrator/estadisticas.do"><spring:message
								code="master.page.administrator.estadisticas" /></a></li>
					<li><a href="administrator/gestionEstilos.do"><spring:message
								code="master.page.administrator.estilos" /></a></li>
				</ul></li>
		</security:authorize>

		<security:authorize access="hasRole('ACADEMIA')">
			<li><a class="fNiv"><spring:message
						code="master.page.academy" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="course/CMCurso.do"><spring:message
								code="master.page.academy.CMCurso" /></a></li>
					<li><a href="tutorial/mostrarTutoriales.do"><spring:message
								code="master.page.academy.action.1" /></a></li>
					<li><a href="academy/gestionSolicitudes.do"><spring:message
								code="master.page.academy.gestionSolicitudes" /></a></li>
				</ul></li>
		</security:authorize>

		<security:authorize access="hasRole('ALUMNO')">
			<li><a class="fNiv"><spring:message code="master.page.alumn" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="alumno/misSolicitudes.do"><spring:message
								code="master.page.alumn.action.1" /></a></li>
					<li><a href="alumno/solicitarCurso.do"><spring:message
								code="master.page.alumn.action.2" /></a></li>
				</ul></li>
		</security:authorize>

		<security:authorize access="isAnonymous()">
			<li>
                <nav class="horizontal-nav">
                    <a href="academy/gestionAcademia.do" class="hover-link"> <spring:message
                            code="master.page.academies" />
                    </a> <a href="course/gestionCursos.do" class="hover-link"> <spring:message
                            code="master.page.courses" />
                    </a> <a href="style/gestionEstilos.do" class="hover-link"> <spring:message
                            code="master.page.styles" />
                    </a>
                </nav>
            </li>

			<li><a class="fNiv hover-link" href="security/login.do"><spring:message
						code="master.page.login" /></a></li>
		</security:authorize>

		<security:authorize access="isAuthenticated()">

			<li>
				<nav class="horizontal-nav">
					<a href="academy/gestionAcademia.do" class="hover-link"> <spring:message
							code="master.page.academies" />
					</a> <a href="course/gestionCursos.do" class="hover-link"> <spring:message
							code="master.page.courses" />
					</a> <a href="style/gestionEstilos.do" class="hover-link"> <spring:message
							code="master.page.styles" />
					</a>
				</nav>
			</li>

			<li>
				<a class="fNiv"> <spring:message code="master.page.profile" /> (<security:authentication
						property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="profile/editarDatos.do"><spring:message
								code="master.page.profile.editarDatos" /></a></li>
					<li><a href="j_spring_security_logout"><spring:message
								code="master.page.logout" /> </a></li>
				</ul>
			</li>
		</security:authorize>
	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>

