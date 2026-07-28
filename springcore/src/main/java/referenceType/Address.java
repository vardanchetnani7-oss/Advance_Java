package referenceType;

public class Address {

	private int hno;
	private String society;
	private String areaName;
	
	public Address(int hno, String society, String areaName) {
		super();
		this.hno = hno;
		this.society = society;
		this.areaName = areaName;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public String getSociety() {
		return society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		return "Address [hno=" + hno + ", society=" + society + ", areaName=" + areaName + "]";
	}

}
