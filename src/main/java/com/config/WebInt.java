//package com.config;
//
//
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.filter.HiddenHttpMethodFilter;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import javax.servlet.Filter;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//
///**
// * @author 张志强
// * @creat 2022/4/9-1:00
// * @Titile :WebInt
// * @ProjectName ssm
// * @Description :TODO
// */
//public class WebInt extends AbstractAnnotationConfigDispatcherServletInitializer {
//    /**
//     * 指定spring的配置类
//     * @return
//     */
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[]{SpringConfig.class};
//    }
//
//
//    /**
//     * 指定SpringMVC的配置类
//     * @return
//     */
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[]{WebConfig.class};
//    }
//
//    /**
//     * 指定DispatcherServlet的映射规则，即url-pattern
//     * @return
//     */
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//    /**
//     * 添加过滤器
//     * @return
//     */
//    @Override
//    protected Filter[] getServletFilters() {
//        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
//        encodingFilter.setEncoding("UTF-8");
//        encodingFilter.setForceRequestEncoding(true);
//        encodingFilter.setForceResponseEncoding(true);
//        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
//        return new Filter[]{encodingFilter, hiddenHttpMethodFilter};
//    }
//
//
//}
