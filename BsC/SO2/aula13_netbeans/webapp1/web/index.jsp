<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Petição Pública</title>
        <link rel="stylesheet" href="estilo.css">
    </head>
    <body>
        <h1>Petição Pública!</h1>

        <h2>Por uma utilização racional da energia</h2>
        <p>O consumo exagerado de energia tem custos ecnonómicos e ambientais.
        Apague a luz sempre que possível...</p>
        
        <h2>Dar o Apoio</h2>
        <p>Se concorda com esta causa, deixe o seu nome na lista apoiantes:
        <br>
        <form name="formulario" action="registo" method="POST">
            Nome: <input type="text" name="nome" size="30">
            <input type="submit" value="assinar">    
        </form>
        </p>

        <h2>Apoiantes desta causa</h2>
        <p>Consulte aqui a <a href="lista">lista de pessoas</a> que estão de acordo com esta causa.</p>
        
        <hr>
        
        <!-- script JSP para mostrar o IP -->
        <% 
            out.println("<p>Origem do pedido: "
                +request.getRemoteAddr()+"</p>");
        %>

    </body>
</html>
