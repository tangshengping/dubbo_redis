package com.hz.util.data;

public class TransData <T>{
	
	private int code = 1;// 是否成功

	private String message = "操作成功";// 提示信息

	private T data = null;// 数据值
	
	public TransData(){
		
	}
	
	public TransData(T data){
		this.code = 1;
		this.message = "操作成功";
		this.data = data;
	}
	
	public TransData(int code,String message){
		this.code = code;
		this.message = message;
		this.data = null;
	}
	
	public TransData(String message,T data){
		this.code = 1;
		this.message = message;
		this.data = data;
	}
	
	public TransData(int code,String message,T data){
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
