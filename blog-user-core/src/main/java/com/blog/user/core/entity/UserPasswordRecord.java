package com.blog.user.core.entity;

import java.io.Serializable;

/**
 * 用户密码记录表
 */
public class UserPasswordRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long userId;
	private String passwordDes;
	private String passwordMd5;
	private Long createAt;

	public UserPasswordRecord() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPasswordDes() {
		return passwordDes;
	}

	public void setPasswordDes(String passwordDes) {
		this.passwordDes = passwordDes;
	}

	public String getPasswordMd5() {
		return passwordMd5;
	}

	public void setPasswordMd5(String passwordMd5) {
		this.passwordMd5 = passwordMd5;
	}

	public Long getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}

}
