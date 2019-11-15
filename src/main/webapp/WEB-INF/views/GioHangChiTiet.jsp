<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp"></jsp:include>
	
	<!-- Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLongTitle">Thông báo</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        Số lượng sản phẩm không còn đủ!!!
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
	
	<c:if test="${sessionScope.count==0}">
		<div class="row" style="margin:20px;">
			<div class="col-12">
				GIỎ HÀNG TRỐNG
			</div>
			<div class="col-12">
				<a href="/CNJava"">Bắt đầu mua hàng</a>
			</div>
		</div>
	</c:if>
	<c:if test="${sessionScope.count>0}">
		<div class="row" style="margin:20px;">
			<div class="col">
				GIỎ HÀNG
			</div>
		</div>
	
		<table class="table" style="margin:20px;width:1000px" >
		  <thead>
		    <tr>
		      <th scope="col">Sản phẩm</th>
		      <th scope="col">Giá</th>
		      <th scope="col">Số lượng</th>
		      <th scope="col">Tổng tiền</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="item" items="${sessionScope.myCartItems}">
			    <tr>
			      <td>
			      	<div class="row">
			      		<div class="col-3">
			      			<img style="width: 70px; height:70px;" src="<c:url value='/resources/images/${item.value.sanPham.hinhAnh}' />" alt="..." class="img-thumbnail">
			      		</div>
			      		<div class="col-9">
			      			<div style="margin-bottom:20px;">Ten san pham: ${item.value.sanPham.tenSanPham}</div>
			      			<a href="/CNJava/giohangchitiet/xoa/${item.value.sanPham.idSanPham}"><span>Remove</span></a>
			      		</div>
			      	</div>
			      </td>
			      <td>${item.value.sanPham.donGia}</td>
			      <td> 
			      	<div class="input-group">
					    <div class="input-group-prepend">
					      <c:if test="${item.value.soLuong==1}">
					      	<button id="sub" type="button" class="btn btn-secondary" disabled>-</button>
					      </c:if>
					      <c:if test="${item.value.soLuong>1}">
					      	<a href="/CNJava/giohangchitiet/giam/${item.value.sanPham.idSanPham}"><button id="sub" type="button" class="btn btn-secondary" >-</button></a>
					      </c:if>
					    </div>
					    <input id="${item.value.sanPham.idSanPham}" type="text" style="max-width:50px;" value="${item.value.soLuong}" readonly class="form-control" aria-label="Input group example" aria-describedby="btnGroupAddon">
				    	<div class="input-group-prepend">
				    	  	<a href="/CNJava/giohangchitiet/them/${item.value.sanPham.idSanPham}" onclick="handleClick(event,${item.value.soLuongCon},${item.value.sanPham.idSanPham})"><button type="button" class="btn btn-secondary">+</button></a>
					    </div>
				    </div>
			      </td>
			      <td>${item.value.tongTien()}đ</td>
			    </tr>
		    </c:forEach>
		   	<script>
		   		function handleClick(event, sl, id){
		   			var soLuong = document.getElementById(id).value;
		   			console.log(sl);
		   			if(soLuong == sl){
		   				console.log("false");
		   				$("#exampleModalCenter").modal('show');
		   				event.preventDefault();
		   			}else{
		   				console.log("true");
		   			}
		   		} 
		   		
		   	</script>
		  </tbody>
		</table>
	</c:if>	
	<div class="row">
		<div class="col-12" style="text-align:right;">
			<span style="margin-right:90px;font-size:20px;">Tổng tiền: ${sessionScope.totalCart}đ</span>
		</div>
	</div>
	<div class="row">
		<div class="col-12" style="text-align:center;margin-top:20px;">
			<a href="/CNJava/thongtin"><button type="button" class="btn btn-danger">Tiến hành đặt hàng</button></a>
		</div>
	</div>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</div>
</body>
</html>