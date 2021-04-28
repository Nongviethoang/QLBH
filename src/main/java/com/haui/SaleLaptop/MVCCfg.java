package com.haui.SaleLaptop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class MVCCfg implements WebMvcConfigurer,Constaint {
			@Bean
			public ViewResolver viewResolver() {
				InternalResourceViewResolver bean = new InternalResourceViewResolver();
				bean.setViewClass(JstlView.class);
				bean.setPrefix("/WEB-INF/views/"); 
				bean.setSuffix(".jsp");
				return bean;
			}
//			cấu hình các static resource	
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				//Front end admin site
				registry.addResourceHandler("/admin/js/**").addResourceLocations("classpath:/META-INF/admin/js/");
				
				registry.addResourceHandler("/admin/css/**").addResourceLocations("classpath:/META-INF/admin/css/");
				registry.addResourceHandler("/admin/css/login/**").addResourceLocations("classpath:/META-INF/admin/css/login/");
				registry.addResourceHandler("/admin/fonts/**").addResourceLocations("classpath:/META-INF/admin/fonts/");
				registry.addResourceHandler("/admin/plugins/images/large/**").addResourceLocations("classpath:/META-INF/admin/plugins/images/large/");
				registry.addResourceHandler("/admin/plugins/images/users/**").addResourceLocations("classpath:/META-INF/admin/plugins/images/users/");
				registry.addResourceHandler("/admin/plugins/images/**").addResourceLocations("classpath:/META-INF/admin/plugins/images/");
				registry.addResourceHandler("/admin/less/icons/font-awesome/fonts/**").addResourceLocations("classpath:/META-INF/admin/less/icons/font-awesome/fonts/");
				//upload file image
				registry.addResourceHandler("/upload/**").addResourceLocations("file:"+ROOT_UPDATE_PATH);
				//Front end user site
				registry.addResourceHandler("/user/js/vendor/**").addResourceLocations("classpath:/META-INF/user/js/vendor/");
				registry.addResourceHandler("/user/js/**").addResourceLocations("classpath:/META-INF/user/js/");
				registry.addResourceHandler("/user/css/**").addResourceLocations("classpath:/META-INF/user/css/");
				registry.addResourceHandler("/user/fonts/**").addResourceLocations("classpath:/META-INF/user/fonts/");
				registry.addResourceHandler("/user/images/product/large-size/**").addResourceLocations("classpath:/META-INF/user/images/product/large-size/");
				registry.addResourceHandler("/user/images/product/small-size/**").addResourceLocations("classpath:/META-INF/user/images/product/small-size/");
				registry.addResourceHandler("/user/images/banner/**").addResourceLocations("classpath:/META-INF/user/images/banner/");
				registry.addResourceHandler("/user/images/menu/logo/**").addResourceLocations("classpath:/META-INF/user/images/menu/logo/");
				
				registry.addResourceHandler("/user/images/**").addResourceLocations("classpath:/META-INF/user/images/");
				registry.addResourceHandler("/user/images/featured-product/**").addResourceLocations("classpath:/META-INF/user/images/featured-product/");
				registry.addResourceHandler("/user/images/shipping-icon/**").addResourceLocations("classpath:/META-INF/user/images/shipping-icon/");
			}	
			
}
