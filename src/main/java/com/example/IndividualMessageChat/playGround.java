package com.example.IndividualMessageChat;

public class playGround {
	
	public static void main(String args[]) {
		String str = "Vahan?$$$?hey man";
		
		System.out.println(str.substring(0, str.indexOf("?$$$?")));
		System.out.println(str.substring(str.indexOf("?$$$?")+5));
		
		
	}
}
