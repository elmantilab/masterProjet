package configAncien;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by xvitcoder on 12/24/15.
 */
//@Configuration
//@EnableWebMvc
//@WebAppConfiguration
//@ComponentScan(basePackages = "com.glv")


//@ComponentScan(basePackages = { "com.glv" }, excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = Configuration.class) })

//@Import({ThymeleafConfig.class})
public class AppConfig2 //extends WebMvcConfigurerAdapter 
{
//
//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/WEB-INF/html/");
//        viewResolver.setSuffix(".html");
//
////        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
////        resolver.setPrefix("/WEB-INF/html/");
////        resolver.setSuffix(".html");
////        resolver.setTemplateMode("HTML5");
////        resolver.setCacheable(false);
//        return viewResolver;
//    }
//
// 
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//
//    @Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new MappingJackson2HttpMessageConverter());
//        super.configureMessageConverters(converters);
//    }
}
