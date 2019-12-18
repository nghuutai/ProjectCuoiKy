package entity;

public class ThongKeChiTiet {
	private int idHoaDon;
	private String tenKhachHang;
	private int tongTien;
	
	public ThongKeChiTiet(int idHoaDon, String tenKhachHang, int tongTien) {
		super();
		this.idHoaDon = idHoaDon;
		this.tenKhachHang = tenKhachHang;
		this.tongTien = tongTien;
	}
	
	public ThongKeChiTiet() {
		
	}

	public int getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(int idHoaDon) {
		this.idHoaDon = idHoaDon;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	
	
}
