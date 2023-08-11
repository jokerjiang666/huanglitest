package com.jiang.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.MybatisMapWrapperFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Configuration
@MapperScan("com.jiang.mapper")
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createdTime", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        this.setFieldValByName("updatedTime", LocalDateTime.now(), metaObject);
    }

    /**
     * 解决Map映射非驼峰 * @return
     */
    @Bean
    public ConfigurationCustomizer mybatisConfigurationCustomizer() {

        return new ConfigurationCustomizer() {

            /** * Customize the given a {@link MybatisConfiguration} object. * * @param configuration the configuration object to customize */
            @Override
            public void customize(MybatisConfiguration configuration) {

                configuration.setObjectWrapperFactory(new MybatisMapWrapperFactory());
            }
        };
    }

}
