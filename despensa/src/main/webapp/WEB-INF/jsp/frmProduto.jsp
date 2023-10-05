<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
    <%@ page import="com.despensa.model.Categoria" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Produtos</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css">
    <link rel="stylesheet" href="css/stylesCadrasto.css">
</head>

<body>
   <div id="cadastro-container">
       <h1>Cadastro de Produtos</h1>
       <form action="restrito" method="post">
         <input type="hidden" name="action" value="InserirProdutoAction">
            <label for="nome">Nome do Produto</label>
            <input type="nome" name="nome_prod" id="nome" placeholder="Digite o Nome do Produto" autocomplete="off">

           <label for="date">Data de Validade</label>
           <input type="date" name="validade" id="validade" placeholder="Selecione a Validade do Produto" autocomplete="off">
           
           <label for="ean">Codigo de Barra</label>
           <input type="nome" name="ean" id="ean" placeholder="Digite o codigo de Barra" autocomplete="off">	

           <label for="local">Local de Armazenamento</label><br>
           <select name="armazenamento" id="armazenamento">           
            <c:forEach var="armazenamento" items="${listaDeArmazem}"> 
                <option value="${armazenamento.id}">${armazenamento.getDescri_local()}</option>     
              </c:forEach>
                  </select>
          	    	<br><br>

            <label for="categoria">Categoria</label><br>
             <select name="categoria" id="categoria">
            <c:forEach var="categoria" items="${listaDeCategorias}"> 
                <option value="${categoria.id}">${categoria.getDescri_categ()}</option>     
              </c:forEach>
                  </select><br><br>
          
           <label for="quantity">Qual a quantidade?</label>
           <input type="number" name="quant" id="quant" min="1" max="100" placeholder="Digite a quantidade " autocomplete="off">
   			<input type="submit" value="adicionar" >
          <!--     <a href="/despensa/restrito?action=HomeAction">
                <input type="submit" value="adicionar" >
           </a>-->
       </form>
   </div> 
  



</body>
</html>