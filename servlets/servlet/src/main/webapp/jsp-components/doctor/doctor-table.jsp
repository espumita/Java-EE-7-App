<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-12">
    <table id="datatable" class="data table table-striped no-margin">
        <thead>
            <tr role="row">
                <th>Image</th>
                <th>DNI</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${doctor.patients()}" var="patient">
            <tr>
                <td class="mine">
                    <a href="./MyPatient?dni=${patient.dni()}">
                        <img src="images/picture.jpg" style="width: 75px; height: 75px;">
                    </a>
                </td>
                <td class="mine" ><c:out value="${patient.dni()}"/></td>
                <td class="mine" ><c:out value="${patient.name()}"/></td>
                <td class="mine" ><c:out value="${patient.gender()}"/></td>
                <td class="mine" ><c:out value="${patient.age()}"/></td>
            </tr>
        </c:forEach>
    </tbody>
    </table>
</div>