<%-- 
    Document   : loguin
    Created on : 19/11/2014, 09:59:29 PM
    Author     : GooMoonRyong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ingrese</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="cssbosti/bootstrap.min.css" rel="stylesheet">

        <link href="css/landing-page.css" rel="stylesheet">

<%
    
    String sesion = (String) request.getSession(true).getAttribute("sesion");

    if(sesion != null){
        
         RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
         rd.forward(request, response);
        
    }
        
%>
        
        
    </head>
    <body>
        <div class="intro-header">
            <div class="row vertical-offset-100">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Ingrese</h3>
                        </div>
                        <div class="panel-body">
                            <form method="post" action="LoginServlet">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Usuario" name="usuario" type="text">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                    </div>
                                    <!--
                                        <div class="checkbox">
                                        <label>
                                    <!--input name="remember" type="checkbox" value="Remember Me"> Recuerdame
                            </label>
                        </div>
                                    -->
                                    <input class="btn btn-lg btn-success btn-block" type="submit" value="Ingresar">
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </body>
</html>

