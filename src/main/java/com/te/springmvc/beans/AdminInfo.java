package com.te.springmvc.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="admin")
@Entity
public class AdminInfo implements Serializable {
	@Id
	@Column
	private int adminid;
	@Column
	private String adminpwd;
}
