<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<h2>Welcome to Save SKU Page</h2><br>
<hr>

<form:form action="saveSku" method="post" modelAttribute="SkuObj">
    <table>
        <tr>
            <td>SKU ID </td> <td> <form:input path="skuId"/> </td>
            <td><form:errors path="skuId"/></td>
        </tr>
        <tr>
            <td>Sku Color </td> <td> <form:input path="skuColour"/> </td>
            <td><form:errors path="skuColour"/></td>
        </tr>
        <tr>
           <td>Sku Size </td> <td> <form:input path="skuSize"/> </td>
           <td><form:errors path="skuSize"/></td>
        </tr>
        <tr>
           <td>Sku Price </td> <td> <form:input path="skuPrice"/> </td>
           <td><form:errors path="skuPrice"/></td>
        </tr>
        <tr>
           <td>Sku Stock </td> <td> <form:input path="skuStock"/> </td>
           <td><form:errors path="skuStock"/></td>
        </tr>
        <tr>
            <td col span="2"> <input type="submit" value="SUBMIT"> </td>
        </tr>
    </table>
</form:form>