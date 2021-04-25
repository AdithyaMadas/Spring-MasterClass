<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "com.madas.utils.Mappings" %>
<%@ page import = "com.madas.utils.AttributeNames" %>


<html>
<head>
    <title>Items Data</title>
</head>
<body>
    <div align = "center">
        <c:url var = "itemsList" value="${Mappings.ITEMS}"/>

        <h2>
            <a href ="${itemsList}">View All Items</a href>
        </h2>

        <table border = "1" cell-padding = "5">
            <caption> <h2> Item </h2> </caption>

            <tr>
                <th> ID </th>
                <th> Title </th>
                <th> DeadLine </th>
                <th> Details </th>
            </tr>
                <tr>
                    <td>${item.id}</td>
                    <td>${item.title}</td>
                    <td>${item.deadLine}</td>
                    <td>${item.details}</td>
                </tr>
        </table>
    </div>
</body>
</html>