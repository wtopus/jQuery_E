package kr.ac.koreatech.book.dto;

// 이클래스는 객체를 만들기 위한 class에요
// 책 1권의 정보를 저장하기 위해 필요한 클래스
// DTO : Data Transfer Object ( 정형화된 용어 )
// entity, VO(Value Object), DO(Domain Object)

public class BookDTO {
	private String bimgurl;
	private String btitile;
	private String bauthor;
	private String bprice;
	
	public String getBimgurl() {
		return bimgurl;
	}
	public void setBimgurl(String bimgurl) {
		this.bimgurl = bimgurl;
	}
	public String getBtitile() {
		return btitile;
	}
	public void setBtitile(String btitile) {
		this.btitile = btitile;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBprice() {
		return bprice;
	}
	public void setBprice(String bprice) {
		this.bprice = bprice;
	}
	public String getBisbn() {
		return bisbn;
	}
	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}
	private String bisbn;
}
