<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	<jsp:include page="Header.jsp"></jsp:include>
	
	
	
	<div class="row">
		<div class="col-12" style="text-align:center;margin-top:20px;margin-bottom:20px;">
			SẢN PHẨM MỚI
		</div>
	</div>
	<div class="album py-5 bg-light">
		<div class="row">
			<c:forEach var="item" items="${ListSanPhamMoi}">
		        <div class="col-md-4">
		          <div class="card mb-4 box-shadow">
		            <img class="card-img-top" style="height:250px;" src="<c:url value='/resources/images/${item.hinhAnh}' />" alt="Card image cap">
		            <div class="card-body">
		              <p class="card-text" style="height:35px;">${item.tenSanPham}</p>
		              <c:if test="${item.soLuong == 0}">
		              	<p class="card-text"><fmt:formatNumber type = "number" maxFractionDigits = "3" value ="${item.donGia }"/> đ (Đã hết hàng)</p>
		              </c:if>
		              <c:if test="${item.soLuong > 0}">
		              	<p class="card-text"><fmt:formatNumber type = "number" maxFractionDigits = "3" value ="${item.donGia }"/> đ</p>
		              </c:if>
		              <div class="d-flex justify-content-between align-items-center">
		                <div class="btn-group">
		                  <a href="/CNJava/chitietsanpham/${item.idSanPham}"><button type="button" class="btn btn-sm btn-outline-secondary">Xem chi tiet</button></a>
		                  <button id="btn1" type="button" class="btn btn-sm btn-outline-secondary" onclick="quickDetail(${item.idSanPham})">Quick view</button>
		                </div>
		              </div>
		            </div>
		          </div>
		        </div>
		        
		        <!-- Modal -->
		        <div class="modal fade" id="exampleModal${item.idSanPham}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content" style="width:700px;height:450px;">
				      <div class="modal-body">
				      	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				       	<div class="row" style="margin:20px;">
						    <div class="col-6">
						      <img style="width: 300px; height:300px;" src="<c:url value='/resources/images/${item.hinhAnh}' />" alt="..." class="img-thumbnail">
						    </div>
						    <div class="col-6">
							   <form action="/CNJava/addquickview/${item.idSanPham}" method="post">	
							      <h3 style="margin-bottom:20px;">${item.tenSanPham}</h3>
							      <label style="margin-top:20px;margin-bottom:20px;font-size:20px;">Giá: <fmt:formatNumber type = "number" maxFractionDigits = "3" value ="${item.donGia }"/> đ</label><br/>
							      <div class="form-group row" style="margin-top:20px;">
							        <div class="col-5" style="margin-top:10px;">
								    	<label >Số lượng:</label>
								    </div>
								    <div class="col-7">
								      <div class="input-group">
										    <div class="input-group-prepend">
										      	<button id="sub${item.idSanPham}" type="button" class="btn btn-secondary" onclick="giamSoLuong(${item.idSanPham})">-</button>
										    </div>
										    <input type="text" name="soLuong" id="soluong${item.idSanPham}" style="max-width:45px;" value="1" class="form-control">
									    	<div class="input-group-prepend">
									    	  	<button id="add${item.idSanPham}" type="button" class="btn btn-secondary" onclick="tangSoLuong(${item.idSanPham}, ${item.soLuong})">+</button>
										    </div>
									    </div>
								    </div>
								  </div>
								  <label id="thongbao${item.idSanPham}" style="margin-top:20px;margin-bottom:20px;font-size:11px;" hidden>Số lượng sản phẩm này không còn đủ</label><br/>
								  <div id="">
								  </div>
								  <div class="row">
								  	<div class="col-12">
								  		<div style="margin-left:90px;">
								  			<button type="submit" class="btn btn-info" style="margin-top:20px;margin-bottom:20px;">Add to cart</button>
								  		</div>
								  	</div>
								  </div>
								</form>
				    		</div>
				  		</div>	
				      </div>
				    </div>
				  </div>
				</div>
	        </c:forEach>
	   	</div>
   	</div>
   	
   	<div class="row">
		<div class="col-12" style="text-align:center;margin-top:20px;margin-bottom:20px;">
			SẢN PHẨM BÁN CHẠY
		</div>
	</div>
	<div class="album py-5 bg-light">
		<div class="row">
			<c:forEach var="item" items="${ListSanPhamBanChay}">
		        <div class="col-md-4">
		          <div class="card mb-4 box-shadow">
		            <img class="card-img-top" style="height:250px;" src="<c:url value='/resources/images/${item.hinhAnh}' />" alt="Card image cap">
		            <div class="card-body">
		              <p class="card-text" style="height:35px;">${item.tenSanPham}</p>
		              <c:if test="${item.soLuong == 0}">
		              	<p class="card-text"><fmt:formatNumber type = "number" maxFractionDigits = "3" value ="${item.donGia }"/> đ (Đã hết hàng)</p>
		              </c:if>
		              <c:if test="${item.soLuong > 0}">
		              	<p class="card-text"><fmt:formatNumber type = "number" maxFractionDigits = "3" value ="${item.donGia }"/> đ</p>
		              </c:if>
		              <div class="d-flex justify-content-between align-items-center">
		                <div class="btn-group">
		                  <a href="/CNJava/chitietsanpham/${item.idSanPham}"><button type="button" class="btn btn-sm btn-outline-secondary">Xem chi tiet</button></a>
		                  <button id="btn1" type="button" class="btn btn-sm btn-outline-secondary" onclick="quickDetail(${item.idSanPham})">Quick view</button>
		                </div>
		              </div>
		            </div>
		          </div>
		        </div>
		        
		        <!-- Modal -->
		        <div class="modal fade" id="exampleModal${item.idSanPham}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content" style="width:700px;height:450px;">
				      <div class="modal-body">
				      	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				       	<div class="row" style="margin:20px;">
						    <div class="col-6">
						      <img style="width: 300px; height:300px;" src="<c:url value='/resources/images/${item.hinhAnh}' />" alt="..." class="img-thumbnail">
						    </div>
						    <div class="col-6">
							   <form action="/CNJava/addquickview/${item.idSanPham}" method="post">	
							      <h3 style="margin-bottom:20px;">${item.tenSanPham}</h3>
							      <label style="margin-top:20px;margin-bottom:20px;font-size:20px;"><fmt:formatNumber type = "number" maxFractionDigits = "3" value ="${item.donGia }"/> đ</label><br/>
							      <div class="form-group row" style="margin-top:20px;">
							        <div class="col-5" style="margin-top:10px;">
								    	<label >Số lượng:</label>
								    </div>
								    <div class="col-7">
								      <div class="input-group">
										    <div class="input-group-prepend">
										      	<button id="sub${item.idSanPham}" type="button" class="btn btn-secondary" onclick="giamSoLuong(${item.idSanPham})">-</button>
										    </div>
										    <input type="text" name="soLuong" id="soluong${item.idSanPham}" style="max-width:45px;" value="1" class="form-control">
									    	<div class="input-group-prepend">
									    	  	<button id="add${item.idSanPham}" type="button" class="btn btn-secondary" onclick="tangSoLuong(${item.idSanPham}, ${item.soLuong})">+</button>
										    </div>
									    </div>
								    </div>
								  </div>
								  <label id="thongbao${item.idSanPham}" style="margin-top:20px;margin-bottom:20px;font-size:11px;" hidden>Số lượng sản phẩm này không còn đủ</label><br/>
								  <div id="">
								  </div>
								  <div class="row">
								  	<div class="col-12">
								  		<div style="margin-left:90px;">
								  			<button type="submit" class="btn btn-info" style="margin-top:20px;margin-bottom:20px;">Add to cart</button>
								  		</div>
								  	</div>
								  </div>
								</form>
				    		</div>
				  		</div>	
				      </div>
				    </div>
				  </div>
				</div>
        	</c:forEach>
	   	</div>
   	</div>
   	
   	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      	Không còn đủ số lượng sản phẩm này!!!
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
   	
   	<script type="text/javascript">
   	function quickDetail(id) {
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "http://localhost:8080/CNJava/quickdetail/" + id,
			dataType : 'json',
			success : function(data) {
				console.log("SUCCESS: ", data.idSanPham);
				$('#exampleModal' + data.idSanPham).modal('show')
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
	}
   	
   	
   	function tangSoLuong(id,sl){
   		var giaTri = $('#soluong' + id).val();
   		var soLuong = parseInt(giaTri);
   		if(soLuong >= sl){
   			$("#thongbao" + id).show();
   		}else{
   			soLuong = soLuong + 1;
   	   		$('#soluong' + id).val(soLuong);
   		}
   	}
   	
   	function giamSoLuong(id){
   		var giaTri = $('#soluong' + id).val();
   		var soLuong = parseInt(giaTri);
   		if(soLuong === 1){
   			$('#soluong' + id).val(1);
   		}else{
   			soLuong = soLuong - 1;
   	   		$('#soluong' + id).val(soLuong);
   		}
   		
   	}
   	
   	</script>
	<jsp:include page="Footer.jsp"></jsp:include>
	