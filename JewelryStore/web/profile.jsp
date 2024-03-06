<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .profile-container {
                margin-top: 20px;
                padding: 20px;
                border: 1px solid #ddd;
                border-radius: 5px;
            }

            .profile-info {
                padding-top: 10px;
            }

            .profile-info strong {
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>

            <div class="container">
                <div class="row">
                <jsp:include page="leftMenuProfile.jsp"></jsp:include>

                    <div class="col-md-6">
                        <div class="profile-container">
                            <h1>Welcome ${user.fullName}</h1>
                        <hr>
                        <div class="row">
                            <div class="col-md-12 profile-info">
                                <p>
                                    <strong>Họ và tên:</strong> ${user.fullName}
                                </p>
                                <p>
                                    <strong>Username:</strong> ${user.userName}
                                </p>
                                <p>
                                    <strong>Email:</strong> ${user.email}
                                </p>
                                <p>
                                    <strong>Ngày sinh:</strong> ${user.birthday}
                                </p>
                                <p>
                                    <strong>Địa chỉ:</strong> ${user.address}
                                </p>
                                <p>
                                    <strong>Số điện thoại:</strong> ${user.phone}
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
