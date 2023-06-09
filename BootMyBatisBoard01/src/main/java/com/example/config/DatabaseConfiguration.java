package com.example.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //스프링프레임워크이 설정파일임을 나타냄
public class DatabaseConfiguration {
    @Autowired 
    private ApplicationContext applicationContext; //스프링컨테이너에 존재하는 bean을 찾거나 생성하는 기능을함
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    	
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource( dataSource ); //스프링과 mybatis를 통합
        sqlSessionFactoryBean.setMapperLocations( //mybatis의 매퍼파일위치를 지정하는 메소드
            applicationContext.getResources("classpath:/mappers/mapper.xml") );
        

        return sqlSessionFactoryBean.getObject();
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}