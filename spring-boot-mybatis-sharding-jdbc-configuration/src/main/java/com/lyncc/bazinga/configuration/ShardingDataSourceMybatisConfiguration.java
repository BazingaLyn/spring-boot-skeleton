package com.lyncc.bazinga.configuration;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Configuration
public class ShardingDataSourceMybatisConfiguration {


    @Bean
    public DataSource ds0() {
        DruidDataSource druidDataSource =  new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://49.235.67.172:3306/ds0?useUnicode=true&amp&characterEncoding=utf-8");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("1qaz2wsx!");
        druidDataSource.setDbType("com.alibaba.druid.pool.DruidDataSource");
        return druidDataSource;
    }

    @Bean
    public DataSource ds1() {
        DruidDataSource druidDataSource =  new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://49.235.67.172:3306/ds1?useUnicode=true&amp&characterEncoding=utf-8");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("1qaz2wsx!");
        druidDataSource.setDbType("com.alibaba.druid.pool.DruidDataSource");
        return druidDataSource;
    }


    @Bean
    public DataSource shardingDataSource() throws SQLException {
        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        dataSourceMap.put("ds0", ds0());

        dataSourceMap.put("ds1", ds1());

        // 配置Order表规则
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration("t_order","ds${0..1}.t_order_${0..2}");

        // 配置分库 + 分表策略
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "ds${user_id % 2}"));
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "t_order_${user_id % 3}"));

        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);


        // 获取数据源对象
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new Properties());
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactory() throws IOException, SQLException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //Mybatis的参数配置
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //启用Mybatis的全部xml文件，就不需要一个个去打开
        String packageSerchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/mappers/**.xml";
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSerchPath));
        sqlSessionFactoryBean.setDataSource(shardingDataSource());
        //实体类所在的包
        sqlSessionFactoryBean.setTypeAliasesPackage("org.lyncc.bazinga.model");
        return sqlSessionFactoryBean;
    }


    @Bean
    public MapperScannerConfigurer createMapperConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.lyncc.bazinga.dao");
        return mapperScannerConfigurer;
    }


}
