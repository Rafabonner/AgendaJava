<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
    <%@ page import="com.despensa.model.Usuario" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="preconnect" href="https://fonts.googleapis.com">

    <title>Login</title>
    <!-- <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css"
    /> -->
    <link rel="stylesheet" href="css/styles.css" />
    
    <!-- <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> -->
  </head>

  <body>
    <div id="login-container">
      <img id="logo" src="img/bolsa-de-compras.png" alt="">
      <h1>Login</h1>
      <form method="post" action="auth">
       <input type="hidden" name="action" value="LoginAction">
        
        <label for="email">E-mail</label>
        <input
          type="email"
          name="email"
          id="email"
          placeholder="Digite seu e-mail"
          autocomplete="off"
        />
        <label for="password">Senha</label>
       
        <input
          type="password"
          name="password"
          id="password"
          placeholder="Digite sua senha"
        />
       <!--   <a href="/despensa/home?action=FrmEsqSenhaAction" id="forgot-pass">Esqueceu a senha?</a>-->

      
          <input id="submit" type="submit" value="Login" />
      
        <!-- <input id="submit" type="submit" value="Login" /> -->
      </form>
      <div id="register-container">
        <p>Ainda não tem uma conta?</p>
        <a href="/despensa/restrito?action=FrmCadastroAction">Registrar</a>
      </div>
      <!-- <script src="../script/login.js"></script> -->
    </div>
  </body>
</html>
    