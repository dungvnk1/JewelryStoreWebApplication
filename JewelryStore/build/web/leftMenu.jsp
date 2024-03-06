<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Thương hiệu</div>
        <ul class="list-group category_block">
            <c:forEach items="${listC}" var="o">
                <li class="list-group-item text-white ${tag == o.cID ? "active":""}"><a href="category?cID=${o.cID}">${o.cName}</a></li>
            </c:forEach>

        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Giá sản phẩm</div>
        <ul class="list-group category_block">
            <li class="list-group-item text-white ${tagPr == 0 ? "active":""}"><a href="filterPrice?minP=0&maxP=49.999">Dưới 50$</a></li>
            <li class="list-group-item text-white ${tagPr == 50 ? "active":""}"><a href="filterPrice?minP=50&maxP=99.999">Từ 50$ - 100$</a></li>
            <li class="list-group-item text-white ${tagPr == 100 ? "active":""}"><a href="filterPrice?minP=100&maxP=9999">Trên 100$</a></li>
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