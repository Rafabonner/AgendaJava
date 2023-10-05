<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
    <%@ page import="com.despensa.model.Produto" %>
    <%@ page import="com.despensa.actions.restrito.FrmAtualizarProdutoAction" %>
     <%@ page import="com.despensa.actions.restrito.AtualizarProdutoAction" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Atualizar Produto</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css">
    <link rel="stylesheet" href="css/stylesCadrasto.css">
</head>

<body>


 
   <div id="cadastro-container">
       <h1>Atualizar Produto</h1>
       <form action="restrito" method="post" >
 		<input type="hidden" name="action" value="AtualizarProdutoAction">
 		<input type="hidden" name="cod_prod" value="${produto.id}">
 		
         <input type="hidden" name="action" value="InserirProdutoAction">
            <label for="nome">Nome do Produto</label>
            <input type="nome" name="nome_prod" id="nome_prod" value="${produto.nome_prod}" >

           <label for="date">Data de Validade</label>
           <input type= "date" 
                name="validade" 
                id="validade"
                value="<fmt:formatDate pattern="yyyy-MM-dd" value="${produto.getValidade().getTime()}" />"
                >
           
           <label for="ean">Codigo de Barra</label>
           <input type="nome"
                name="ean" 
                id="ean"
                value="${produto.ean}"
                >

           <label for="quantity">Qual a quantidade?</label>
           <input type="text"
              name="quant" 
              id="quant" 
              value="${produto.quant}"
              >
   			<input type="submit" value="Atualizar">
          <!--     <a href="/despensa/restrito?action=HomeAction">
                <input type="submit" value="adicionar" >
           </a>-->
       </form>
   </div> 
  



</body>
</html>