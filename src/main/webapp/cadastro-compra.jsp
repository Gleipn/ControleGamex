<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Jogo" %>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Fornecedor" %>
<%@ page import="br.com.gamex.controlegamex.controller.JogoController" %>
<%@ page import="br.com.gamex.controlegamex.controller.FornecedorController" %>
<%@ page import="java.util.ArrayList" %>

<jsp:include page="header-SI.jsp"/>

	<%
		Jogo j = (Jogo) request.getAttribute("jogo");
	%>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Realizar compra</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="sistema-interno.jsp">Home</a></li>
              <li class="breadcrumb-item"><a href="jogos.jsp">Jogos</a></li>
              <li class="breadcrumb-item active">Comprar jogo #<%= j.getId() %></li>
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
              <p class="lead mb-5">Cadastre um jogo</p>
            </div>
          </div>
          <div class="col-7">
          <form id="produtoform" action="CadastrarCompra" method="post">
          <input type="hidden" name="inputJogo" value="<%= j.getId() %>" />
                <div class="form-group">
                  <label for="idNome">Nome</label>
                  <input type="text" id="idNome" name="inputNome" class="form-control" readonly value="<%= j.getNome()%>">
                </div>
                <div class="form-group">
                  <label for="idCategoria">Categoria</label>
                  <input type="text" id="idCategoria" name="inputCategoria" class="form-control" readonly value="<%= j.getCategoria()%>">
                </div>
                <div class="form-group">
                  <label for="idDesenvolvedor">Desenvolvedor</label>
                  <input type="text" id="idDesenvolvedor" name="inputDesenvolvedor" class="form-control"  readonly value="<%= j.getDesenvolvedor()%>">
                </div>
                <div class="form-group">
                  <label for="idValor">Valor de Compra</label>
                  <input type="number" step="any" id="idValor" name="inputValorCompra"  class="form-control" value="">
                </div>
                <div class="form-group">
                  <label for="idValor">Valor de Venda</label>
                  <input type="number" step="any" id="idValor" name="inputValorVenda"  class="form-control" value="">
                </div>
                <div class="form-group">
                  <label for="idEstoque">Quantidade</label>
                  <input type="number" step="any" id="idEstoque" name="inputEstoque"  class="form-control" value="">
                </div>
                <div class="form-group">
                  <label for="idFornecedor">Fornecedor</label>
                  <select id="idFornecedor" name="inputFornecedor" class="form-control custom-select">
                    <option selected disabled>Selecione</option>
                   <%
          			FornecedorController fc = new FornecedorController();
          			ArrayList<Fornecedor> fornecedores = fc.Listar(10);
          			for (Fornecedor f: fornecedores) {
          			%>
                   
                    <option value="<%= f.getId() %>" ><%= f.getNome() %></option>
                  
                  <% } %>
                  </select>
                </div>
                
                <!-- <div class="form-group">
                  <label for="statusId">Status do jogo</label>
                  <select id="statusId" name="inputStatus" class="form-control custom-select">
                    <option disabled>Selecione</option>
                    <option value="1" selected>Ativo</option>
                    <option value="0">Inativo</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="inputDescription">Descrição do jogo</label>
                  <textarea id="inputDescription" name="inputDescricao" class="form-control" rows="4"></textarea>
                </div> -->
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
