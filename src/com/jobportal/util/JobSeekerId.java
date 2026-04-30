package com.jobportal.util;

public class JobSeekerId {
	public static String GetJobSeekerId(String id){
		int codeLength=5;
		
		int x=0;
		x=x+1;
		String strId=""+x;
		if(strId.length()!=codeLength){
			int len=strId.length();
			for(int i=0;i<codeLength-len;i++)
				strId="0"+strId;
		}
		String startCode="uid";
		return (startCode+strId);
	}
}
