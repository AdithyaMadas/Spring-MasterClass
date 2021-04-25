<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "com.madas.utils.Mappings" %>

<html>
<head>
    <title>Todo Application</title>
</head>
<body>
    <div align = "center">
        <c:url var = "itemsLink" value="${Mappings.ITEMS}"/>
        <h2>
            <a href ="${itemsLink}">Show todo Items</a href>
        </h2>
    </div>
</body>
</html>