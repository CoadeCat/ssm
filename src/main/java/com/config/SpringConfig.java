//package com.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.pool.DruidDataSourceFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.FilterType;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.stereotype.Controller;
//import org.apache.ibatis.io.Resources;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
///**
// * @author 张志强
// * @creat 2022/4/9-1:02
// * @Titile :SpringConfig
// * @ProjectName ssm
// * @Description :TODO
// */
//
//@Configuration
//@ComponentScan(basePackages = "com" ,excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)})
////开启MVC注解驱动
//@EnableWebMvc()
//@EnableTransactionManagement()
//public class SpringConfig {
//
//
//  @Bean
//  public DruidDataSource dataSource () throws Exception {
//
//    InputStream resourceAsStream = Resources.getResourceAsStream("jdbc.properties");
//    Properties properties = new Properties();
//    properties.load(resourceAsStream);
//    DruidDataSource druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
//    return  druidDataSource;
//  }
//
//
//  @Bean
//  public SqlSessionFactoryBean sqlSessionFactory(DruidDataSource druidDataSource) throws IOException {
//
//            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//            sqlSessionFactoryBean.setDataSource(druidDataSource);
//            sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
//            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com.mapper/*.xml"));
//            return  sqlSessionFactoryBean;
//  }
//
//  @Bean
//  public MapperScannerConfigurer mapperScannerConfigurer(){
//
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("com.dao");
//        return  mapperScannerConfigurer;
//  }
//
//   //事务管理器
//    @Bean
//    public DataSourceTransactionManager transactional (DruidDataSource druidDataSource){
//        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
//        dataSourceTransactionManager.setDataSource(druidDataSource);
//        return  dataSourceTransactionManager;
//    }
//
//
//}
