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
   <div id="novasenha-container">
       <h1>REDEFINIR SENHA</h1>
       <form action="/despensa/home?action=FrmLoginAction">
           <label for="email">E-mail</label>
           <input type="email" name="email" id="email" placeholder="Digite seu E-mail" autocomplete="off">
           <label for="password">Nova Senha</label>
           <input type="password" name="password" id="password" placeholder="Digite sua Nova Senha">
           <a href="/despensa/home?action=FrmLoginAction">
                <input type="submit" value="enviar email" > <!--cadastro-->
           </a>
           
       </form>
   </div> 




</body>
</html>