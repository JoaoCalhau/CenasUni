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
public class GetMedia extends HttpServlet {
    
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
            out.println("<li><a href=\"responder.html\"><font size=\"5\">Responder</font></a></li>");
            out.println("<li><a class=\"active\" href=\"#media\"><font size=\"5\">Consultar Média</font></a></li>");
            out.println("<li><a href=\"Vezes\"><font size=\"5\">Consultar Vezes</font></a></li>");
            out.println("<li><a href=\"criar.html\"><font size=\"5\">Criar</font></a></li>");
            out.println("<li><a href=\"remover.html\"><font size=\"5\">Remover</font></a></li>");
            out.println("</ul>");
            out.println("<div Style=\"margin-left:25%; padding:1px 16px; height: 1000px;\">");
            String s = request.getParameter("index");
            if(isInteger(s)) {
                int index = Integer.parseInt(s);
                ListaQuest l = new ListaQuest();
                l = client.getQuestList_JSON(l.getClass());
                if(!(index+1 > l.getLista().size())) {
                    QuestImpl q = l.getLista().get(index);
                    out.println("<h1 align=\"center\">Média das perguntas do Questionário \"" + q.getNome() + "\"</h1>");
                    int j = 1;
                    for(PergQuest p : q.getPerg()) {
                        if(p.getRespostas() == 0 || p.getTotal() == 0) {
                            out.println("<p><font size=\"4\">" + j + "-" + p.getNome() + ": 0.0</font></p>");
                        } else {
                            double d = (double)p.getRespostas()/(double)p.getTotal();
                            out.println("<p><font size=\"4\">" + j + "-" + p.getNome() + ": " + d + "</font></p>");
                            j++;
                        }
                    }
                } else {
                    out.println("<h1 align=\"center\">Indice não aceite</h1>");
                }
            } else {
                out.println("<h1 align=\"center\">Indice não aceite</h1>");
            }
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
