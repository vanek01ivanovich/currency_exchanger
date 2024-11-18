package com.test.spribetesttask.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

public class RateDtoDeserializer extends StdDeserializer<HashMap<String, BigDecimal>> {

  public RateDtoDeserializer() {
    this(null);
  }

  public RateDtoDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public HashMap<String, BigDecimal> deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
    JsonNode node = jsonParser.getCodec().readTree(jsonParser);
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.convertValue(node, new TypeReference<>() {});
  }
}
