<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<a  href="add Customers"> Add Customers </a> <br> <br>

<table border="1">
    <tr>
        <th>Customer ID	</th>
        <th>Customer First Name</th>
        <th>Customer Last Name</th>
        <th>Customer Email</th>
        <th>Customer MobileNo</th>
        <th>Customer City</th>
        <th>Edit/Delete</th>
    </tr>

    <c:if test="${!empty customerModelList}">
        <c:forEach items="${customerModelList}" var="cus">
            <tr>
                <td> <c:out value="${cus.cusId}"/></td>
                <td><c:out value="${cus.cusFirstName}"/></td>
                <td><c:out value="${cus.cusLastName}"/></td>
                <td><c:out value="${cus.cusEmail}"/></td>
                <td><c:out value="${cus.cusMobileNo}"/></td>
                <td><c:out value="${cus.cusCity}"/></td>
                <td>
                      <a href="deleteCustomer?id=${cus.cusId}">Delete Customer</a>
                    <a href="editCustomer?editId=${cus.cusId}"> Edit Customer</a>

                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
