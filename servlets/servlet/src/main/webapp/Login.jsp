<html lang="en"><head>
    <jsp:include page="jsp-components/dependencies/head.jsp" />
</head>

<body class="login">
<div>
    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form action="./checkLogin" method="post">
                    <h1>Login Form</h1>
                    <div>
                        <input type="text" name="dni" class="form-control" placeholder="DNI">
                    </div>
                    <div>
                        <input type="password" name="password" class="form-control" placeholder="Password">
                    </div>
                    <div>
                        <button>Log in</button>
                        <a class="reset_pass" href="#">Lost your password?</a>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">

                        <div class="clearfix"></div>
                        <br>

                        <div>
                            <h1><i class="fa fa-heart"></i> Glucose App!</h1>
                            <p>©2016 All Rights Reserved.</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>


</body></html>