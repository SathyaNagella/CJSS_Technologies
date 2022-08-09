<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>


<form:form action="saveCustomers" method="post" modelAttribute="customerModel">
    <table>
        <tr>
            <td>Customer ID </td> <td> <form:input path="cusId"/> </td>
            <td><form:errors path="cusId"/></td>
        </tr>
        <tr>
            <td>Customer First Name </td> <td> <form:input path="cusFirstName"/></td>
            <td><form:errors path="cusFirstName"/></td>
        </tr>
        <tr>
            <td>Customer Last Name </td><td> <form:input path="cusLastName"/></td>
             <td><form:errors path="cusLastName"/></td>
        </tr>
        <tr>
            <td>Customer Email</td> <td> <form:input path="cusEmail"/></td>
            <td><form:errors path="cusEmail"/></td>
        </tr>
        <tr>
            <td>Customer MobileNo</td> <td><form:input path="cusMobileNo"/></td>
            <td><form:errors path="cusMobileNo"/></td>
        </tr>
        <tr>
               <td>Customer City</td> <td><form:input path="cusCity"/></td>
                <td><form:errors path="cusCity"/></td>
        </tr>
        <tr>
            <td colspan="2"> <input type="submit" value="SUBMIT"> </td>
        </tr>
    </table>
</form:form>
