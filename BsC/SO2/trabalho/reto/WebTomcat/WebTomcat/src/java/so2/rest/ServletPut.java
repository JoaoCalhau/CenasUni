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
public class ServletPut extends HttpServlet {

    NewJerseyClient njc = new NewJerseyClient();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPut</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Adicionar um novo Questionário</h1>");
            
            ListQuest list = new ListQuest();
            list = njc.getQuestList_JSON(list.getClass());
            ArrayList<Questionarios> cenas = list.getListQuest();
            
            String nome = request.getParameter("adicionarcenas");
            int num = Integer.parseInt(request.getParameter("quantidade"));
            Pergunta q1 = new Pergunta(request.getParameter("questao1"));
            Pergunta q2 = new Pergunta(request.getParameter("questao2"));
            Pergunta q3 = new Pergunta(request.getParameter("questao3"));
            Pergunta q4 = new Pergunta(request.getParameter("questao4"));
            Pergunta q5 = new Pergunta(request.getParameter("questao5"));
            out.println("<p>"+num+"</p>");
            ArrayList<Pergunta> pergs = new ArrayList<>();
            if(num == 3){
                pergs.add(q1);
                pergs.add(q2);
                pergs.add(q3);
            }
            else if(num == 4){
                pergs.add(q1);
                pergs.add(q2);
                pergs.add(q3);
                pergs.add(q4);
            }
            else if(num == 5){
                pergs.add(q1);
                pergs.add(q2);
                pergs.add(q3);
                pergs.add(q4);
                pergs.add(q5);
            }
            if(pergs.size()>=3 && pergs.size()<=5){
                out.println("<p>"+"bodegas"+"</p>");
                Questionarios quest = new Questionarios(nome,pergs);
                njc.putQuestList_JSON(quest,"0");
                out.println("<p></p>\n" +
"        <button onclick=\"goBack()\">Back to the past now</button>\n" +
"        <script>\n" +
"            function goBack(){\n" +
"                window.history.back();\n" +
"            }\n" +
"        </script>");
            }
            else{
                out.println("<h2>Os questionarios teem de ter entre 3 a 5 perguntas...</h2>");
                out.println("<p></p>\n" +
"        <button onclick=\"goBack()\">Back to the past now</button>\n" +
"        <script>\n" +
"            function goBack(){\n" +
"                window.history.back();\n" +
"            }\n" +
"        </script>");
            }
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
