package com.dse.cms.web.entity;

import javax.persistence.*;

@Cacheable
@Table(name="TB_WECHATIMAGE")
@Entity
public class WeChatImage {

	private Integer id;

	private WeChat weChat;

	private String url;

	private String imgformat;

	private Byte[] images;

	@GeneratedValue
	@Id
	@Column(name = "id", nullable = false, length = 32)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JoinColumn(name="WECHAT_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	public WeChat getWeChat() {
		return weChat;
	}

	public void setWeChat(WeChat weChat) {
		this.weChat = weChat;
	}

	@Basic
	@Column(name = "tb_url", nullable = true, length = 150)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
	public Byte[] getImages() {
		return images;
	}

	public void setImages(Byte[] images) {
		this.images = images;
	}
}
