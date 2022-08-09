<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<h2>Welcome to Add Admin Page</h2>

<form:form action="saveAdmin" method="post" modelAttribute="adminModel">
    <table>
        <tr>
            <td>Admin ID </td> <td> <form:input path="adminId"/> </td>
            <td><form:errors path="adminId"/></td>
        </tr>
        <tr>
            <td>Admin Name </td> <td> <form:input path="adminName"/> </td>
            <td><form:errors path="adminName"/></td>
        </tr>
        <tr>
           <td>Admin PhoneNO </td> <td> <form:input path="adminMobileNo"/> </td>
           <td><form:errors path="adminMobileNo"/></td>
        </tr>
        <tr>
            <td col span="2"> <input type="submit" value="SUBMIT"> </td>
        </tr>
    </table>
</form:form>