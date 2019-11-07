<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<jsp:include page="Header.jsp"></jsp:include>
	
	
	<div class="row">
		<div class="col-12" style="text-align:center;margin-top:20px;margin-bottom:20px;">
			SAN PHAM MOI
		</div>
	</div>
	<div class="album py-5 bg-light">
		<div class="row">
			<c:forEach var="item" items="${ListSanPhamMoi}">
		        <div class="col-md-4">
		          <div class="card mb-4 box-shadow">
		            <img class="card-img-top" style="height:250px;" src="<c:url value='/resources/images/${item.hinhAnh}' />" alt="Card image cap">
		            <div class="card-body">
		              <p class="card-text">${item.tenSanPham }</p>
		              <p class="card-text">${item.donGia }</p>
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
						      <form action="#" method="get">	
						      <h3 style="margin-bottom:20px;">${item.tenSanPham}</h3>
						      <label style="margin-top:20px;margin-bottom:20px;font-size:20px;">Giá: ${item.donGia}đ</label><br/>
						      <div class="form-group row" style="margin-top:20px;">
						        <div class="col-5" style="margin-top:10px;">
							    	<label >Số lượng:</label>
							    </div>
							    <div class="col-7"">
							      <div class="input-group">
									    <div class="input-group-prepend">
									      	<a href="#"><button id="sub" type="button" class="btn btn-secondary">-</button></a>
									    </div>
									    <input type="text" style="max-width:45px;" value="10" readonly class="form-control" aria-label="Input group example" aria-describedby="btnGroupAddon">
								    	<div class="input-group-prepend">
								    	  	<a href="#"><button type="button" class="btn btn-secondary">+</button></a>
									    </div>
								    </div>
							    </div>
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
			SAN PHAM BAN CHAY
		</div>
	</div>
	<div class="album py-5 bg-light">
	<div class="row">
        <div class="col-md-4">
          <div class="card mb-4 box-shadow">
            <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail" alt="Card image cap">
            <div class="card-body">
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                </div>
                <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card mb-4 box-shadow">
            <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail" alt="Card image cap">
            <div class="card-body">
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                </div>
                <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card mb-4 box-shadow">
            <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail" alt="Card image cap">
            <div class="card-body">
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                </div>
                <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card mb-4 box-shadow">
            <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail" alt="Card image cap">
            <div class="card-body">
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                </div>
                <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card mb-4 box-shadow">
            <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail" alt="Card image cap">
            <div class="card-body">
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                </div>
                <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card mb-4 box-shadow">
            <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail" alt="Card image cap">
            <div class="card-body">
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                </div>
                <small class="text-muted">9 mins</small>
              </div>
            </div>
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
   	/* 
   	$(document).ready(function(){
   		$("#btn1").click(function(){
   			$.ajax({
   				type: 'get',
   				data: {
   					format: 'json'
   				},
   				url: 'http://localhost:8080/CNJava/quickdetail/1',
   				success: function(data){
   					console.log(data);
   				}
   			});
   			$('exampleModal').modal('show')
   			console.log("hello");
   		});
   	}); */
   	</script>
	<jsp:include page="Footer.jsp"></jsp:include>
	