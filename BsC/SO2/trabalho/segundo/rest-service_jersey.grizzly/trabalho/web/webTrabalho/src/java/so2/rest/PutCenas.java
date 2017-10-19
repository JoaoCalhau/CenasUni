package so2.rest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PutCenas extends HttpServlet {
    
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
            out.println("<li><a href=\"media.html\"><font size=\"5\">Consultar Média</font></a></li>");
            out.println("<li><a href=\"Vezes\"><font size=\"5\">Consultar Vezes</font></a></li>");
            out.println("<li><a class=\"active\" href=\"#criar\"><font size=\"5\">Criar</font></a></li>");
            out.println("<li><a href=\"remover.html\"><font size=\"5\">Remover</font></a></li>");
            out.println("</ul>");
            out.println("<div Style=\"margin-left:25%; padding:1px 16px; height: 1000px;\">");
            out.println("<h1 align=\"center\"></h1>");
            String n = request.getParameter("nomeq");
            String quant = request.getParameter("quant");
            String n1 = request.getParameter("nomep1");
            String n2 = request.getParameter("nomep2");
            String n3 = request.getParameter("nomep3");
            String n4 = request.getParameter("nomep4");
            String n5 = request.getParameter("nomep5");
            if(isInteger(quant)) {
                int qi = Integer.parseInt(quant);
                QuestImpl q = new QuestImpl(n);
                switch (qi) {
                    case 3:
                        q.addPergunta(n1);
                        q.addPergunta(n2);
                        q.addPergunta(n3);
                        client.addQuest(q);
                        out.println("<h1 align=\"center\">Questionario criado</h1>");
                        break;
                    case 4:
                        q.addPergunta(n1);
                        q.addPergunta(n2);
                        q.addPergunta(n3);
                        q.addPergunta(n4);
                        client.addQuest(q);
                        out.println("<h1 align=\"center\">Questionario criado</h1>");
                        break;
                    case 5:
                        q.addPergunta(n1);
                        q.addPergunta(n2);
                        q.addPergunta(n3);
                        q.addPergunta(n4);
                        q.addPergunta(n5);
                        client.addQuest(q);
                        out.println("<h1 align=\"center\">Questionario criado</h1>");
                        break;
                    default:
                        out.println("<h1 align=\"center\">Só serão aceites questionários entre 3 a 5 perguntas</p>");
                        break;
                }
            } else {
                out.println("<h1 align=\"center\">Só serão aceites questionários entre 3 a 5 perguntas</p>");
            }
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
