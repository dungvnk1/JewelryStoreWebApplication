<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
        <title>Enter your information for order</title>
    </head>
    <body>
        <form action="buy?uID=${sessionScope.acc.userID}" method="post" class="container">
            <h1>Nhập thông tin đặt hàng</h1>
            <div class="form-group">
                <label for="name">Họ và tên:</label>
                <input type="text" id="name" name="name" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="address">Địa chỉ</label>
                <input type="address" id="address" name="address" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="phone">Số điện thoại:</label>
                <input type="text" id="phone" name="phone" class="form-control" required>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <h2>Thông tin đơn hàng của bạn</h2>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th width="40%">Sản phẩm</th>
                                <th width="30%">Hình ảnh sản phẩm</th>
                                <th width="10%">Số lượng</th>
                                <th width="20%">Giá</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listCart}" var="o">
                            <tr>
                                <td>${o.p.pName}</td>
                                <td>
                                    <img src="${o.p.pImage}" style="width: 30%">
                                </td>
                                <td>${o.quantity}</td>
                                <td>${o.p.pPrice}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-12">
                    <h2>Tổng giá đơn hàng: <span id="totalPrice">${total}</span></h2>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Đặt hàng</button>
            <a class="btn btn-primary" href="loadCart?uID=${sessionScope.acc.userID}">Back</a>
        </form>   
    </body>
</html>
