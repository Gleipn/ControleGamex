<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Compra" %>
<%@ page import="br.com.gamex.controlegamex.model.entidade.Venda" %>
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
          <h3 class="card-title"><strong>GAMEX</strong></h3>

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
          <div class="row">
            <div class="col-6 col-md-6 col-lg-4 order-2 order-md-1">
              <div class="row">
                <div class="col-12">
                  <h4>Últimas vendas adicionados</h4>
                  <%
          			VendaController vc = new VendaController();
          			ArrayList<Venda> vendas = vc.Listar(10);
          			int vindex = 0;
          			for (Venda v: vendas) {
          				vindex++;
          		%>
                    <div class="post <%= (vindex%2==0) ? "clearfix" : "" %>">
                      <div class="user-block">
                        <span>
                          <a href="#<%= v.getId() %>"><strong> <%= v.getJogo().getNome() %></strong></a>
                        </span>
                        <small class=""> - <%= v.getCriado_em() %></small>
                      </div>
                      <!-- /.user-block -->
                    </div>
                    <% } %>
                </div>
              </div>
            </div>
            <div class="col-6 col-md-6 col-lg-4 order-2 order-md-1">
              <div class="row">
                <div class="col-12">
                  <h4>Últimas compras adicionados</h4>
                  <%
          			CompraController cc = new CompraController();
          			ArrayList<Compra> compras = cc.Listar(10);
          			int cindex = 0;
          			for (Compra c: compras) {
          				cindex++;
          		%>
                    <div class="post <%= (cindex%2==0) ? "clearfix" : "" %>">
                      <div class="user-block">
                        <span>
                          <a href="#<%= c.getId() %>"><strong> <%= c.getJogo().getNome() %></strong></a>
                        </span>
                        <small class=""> - <%= c.getCriado_em() %></small>
                      </div>
                      <!-- /.user-block -->
                    </div>
                    <% } %>
                </div>
              </div>
            </div>
            <div class="col-12 col-md-12 col-lg-4 order-1 order-md-2">
              <h3 class="text-primary"><i class="fas fa-box-archive"></i> <strong>Senac</strong>|Stock</h3>
              <p class="text-muted">Lorem ipsum represents a long-held tradition for designers, typographers and the like. Some people hate it and argue for its demise, but others ignore.</p>
              <br>
              <div class="text-muted">
                <p class="text-sm">Sistema
                  <b class="d-block"><strong>Senac</strong>|Stock</b>
                </p>
                <p class="text-sm">Desenvolvedor
                  <b class="d-block">Senac Marechal Floriano</b>
                </p>
              </div>
            </div>
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
