package com.example.duongnl_selling.infrastructure.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

            @Bean
           public ModelMapper modelMapper() {
               ModelMapper modelMapper = new ModelMapper();
               modelMapper.getConfiguration()
                       .setMatchingStrategy(MatchingStrategies.STANDARD);
               return modelMapper;
           }
}
