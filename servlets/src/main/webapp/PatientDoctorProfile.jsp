<html lang="es">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="jsp-components/dependencies/head.jsp" />
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <!-- left menu -->
        <jsp:include page="jsp-components/patient/patient-left-menu.jsp" />
        <!-- /left menu -->

        <!-- top navigation -->
        <jsp:include page="jsp-components/web/top-nav.jsp" />
        <!-- /top navigation -->

        <!-- page content -->
        <jsp:include page="jsp-components/patient/patient-doctor-right.jsp" />
        <!-- /page content -->

        <!-- footer content -->
        <jsp:include page="jsp-components/web/footer.jsp" />
        <!-- /footer content -->
    </div>
</div>
<jsp:include page="jsp-components/dependencies/scripts.jsp" />
</body>
</html>
