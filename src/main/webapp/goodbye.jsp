<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Goodbye</title>
</head>
<body>
<%
    String username = request.getParameter("username");
%>
<p>Goodbye <%= username != null ? username : "Guest" %></p>
</body>
</html>