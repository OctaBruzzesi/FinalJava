<%-- 
    Document   : Cabecera
    Created on : 20-mar-2018, 17:27:46
    Author     : Augusto
--%>

<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% HttpSession sesion = request.getSession(true);%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../CSS/Cabecera.css">
        <link rel="shortcut icon" type="image/x-icon" href="https://upload.wikimedia.org/wikipedia/commons/b/bf/TfNSW_F.png">
    </head>
    <body>
           <% response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
           response.addHeader("Pragma", "no-cache");
           response.setDateHeader("Expires", 0);
           %>
           
           <header id="cabecera">		
		<a id="descripciones" href="#">

                    
			<span class="nombreSitio">Foro de Consultas - UTN - FRRo - Ingeniería en Sistemas de Información</span>
			<span class="datosAlumno">${usuario.tipo}: ${usuario.nombre} ${usuario.apellido}</span>
                        <span class="datosAlumno">Legajo: ${usuario.legajo}</span>                       
		</a>       
		<nav>
			<ul>
                                <li><a href="CerrarSesion">Cerrar Sesión</a></li>
			</ul>
		</nav>
	</header>
    </body>
</html>
