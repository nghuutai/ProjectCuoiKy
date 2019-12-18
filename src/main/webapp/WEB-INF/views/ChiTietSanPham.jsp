<%@page import="entity.CauHinhPC"%>
<%@page import="entity.CauHinhLaptop"%>
<%@page import="dao.DatabaseCauHinhMay"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="entity.SanPham"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
			      <label style="margin-top:20px;margin-bottom:20px;font-size:20px;">Giá: <fmt:formatNumber type = "number" maxFractionDigits = "3" value ="${SanPham.donGia }"/> đ</label><br/>
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
				  <!-- <button type="submit" class="btn btn-info" style="margin-top:20px;margin-bottom:20px;margin-left:200px;">Add to cart</button> -->
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
  		
  		<div class="row">
			<div class="col-12" style="margin-top:20px;margin-bottom:20px;">
				SẢN PHẨM LIÊN QUAN
			</div>
		</div>
		
		<div class="album py-5 bg-light">
			<div class="row">
				<%-- <c:forEach var="item" items="${SanPhamLienQuan}"> --%>
				<%
					ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
					DatabaseCauHinhMay dbchm = (DatabaseCauHinhMay) context.getBean("databasecauhinhmay");
					List<SanPham> listSanPham = (List<SanPham>) request.getAttribute("SanPhamLienQuan");
					SanPham sp = (SanPham) request.getAttribute("SanPham");
					for(SanPham sanPham:listSanPham){
						String path = "/resources/images/" + sanPham.getHinhAnh();
						CauHinhLaptop cauHinhLaptop = new CauHinhLaptop();
						CauHinhPC cauHinhPC = new CauHinhPC();
						if(sp.getIdLoaiMay() == 1) {
							cauHinhLaptop = dbchm.getCauHinhLaptopByID(sanPham.getIdSanPham());
						}else {
							cauHinhPC = dbchm.getCauHinhPCByID(sanPham.getIdSanPham());
						}
				%>
		        <div class="col-md-2">
		          <div class="card mb-4 box-shadow" style="height:380px;">
		            <img class="card-img-top"style="height:130px;" src="<c:url value='<%=path %>' />" alt="Card image cap">
		            <div class="card-body">
		              <p class="card-text" style="height:90px;"><%=sanPham.getTenSanPham() %></p>
		              <p class="card-text"><fmt:formatNumber type = "number" maxFractionDigits = "3" value ="<%=sanPham.getDonGia() %>"/> đ</p>
		              <div class="d-flex justify-content-between align-items-center">
		                <div class="btn-group">
		                  <a href="/CNJava/chitietsanpham/<%=sanPham.getIdSanPham() %>"><button type="button" class="btn btn-sm btn-outline-secondary">Xem chi tiết</button></a>
		                  <button type="button" class="btn btn-sm btn-outline-secondary" onclick="soSanh(<%=sanPham.getIdSanPham() %>)">So sánh</button>
		                </div>
		              </div>
		            </div>
		          </div>
		        </div>
		        
		        <!-- Modal -->
		        <div class="modal fade" id="<%=sanPham.getIdSanPham() %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content" style="width:700px;">
				      <div class="modal-body">
				      	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				       	<table class="table">
						  <thead>
						    <tr>
						      <th scope="col" colspan="2"><%=sp.getTenSanPham() %></th>
						      <th scope="col" colspan="2"><%=sanPham.getTenSanPham() %></th>
						    </tr>
						  </thead>
						  <tbody>
						  		<% 
						  			if(sp.getIdLoaiMay() == 1){
						  		%>
						  		<tr>
						  			<td>CPU</td>
						  			<td>${CauHinhMay.cpu}</td>
						  			<td>CPU</td>
						  			<td><%=cauHinhLaptop.getCpu() %></td>
						  		</tr>
						  		<tr>
						  			<td>RAM</td>
						  			<td>${CauHinhMay.ram}</td>
						  			<td>RAM</td>
						  			<td><%=cauHinhLaptop.getRam() %></td>
						  		</tr>
						  		<tr>
						  			<td>HardDisk</td>
						  			<td>${CauHinhMay.hardDisk}</td>
						  			<td>HardDisk</td>
						  			<td><%=cauHinhLaptop.getHardDisk() %></td>
						  		</tr>
						  		<tr>
						  			<td>VGA</td>
						  			<td>${CauHinhMay.vga}</td>
						  			<td>VGA</td>
						  			<td><%=cauHinhLaptop.getVga() %></td>
						  		</tr>
						  		<tr>
						  			<td>Kích thước màn hình</td>
						  			<td>${CauHinhMay.kichThuocManHinh}</td>
						  			<td>Kích thước màn hình</td>
						  			<td><%=cauHinhLaptop.getKichThuocManHinh() %></td>
						  		</tr>
						  		<tr>
						  			<td>Độ phân giải màn hình</td>
						  			<td>${CauHinhMay.doPhanGiaiManHinh}</td>
						  			<td>Độ phân giải màn hình</td>
						  			<td><%=cauHinhLaptop.getDoPhanGiaiManHinh() %></td>
						  		</tr>
						  		<tr>
						  			<td>Loại màn hình</td>
						  			<td>${CauHinhMay.loaiManHinh}</td>
						  			<td>Loại màn hình</td>
						  			<td><%=cauHinhLaptop.getLoaiManHinh() %></td>
						  		</tr>
						  		<tr>
						  			<td>Trọng lượng</td>
						  			<td>${CauHinhMay.trongLuong}</td>
						  			<td>Trọng lượng</td>
						  			<td><%=cauHinhLaptop.getTrongLuong() %></td>
						  		</tr>
						  		<tr>
						  			<td>Kích thước</td>
						  			<td>${CauHinhMay.kichThuoc}</td>
						  			<td>Kích thước</td>
						  			<td><%=cauHinhLaptop.getKichThuoc() %></td>
						  		</tr>
						  		<tr>
						  			<td>OS</td>
						  			<td>${CauHinhMay.os}</td>
						  			<td>OS</td>
						  			<td><%=cauHinhLaptop.getOs() %></td>
						  		</tr>
						  		<tr>
						  			<td>Pin</td>
						  			<td>${CauHinhMay.pin}</td>
						  			<td>Pin</td>
						  			<td><%=cauHinhLaptop.getPin() %></td>
						  		</tr>
						  		<%
						  			} else if(sp.getIdLoaiMay() == 2){
						  		%>
						  		<tr>
						  			<td>CPU</td>
						  			<td>${CauHinhMay.cpu}</td>
						  			<td>CPU</td>
						  			<td><%=cauHinhPC.getCpu() %></td>
						  		</tr>
						  		<tr>
						  			<td>Mainboard</td>
						  			<td>${CauHinhMay.mainboard}</td>
						  			<td>Mainboard</td>
						  			<td><%=cauHinhPC.getMainboard() %></td>
						  		</tr>
						  		<tr>
						  			<td>RAM</td>
						  			<td>${CauHinhMay.ram}</td>
						  			<td>RAM</td>
						  			<td><%=cauHinhPC.getRam() %></td>
						  		</tr>
						  		<tr>
						  			<td>HardDisk</td>
						  			<td>${CauHinhMay.hardDisk}</td>
						  			<td>HardDisk</td>
						  			<td><%=cauHinhPC.getHardDisk() %></td>
						  		</tr>
						  		<tr>
						  			<td>VGA</td>
						  			<td>${CauHinhMay.vga}</td>
						  			<td>VGA</td>
						  			<td><%=cauHinhPC.getVga() %></td>
						  		</tr>
						  		<tr>
						  			<td>Nguồn</td>
						  			<td>${CauHinhMay.nguon}</td>
						  			<td>Nguồn</td>
						  			<td><%=cauHinhPC.getNguon() %></td>
						  		</tr>
						  		<tr>
						  			<td>Case</td>
						  			<td>${CauHinhMay.mCase}</td>
						  			<td>Case</td>
						  			<td><%=cauHinhPC.getmCase() %></td>
						  		</tr>
						  		<%
						  			}
						  		%>
						  </tbody>
						</table>	
				      </div>
				    </div>
				  </div>
				</div>
		        
		        <%
					}
		        %>
		        <%-- </c:forEach> --%>
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
  	   	
  	   	function soSanh(id){
  	   		$('#' + id).modal('show');
  	   	}
		</script>
  	<jsp:include page="Footer.jsp"></jsp:include>	