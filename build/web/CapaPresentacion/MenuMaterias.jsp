<%--
    Document   : MenuMaterias
    Created on : 28/02/2018, 18:23:13
    Author     : octas
--%>
<%@page import="CapaNegocio.CN_Materias"%>
<%@page import="Excepciones.ExcepcionBaseDeDatos"%>
<%@page import="java.sql.ResultSet"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado De Materias</title>

        <link rel="stylesheet" href="../CSS/MenuMaterias.css">
        <jsp:include page="Cabecera.jsp" />

    </head>
    <body>
        <% /*response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
           response.addHeader("Pragma", "no-cache");
           response.setDateHeader("Expires", 0);
           HttpSession sesion = request.getSession(true);
           if(sesion.getAttribute("legajo") == null){
                request.setAttribute("descripcionExcepcion", "Primero debes iniciar sesión.");
                getServletContext().getRequestDispatcher("/SesionNoIniciada").forward(request,response);
        }*/%>


        <%  
            ResultSet mat = null;
            CN_Materias cnMaterias = new CN_Materias(); 
            try{
                mat = cnMaterias.mostrarMateriasHabilitadas(); 

        %>

         <table class="materias" align="center" border="3" title="Listado de Materias">
            <caption><b>Listado de Materias</b></caption>
            <tr>
                <th>NOMBRE</th>
                <th>AÑO</th>
            </tr>

            <%
                int codMateria, año;
                String nombre;

                while(mat.next()){
                codMateria = mat.getInt(1);
                nombre = mat.getString(2);
                año = mat.getInt(3);

            %>
                <tr>
                    <td><a href="MenuConsultas.jsp?n=<%=codMateria%>"> <%=nombre%></a></td>
                    <td><%=año%></td>
                </tr>
            <%
                   }
            }catch(ExcepcionBaseDeDatos e){
                request.setAttribute("descripcionExcepcion", e.DescripcionError());
                getServletContext().getRequestDispatcher("/manejoExcepciones").forward(request,response);
            }
            catch(Exception e){
                request.setAttribute("descripcionExcepcion", "Se produjo un error inesperado.");
                getServletContext().getRequestDispatcher("/manejoExcepciones").forward(request,response);
            }
            %>
        </table>
    </body>
</html>
