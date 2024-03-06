<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Cài đặt hồ sơ</div>
        <ul class="list-group category_block">
            <li class="list-group-item text-white ${tag == 1 ? "active":""}"><a href="loadProfileToEdit?uID=${user.userID}">Chỉnh sửa hồ sơ</a></li>
            <li class="list-group-item text-white ${tag == 2 ? "active":""}"><a href="loadProfilePassword?uID=${user.userID}">Thay đổi mật khẩu</a></li>
        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Sản phẩm mới nhất</div>
        <div class="card-body">
            <img class="img-fluid" src="${lastP.pImage}" />
            <h5 class="card-title">${lastP.pName}</h5>
            <p class="card-text">${lastP.pDescription}</p>
            <p class="bloc_left_price">${lastP.pPrice} $</p>
        </div>
    </div>
</div>