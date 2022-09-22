<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Cliente" %>
<%@ page import="br.com.gamex.controlegamex.controller.ClienteController" %>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Venda" %>
<%@ page import="br.com.gamex.controlegamex.controller.VendaController" %>
<%@ page import="java.util.ArrayList" %>
<%
		Cliente c = (Cliente) session.getAttribute("clienteLogado");
%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>Gamex</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- bootstrap css -->
      <link rel="stylesheet" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" href="css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <!-- Style do perfil -->
      <link rel="stylesheet" href="css/perfil.css">
      <!-- fevicon -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
   </head>
   <!-- body -->
   <body class="main-layout inner_posituong contact_page">
      <!-- loader  -->
      <div class="loader_bg">
         <div class="loader"><img src="images/loading.gif" alt="#" /></div>
      </div>
      <!-- end loader -->
      <!-- header -->
      <header>
         <!-- header inner -->
         <div class="header">
            <div class="container-fluid">
               <div class="row">
                  <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
                     <div class="full">
                        <div class="center-desk">
                           <div class="logo">
                              <a href="index.html"><img src="images/GAMEX-sem-fundo.png" class="gamex-logo" alt="Gamex" /></a>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                     <nav class="navigation navbar navbar-expand-md navbar-dark ">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarsExample04">
                           <ul class="navbar-nav mr-auto">
                              <li class="nav-item">
                                 <a class="nav-link" href="index.html">Home</a>
                              </li>
                              <li class="nav-item">
                                 <a class="nav-link" href="about.html">About</a>
                              </li>
                              <li class="nav-item">
                                 <a class="nav-link" href="computer.html">Computer</a>
                              </li>
                              <li class="nav-item">
                                 <a class="nav-link" href="laptop.html">Laptop</a>
                              </li>
                              <li class="nav-item">
                                 <a class="nav-link" href="product.html">Products</a>
                              </li>
                              <li class="nav-item">
                                 <a class="nav-link" href="contact.html">Contact Us</a>
                              </li>
                              <li class="nav-item d_none">
                                 <a class="nav-link" href="#"><i class="fa fa-search" aria-hidden="true"></i></a>
                              </li>
                             <%
    							if (session.getAttribute("clienteLogado") == null){ 
    							%>
    							<li class="nav-item d_none">
                                    <a class="nav-link" href="login.jsp">Login</a>
                                 </li>
    							<% } else {%>
                               <li class="nav-item d_none">
                               <a class="nav-link" href="LocalizarCliente?id=<%= c.getId() %>">Perfil <i class="fa fa-user" aria-hidden="true"></i></a>
                            </li>
                               <li class="nav-item d_none">
                               <a class="nav-link" href="LogoutCliente">Sair</a>
                            </li>
    						<% } %>
                           </ul>
                        </div>
                     </nav>
                  </div>
               </div>
            </div>
         </div>
      </header>

      <main>

        <section class="perfil">
            <div class="perfil-header">
                <h2 class="perfil-h2">Usuário <i class="fa fa-user" aria-hidden="true"></i></h2>
                <div class="info-usuário" style="display: flex; align-items: center;">
                    <img class="foto-usuario" src="./images/user00.jpg">
                    <h3 class="nome-usuario"><%= c.getNome() %></h3>
                    <span>ID: <%= c.getId() %></span>
                </div>
                </div>
        </section>
        
        <section class="pedidos">
            <div class="pedidos-box">
                <h2 class="perfil-h2">Pedidos <i class="fa fa-truck" aria-hidden="true"></i></h2>
                <div class="pedidos-tabela">
                    <table class="table">
                        <thead>
                          <tr>
                            <th scope="col">ID Pedido</th>
                            <th scope="col">Jogo</th>
                            <th scope="col">Data</th>
                          </tr>
                        </thead>
                        <tbody>
        <%
        			long idcliente = c.getId();
          			VendaController vc = new VendaController();
          			ArrayList<Venda> vendas = vc.ListarPorCliente(idcliente, 10);
          			int vindex = 0;
          			for (Venda v: vendas) {
          				vindex++;
          		%>
                          <tr>
                            <th scope="row"><%= v.getId() %></th>
                            <td><%= v.getJogo().getNome() %></td>
                            <td><%= v.getCriado_em() %></td>
                          </tr>
                          <% } %>
                        </tbody>
                      </table>
                </div>
            </div>
        </section>
      </main>



      <footer>
        <div class="footer">
           <div class="container">
              <div class="row">
                 <div class="col-xl-3 col-lg-3 col-md-6 col-sm-6">
                    <img class="logo1" src="images/GAMEX-sem-fundo.png" alt="#"/>
                    <ul class="social_icon">
                       <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                       <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                       <li><a href="#"><i class="fa fa-linkedin-square" aria-hidden="true"></i></a></li>
                       <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                    </ul>
                 </div>
                 <div class="col-xl-3 col-lg-3 col-md-6 col-sm-6">
                    <h3>About Us</h3>
                    <ul class="about_us">
                       <li>dolor sit amet, consectetur<br> magna aliqua. Ut enim ad <br>minim veniam, <br> quisdotempor incididunt r</li>
                    </ul>
                 </div>
                 <div class="col-xl-3 col-lg-3 col-md-6 col-sm-6">
                    <h3>Contact Us</h3>
                    <ul class="conta">
                       <li>dolor sit amet,<br> consectetur <br>magna aliqua.<br> quisdotempor <br>incididunt ut e </li>
                    </ul>
                 </div>
                 <div class="col-xl-3 col-lg-3 col-md-6 col-sm-6">
                    <form class="bottom_form">
                       <h3>Newsletter</h3>
                       <input class="enter" placeholder="Enter your email" type="text" name="Enter your email">
                       <button class="sub_btn">subscribe</button>
                    </form>
                 </div>
              </div>
           </div>
           <div class="copyright">
              <div class="container">
                 <div class="row">
                    <div class="col-md-12">
                       <p>© 2019 All Rights Reserved. Design by<a href="https://html.design/"> Free Html Templates</a></p>
                    </div>
                 </div>
              </div>
           </div>
        </div>
     </footer>
      <!-- end footer -->
      <!-- Javascript files-->
      <script src="js/jquery.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.bundle.min.js"></script>
      <script src="js/jquery-3.0.0.min.js"></script>
      <!-- sidebar -->
      <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
      <script src="js/custom.js"></script>
   </body>
</html>