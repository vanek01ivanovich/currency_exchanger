package com.test.spribetesttask.util;

import lombok.experimental.UtilityClass;
import org.springframework.web.util.DefaultUriBuilderFactory;

@UtilityClass
public class FixerApiUtil {

  public static String buildAccessKeyUrl(String url, String accessKey) {
    return new DefaultUriBuilderFactory(url).builder()
        .path("/latest")
        .queryParam("access_key", accessKey)
        .build().toString();
  }

  public static String buildAccessKeyWithBaseCurrencyUrl(String url, String accessKey,
      String baseCurrency) {
    return new DefaultUriBuilderFactory(url).builder()
        .path("/latest")
        .queryParam("access_key", accessKey)
        .queryParam("base", baseCurrency)
        .build().toString();
  }

}
