/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaDatos.AccesoUsuario;
import Entidades.Usuario;
import Excepciones.ExcepcionBaseDeDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Augusto
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
            response.setContentType("text/html;charset=UTF-8");
            HttpSession sesion=request.getSession(true);
        try {

            int leg= Integer.parseInt(request.getParameter("legajo"));
            String cla= request.getParameter("contra");

            Usuario usuario;
            AccesoUsuario accesoUsuario = new AccesoUsuario();
            usuario = accesoUsuario.buscarUsuario(leg, cla);
            
            String retorno="ErrorLogueo.jsp";
            
            sesion.setAttribute("usuario",usuario);

                

                if(usuario.isHabilitado()){
                    if(usuario.getTipo().equals("alumno")  || usuario.getTipo().equals("profesor"))
                        retorno="CapaPresentacion/MenuMaterias.jsp";
                    else
                        retorno= "CapaPresentacion/Administrador.jsp";
                }
                else{
                    retorno = "CapaPresentacion/MensajeUsuarioInhabilitado.jsp";
                }
            
            response.sendRedirect(retorno);
         }

         catch (NumberFormatException ex) {
            request.setAttribute("descripcionExcepcion", "El legajo deben ser solo números.");
            getServletContext().getRequestDispatcher("/manejoExcepciones").forward(request,response);
        }
         catch(ExcepcionBaseDeDatos e){
            request.setAttribute("descripcionExcepcion", e.DescripcionError());
            getServletContext().getRequestDispatcher("/manejoExcepciones").forward(request,response);
         }
        catch(Exception e){
            request.setAttribute("descripcionExcepcion", "Se produjo un error inesperado.");
            getServletContext().getRequestDispatcher("/manejoExcepciones").forward(request,response);
        }
    }
       /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
