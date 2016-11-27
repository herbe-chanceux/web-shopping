package huel.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeCreator {
    public  String createAccountcode(Integer userid)
    {   System.out.println("codecreater:  userid="+userid);
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
    	String accountCode=sdf.format(new Date()).toString();
    	if(userid<10){
    		accountCode=accountCode+"00"+userid.toString();
    	}else if(userid<100){
    		accountCode=accountCode+"0"+userid.toString();
    	}
    	else{
    		accountCode=accountCode+userid.toString();
    	}
    	return accountCode;
    }
}
