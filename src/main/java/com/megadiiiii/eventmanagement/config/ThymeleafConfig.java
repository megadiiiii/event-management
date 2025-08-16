package com.megadiiiii.eventmanagement.config;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfig {

    @Bean
    public LayoutDialect layoutDialect() {  // ← Và dòng này
        return new LayoutDialect();
    }
}