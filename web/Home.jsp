<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/home.css" rel="stylesheet" type="text/css"/>
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap"
      rel="stylesheet"
      />
  </head>
  <body>
    <!--begin of menu-->
    <jsp:include page="Menu.jsp"></jsp:include>
      <div class="anh_to">  
        <img src="img/BG.webp" alt="anh to">
      </div>            
      <!--end of menu-->

      <div class="container">
        <div class="row">
          <div class="col-sm-3">
            <div class="card bg-light mb-3">
              <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Brand</div>
              <ul class="list-group category_block">
              <c:forEach items="${listB}" var="o">
                <li class="list-group-item text-white ${tag == o.id?"active":""}"><a href="brand?bid=${o.id}">${o.name}</a></li>
                </c:forEach>

            </ul>
          </div>
          <div class="card bg-light mb-3">
            <div class="card-header bg-success text-white text-uppercase">HOT PERFUME</div>
            <div class="card-body">
              <img class="card-img-top" src="img/${hot.img}" alt="Card image cap">
              <h5 class="card-title"><a href="detail?pid=${hot.id}">${hot.name}</a></h5>
              <p class="card-text">${hot.fomulation}</p>
              <p class="bloc_left_price">${hot.price} VNĐ</p>
            </div>
          </div>
        </div>

        <div class="col-sm-9">
          <div class="row">
            <c:forEach items="${listP}" var="o">
              <div class="col-12 col-md-6 col-lg-4">
                <div class="card">
                  <img class="card-img-top" src="img/${o.img}" alt="Card image cap">
                  <div class="card-body">
                    <p class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></p>
                    <p class="card-text show_txt">${o.fomulation}</p>
                    <div class="row">
                      <div class="col">
                        <p class="btn btn-danger btn-block">${o.price} VNĐ</p>
                      </div>
                      <div class="col">
                        <a href="#" class="btn btn-success btn-block">Add to cart</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
          </div>
        </div>

      </div>
    </div>

    <!-- Footer -->
    <footer class="text-light">
      <div class="container">
        <div class="row">
          <div class="col-md-3 col-lg-4 col-xl-3">
            <h5>About</h5>
            <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
            <p class="mb-0">
              Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression.
            </p>
          </div>

          <div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
            <h5>Informations</h5>
            <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
            <ul class="list-unstyled">
              <li><a href="">Link 1</a></li>
              <li><a href="">Link 2</a></li>
              <li><a href="">Link 3</a></li>
              <li><a href="">Link 4</a></li>
            </ul>
          </div>

          <div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
            <h5>Others links</h5>
            <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
            <ul class="list-unstyled">
              <li><a href="">Link 1</a></li>
              <li><a href="">Link 2</a></li>
              <li><a href="">Link 3</a></li>
              <li><a href="">Link 4</a></li>
            </ul>
          </div>

          <div class="col-md-4 col-lg-3 col-xl-3">
            <h5>Contact</h5>
            <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
            <ul class="list-unstyled">
              <li><i class="fa fa-home mr-2"></i> My company</li>
              <li><i class="fa fa-envelope mr-2"></i> email@example.com</li>
              <li><i class="fa fa-phone mr-2"></i> + 33 12 14 15 16</li>
              <li><i class="fa fa-print mr-2"></i> + 33 12 14 15 16</li>
            </ul>
          </div>
          <div class="col-12 copyright mt-3">
            <p class="float-left">
              <a href="#">Back to top</a>
            </p>
            <p class="text-right text-muted">created with <i class="fa fa-heart"></i> by <a href="https://t-php.fr/43-theme-ecommerce-bootstrap-4.html"><i>t-php</i></a> | <span>v. 1.0</span></p>
          </div>
        </div>
      </div>
    </footer>
  </body>
</html>

