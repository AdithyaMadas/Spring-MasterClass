<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "com.madas.utils.Mappings" %>


<html>
<head>
    <title>Items List</title>
</head>
<body>
    <div align = "center">
        <c:url var = "addItemsLink" value="${Mappings.ADD_ITEM}"/>

        <h2>
            <a href ="${addItemsLink}">Add Items to List</a href>
        </h2>

        <table border = "1" cell-padding = "5">
            <caption> <h2> Todo Items </h2> </caption>

            <tr>
                <th>Title</th>
                <th> DeadLine </th>
                <th> View </th>
                <th> Edit </th>
                <th> Delete </th>
            </tr>

           <c:forEach var="item" items="${data123.items}">
                <c:url var = "deleteItem" value = "${Mappings.DELETE_ITEM}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>

                <c:url var = "editItem" value = "${Mappings.ADD_ITEM}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>

                <c:url var = "viewItem" value = "${Mappings.VIEW}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>

                <tr>
                    <td><c:out value = "${item.title}"/></td>
                    <td><c:out value = "${item.deadLine}"/></td>
                    <td><a href = "${viewItem}">View</a></td>
                    <td><a href = "${editItem}">Edit</a></td>
                    <td><a href = "${deleteItem}">Delete</a></td>

                </tr>
           </c:forEach>
        </table>
    </div>
</body>
</html>