package sendemail;


import java.util.Scanner;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GMailAuthenticator {


	public static void main(String[] args)throws Exception {
	Address ad=new Address();
	ad.sendmessage();
	
}
}

class Address{
	void sendmessage()throws Exception {
	Set<String> list=new TreeSet<>();
	Scanner sc=new Scanner(System.in);
	System.out.print("please enter how many mail will be sent :");
	int a=sc.nextInt();
	sc.nextLine();
	for (int i=0;i<a;i++) {
		list.add(sc.nextLine());
	}
	sc.close();
	int count=0;
	int count1=0;
	for(String str:list) {
		list.add(str);
	}
	for (String name : list)
    {
    	String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +  
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
 
        Pattern pattern = Pattern.compile(regex);
        String mail=name;
      Matcher matcher = pattern.matcher(name);
      if(matcher.matches()) {
    	  String sendname=name.substring(0, name.indexOf('@'));
  		
  		System.out.println("prepare to send mail: "+sendname);
  		
  		Sendmail.sendme(mail,sendname);
  		count++;
      }
      else {
    	  
    	  System.out.println("invail mail");
    	  count1++;
      }
    }
	System.out.println();
	System.out.println("Total send message :  "+count);
	System.out.println("Total Invail mail : "+count1);	
	}
}




