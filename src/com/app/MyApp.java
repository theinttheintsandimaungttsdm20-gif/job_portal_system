package com.app;

public class MyApp {

	public static void main(String[] args) {

    String myStr = "uid01000";
    String subStr=myStr.substring(myStr.indexOf("0")+1);
    int a=Integer.parseInt(subStr)+1;
    String b=""+a;
	int codeLength=5;
	
	if(b.length()!=codeLength){
		int len=b.length();
		for(int i=0;i<codeLength-len;i++)
			b="0"+b;
	}
	String startCode="uid";
	String d=startCode+b;

    System.out.println(d);
  }
	
	}
