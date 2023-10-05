<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css">
    <link rel="stylesheet" href="css/stylesCadrasto.css">
</head>

<body>
   <div id="cadastro-container">
       <h1>Cadastro</h1>
       <form action="home" method="post">
       
       <input type="hidden" name="action" value="InserirUsuarioAction">
            <label for="nome">Nome</label>
            <input type="nome" name="nome" id="nome" placeholder="Digite seu Nome" autocomplete="off">
           <label for="email">E-mail</label>
           <input type="email" name="email" id="email" placeholder="Digite seu E-mail" autocomplete="off">
           <label for="password">Senha</label>
           <input type="password" name="senha" id="senha" placeholder="Digite sua Senha">
          
                <input type="submit" value="cadastro" >
       
       </form>
   </div> 




</body>
</html>