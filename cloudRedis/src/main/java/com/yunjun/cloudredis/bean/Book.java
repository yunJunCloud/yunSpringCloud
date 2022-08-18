package com.yunjun.cloudredis.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Book
 * @Description Book is to handle xxxx
 * @Author jack
 * @Date 8/11/2022 5:05 PM
 * @Version 1.0
 **/
@Data
public class Book implements Serializable {

	private String ID;
	private String Name;
	private String Author;
	private String Press;
	private String Key;
}
