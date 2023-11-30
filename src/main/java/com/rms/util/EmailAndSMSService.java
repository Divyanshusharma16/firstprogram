package com.rms.util;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.comman.CommonConstants;
import com.rms.dao.EMRDataRepository;
import com.rms.model.SmsAndEmailResponseModel;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;



/**
 * @author Susheel.Kumar
 *
 */
@Service
public class EmailAndSMSService {
	@Autowired

	EMRDataRepository eMRDataRepository;
	
	  
	//public static final String ACCOUNT_SID = "AC3cf18a8e82972a7a29a4bf16a4374ecd";
	//public static final String AUTH_TOKEN = "ce05c1936c7e24b608e64509cd204839";
	 
	    
	 public  SmsAndEmailResponseModel sendSmsToUser(String toNumber,String fromNumber,String contentToSend ) {
		 Twilio.init(CommonConstants.ACCOUNT_SID, CommonConstants.AUTH_TOKEN);
	     Message message =null;
	     int  update_flag=0;
	     SmsAndEmailResponseModel smsAndEmailResponseModel=new SmsAndEmailResponseModel();
			/* message = Message.creator(
	             new com.twilio.type.PhoneNumber("+917906214191"),
	             new com.twilio.type.PhoneNumber("+16122236639"),
	             "Hello")
	         .create();*/
	    
	      /* String add="+91";
	       if(toNumber.startsWith("+91"))
	       {
	    	   toNumber=toNumber;
	       }else
	       {
	    	   toNumber= add.concat(toNumber);
	       }*/    
	     
	    if(StringUtils.isNotEmpty(toNumber)) {
			 
	    	 toNumber=StringUtils.deleteWhitespace(toNumber);
	    	 toNumber=StringUtils.remove(toNumber,"-");
	    	 toNumber=StringUtils.prependIfMissing (toNumber, "+91", "+91");
	  
	     
	       
	     try {
	              message = Message.creator(
                    
		             new com.twilio.type.PhoneNumber(toNumber),
		             new com.twilio.type.PhoneNumber(fromNumber),
                    	
		             contentToSend)
		             .create();
	               } catch (Exception e) {
				      System.out.println(e.getMessage());
			      }
		              System.out.println(message.getSid()); 
                     if(update_flag==0) {
                       //  smsAndEmailResponseModel.setMessageHasBeenSent(true);
                    	 String status="YES";
                    	 eMRDataRepository.updateSMSStatus(status,toNumber);
                     }
	    }else {
        	
       	 String status="NA";
       	 eMRDataRepository.updateSMSStatus(status,toNumber);
        }
                     
		return smsAndEmailResponseModel; 
	 }
	 
	 
	 
	 public  SmsAndEmailResponseModel sendEmailToUser(String emailTo,String emailFrom,String contentToSend ) throws IOException {
		  int  update_flag=0;
		     SmsAndEmailResponseModel smsAndEmailResponseModel=new SmsAndEmailResponseModel();
		     Email from = new Email(emailFrom);
		     String subject = CommonConstants.MAIL_SUBJECT;
		 if(!emailTo.isEmpty()) {
		    Email to = new Email(emailTo);
		    Content content = new Content("text/html",contentToSend);
		    Mail mail = new Mail(from, subject, to, content);

		   // SendGrid sg = new SendGrid("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");
		    SendGrid sg = new SendGrid(CommonConstants.API_KEY_SENDGRIDE);
		    Request request = new Request();
		    try {
		      request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      Response response = sg.api(request);
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		    } catch (IOException ex) {
		      throw ex;
		    }
		    
		    if(update_flag==0) {
		    	String status="YES";
		    	eMRDataRepository.updateEmailStatus(status,emailTo);
           	// smsAndEmailResponseModel.setEmailHasBeenSent(true);
		 }	 
            }else {
            	String status="NA";
		    	eMRDataRepository.updateEmailStatus(status,emailTo);
           	 //smsAndEmailResponseModel.setEmailHasBeenSent(false);
            }
			return smsAndEmailResponseModel;
		    
		  }
		 
		
		 
 }
	 