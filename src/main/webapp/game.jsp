<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
<h1>UFO quest</h1>
<img src="${img}"/>
<h3>  ${currentQuestion}  </h3>

<form name="myForm" action="${pageContext.request.contextPath}/game" method="post">
    <br><input  type="radio" name="answer"
               value="${positiveAnswer}"  />
    ${positiveAnswer}
    <br><input type="radio" name="answer"
               value= "${negativeAnswer}" />
    ${negativeAnswer}
    <p><input type="submit" name="submit" value="Ответить" /></p>
</form>


<h3>Статистика </h3>
<h3>IP address: ${ip}  </h3>
<h3>Имя в игре: ${playerName} </h3>
<h3>Количество игр:${countGames} </h3>
</body>
</html>
