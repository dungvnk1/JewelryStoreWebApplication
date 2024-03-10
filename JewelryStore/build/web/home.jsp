<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jewelry Store</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <%
            String buyMes = (String) request.getAttribute("buySuccess");
            if(buyMes != null) {
        %>
            <script type="text/javascript">
                alert("<%= buyMes %>");
            </script>
        <%
            }
        %>
        
        <%
            String errMes = (String) request.getAttribute("errAuth");
            if(errMes != null) {
        %>
            <script type="text/javascript">
                alert("<%= errMes %>");
            </script>
        <%
            }
        %>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="home">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="#">Category</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        
        <div class="container">
            <div class="row">
                <jsp:include page="leftMenu.jsp"></jsp:include>
                <div class="col-sm-9">
                    <div class="row">
                        <c:forEach items="${listP}" var="o">
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${o.pImage}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pID=${o.pID}" title="View Product">${o.pName}</a></h4>
                                        <p class="card-text show_txt">${o.pDescription}</p>
                                        <c:if test="${sessionScope.acc.roleID != 1}">
                                            <div class="row">
                                                <div class="col">
                                                    <a class="btn btn-danger btn-block" href="addToCart?pID=${o.pID}&uID=${sessionScope.acc.userID}">${o.pPrice} $</a>
                                                </div>
                                                <div class="col">
                                                    <a href="addToCart?pID=${o.pID}&uID=${sessionScope.acc.userID}" class="btn btn-success btn-block">Add to cart</a>
                                                </div>
                                            </div>
                                        </c:if>
                                        
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <ul class="pagination pagination-lg" style="margin-left: 50%">
                        <c:forEach begin="1" end="${numberPage}" var="i">
                            <li class="page-item"><a class="page-link" href="home?index=${i}">${i}</a></li>
                        </c:forEach>
                    </ul>
        </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>

