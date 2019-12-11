package entity;

import java.sql.Date;

import entity.ChiTietHoaDon;

public class HoaDon {

	private int maHoaDon;
	private String tenKhachHang;
	private String email;
	private String soDienThoai;
	private String diaChi;
	private String thanhPho;
	private Date ngayTao;
	private int tinhTrangHoaDon;
	private ChiTietHoaDon chiTietHoaDon;
	
	public HoaDon(int maHoaDon, String tenKhachHang, String email, String soDienThoai, String diaChi, String thanhPho, Date ngayTao,
			int tinhTrangHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
		this.tenKhachHang = tenKhachHang;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.thanhPho = thanhPho;
		this.ngayTao = ngayTao;
		this.tinhTrangHoaDon = tinhTrangHoaDon;
	}

	public HoaDon() {
		super();
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public int getTinhTrangHoaDon() {
		return tinhTrangHoaDon;
	}

	public void setTinhTrangHoaDon(int tinhTrangHoaDon) {
		this.tinhTrangHoaDon = tinhTrangHoaDon;
	}

	public ChiTietHoaDon getChiTietHoaDon() {
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}

	public String getThanhPho() {
		return thanhPho;
	}

	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}
	
}
