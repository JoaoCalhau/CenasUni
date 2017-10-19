/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so2.rest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joaoc
 */
public class PostSecondFase extends HttpServlet {
    
     NewJerseyClient client = new NewJerseyClient();
     
     public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Delete</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<ul>");
            out.println("<li><a href=\"index.html\"><font size=\"5\">Menu</font></a></li>");
            out.println("<li><a href=\"Listar\"><font size=\"5\">Listar</font></a></li>");
            out.println("<li><a class=\"active\" href=\"#responder\"><font size=\"5\">Responder</font></a></li>");
            out.println("<li><a href=\"media.html\"><font size=\"5\">Consultar Média</font></a></li>");
            out.println("<li><a href=\"Vezes\"><font size=\"5\">Consultar Vezes</font></a></li>");
            out.println("<li><a href=\"criar.html\"><font size=\"5\">Criar</font></a></li>");
            out.println("<li><a href=\"remover.html\"><font size=\"5\">Remover</font></a></li>");
            out.println("</ul>");
            out.println("<div Style=\"margin-left:25%; padding:1px 16px; height: 1000px;\">");
            String i = (String) request.getSession().getAttribute("index");
            int index = Integer.parseInt(i);
            ListaQuest l = new ListaQuest();
            l = client.getQuestList_JSON(l.getClass());
            QuestImpl q = l.getLista().get(index);
            switch (q.getPerg().size()) {
                case 3:
                    {
                        String ap1 = request.getParameter("ap1");
                        String ap2 = request.getParameter("ap2");
                        String ap3 = request.getParameter("ap3");
                        if(isInteger(ap1) && isInteger(ap2) && isInteger(ap3)) {
                            int r1 = Integer.parseInt(ap1);
                            int r2 = Integer.parseInt(ap2);
                            int r3 = Integer.parseInt(ap3);
                            if((r1 < 1 || r1 > 10) || (r2 < 1 || r2 > 10) || (r3 < 1 || r3 > 10)) {
                                out.println("<h1 align=\"center\">Resposta falhou... Por favor responda com numeros de 1 a 10</h1>");
                            } else {
                                q.addPergunta(0, r1);
                                q.addPergunta(1, r2);
                                q.addPergunta(2, r3);
                                client.updateAnswer(q);
                                out.println("<h1 align=\"center\">Questionário respondido com sucesso!</h1>");
                            }
                        } else {
                            out.println("<h1 align=\"center\">Resposta falhou... Por favor responda com numeros de 1 a 10</h1>");
                        }       break;
                    }
                case 4:
                    {
                        String ap1 = request.getParameter("ap1");
                        String ap2 = request.getParameter("ap2");
                        String ap3 = request.getParameter("ap3");
                        String ap4 = request.getParameter("ap4");
                        if(isInteger(ap1) && isInteger(ap2) && isInteger(ap3) && isInteger(ap4)) {
                            int r1 = Integer.parseInt(ap1);
                            int r2 = Integer.parseInt(ap2);
                            int r3 = Integer.parseInt(ap3);
                            int r4 = Integer.parseInt(ap4);
                            if((r1 < 1 || r1 > 10) || (r2 < 1 || r2 > 10) || (r3 < 1 || r3 > 10) || (r4 < 1 || r4 > 10)) {
                                out.println("<h1 align=\"center\">Resposta falhou... Por favor responda com numeros de 1 a 10</h1>");
                            } else {
                                q.addPergunta(0, r1);
                                q.addPergunta(1, r2);
                                q.addPergunta(2, r3);
                                q.addPergunta(3, r4);
                                client.updateAnswer(q);
                                out.println("<h1 align=\"center\">Questionário respondido com sucesso!</h1>");
                            }
                        } else {
                            out.println("<h1 align=\"center\">Resposta falhou... Por favor responda com numeros de 1 a 10</h1>");
                        }       break;
                    }
                default:
                    {
                        String ap1 = request.getParameter("ap1");
                        String ap2 = request.getParameter("ap2");
                        String ap3 = request.getParameter("ap3");
                        String ap4 = request.getParameter("ap4");
                        String ap5 = request.getParameter("ap5");
                        if(isInteger(ap1) && isInteger(ap2) && isInteger(ap3) && isInteger(ap4) && isInteger(ap5)) {
                            int r1 = Integer.parseInt(ap1);
                            int r2 = Integer.parseInt(ap2);
                            int r3 = Integer.parseInt(ap3);
                            int r4 = Integer.parseInt(ap4);
                            int r5 = Integer.parseInt(ap5);
                            if((r1 < 1 || r1 > 10) || (r2 < 1 || r2 > 10) || (r3 < 1 || r3 > 10) || (r4 < 1 || r4 > 10) || (r5 < 1 || r5 > 10)) {
                                out.println("<h1 align=\"center\">Resposta falhou... Por favor responda com numeros de 1 a 10</h1>");
                            } else {
                                q.addPergunta(0, r1);
                                q.addPergunta(1, r2);
                                q.addPergunta(2, r3);
                                q.addPergunta(3, r4);
                                q.addPergunta(4, r5);
                                client.updateAnswer(q);
                                out.println("<h1 align=\"center\">Questionário respondido com sucesso!</h1>");
                            }
                        } else {
                            out.println("<h1 align=\"center\">Resposta falhou... Por favor responda com numeros de 1 a 10</h1>");
                        }       break;
                    }
            }
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
