<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Denied</title>
    </head>
    <body>
        <h1>${pageContext.request.userPrincipal.name}, Bạn không có quyền truy cập!!!</h1>
        <a href="logon">Back</a>
    </body>
</html>