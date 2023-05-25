package com.web.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.web.dao.UserInfoDAO;
import com.web.entity.Account;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	@Autowired
	private UserInfoDAO userinfor;
	
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		String username = authentication.getName();
       	
       	List<String> roles = userinfor.getUserRoles(username);
       	
        String redirectURL = request.getContextPath();
         
        if (checkRole("ADMIN", roles)) {
            redirectURL = "admin/trang-chu";
        } else if (checkRole("USER", roles)) {
            redirectURL = "trang-chu";
        } 
         
        response.sendRedirect(redirectURL);
         
	}



	public boolean checkRole(String role,List<String> list) {
		for(String s : list) {
			if(s.equals(role)) {
				return true;
			}
		}
		return false;
	}
}
