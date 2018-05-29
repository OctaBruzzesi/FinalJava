<%--
Document   : MenuConsultas
Created on : 28-feb-2018, 21:54:01
Author     : mica_
--%>

<%@page import="Entidades.Usuario"%>
<%@page import="CapaNegocio.CN_Usuario"%>
<%@page import="CapaNegocio.CN_Materias"%>
<%@page import="CapaNegocio.CN_Consultas"%>
<%@page import="Entidades.Materia"%>
<%@page import="java.sql.SQLException"%>
<%@page import="Excepciones.ExcepcionBaseDeDatos"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesion = request.getSession(true);%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Listado de Consultas</title>
            <link rel="stylesheet" href="materialize/css/materialize.css">
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link rel="stylesheet" href="CSS/MenuConsultas.css">
            <jsp:include page="Cabecera.jsp" />
                    </head>
                    <body>
           <%
                  try{
                        /*response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                        response.addHeader("Pragma", "no-cache");
                        response.setDateHeader("Expires", 0);
                        if(sesion.getAttribute("legajo") == null){
                        request.setAttribute("descripcionExcepcion", "Primero debes iniciar sesión.");
                        getServletContext().getRequestDispatcher("/SesionNoIniciada").forward(request,response);}
                        */

                        CN_Materias cnMateria = new CN_Materias();
                        String cod = request.getParameter("n");
                        int cod_materia = Integer.parseInt(cod);
                        Materia materia = cnMateria.buscarMateriaPorCodigo(cod_materia);
                                             
                        sesion.setAttribute("materia", materia);
                        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
                        
                        if((usuario.getTipo()).equals("alumno")){
                            System.out.println("ALOHA");
                        %>
                        <form method="post" action="NuevoTema.jsp">
                            <button type="submit" class="botonNuevaConsulta">Nueva Consulta</button>
                        </form>
                        <%
                        }
                        %>
                        <p align="center"><b>Listado de Consultas</b>
                        <h3 align="center"><%=materia.getNombre()%> </h3></p>

                        <div class="collapsible" data-collapsible="accordion">

                            <%

                        CN_Consultas cnConsulta = new CN_Consultas();
                        ResultSet consultas = cnConsulta.mostrarConsultas(materia.getCodMteria());

                        while (consultas.next())
                        {
                            String titulo = consultas.getString("titulo");
                            String cuerpo = consultas.getString("cuerpo");
                            String respuesta = consultas.getString("respuesta");
                            String imagen = consultas.getString("imagen");
                            Integer legajoAlumno = consultas.getInt("legajoAlumno");
                            Integer legajoProfesor = consultas.getInt("legajoProfesor");

                            CN_Usuario cnUsuario = new CN_Usuario();
                            Usuario alumno = cnUsuario.buscarUsarioSinClave(legajoAlumno);

                            Usuario profesor = cnUsuario.buscarUsarioSinClave(legajoProfesor);

                            %>

                            <li class="respuesta">
                                <div class="collapsible-header">
                                    <span><i class="material-icons">message</i><%=titulo%></span>
                                    <div class="autor"><i class="material-icons">person</i><%=alumno.getNombre()%> <%=alumno.getApellido()%>, <%=alumno.getLegajo()%></div>
                                </div>
                                <div class="cajacuerpo collapsible-body">
                                    <div class="cuerpo"><%=cuerpo%></div>

                                    <% if (imagen != null){ %>
                                    <img src="<%=imagen%>"  />
                                    <% }%>
                                </div>

                                    <%   if (respuesta.equals(""))
                                    {
                                        respuesta="No hay respuesta aún";
                                    }
                                    else
                                    %>
                                    <div class="cajarespuesta collapsible-body">
                                        <% if(profesor.getNombre() != null) {
                                            %><span>Respuesta por el profesor <%=profesor.getNombre()%> <%=profesor.getApellido()%></span>

                                        <% }
                                        %>
                                        <div class="res"><%=respuesta%>

                                            <%
                                                int codConsulta = consultas.getInt(1);
                                                if(sesion.getAttribute("usuario.tipo").equals("profesor") && respuesta.equals("No hay respuesta aún")){ //&& materiaProfesor.validarProfesorMateria(usuario.getLegajo(), materia.getCodMteria())) {
                                            %>
                                                    <form action="/tp_consultas/ResponderTema?n=<%=codConsulta%>" method="POST" align="center">
                                                        <textarea placeholder="Ingrese texto" name="respuesta" required="true"></textarea>
                                                        <button class="waves-effect waves-light btn botonResponder">Responder</button>
                                                    </form>
                                            <%
                                                sesion.setAttribute("codTema", codConsulta);
                                                }

                                            %>

                                        </div>
                                    </div>
                            </li>
                            <%
                        }
                }catch(ExcepcionBaseDeDatos e) {
                    request.setAttribute("descripcionExcepcion", e.DescripcionError());
                    getServletContext().getRequestDispatcher("/manejoExcepciones").forward(request,response);
                }
                catch(IllegalStateException e){
                    request.setAttribute("descripcionExcepcion", "Primero debes iniciar sesión.");
                    getServletContext().getRequestDispatcher("/manejoExcepciones").forward(request,response);
                }
                catch(Exception e){
                    request.setAttribute("descripcionExcepcion", "Se produjo un error inesperado.");
                    getServletContext().getRequestDispatcher("/manejoExcepciones").forward(request,response);
                }
                        %>
                    </div>

                    <p align="center" class="boton-volver"><a href="/tp_consultas/MenuMaterias.jsp">Volver</a></p>

                    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
                    <script src="Javascript/materialize.js"></script>
                    <script src="Javascript/MenuMaterias.js"></script>
                </body>
            </html>
