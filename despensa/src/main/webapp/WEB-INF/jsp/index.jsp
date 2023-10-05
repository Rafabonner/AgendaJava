<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
    <%@ page import="com.despensa.model.Produto" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/stylesIndex.css">
<title>Despensa</title>
<link href="Bootstrap/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia&effect=neon|outline|emboss|shadow-multiple">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


	<div id="header">
		<input type="checkbox" id="chec"> <label id="btn-menu"
			for="chec"> <img src="img/menu.png">
		</label>

		<h1 id="titulo" >Despensa</h1>

		<nav>
			<div>
				<img id="foto-perfil" src="img/perfil.png" alt="perfil">
				<h3 id="nome-familia">Nome da Pessoa</h3>
			</div>

			<ul id="menuu">
				<li><a href="/despensa/home?action=FrmLoginAction">Sair</a></li>
			</ul>
		</nav>
	</div>

	<div class="container">
	<div id="site">
            <div id="conteudo">
              <div id="conteudo-left" >
                <!--<h2>Role de noticias</h2>-->
                    <div class="container">
                      <!--<h2>Carousel Example</h2>-->  
                      <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                          <li data-target="#myCarousel" data-slide-to="1"></li>
                          <li data-target="#myCarousel" data-slide-to="2"></li>
                          <li data-target="#myCarousel" data-slide-to="3"></li>
                          <li data-target="#myCarousel" data-slide-to="4"></li>
                          <li data-target="#myCarousel" data-slide-to="5"></li>
                          <li data-target="#myCarousel" data-slide-to="6"></li>
                          <li data-target="#myCarousel" data-slide-to="7"></li>
                          <li data-target="#myCarousel" data-slide-to="8"></li>
                        </ol>
                    
                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                          <div class="item active">
                            <img src="img/promocoes/promo1.png" alt="promo1" style="width: 350px;">
                          </div>
                    
                          <div class="item">
                            <img src="img/promocoes/promo2.png" alt="promo2" style="width: 350px;" >
                          </div>
                        
                          <div class="item">
                            <img src="img/promocoes/promo3.png" alt="promo3" style="width: 350px;">
                          </div>

                          <div class="item">
                            <img src="img/promocoes/promo4.png" alt="promo4" style="width: 350px;">
                          </div>

                          <div class="item">
                            <img src="img/promocoes/promo5.png" alt="promo5" style="width: 350px;">
                          </div>

                          <div class="item">
                            <img src="img/promocoes/promo6.png" alt="promo6" style="width: 350px;">
                          </div>

                          <div class="item">
                            <img src="img/promocoes/promo7.png" alt="promo7" style="width: 350px;">
                          </div>

                          <div class="item">
                            <img src="img/promocoes/promo8.png" alt="promo8" style="width: 350px;">
                          </div>

                          <div class="item">
                            <img src="img/promocoes/promo9.png" alt="promo9" style="width: 350px;">
                          </div>
                        </div>
                    
                        <!-- Left and right controls -->
                      <!--<a class="left carousel-control" href="#myCarousel" data-slide="prev">
                          <span class="glyphicon glyphicon-chevron-left"></span>
                          <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">
                          <span class="glyphicon glyphicon-chevron-right"></span>
                          <span class="sr-only">Next</span>
                        </a>-->
                      </div>
                    </div>


              </div>
              <div id="conteudo-right">
                <h2>O que tem na sua Casa</h2>
                
                <div id="divBusca">	
                  <img src="img/lupa.png" alt="Buscar..."/>
                  <input type="text" id="txtBusca" placeholder="Buscar..."/>
                  <button id="btnBusca">Buscar</button>
                </div>
                
                  <table>
			 <tr>
			   <th>Nome Produto</th>
			   <th>Quantidade</th>
			   <th>Vencimento</th>
			   <th colspan="2">Ações</th> 
			   
			   <c:forEach var="produto" items="${listaDeProdutos}">
			   <tr>
			    <td>${produto.getNome_prod()}</td>
			    <td>${produto.getQuant()}</td>
			   
			    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${produto.getValidade().getTime()}" /></td>
			   <td><a href="?action=FrmAtualizarProdutoAction&id=${produto.getId()}">Editar</a></td>
			  <td><a href="?action=FrmExcluirProdutoAction&id=${produto.getId()}" 
			           onclick="return confirm('Confirma a exclusão?')">Excluir</a></td>
			   </tr>
			   </c:forEach>
			 </tr>
			</table>
                
                
                
                
              </div>

               
                <div id="btn-adicionar"> 
                <a href="/despensa/restrito?action=FrmProdutoAction">
                  <img src="img/adicionar-ao-carrinho.png">
                </a>
                </div>           

            </div>
</div>