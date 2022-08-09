<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<h2>Welcome to Products Page</h2>
${message}<br>
${productMessage}<br>

<a href="curd">CRUD Page</a><br><br>
<a  href="Add SKU"> Add SKU </a> <br> <br>

<table border="1">
    <tr>
        <th>Product ID	</th>
        <th>Product Name</th>
        <th>Product  Category</th>
        <th>Product Brand</th>

        <th>Color	</th>
        <th>Size  </th>
        <th>Price </th>
        <th>Stock </th>
        <th>ID  </th>

        <th>UPDATE / DELETE </th>
    </tr>

    <c:if test="${!empty productsModelList}">
        <c:forEach items="${productsModelList}" var="product">
            <tr>
                <td> <c:out value="${product.productId}"/></td>
                <td><c:out value="${product.productName}"/></td>
                <td><c:out value="${product.productCategory}"/></td>
                <td><c:out value="${product.productBrand}"/></td>
                <td><c:out value="${product.skuEntity.skuColour}"/></td>
                <td><c:out value="${product.skuEntity.skuSize}"/></td>
                <td><c:out value="${product.skuEntity.skuPrice}"/></td>
                <td><c:out value="${product.skuEntity.skuStock}"/></td>
                 <td><c:out value="${product.skuEntity.skuId}"/></td>
                <td>
                    <a href="EDIT?editId=${product.productId}"> Edit Product/SKU </a>
                    <a href="deleteProduct?id=${product.productId}">Delete Product</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
