<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<h2>Welcome TO Add Items Page</h2>
<br><hr>



<form:form action="saveItems" method="post" modelAttribute="itemsModel">
    <table>
        <tr>
            <td>items ID </td> <td> <form:input path="itemsId"/> </td>
            <td><form:errors path="itemsId"/></td>
        </tr>
        <tr>
            <td>serial Number </td> <td> <form:input path="serialNumber"/></td>
            <td><form:errors path="serialNumber"/></td>
        </tr>
        <tr>
            <td col span="2"> <input type="submit" value="SUBMIT"> </td>
        </tr>
    </table>
</form:form>


