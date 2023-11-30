package com.rms.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;


@Component
public class UtilityService {
	
	
	       public  String readMsgEmail() {
           StringBuilder sb = new StringBuilder();
	        
	        try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\rajish.nair\\Desktop\\msg1.txt"))) {

	            // read line by line
	            String line;
	            while ((line = br.readLine()) != null) {
	                sb.append(line).append("\n");
	            }

	        } catch (IOException e) {
	            System.err.format("IOException: %s%n", e);
	        }
             System.out.println(sb);
	         return sb.toString();
	    }
		
		
	       
	       
		public  String readSMSMsg() {

	        StringBuilder sb = new StringBuilder();
	        
	        try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\rajish.nair\\Desktop\\sms.txt"))) {

	            // read line by line
	            String line;
	            while ((line = br.readLine()) != null) {
	                sb.append(line).append("\n");
	            }

	        } catch (IOException e) {
	            System.err.format("IOException: %s%n", e);
	        }

	        System.out.println(sb);
	         return sb.toString();
	    }
		
		
		
		public static String getNextDay(int interval) {
			 final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			     Date currentDate = new Date();
		        // convert date to calendar
		        Calendar c = Calendar.getInstance();
		        c.setTime(currentDate);	
		        Date currentDatePlusOne=c.getTime();
		        String result=null;
		        try{		        	
					 c.add(Calendar.DATE,interval );
			          currentDatePlusOne = c.getTime(); 	
		        }catch (Exception e) {
					e.printStackTrace();
				}finally {
					result=dateFormat.format(currentDatePlusOne).toString()	;
				}		                    
		        return result;
		}
	
		
		
		 public String dateFormate(String strDate) {

 			//String strDate= "2019-05-02 11:16:38";  

 	        String returnDate="";
 	        String returnDate1="";
 	        String formateDate="";
 	        
 	        
 			try {
 				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
 				Date date = sdf.parse(strDate);
 				 sdf.applyPattern("MMM,dd");
 					  returnDate= sdf.format(date);
 					  sdf.applyPattern("ha");
 					  returnDate1= sdf.format(date);
 					  formateDate=returnDate+" at "+returnDate1;
 			}
 			catch(Exception e){
 				System.err.println(e);
 			}
 	               return formateDate;  
 	    
 	}
}
