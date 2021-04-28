package com.haui.SaleLaptop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.haui.SaleLaptop.entities.ThanhVienEntity;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
@Autowired
ThanhVienService thanhVienService;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		ThanhVienEntity user=thanhVienService.loadUserByUsername(email);
		System.out.println("email đang tim"+email);
		System.out.println("thành viên:"+user);
		return user;
	}

}
