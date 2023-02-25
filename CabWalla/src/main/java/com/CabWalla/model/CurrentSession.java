package com.CabWalla.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrentSession {

	@Id
	@Column(unique = true)
	private Integer userId;
	
	private String uuid;
	
	private LocalDateTime time;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CurrentSession [userId=" + userId + ", uuid=" + uuid + ", time=" + time + "]";
	}

	public CurrentSession(Integer userId, String uuid, LocalDateTime time) {
		super();
		this.userId = userId;
		this.uuid = uuid;
		this.time = time;
	}

	public CurrentSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
