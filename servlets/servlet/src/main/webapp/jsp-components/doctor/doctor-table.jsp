<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-12">
    <table id="datatable" class="table table-striped table-bordered dataTable no-footer" role="grid" aria-describedby="datatable_info">
        <thead>
            <tr role="row">
                <th>#</th>
                <th>DNI</th>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${doctor.patients()}" var="patient">
            <tr>
                <td><c:out value="${doctor.patients().indexOf(patient) + 1}"/></td>
                <td><c:out value="${patient.dni()}"/></td>
                <td><c:out value="${patient.name()}"/></td>
            </tr>
        </c:forEach>
    </tbody>
    </table>
</div>