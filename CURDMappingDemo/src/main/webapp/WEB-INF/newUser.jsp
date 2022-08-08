<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<h2>Welcome to Save User Page</h2><br>
<hr>

<form:form action="saveUser" method="post" modelAttribute="userModel">
    <table>
        <tr>
            <td>User ID </td> <td> <form:input path="userId"/> </td>
            <td><form:errors path="userId"/></td>
        </tr>
        <tr>
            <td>User Name </td> <td> <form:input path="userName"/> </td>
            <td><form:errors path="userName"/></td>
        </tr>
        <tr>
           <td>User PhoneNO </td> <td> <form:input path="userMobileNo"/> </td>
           <td><form:errors path="userMobileNo"/></td>
        </tr>
        <tr>
           <td>User PassWord </td> <td> <form:input path="userPassWord"/> </td>
           <td><form:errors path="userPassWord"/></td>
        </tr>
        <tr>
            <td col span="2"> <input type="submit" value="SUBMIT"> </td>
        </tr>
    </table>
</form:form>