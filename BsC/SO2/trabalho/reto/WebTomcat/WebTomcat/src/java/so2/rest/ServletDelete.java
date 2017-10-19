/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so2.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel Reto
 */
public class ServletDelete extends HttpServlet {

    NewJerseyClient njc = new NewJerseyClient();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletDelete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p></p>");
            
            // apagar um questionario
            ListQuest list = new ListQuest();
            list = njc.getQuestList_JSON(list.getClass());
            ArrayList<Questionarios> cenas = list.getListQuest();
            if(cenas.size()==0){
                out.println("<h1>"+"Nao existem questionários"+"</h1>");
            }
            String c = request.getParameter("deletecenas");
            for(Questionarios p: cenas){
                String a = ""+p.getNumQuest()+"";
                if(a.equals(c)){
                    System.out.println("cenas");
                    njc.deleteQuestList(a);
                    out.println("<h2>A apagar:</h2>");
                    out.println("<p>" + p.getNomeQuest() + "</p>");
                }
            }
            out.println("<p></p>\n" +
"        <button onclick=\"goBack()\">Back to the past now</button>\n" +
"        <script>\n" +
"            function goBack(){\n" +
"                window.history.back();\n" +
"            }\n" +
"        </script>");
            
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
