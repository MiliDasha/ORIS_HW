<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Добавление пользователей</title>
</head>
<body style="padding: 20px; font-family: sans-serif;">

<h1>Добавление пользователей</h1>
<p style="color:red;"><c:out value="${error}"/></p>

<form method="post" action="${pageContext.request.contextPath}/save">
    <input type="hidden" name="count" value="${count}">

    <c:forEach begin="0" end="${count - 1}" var="i">
        <fieldset style="margin-bottom: 16px; padding: 12px; border: 1px solid #ccc; border-radius: 6px;">
            <legend><strong>Пользователь ${i + 1}</strong></legend>
            <p>Имя: <input type="text" name="name_${i}" required></p>
            <p>Фамилия: <input type="text" name="surname_${i}" required></p>
            <p>Возраст: <input type="number" name="age_${i}" min="0" max="150" required></p>
            <p>Email: <input type="email" name="email_${i}" required></p>
            <p>Город: <input type="text" name="city_${i}" required></p>
            <p>Телефон: <input type="text" name="phone_${i}" required></p>
        </fieldset>
    </c:forEach>

    <div style="margin: 20px 0 40px 0;">
        <button type="submit" style="padding: 10px 24px; font-size: 16px; font-weight: bold; cursor: pointer; background-color: #28a745; color: white; border: none; border-radius: 4px;">
            Сохранить всех пользователей
        </button>
    </div>
</form>

</body>
</html>