package my.gallery.domain;

public class Cat {
	private int nr;
	private String name;
	private String pictureSrc;// = "img/flying.gif";
	private String comment;

	public Cat(int nr, String name, String pictureSrc, String comment) {
		super();
		this.nr = nr;
		this.name = name;
		this.pictureSrc = pictureSrc;
		this.comment = comment;
	}

	public Cat() {

	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPictureSrc() {
		return pictureSrc;
	}

	public void setPictureSrc(String pictureSrc) {
		this.pictureSrc = pictureSrc;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
