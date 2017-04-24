<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="data table table-striped no-margin">
    <thead>
    <tr>
        <th>#</th>
        <th>Value</th>
        <th>Date</th>
        <th>Graph</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${samples}" var="sample">
        <tr>
            <td><c:out value="${sample.date()}"/></td>
            <td><c:out value="${sample.glucoseLevel()}"/></td>
            <td class="vertical-align-mid">
                <div class="progress">
                    <div class="progress-bar progress-bar-success" data-transitiongoal="50" style="width: 50%;" aria-valuenow="50"></div>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>