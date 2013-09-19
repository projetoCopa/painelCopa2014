<%-- 
    Document   : index
    Created on : 15/07/2013, 00:09:01
    Author     : Pimenta
--%>


<%
       if (request.getServerPort() != -1) {
            response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/painel/painelCopa.jsp");
        } else {
            response.sendRedirect(request.getScheme() + "://" + request.getServerName() + request.getContextPath() + "/painel/painelCopa.jsp");
        }
%> 


<%--  INDEX COM LOGIN:
<%
    session = ((HttpServletRequest) request).getSession();
    if (session.getAttribute("user") != null) {
        if (request.getServerPort() != -1) {
            response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/painel/painelCopa.jsp");
        } else {
            response.sendRedirect(request.getScheme() + "://" + request.getServerName() + request.getContextPath() + "/painel/painelCopa.jsp");
        }
    } 
%>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="index.css" rel="stylesheet" type="text/css" /> 

        <title>Página de Login</title>
    </head>
    <body>

        <div id="cabecalhoMinisterio">
            <div class="containerVisPublicaPage">
                <a href="http://www.brasil.gov.br" id="linkBrasil" target="_blank" ></a>
                <a href="http://www.acessoainformacao.gov.br" id="linkAcessoInformacao" target="_blank" ></a>
            </div>
        </div>

        <div class="boxLogin">       
            <form action="Login" method="post">

                <div class="boxLog">
                    <span>Login</span>
                    <input type="text" name="login">
                </div><br class="clear" />
                <div class="boxSenha"> 
                    <br/>
                    <span>Senha</span>
                    <input type="password" name="pass">
                </div><br class="clear" /> 
                <div class="boxButton">
                    <input class="buttonLogin" type="submit" value="Entrar"/>
                    <input class="buttonLogin" type="reset" value="Limpar"/>
                </div>
                <br class="clear"/>
        </div>
    </form>
</div>    
</body>
</html>

--%>




