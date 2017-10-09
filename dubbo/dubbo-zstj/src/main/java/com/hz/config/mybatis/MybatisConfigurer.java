package com.hz.config.mybatis;
import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
public class MybatisConfigurer implements TransactionManagementConfigurer{

    private static Log logger = LogFactory.getLog(MybatisConfigurer.class);

    @Autowired
    private DataSource dataSource;

    // 提供SqlSeesion
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource);
            // 手写配置
            // 配置类型别名
            sessionFactoryBean.setTypeAliasesPackage("com.hz.bean.mybatis");

            // 配置mapper的扫描，找到所有的mapper.xml映射文件
            Resource[] resources = new PathMatchingResourcePatternResolver()
                    .getResources("classpath:mybatis/mapper/*Mapper.xml");
            sessionFactoryBean.setMapperLocations(resources);

            // 加载全局的配置文件
            sessionFactoryBean.setConfigLocation(
                    new DefaultResourceLoader().getResource("classpath:mybatis/mybatis-config.xml"));

            return sessionFactoryBean.getObject();
        } catch (IOException e) {
            logger.warn("mybatis resolver mapper*xml is error");
            return null;
        } catch (Exception e) {
            logger.warn("mybatis sqlSessionFactoryBean create error");
            return null;
        }
    }


    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}