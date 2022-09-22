<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Fornecedor" %>  
<%@ page import="br.com.gamex.controlegamex.controller.FornecedorController" %>

<jsp:include page="header-SI.jsp"/>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Fornecedor</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="home">Home</a></li>
              <li class="breadcrumb-item active">Cadastro de Fornecedor</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-body row">
          <div class="col-5 text-center d-flex align-items-center justify-content-center">
            <div class="">
              <h2>GAMEX<strong></strong></h2>
              <p class="lead mb-5">Cadastre um fornecedor</p>
              	<%
				if (request.getAttribute("erro") != null){
				 %>
	 			<p> <%= request.getAttribute("erro") %> </p>
	 
	 			<% } %>
            </div>
          </div>
          <div class="col-7">
            <form action="CadastrarFornecedor" method="post">
              <div class="form-group">
                <label for="idNome">CNPJ</label>
                <input type="text" id="idNome" name="inputCnpj" class="form-control" />
                <label for="idNome">Nome</label>
                <input type="text" id="idNome" name="inputNome" class="form-control" />
                <label for="idNome">Endereço</label>
                <input type="text" id="idNome" name="inputEndereco" class="form-control" />
                <label for="idNome">Email</label>
                <input type="text" id="idNome" name="inputEmail" class="form-control" />
              </div>
              <div class="form-group">
                <button type="submit" class="btn btn-dark">Cadastrar</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

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