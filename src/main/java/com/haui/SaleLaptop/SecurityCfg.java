package com.haui.SaleLaptop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityCfg extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()

		.antMatchers("/admin/css/**", "/admin/css/login/**", "/admin/fonts/**", "/admin/plugins/images/large/**", "/admin/plugins/images/users/**","/admin/plugins/images/**","/admin/less/icons/font-awesome/fonts/**","/user/js/vendor/**","/user/js/**","/user/css/**","/user/fonts/**","/user/images/product/large-size/**","/user/images/product/small-size/**","/user/images/banner/**","/user/images/menu/logo/**","/user/images/**","/user/images/featured-product/**","/user/images/shipping-icon/**")
		.permitAll()//cho phép truy cập
		//.antMatchers("/admin/**").hasAnyAuthority("Admin")//để lấy quyền admin//bảng role impelem crenautoriy
		.antMatchers("/admin1/**").hasAnyAuthority("Admin")//phải đăng nhập để vào các request có tiền tố /admin/
		.antMatchers("/user/**").hasAnyAuthority("User")
		.and()
		.formLogin().loginPage("/login").loginProcessingUrl("/perform_login")
		.failureUrl("/login?login_error=true").and().exceptionHandling().accessDeniedPage(("/login"))//chuyển đến trang login 
		//perform_login đường link đền bên form nếu thành công trả về trang chủ home
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true)//đăng xuất trả về trang home
		.deleteCookies("JSESSIONID").permitAll();
}

@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder(4));
}	
}
