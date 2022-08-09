<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<h2>Welcome to Add Cart Page</h2>

<form:form action="saveCart" method="post" modelAttribute="cartModel">
    <table>
        <tr>
            <td>Cart ID </td> <td> <form:input path="cartId"/> </td>
            <td><form:errors path="cartId"/></td>
        </tr>
        <tr>
            <td>Cart Name </td> <td> <form:input path="name"/> </td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td col span="2"> <input type="submit" value="SUBMIT"> </td>
        </tr>
    </table>
</form:form>