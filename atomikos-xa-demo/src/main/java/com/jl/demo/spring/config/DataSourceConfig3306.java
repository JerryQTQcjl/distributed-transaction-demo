package com.jl.demo.spring.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author jerry chan
 * @date 2023/7/23 19:35
 */
@Configuration
@MapperScan(value = "com.jl.demo.spring.repository.mapper.db3306", sqlSessionFactoryRef = "sqlSessionFactory3306")
public class DataSourceConfig3306 extends AbstractDataSourceConfig {

    @Bean
    public DataSource dataSource3306() {
        AtomikosDataSourceBean datasource = new AtomikosDataSourceBean();
        DruidXADataSource druidXADataSource = createDruidXADataSource("jdbc:mysql://localhost:3306/xa_test", "root", "123456");
        datasource.setXaDataSource(druidXADataSource);
        datasource.setUniqueResourceName("local_3306");
        return datasource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory3306() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource3306());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/db3306/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
}
