package org.lyncc.bazinga;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.lyncc.bazinga.dao")
public class SpringBootMybatisShardingJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisShardingJdbcApplication.class, args);
    }

}
