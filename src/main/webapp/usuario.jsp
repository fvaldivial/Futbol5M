<%-- 
    Document   : index
    Created on : 08/09/2014, 01:40:43 PM
    Author     : GooMoonRyong
--%>

<%@page import="pe.edu.bean.PartidoBean"%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.bean.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="cssbosti/bootstrap.min.css" rel="stylesheet">

        <link href="css/mine.css" rel="stylesheet">

        <%UsuarioBean usu = (UsuarioBean) request.getAttribute("usuario");%>

        <%---  ---%>

        <% List b = usu.getPartidos();%>

        <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

        <title> Pagina de <%= usu.getUsuario()%> </title>
    </head>
    <body>

        <div class="container">
            <div class="row">

                <div class="col-md-6">
                    <div class="panel with-nav-tabs panel-info">
                        <div class="panel-heading">
                            
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#tab1info" data-toggle="tab">Editar perfil</a></li>
                                
                                <li><a href="InscServlet?usuario=<%=usu.getUsuario()%>">Crear Partido</a></li>
                                <li class="dropdown">
                                    <a href="#" data-toggle="dropdown">Inscripcion<span class="caret"></span></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="PartidoServlet?usuario=<%=usu.getUsuario()%>">Forma normal</a></li>
                                        <li><a href="PartInsServlet?usuario=<%=usu.getUsuario()%>">Forma solidaria</a></li>
                                    </ul>
                                </li>
                                <li><a href="index.html" >Salir</a></li>
                            </ul>
                            
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="intro-header">



            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title"><%= usu.getNombre()%></h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3 col-lg-3 " align="center">
                                <img alt="User Pic" src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQPPpGPpBU-CeawafyfRtPZZ8bHvSlKfks3aqf3ZMkrrz8QXXF8FQ" class="img-circle" width="130px" height ="100px "> </div>

                            <div class=" col-md-9 col-lg-9 "> 
                                <table class="table table-user-information">
                                    <tbody>
                                        <tr>
                                            <td>DNI :</td>
                                            <td><%= usu.getDni()%></td>
                                        </tr>
                                        <tr>
                                            <td>Telefono :</td>
                                            <td><%= usu.getTelefono()%></td>
                                        </tr>

                                        <% for (int i = 0; i < b.size(); i++) {%>

                                        <tr>
                                            <td>id : <%= ((PartidoBean) b.get(i)).getId() %> </td>
                                            <td>cancha : <%= ((PartidoBean) b.get(i)).getCancha() %></td>
                                            <td> <a href="CancelarServlet?usuario=<%=usu.getUsuario()%>&partido=<%=((PartidoBean) b.get(i)).getId()%>" class="btn btn-primary">salir de partido</a></td>
                                        </tr>

                                        <%}%>

                                        <tr>
                                            <td>Fecha de Nacimiento : </td>
                                            <td>30/01/1994</td>
                                        </tr>

                                        <tr>
                                            <td>Email : </td>
                                            <td><%= usu.getEmail()%></td>
                                        </tr>

                                        <tr>
                                        <tr>
                                            <td>Direccion : </td>
                                            <td><%= usu.getDireccion()%></td>
                                        </tr>
                                    </tbody>
                                </table>

                                <a href="#" class="btn btn-primary">Modificar datos</a>
                                         <a href="index.html" class="btn btn-primary">Salir a inicio</a>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </div>           

</div>
</body>
</html>
