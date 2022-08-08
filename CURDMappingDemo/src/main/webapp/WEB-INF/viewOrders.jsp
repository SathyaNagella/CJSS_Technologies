<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<h2>Welcome to Orders Page</h2>
${message}<br>
${productMessage}<br><hr>
<a href="ordersPage">Orders Page</a><br><br>
<table border="1">
    <tr>
        <th>Order ID</th>
        <th>Product ID</th>
        <th>User ID</th>
        <th>Order Qty</th>
        <th>Order Status</th>

        <th> Delete Order </th>
    </tr>

    <c:if test="${!empty orderProductList}">
        <c:forEach items="${orderProductList}" var="order">
            <tr>
                <td> <c:out value="${order.orderId}"/></td>
                <td><c:out value="${order.productId}"/></td>
                <td><c:out value="${order.userId}"/></td>
                <td><c:out value="${order.orderQty}"/></td>
                <td><c:out value="${order.orderStatus}"/></td>
                <td>
                    <a href="deleteOrder?orderId=${order.orderId}"> Delete Order </a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
