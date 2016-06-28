<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>Hitsan Registration Page</title>
    <meta charset="utf-8">
    <meta name="description" content="HomePage">
    <link href="../resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../resources/css/datatables.min.css" rel="stylesheet">
</head>

<body>
<%@include file="../jspf/header.jspf" %>
<div class="container">
    <h1>Добро пожаловать! Пожалуйста, заполните форму:</h1>
<form action="/registration/customer" class="form-horizontal" method="POST">
    <input type="hidden" name="id" value="${users.id}">
    <div class="form-group">
        <label for="login" class="col-sm-2 control-label">Ваш логин:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="login" name="login" style="width: 530px" placeholder="Логин">
        </div>
    </div>
    <div class="form-group">
        <label for="pass" class="col-sm-2 control-label">Придумайте пароль:</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="pass" name="pass" style="width: 530px" placeholder="Пароль">
        </div>
    </div>
    <div class="form-group">
        <label for="mail" class="col-sm-2 control-label">Електронная почта:</label>
        <div class="col-sm-10">
            <input type="email" class="form-control" id="mail" name="mail" style="width: 530px" placeholder="Email">
        </div>
    </div>
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Ваше имя:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="name" name="name" style="width: 530px" placeholder="Имя">
        </div>
    </div>
    <div class="form-group">
        <label for="phone" class="col-sm-2 control-label">Ваш моб. телефон:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="phone" name="phone" style="width: 530px" placeholder="Телефон">
        </div>
    </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Зарегистрироваться</button>
            </div>
        </div>
</form>
</div>

</body>
<%@include file="../jspf/footer.jspf" %>
</html>
