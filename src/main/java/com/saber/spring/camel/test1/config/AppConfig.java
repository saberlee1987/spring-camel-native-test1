package com.saber.spring.camel.test1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = "classpath:camel.xml")
public class AppConfig {
}
