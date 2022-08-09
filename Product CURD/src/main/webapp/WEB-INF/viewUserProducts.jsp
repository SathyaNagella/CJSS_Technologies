<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<h2>${message}</h2><br><br>

<a href="start">Home</a><br><br>
<a href="ordersPage">Orders Page</a><br><br>
    <div align="right">
        <form action="searchProducts" method="post">
            Enter Product Category :<input type="text" name="productCategory"/><br>
            <input type="submit" value=" SEARCH "/>
        </form>
    </div>
<table border="1">
    <tr>
        <th>Product ID	</th>
        <th>Product Name</th>
        <th>Product Category</th>
        <th>Product Brand</th>
        <th>Color</th>
        <th>Size  </th>
        <th>Price </th>
        <th>Stock </th>
        <th>ID  </th>
        <th>Select Order</th>
    </tr>

    <c:if test="${!empty userModelList}">
        <c:forEach items="${userModelList}" var="productList">
            <tr>
                <td> <c:out value="${productList.productId}"/></td>
                <td><c:out value="${productList.productName}"/></td>
                <td><c:out value="${productList.productCategory}"/></td>
                <td><c:out value="${productList.productBrand}"/></td>
                <td><c:out value="${productList.skuEntity.skuColour}"/></td>
                <td><c:out value="${productList.skuEntity.skuSize}"/></td>
                <td><c:out value="${productList.skuEntity.skuPrice}"/></td>
                <td><c:out value="${productList.skuEntity.skuStock}"/></td>
                 <td><c:out value="${productList.skuEntity.skuId}"/></td>
                 <td>
                  <a href="placeOrder?orderId=${productList.productId}">Place Order</a>
                  </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
