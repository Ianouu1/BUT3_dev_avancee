<%@ page import="com.example.but3_dev_avancee.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Page1</title>
</head>
<body>
<a href="logout-action.do">Logout</a> <br/>
<%
    User user = (User) session.getAttribute("user");
    if (user != null) {
%>
<p>Welcome <%= user.getUsername() %></p>
<p>Attribut 2 : <%= user.getAttribute2() %></p>
<p>Attribut 3 : <%= user.getAttribute3() %></p>
<%
    }
%>

<form action="actionUn.do" method="post">
    <label for="attribute2">Attribut 2 : </label>
    <input type="text" id="attribute2" name="attribute2" required>
    <br/>
    <label for="attribute3">Attribut 3 : </label>
    <input type="text" id="attribute3" name="attribute3" required>
    <br/>
    <input type="submit" value="ok">
</form>

</body>
</html>