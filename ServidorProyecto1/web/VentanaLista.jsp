<%-- 
    Document   : VentanaLista
    Created on : 27/08/2016, 04:25:42 PM
    Author     : jerduar
--%>

<%!
    public int factorial(int num) {
        if (num == 0) {
            return 1;
        } else if (num < 0) {
            return -1;
        } else {
            return num * factorial(num - 1);
        }
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lienzos Web</title>
    </head>
    <body background="/home/jerduar/Escritorio/fondo.jpg">
        <h1><s>Cálculo del factoria</s>l</h1>
        <form action="VentanaLista.jsp" method="get">
            <p>Número: <input type="text" name="num">
                <input type="submit" value="Calcular"></p>
        </form>

        <%
            String num = request.getParameter("num");
            if (num != null) {
                out.println(factorial(Integer.parseInt(num)));
            }
            
        %>

    </body>
</html>
