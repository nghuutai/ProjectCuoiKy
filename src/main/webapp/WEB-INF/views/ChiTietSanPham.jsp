<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    	<jsp:include page="Header.jsp"></jsp:include>
	
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
	
		<div class="row" style="margin:20px;">
		    <div class="col-6">
		      <img style="width: 450px; height:450px;" src="<c:url value='/resources/images/${SanPham.hinhAnh}' />" alt="..." class="img-thumbnail">
		    </div>
		    <div class="col-6">
		      <form action="/CNJava/chitietsanpham/add/${SanPham.idSanPham}" method="post">	
			      <h2 style="margin-top:20px;margin-bottom:20px;">${SanPham.tenSanPham}</h2>
			      <label style="margin-top:20px;margin-bottom:20px;font-size:20px;">Giá: ${SanPham.donGia}đ</label><br/>
			      <div class="form-group row" style="margin-top:20px;">
			        <div class="col-3" style="margin-top:10px;">
				    	<label>Số lượng:</label>
				    </div>
				    <div class="col-4"">
				      <div class="input-group">
						    <div class="input-group-prepend">
						      	<button id="sub${item.idSanPham}" type="button" class="btn btn-secondary" onclick="giamSoLuong(${SanPham.idSanPham})">-</button>
						    </div>
						    <input type="text" id="soluong${SanPham.idSanPham}" name="soLuong" style="max-width:45px;" value="1" class="form-control">
					    	<div class="input-group-prepend">
					    	  	<button id="add" type="button" class="btn btn-secondary" onclick="tangSoLuong(${SanPham.idSanPham},${SanPham.soLuong},${SessionCart.soLuong})">+</button>
						    </div>
				    	</div>
				    </div>
				  </div>	
				  <c:if test="${SessionCart.soLuong >= SanPham.soLuong}">
				  	<button type="submit" class="btn btn-info" disabled style="margin-top:20px;margin-bottom:20px;margin-left:200px;">Add to cart</button>
				  </c:if>
				  <c:if test="${SessionCart.soLuong < SanPham.soLuong}">
				  	<button type="submit" class="btn btn-info" style="margin-top:20px;margin-bottom:20px;margin-left:200px;">Add to cart</button>
				  </c:if>		  
			  </form>
    		</div>
  		</div>
  		<div class="row" style="margin:20px;">
		    <div class="col-6">
		    	 ${SanPham.moTa}
		    </div> 
		    <div class="col-6">
		    	<table class="table">
				  <thead>
				    <tr>
				      <th scope="col" colspan="2">Thông số kỹ thuật</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:if test="${SanPham.idLoaiMay == 1}">
				  		<tr>
				  			<td>CPU</td>
				  			<td>${CauHinhMay.cpu}</td>
				  		</tr>
				  		<tr>
				  			<td>RAM</td>
				  			<td>${CauHinhMay.ram}</td>
				  		</tr>
				  		<tr>
				  			<td>HardDisk</td>
				  			<td>${CauHinhMay.hardDisk}</td>
				  		</tr>
				  		<tr>
				  			<td>VGA</td>
				  			<td>${CauHinhMay.vga}</td>
				  		</tr>
				  		<tr>
				  			<td>Kích thước màn hình</td>
				  			<td>${CauHinhMay.kichThuocManHinh}</td>
				  		</tr>
				  		<tr>
				  			<td>Độ phân giải màn hình</td>
				  			<td>${CauHinhMay.doPhanGiaiManHinh}</td>
				  		</tr>
				  		<tr>
				  			<td>Loại màn hình</td>
				  			<td>${CauHinhMay.loaiManHinh}</td>
				  		</tr>
				  		<tr>
				  			<td>Trọng lượng</td>
				  			<td>${CauHinhMay.trongLuong}</td>
				  		</tr>
				  		<tr>
				  			<td>Kích thước</td>
				  			<td>${CauHinhMay.kichThuoc}</td>
				  		</tr>
				  		<tr>
				  			<td>OS</td>
				  			<td>${CauHinhMay.os}</td>
				  		</tr>
				  		<tr>
				  			<td>Pin</td>
				  			<td>${CauHinhMay.pin}</td>
				  		</tr>
				  	</c:if>
				    <c:if test="${SanPham.idLoaiMay == 2}">
				    	<tr>
				  			<td>CPU</td>
				  			<td>${CauHinhMay.cpu}</td>
				  		</tr>
				  		<tr>
				  			<td>Mainboard</td>
				  			<td>${CauHinhMay.mainboard}</td>
				  		</tr>
				  		<tr>
				  			<td>RAM</td>
				  			<td>${CauHinhMay.ram}</td>
				  		</tr>
				  		<tr>
				  			<td>HardDisk</td>
				  			<td>${CauHinhMay.hardDisk}</td>
				  		</tr>
				  		<tr>
				  			<td>VGA</td>
				  			<td>${CauHinhMay.vga}</td>
				  		</tr>
				  		<tr>
				  			<td>Nguồn</td>
				  			<td>${CauHinhMay.nguon}</td>
				  		</tr>
				  		<tr>
				  			<td>Case</td>
				  			<td>${CauHinhMay.mCase}</td>
				  		</tr>
				    </c:if>
				  </tbody>
				</table>
		    </div>
  		</div>
  		<script type="text/javascript">
  		function tangSoLuong(id, sl, slCart){
  	   		var giaTri = $('#soluong' + id).val();
  	   		var soLuong = parseInt(giaTri);
  	   		if(soLuong + slCart >= sl){
  	   			$('#exampleModal').modal('show');
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