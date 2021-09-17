<%--
  Created by IntelliJ IDEA.
  User: evgenijsvetasev
  Date: 16.09.2021
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@page import="ru.appline.logic.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1>Домашняя страница по работе с пользоавтелями</h1>
  Введите ID пользователя (0 - для ввывода всего списка пользователей)
  <br/>

  Доступно: <%

  Model model = Model.getInstance();
  out.print(model.getFromList().size());
  %>
  <form method="get" action="get">
    <label >ID:
      <input type="text" name="id"><b/>
    </label>
    <button type="submit">Поиск</button><br/>
  </form>
  <a href="addUser.html">Создать нового пользователя</a>
  </body>
</html>
