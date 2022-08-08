<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<h2>Welcome TO AddProduct Page</h2>
<br><hr>

<form:form action="saveProducts" method="post" modelAttribute="productModel">
    <table>
        <tr>
            <td>Product ID </td> <td> <form:input path="productId"/> </td>
            <td><form:errors path="productId"/></td>
        </tr>
        <tr>
            <td>Product Name </td> <td> <form:input path="productName"/></td>
            <td><form:errors path="productName"/></td>
        </tr>
        <tr>
            <td>Product Category </td><td> <form:input path="productCategory"/></td>
             <td><form:errors path="productCategory"/></td>
        </tr>
        <tr>
            <td>Product Brand</td> <td> <form:input path="productBrand"/></td>
            <td><form:errors path="productBrand"/></td>
        </tr>
        <tr>
            <td col span="2"> <input type="submit" value="SUBMIT"> </td>
        </tr>
    </table>
</form:form>


