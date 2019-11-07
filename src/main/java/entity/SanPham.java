package entity;

public class SanPham {
	private int idSanPham;
	private String tenSanPham;
	private int donGia;
	private int soLuong;
	private String hinhAnh;
	private String moTa;
	private int idNhaSanXuat;
	private int idLoaiMay;
	
	public SanPham() {
		super();
	}

	public SanPham(int idSanPham, String tenSanPham, int donGia, int soLuong, String hinhAnh, String moTa,
			int idNhaSanXuat, int idLoaiMay) {
		super();
		this.idSanPham = idSanPham;
		this.tenSanPham = tenSanPham;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
		this.idNhaSanXuat = idNhaSanXuat;
		this.idLoaiMay = idLoaiMay;
	}

	public int getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getIdNhaSanXuat() {
		return idNhaSanXuat;
	}

	public void setIdNhaSanXuat(int idNhaSanXuat) {
		this.idNhaSanXuat = idNhaSanXuat;
	}

	public int getIdLoaiMay() {
		return idLoaiMay;
	}

	public void setIdLoaiMay(int idLoaiMay) {
		this.idLoaiMay = idLoaiMay;
	}
	
	
}
