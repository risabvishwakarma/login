package spring.rest.loginControler;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginControlerJava {
	
	@Autowired
	Mail_Sending ms=null;
	
	HashMap<String,String[]> hm=new HashMap<String, String[]>();
	String Otp;
	//String id;
	
	
	String timeMilli;
	@GetMapping("/")
	public String loginPage() {
		
		return "login";
		 
	}
	
	@GetMapping("/otpgen")
	public String optgn(@RequestParam String userid,HttpSession session,Model m,HttpServletRequest serv) {
		
		 Date date = new Date();
		int max=9999;
		int min=1000;
		int a=a = (int) (Math.random()*(max-min+1)+min); 
		Otp=""+a;
	//	System.out.println("OTP  : "+Otp);
		
		if(false==ms.send(userid, Otp))return "/";
		timeMilli = String.valueOf(date.getTime());
		//id=userid;
		//System.out.println(timeMilli);
		m.addAttribute("id",userid);
		hm.put(session.getId(),new String[] {userid,Otp,timeMilli});
		return "wellcome";
		
	}
	@PostMapping("/log")
	public String log (@RequestParam String otp,Model m,HttpSession session)throws Exception {
m.addAttribute("message",hm.get(session.getId())[0]);
		 Date date = new Date();
		long timeMilli2 = date.getTime();
		long PtimeMilli=Long.parseLong(hm.get(session.getId())[2])+30000;
		//System.out.println(PtimeMilli+" "+timeMilli2+" "+(timeMilli2-PtimeMilli));
		if(!otp.equals(hm.get(session.getId())[1]) || timeMilli2>PtimeMilli)return "wellcome";
		hm.remove(session.getId());
		return "er";
		
	}
	

}
