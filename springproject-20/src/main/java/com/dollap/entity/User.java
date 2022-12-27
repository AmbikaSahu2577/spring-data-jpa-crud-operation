package com.dollap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="userTab")
public class User {
	@Id
	@Column(name="uId")
private Integer userId;
	@Column(name="uName")
private String  userName;
	@Column(name="uEmai")
private String userEmail;
	@Column(name="uStatus")
private String userStatus;
	
	
}
