package com.test.spribetesttask.configuration.container;

import java.util.function.Supplier;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

public class PostgresqlContainer {

  private static final String USER = "postgres";
  private static final String PASSWORD = "password";
  private static final int PORT = 5432;
  private static final String TRUE_VALUE = "true";
  private static final String CONN_URL_TEMPLATE = "jdbc:postgresql://%s:%s/test_db";
  private static final DockerImageName image = DockerImageName.parse("postgres:latest");


  public static PostgreSQLContainer<?> create() {
    return new PostgreSQLContainer<>(image)
        .withDatabaseName("test_db")
        .withUsername(USER)
        .withPassword(PASSWORD);
  }

  public static void addProperties(final DynamicPropertyRegistry registry,
      final GenericContainer<?> sqlContainer) {
    registry.add("spring.datasource.username", () -> USER);
    registry.add("spring.datasource.password", () -> PASSWORD);
    registry.add("spring.datasource.url", buildUrl(sqlContainer));
  }

  public static void enableLiquibase(final DynamicPropertyRegistry registry) {
    registry.add("preliquibase.enabled", () -> TRUE_VALUE);
  }

  private static Supplier<Object> buildUrl(final GenericContainer<?> sqlContainer) {
    return () -> String.format(CONN_URL_TEMPLATE, sqlContainer.getHost(),
        sqlContainer.getMappedPort(PORT));
  }

}
