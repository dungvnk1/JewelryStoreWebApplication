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
                        <form action="editProfile" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Edit User</h4>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>ID</label>
                                    <input value="${user.userID}" name="id" type="text" class="form-control" readonly required>
                            </div>
                            <div class="form-group">
                                <label>User Name</label>
                                <input value="${user.userName}" name="userName" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Full Name</label>
                                <input value="${user.fullName}" name="fullName" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input value="${user.email}" name="email" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Birthday</label>
                                <input value="${user.birthday}" name="birthday" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Address</label>
                                <input value="${user.address}" name="address" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Phone</label>
                                <input value="${user.phone}" name="phone" type="text" class="form-control" required>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <input type="submit" class="btn btn-success" value="Edit">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
