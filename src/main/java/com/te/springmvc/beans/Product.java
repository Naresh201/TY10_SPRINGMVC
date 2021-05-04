package com.te.springmvc.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product implements Serializable{
     @Id
     @Column
	private int productid;
     @Column
     private String productname;
     @Column
     private int productprice;
     @Column
     private int quantity;
}
