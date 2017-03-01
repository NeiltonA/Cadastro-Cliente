package br.com.control;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "LoginMB")
@SessionScoped
public class LoginManagedBean {


     public String envia() {
    	 
    		 

    			   return "principal.xhtml? faces-redirect-true";

    
    	
        
         
         
   }
   


}