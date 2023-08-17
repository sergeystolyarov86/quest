
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Welcome to quest</title>
    <h3>Welcome UFO quest</h3>
    <img src="img/ufo.jpg"/>
    </head>

<br> <form action="${pageContext.request.contextPath}/game"  >
    <p>Введите имя игрока
        <input type="text" name="playerName" /></p>
    <input type="submit" value="Начать квест" />
</form>
<body>
</body>
</html>
