<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Order</title>
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

                    <div class="col-md-9">
                        <div class="row">
                            <div class="col-md-12">
                                <h2>Lịch sử đơn hàng</h2> 
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th>Tên người mua</th>
                                            <th>Địa chỉ người mua</th>
                                            <th>Số điện thoại</th>
                                            <th>Tên sản phẩm</th>
                                            <th width="200%">Hình ảnh sản phẩm</th>
                                            <th>Đơn giá</th>
                                            <th>Số lượng đặt hàng</th>
                                            <th>Tổng số tiền phải trả</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listOrder}" var="o">
                                    <tr>
                                        <td>${o.oName}</td>
                                        <td>${o.oAddress}</td>
                                        <td>${o.oPhone}</td>
                                        <td>${o.oProduct.pName}</td>
                                        <td>
                                            <img src="${o.oProduct.pImage}" style="width: 30%">
                                        </td>
                                        <td>${o.oProduct.pPrice}</td>
                                        <td>${o.quantity}</td>
                                        <td>${o.total}</td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                                <h2>Tổng số tiền: ${totalMoney}</h2>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
