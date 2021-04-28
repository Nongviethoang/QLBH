
public class Salare {
private int hs,luong,ngaylam;

public int getHs() {
	return hs;
}

public void setHs(int hs) {
	this.hs = hs;
}

public int getLuong() {
	return luong;
}

public void setLuong(int luong) {
	this.luong = luong;
}

public int getNgaylam() {
	return ngaylam;
}

public void setNgaylam(int ngaylam) {
	this.ngaylam = ngaylam;
}

public Salare(int hs, int luong, int ngaylam) {
	super();
	this.hs = hs;
	this.luong = luong;
	this.ngaylam = ngaylam;
}

@Override
public String toString() {
	return "he so luong=" + hs + "\n luong=" + luong + "\n ngaylam=" + ngaylam + "]";
}

}
