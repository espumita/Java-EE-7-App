<html lang="en">
<head>
    <jsp:include page="jsp-components/dependencies/head.jsp" />
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <!-- left menu -->
        <jsp:include page="jsp-components/doctor/doctor-left-menu.jsp" />
        <!-- /left menu -->

        <!-- top navigation -->
        <jsp:include page="jsp-components/web/top-nav.jsp" />
        <!-- /top navigation -->

        <!-- page content -->
        <jsp:include page="jsp-components/doctor/doctor-patient-right.jsp" />
        <!-- /page content -->

        <!-- footer content -->
        <jsp:include page="jsp-components/web/footer.jsp" />
        <!-- /footer content -->
    </div>
</div>
<jsp:include page="jsp-components/dependencies/scripts.jsp" />
</body>
</html>