package com.gt.config;

import com.gt.HandlerInterceptor.LoginInterceptor;
import com.gt.bean.Pet;
import com.gt.converter.aliceConverter;
import com.gt.converter.wannaConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration(proxyBeanMethods = true)
public class WebConfig{


    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter httpMethodFilter = new HiddenHttpMethodFilter();
        httpMethodFilter.setMethodParam("_m");
        return httpMethodFilter;
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                WebMvcConfigurer.super.addInterceptors(registry);
                registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**"); //放行的请求
            }

            //ContentNegotiationStrategy
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> map = new HashMap<>();
                map.put("json", MediaType.APPLICATION_JSON);
                map.put("xml",MediaType.APPLICATION_XML);
                map.put("alice-wanna",MediaType.parseMediaType("application/alice-wanna"));
                map.put("wanna",MediaType.parseMediaType("application/wanna"));
                ParameterContentNegotiationStrategy strategy = new ParameterContentNegotiationStrategy(map);
                strategy.setParameterName("myFormat");
                HeaderContentNegotiationStrategy headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();
                configurer.strategies(Arrays.asList(strategy,headerContentNegotiationStrategy));
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                WebMvcConfigurer.super.extendMessageConverters(converters);
                converters.add(new wannaConverter());
                converters.add(new aliceConverter());
            }

            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                WebMvcConfigurer.super.configurePathMatch(configurer);
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        if(StringUtils.hasLength(source)){
                            String[] split = source.split("--");
                            Pet pet = new Pet();
                            pet.setName(split[0]);
                            pet.setAge(Integer.parseInt(split[1]));
                            return pet;
                        }
                        return null;
                    }
                });
//                registry.addConverter(new Converter<String, Pet>() {
//                    @Override
//                    public Pet convert(String source) {
//                        if(StringUtils.hasLength(source)){
//                            Pet pet = new Pet();
//                            String[] split = source.split(",");
//                            pet.setName(split[0]);
//                            pet.setAge(Integer.parseInt(split[1]));
//                            return pet;
//                        }
//                        return null;
//                    }
//                });
//                registry.addConverter((Converter<String, Pet>) source -> {
//                    if(!StringUtils.hasLength(source)){
//                        Pet pet = new Pet();
//                        String[] split = source.split(",");
//                        pet.setName(split[0]);
//                        pet.setAge(Integer.parseInt(split[1]));
//                        return pet;
//                    }
//                    return null;
//                });
            }
        };
    }
}
