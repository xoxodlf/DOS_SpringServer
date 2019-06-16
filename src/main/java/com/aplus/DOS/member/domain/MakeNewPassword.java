package com.aplus.DOS.member.domain;

import java.util.Random;

public class MakeNewPassword {
	public static String getRandomString(int length)
	{
	  StringBuffer buffer = new StringBuffer();
	  Random random = new Random();
	 
	  String chars[] = 
	    "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,1,2,3,4,5,6,7,8,9".split(",");
	 
	  for (int i=0 ; i<length ; i++)
	  {
	    buffer.append(chars[random.nextInt(chars.length)]);
	  }
	  return buffer.toString();
	}
}
