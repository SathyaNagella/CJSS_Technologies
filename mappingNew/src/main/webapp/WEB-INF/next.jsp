<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<h2>Welcome to Cart List Page</h2>
${message}<br>
${productMessage}<br><hr>
<a href="AddCart">AddCart</a><br><br>
<table border="1">
    <tr>
        <th>Cart ID</th>
        <th>Cart Name</th>
        <th>Add Items</th>
    </tr>

    <c:if test="${!empty cartList}">
        <c:forEach items="${cartList}" var="cart">
            <tr>
                <td> <c:out value="${cart.cartId}"/></td>
                <td><c:out value="${cart.name}"/></td>
                 <td>
                      <a href="AddItems?cartId=${cart.cartId}"> Add Items </a>
                 </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
