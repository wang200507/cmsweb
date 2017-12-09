package com.dse.cms.web.entity;

import javax.persistence.*;

@Cacheable
@Table(name="TB_WECHAT")
@Entity
public class WeChat {

	private Integer id;

	private String datetime;//日期

	 private String url;//文件来源

	private String title;//标题

	private String content;//内容文本

	private String html;//

	private String author;//作者

	private String imgformat;

	private byte[] images;

	@Transient
	private String imgUrl ;

	@GeneratedValue
	@Id
	@Column(name = "id", nullable = false, length = 32)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic
	@Column(name = "tb_datetime", nullable = true, length = 50)
	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	@Basic
	@Column(name = "tb_url", nullable = true, length = 500)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Basic
	@Column(name = "tb_title", nullable = true, length = 50)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Lob
	@Column(name = "tb_content", nullable = true)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Lob
	@Column(name = "tb_html", nullable = true)
	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	@Basic
	@Column(name = "tb_format", nullable = true,length=10)
	public String getImgformat() {
		return imgformat;
	}

	public void setImgformat(String imgformat) {
		this.imgformat = imgformat;
	}

	@Lob
	@Column(name = "tb_images", nullable = true)
	public byte[] getImages() {
		return images;
	}

	public void setImages(byte[] images) {
		this.images = images;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
