package com.test.spribetesttask;

import com.test.spribetesttask.configuration.annotations.SpribeTaskSpringBootTest;
import com.test.spribetesttask.configuration.container.PostgresqlContainer;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;

@SpribeTaskSpringBootTest
public class SpribeTestTaskSpringBootTest {

  static final GenericContainer<?> postgresqlContainer;

  static {
    postgresqlContainer = PostgresqlContainer.create();
    postgresqlContainer.start();
  }

  @DynamicPropertySource
  static void initiatePropertiesAndSchema(DynamicPropertyRegistry registry) {
    PostgresqlContainer.addProperties(registry, postgresqlContainer);
    PostgresqlContainer.enableLiquibase(registry);
  }

}
