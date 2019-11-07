<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png" href="../assets/paper_img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Farmer profile</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="viewport" content="width=device-width"/>

    <base href="${pageContext.request.contextPath}/"/>

    <link href="./bootstrap3/css/bootstrap.css" rel="stylesheet"/>
    <link href="./assets/css/ct-paper.css" rel="stylesheet"/>
    <link href="./assets/css/demo.css" rel="stylesheet"/>
    <link href="./assets/css/examples.css" rel="stylesheet"/>

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>

</head>
<body>
<nav class="navbar navbar-ct-transparent navbar-relative " role="navigation-demo" id="register-navbar">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navigation-example-2">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#" class="btn btn-simple">Manage Fields</a>
                </li>
                <li>
                    <a href="logout" class="btn btn-simple">Sing Out</a>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-->
</nav>

<div class="wrapper">
    <div class="profile-background">
        <div class="filter-black"></div>
    </div>
    <div class="profile-content section-nude">
        <div class="container">
            <div class="row owner">
                <div class="col-md-2 col-md-offset-5 col-sm-4 col-sm-offset-4 col-xs-6 col-xs-offset-3 text-center">
                    <div class="avatar">
                        <img src="./assets/paper_img/potatoAvatar.jpg" alt="Circle Image"
                             class="img-circle img-no-padding img-responsive">
                    </div>
                    <div class="name">

                        <h4 items="${farmer}" var="farmer">${farmer.username}
                            <br/>
                            <small>${farmer.firstName} ${farmer.lastName}</small>
                        </h4>
                    </div>
                </div>
            </div>
            <div class="row" items="${farmer}" var="farmer">
                <div class="col-md-6 col-md-offset-3 text-center">
                    <p>Email: ${farmer.email}
                        <br/>
                        Address: ${farmer.address}
                    </p>
                    <br/>
                    <btn class="btn"><i class="fa fa-cog"></i> Settings</btn>
                </div>
            </div>
        </div>
    </div>
    <footer class="footer-demo section-nude">
        <div class="container">
            <nav class="pull-left">

                </ul>
            </nav>
            <div class="copyright pull-right">&copy; 2019, AMT PROJECT</div>
        </div>
    </footer>


</body>

<script src="./assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="./assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>

<script src="./bootstrap3/js/bootstrap.js" type="text/javascript"></script>

<!--  Plugins -->
<script src="./assets/js/ct-paper-checkbox.js"></script>
<script src="./assets/js/ct-paper-radio.js"></script>
<script src="./assets/js/bootstrap-select.js"></script>
<script src="./assets/js/bootstrap-datepicker.js"></script>

<script src="./assets/js/ct-paper.js"></script>

</html>