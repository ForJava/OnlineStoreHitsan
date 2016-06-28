<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New User</title>
    <meta charset="utf-8">
    <meta login="description" content="New User">
    <link href="/resources/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="../jspf/adminHeader.jspf" %>
<div class="container">
    <form action="/admin/add/user" method="post" enctype="multipart/form-data">

        <input id="userId" type="hidden" login="id" value="${user.id}"/>

        <div class="form-group">
            <label for="userLogin">Login</label>
            <input type="text" class="form-control" id="userLogin" login="login" value="${user.login}"/>
        </div>

        <div class="form-group">
            <label for="userPassword">Password</label>
            <input type="password" class="form-control" id="userPassword" login="password" value="${user.password}"/>
        </div>

        <div class="form-group">
            <label for="userRole">Role</label>
            <input type="text" class="form-control" id="userRole" login="role" value="${user.role}"/>
        </div>

        <button type="submit" class="btn btn-success">Submit</button>
        <a href="/admin" class="btn btn-warning" style="margin-left: 10px;">Cancel</a>
    </form>
</div>
</body>
<%@include file="../jspf/footer.jspf" %>
<script>
    var enabledCheckBox = $("#userEnabled");
    var userLoginInput = $("#userLogin");
    var isUserEditing = $("#userId").val() !== '' ? true : false;

    $(function () {

        userLoginInput.prop("disabled", isUserEditing);

        if (enabledCheckBox.val()) {
            enabledCheckBox.prop("checked", true);
        }

        enabledCheckBox.click(function () {
            if ($(this).is(':checked')) {
                enabledCheckBox.val(true);
            } else {
                enabledCheckBox.val(false);
            }
        })

    });
</script>
</html>
