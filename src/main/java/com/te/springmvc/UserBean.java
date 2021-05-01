package com.te.springmvc;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserBean implements Serializable{

	private String username;
	private String password;
}
