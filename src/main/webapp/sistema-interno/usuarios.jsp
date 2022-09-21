<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Usuario" %>  
<%@ page import="br.com.gamex.controlegamex.controller.UsuarioController" %>
<%@ page import="java.util.ArrayList" %>

<jsp:include page="header-SI.jsp"/>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Usuarios</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="sistema-interno.jsp">Home</a></li>
              <li class="breadcrumb-item active">Usuarios</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card card-solid">
        <div class="card-body pb-0">
          <div class="text-right">
            <a href="cadastro-usuario.jsp" class="btn btn-link">
              <i class="fas fa-plus-circle"></i> Adicionar
            </a>
          </div>
          <div class="row">
          <%
          UsuarioController uc = new UsuarioController();
          ArrayList<Usuario> usuarios = uc.Listar(10);
          for (Usuario u: usuarios) {
          %>
            <div class="col-12 col-sm-6 col-md-4 d-flex align-items-stretch flex-column">
              <div class="card bg-light d-flex flex-fill">
                <div class="card-header text-muted border-bottom-0">
                  <%= u.getEmail() %>
                </div>
                <div class="card-body pt-0">
                  <div class="row">
                    <div class="col-7">
                      <h2 class="lead"><b><%= u.getNome() %></b></h2>
                      <p class="text-muted text-sm"><b>Criado em: </b> <%= u.getCriado_em() %> </p>
                      <ul class="ml-4 mb-0 fa-ul text-muted">
                      </ul>
                    </div>
                  </div>
                </div>
                <div class="card-footer">
                  <div class="text-right">
                    <a href="IniciarAlterarUsuario?id=<%= u.getId() %>" class="btn btn-sm btn-primary">
                      <i class="fas fa-boxes-stacked"></i> Editar
                    </a>
                    <a href="ExcluirUsuario?id=<%= u.getId() %>" class="btn btn-sm btn-danger"
                     onclick="return confirm('Deseja excluir esse registro?')">
                      <i class="fas fa-solid fa-trash"></i> Excluir

                    </a>
                  </div>
                </div>
              </div>
            </div>
            <% } %>
          </div>
        </div>
        <!-- /.card-body -->
        <div class="card-footer">
          <nav aria-label="Contacts Page Navigation">
            <ul class="pagination justify-content-center m-0">
              <li class="page-item active"><a class="page-link" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
            </ul>
          </nav>
        </div>
      </div>

    </section>
  </div>

  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 1.1.0
    </div>
    
  </footer>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="resources/js/adminlte.min.js"></script>
</body>
</html>