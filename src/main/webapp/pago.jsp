<%-- 
    Document   : pago
    Created on : 20/11/2014, 02:08:52 PM
    Author     : Rafael
--%>

<%@page import="pe.edu.bean.PartidoBean"%>
<%@page import="pe.edu.bean.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <%UsuarioBean usu = (UsuarioBean) request.getAttribute("usuario");%>
        <%PartidoBean p = (PartidoBean) request.getAttribute("partido");%>
        
    </head>
    <body>
        <div class="intro-header">
            <div class="row vertical-offset-100">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"> <%=usu.getNombre()%> por favor ingrese su información bancaria para pagar lo siguiente</h3>
                            <h4>Partido: <%=p.getId()%> </h4>
                            <h4>Fecha a realizarse: <%=p.getFechap()%> </h4>
                            <% if(p.getTurno() == 1){ %>
                            <h4>Turno: Mañana</h4>
                            <% }else if(p.getTurno() == 2){%>
                            <h4>Turno: Tarde</h4>
                            <% }else{ %>
                            <h4>Turno: Noche</h4>
                            <% } %>
                            <h4>Monto a pagar: s/.15</h4>
                        </div>
                        <div class="panel-body">
                            
                            <form method="post" action="PagarServlet">
                                <fieldset>
                                    <div class="form-group">
                                        <h4>Tarjeta de crédito/débito</h4>
                                        <input class="form-control" placeholder="tarjeta" name="tarjeta" type="text">
                                    </div>
                                    <div class="form-group">
                                        <h4>Password</h4>
                                        <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                    </div>
                                    <input type="hidden" name="partido" value="<%=p%>" />
                                    
                                    <%-- La simulación de pago siempre resulta en exito --%>
                                    <input class="btn btn-lg btn-success btn-block" type="submit" value="Pagar">
                                </fieldset>                                
                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </body>
</html>
