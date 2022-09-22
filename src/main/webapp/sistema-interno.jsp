<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Jogo" %>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Compra" %>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Venda" %>
<%@ page import="br.com.gamex.controlegamex.controller.JogoController" %>
<%@ page import="br.com.gamex.controlegamex.controller.CompraController" %>
<%@ page import="br.com.gamex.controlegamex.controller.VendaController" %>
<%@ page import="java.util.ArrayList" %>  
    
<jsp:include page="header-SI.jsp"/>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Home</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="sistema-interno">Home</a></li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

   <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">
          <h3 class="card-title">Jogos com baixo estoque</h3>

          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
              <i class="fas fa-minus"></i>
            </button>
            <button type="button" class="btn btn-tool" data-card-widget="remove" title="Remove">
              <i class="fas fa-times"></i>
            </button>
          </div>
        </div>
        <div class="card-body">
                    <table class="table">
                        <thead>
                          <tr>
                            <th scope="col">ID Pedido</th>
                            <th scope="col">Cliente</th>
                            <th scope="col">Jogo</th>
                            <th scope="col">Data</th>
                            <th scope="col">Gerir</th>
                          </tr>
                        </thead>
                        <tbody>
        <%
        			
          			JogoController jc = new JogoController();
          			ArrayList<Jogo> jogos = jc.ListarEstoqueBaixo(10);
          			int jindex = 0;
          			for (Jogo j: jogos) {
          				jindex++;
          		%>
                          <tr>
                            <th scope="row"><%= j.getId() %></th>
                            <td><%= j.getNome() %></td>
                            <td><%= j.getEstoque() %></td>
                            <td><%= j.getCriado_em() %></td>
                            <td>
                            <a href="IniciarCompra?id=<%= j.getId() %>">Repor</a> 
					</td>
                          </tr>
                          <% } %>
                        </tbody>
                      </table>
        </div>
        <div class="card-body">
          <div class="row">          

          </div>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
      
      <div class="card">
        <div class="card-header">
          <h3 class="card-title">Últimas vendas</h3>

          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
              <i class="fas fa-minus"></i>
            </button>
            <button type="button" class="btn btn-tool" data-card-widget="remove" title="Remove">
              <i class="fas fa-times"></i>
            </button>
          </div>
        </div>
        <div class="card-body">
                    <table class="table">
                        <thead>
                          <tr>
                            <th scope="col">ID Pedido</th>
                            <th scope="col">Cliente</th>
                            <th scope="col">Jogo</th>
                            <th scope="col">Data</th>
                          </tr>
                        </thead>
                        <tbody>
        <%
        			
          			VendaController vc = new VendaController();
          			ArrayList<Venda> vendas = vc.Listar(10);
          			int vindex = 0;
          			for (Venda v: vendas) {
          				vindex++;
          		%>
                          <tr>
                            <th scope="row"><%= v.getId() %></th>
                            <td><%= v.getCliente().getNome() %></td>
                            <td><%= v.getJogo().getNome() %></td>
                            <td><%= v.getCriado_em() %></td>
                          </tr>
                          <% } %>
                        </tbody>
                      </table>
        </div>
        <div class="card-body">
          <div class="row">          

          </div>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
      
      <div class="card">
        <div class="card-header">
          <h3 class="card-title">Últimas compras</h3>

          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
              <i class="fas fa-minus"></i>
            </button>
            <button type="button" class="btn btn-tool" data-card-widget="remove" title="Remove">
              <i class="fas fa-times"></i>
            </button>
          </div>
        </div>
        <div class="card-body">
                    <table class="table">
                        <thead>
                          <tr>
                            <th scope="col">ID Pedido</th>
                            <th scope="col">Fornecedor</th>
                            <th scope="col">Jogo</th>
                            <th scope="col">Data</th>
                          </tr>
                        </thead>
                        <tbody>
        <%
        			
          			CompraController cc = new CompraController();
          			ArrayList<Compra> compras = cc.Listar(10);
          			int cindex = 0;
          			for (Compra c: compras) {
          				cindex++;
          		%>
                          <tr>
                            <th scope="row"><%= c.getId() %></th>
                            <td><%= c.getFornecedor().getNome() %></td>
                            <td><%= c.getJogo().getNome() %></td>
                            <td><%= c.getCriado_em() %></td>
                          </tr>
                          <% } %>
                        </tbody>
                      </table>
        </div>
        <div class="card-body">
          <div class="row">          

          </div>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
      

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
