package com.Users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.ErrorDecoder;

@Configuration
public class ErrorDeocder{

    @Bean
    public ErrorDecoder errorDecoder() {
        return new PlaylistErrorDecoder();
    }
}
