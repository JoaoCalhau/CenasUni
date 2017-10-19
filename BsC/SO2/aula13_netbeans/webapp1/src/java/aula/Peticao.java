/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joaoc
 */
public class Peticao extends HttpServlet {
    
    static List<String> nomes;
    
    public void init() {
        if (nomes == null)
            nomes = new LinkedList();
    }
    
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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Peticao</title>");
            out.println("<link rel=\"stylesheet\" href=\"estilo.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Peticao at " + request.getContextPath() + "</h1>");
            String novoNome = request.getParameter("nome");
            if (novoNome != null) {
                out.println("<p> Obrigado pelo seu apoio, Sr(a) <i>" + novoNome + "</i></p>");
                nomes.add(novoNome);
                out.println("<i>neste momento já temos " + nomes.size() + " apoiantes</i>");
            } else if (request.getRequestURI().endsWith("/lista")) {
                out.println("<h3>Lista de Apoiantes</h3>");
                for (int i = 0; i < nomes.size(); i++) {
                    String codeHTML = " - <i>" + nomes.get(i) + "</i><br>";
                    out.println(codeHTML);
                }
            }
            out.println("<p> </p>");
            out.println("<a href=\"javascript: history.go(-1)\">voltar</a>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
