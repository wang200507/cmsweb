package com.dse.cms.web.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;

@Cacheable
@Table(name="TB_WECHATIMAGE")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Entity
public class WeChatImage implements Serializable {

	private Integer id;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private WeChat weChat;

	private String url;

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
	public byte[] getImages() {
		return images;
	}

	public void setImages(byte[] images) {
		this.images = images;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
