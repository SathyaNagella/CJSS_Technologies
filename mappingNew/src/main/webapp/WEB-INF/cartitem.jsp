<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<h2>Welcome to Products Page</h2>
${message}<br>
<table border="1">
    <tr>
        <th>cartId	</th>
        <th>name</th>
        <th>itemsId</th>
        <th>serialNumber</th>

    </tr>

    <c:if test="${!empty CarDelarsList}">
        <c:forEach items="${CarDelarsList}" var="product">
            <tr>
                <td> <c:out value="${product.itemsId}"/></td>
                <td><c:out value="${product.serialNumber}"/></td>
                <td><c:out value="${product.cart.cartId}"/></td>
                <td><c:out value="${product.cart.name}"/></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
