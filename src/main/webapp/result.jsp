
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <h3>${result}</h3>

    <img src="${resultImg}"/>
    <br>
    <form action="${pageContext.request.contextPath}/game" >
        <input type="submit" value="Попробовать снова" />
    </form>
</head>
<body>

</body>
</html>
