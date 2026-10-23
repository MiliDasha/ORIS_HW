<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Поиск пользователей</title>
</head>
<body>
<h1>Поиск пользователей (WHERE)</h1>

<form method="get" action="${pageContext.request.contextPath}/select">
    <label>Поле поиска:
        <select name="field">
            <option value="email">Email</option>
            <option value="city">Город</option>
            <option value="phone">Телефон</option>
        </select>
    </label>
    <label>Значение: <input name="value" required></label>
    <button type="submit">Найти</button>
</form>

<hr>
<h3>Консольный вывод:</h3>
<pre style="background: #f4f4f4; padding: 12px; border: 1px solid #ccc; font-family: monospace;">
<c:choose>
    <c:when test="${empty users}">
Ничего не найдено (или введите запрос выше).
    </c:when>
    <c:otherwise>
<c:forEach items="${users}" var="u">
${u}
</c:forEach>
    </c:otherwise>
</c:choose>
</pre>

<br>
<a href="${pageContext.request.contextPath}/save">Добавить пользователей</a>
</body>
</html>