package entity;

public class CauHinhPC {

	private int idSanPham;
	private String cpu;
	private String mainboard;
	private String ram;
	private String hardDisk;
	private String vga;
	private String nguon;
	private String mCase;
	
	public CauHinhPC() {
		super();
	}
	
	public CauHinhPC(int idSanPham, String cpu, String mainboard, String ram, String hardDisk, String vga, String nguon,
			String mCase) {
		super();
		this.idSanPham = idSanPham;
		this.cpu = cpu;
		this.mainboard = mainboard;
		this.ram = ram;
		this.hardDisk = hardDisk;
		this.vga = vga;
		this.nguon = nguon;
		this.mCase = mCase;
	}

	public int getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMainboard() {
		return mainboard;
	}

	public void setMainboard(String mainboard) {
		this.mainboard = mainboard;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}

	public String getVga() {
		return vga;
	}

	public void setVga(String vga) {
		this.vga = vga;
	}

	public String getNguon() {
		return nguon;
	}

	public void setNguon(String nguon) {
		this.nguon = nguon;
	}

	public String getmCase() {
		return mCase;
	}

	public void setmCase(String mCase) {
		this.mCase = mCase;
	}
	
	
}
