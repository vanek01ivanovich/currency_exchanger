package com.test.spribetesttask;

import java.time.Instant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan("com.test.spribetesttask")
public class SpribeTestTaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpribeTestTaskApplication.class, args);
  }


}
