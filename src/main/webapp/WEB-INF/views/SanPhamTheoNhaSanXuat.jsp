<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<jsp:include page="Header.jsp"></jsp:include>
	
	<div class="row" style="margin-top:20px;margin-bottom:20px;">
    	<div class="col-1">
    		<div style="margin-top:10px">${NhaSanXuat.tenNhaSanXuat}</div>
    	</div>
    </div>
    
	<div class="row" style="margin-top:20px;margin-bottom:20px;">
    	<div class="col-2">
    		<div style="margin-top:10px">Chon muc gia: </div>
    	</div>
    	<div class="col-10">
    		<a href="/CNJava//sanphamtheonhasanxuat/${NhaSanXuat.idNhaSanXuat}/${LoaiMay.idLoaiMay}/1-5000000"><button type="button" class="btn btn-outline-danger">Dưới 5 triệu</button></a>
		 	<a href="/CNJava//sanphamtheonhasanxuat/${NhaSanXuat.idNhaSanXuat}/${LoaiMay.idLoaiMay}/5000000-10000000"><button type="button" class="btn btn-outline-danger">5 - 10 triệu</button></a>
		 	<a href="/CNJava//sanphamtheonhasanxuat/${NhaSanXuat.idNhaSanXuat}/${LoaiMay.idLoaiMay}/10000000-15000000"><button type="button" class="btn btn-outline-danger">10 - 15 triệu</button></a>
		 	<a href="/CNJava//sanphamtheonhasanxuat/${NhaSanXuat.idNhaSanXuat}/${LoaiMay.idLoaiMay}/15000000-20000000"><button type="button" class="btn btn-outline-danger">15 - 20 triệu</button></a>
		 	<a href="/CNJava//sanphamtheonhasanxuat/${NhaSanXuat.idNhaSanXuat}/${LoaiMay.idLoaiMay}/20000000-"><button type="button" class="btn btn-outline-danger">Trên 20 triệu</button></a>
    	</div>
    </div>
    
    <div class="album py-5 bg-light">
		<div class="row">
			<c:if test="${ListSanPhamTheoNhaSanXuat.size() == 0}">
				<div class="col-12" style="text-align:center;">
				  ${ThongBao}
				</div>
			</c:if>
			<c:forEach var="item" items="${ListSanPhamTheoNhaSanXuat}">
		        <div class="col-md-4">
		          <div class="card mb-4 box-shadow">
		            <img class="card-img-top" style="height:250px;" src="<c:url value='/resources/images/${item.hinhAnh}' />" alt="Card image cap">
		            <div class="card-body">
		              <p class="card-text">${item.tenSanPham}</p>
		              <p class="card-text">${item.donGia}</p>
		              <div class="d-flex justify-content-between align-items-center">
		                <div class="btn-group">
		                  <button type="button" class="btn btn-sm btn-outline-secondary">Xem chi tiet</button>
		                  <button type="button" class="btn btn-sm btn-outline-secondary">Quick view</button>
		                </div>
		              </div>
		            </div>
		          </div>
		        </div>
	        </c:forEach>
	   	</div>
   	</div>
   	
   	<div class="row">
   		<div class="col-12">
		   	<div class="pagination-0" style="margin-top:20px;float:right;">
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				    <li class="page-item">
				      <a class="page-link" href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				        <span class="sr-only">Previous</span>
				      </a>
				    </li>
			    	<li class="page-item"><a class="page-link" href="#" >1</a></li>
			    	<li class="page-item"><a class="page-link" href="#" >2</a></li>
			    	<li class="page-item"><a class="page-link" href="#" >3</a></li>
				    <li class="page-item">
				      <a class="page-link" href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				        <span class="sr-only">Next</span>
				      </a>
				    </li>
				  </ul>
				</nav>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>