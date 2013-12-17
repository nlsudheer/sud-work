package com.example.android.facebook.base;


public class BaseHelper {

public  AndroidSolo solo;
	
	public BaseHelper(AndroidSolo helperSolo){
		this.solo = helperSolo;
	}
	
	public AndroidSolo getSolo(){
		return solo;
		
	}

}
