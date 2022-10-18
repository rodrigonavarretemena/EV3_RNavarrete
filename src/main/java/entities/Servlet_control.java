/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package entities;

//import Concecionaria.java;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rodri
 */
@WebServlet(name = "Servlet_control", urlPatterns = {"/Servlet_control"})
public class Servlet_control extends HttpServlet {

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
        
        
                //####################
        //1. recuperamos parametros
        String strMarca = request.getParameter("inputMarca").toString();
        String strModelo = request.getParameter("inputModelo").toString();
        String strAno = request.getParameter("inputAno").toString();
        String strColor = request.getParameter("inputColor").toString();
        String strKilo = request.getParameter("inputKilo").toString();
        
        
        
        //2. Ingreso de informacion a base de datos
        // creacion de clase entity
        // creacion de clase DAO
        // ejecucion de metodo CREATE
        
        
        
        
        //#############
        //se crea objeto Entity
        //Persona pers = new Persona();
        
        





//asignamos los valores que venian del formulario a los atributos del objeto ENTITY
        //alum.setId(Integer.parseInt(strID));
        //alum.setNombre(strNombre);
        //alum.setNotafinal(Integer.parseInt(strNotaFinal));
        
        
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>PROCESO</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>PROCESO jajaja" + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
