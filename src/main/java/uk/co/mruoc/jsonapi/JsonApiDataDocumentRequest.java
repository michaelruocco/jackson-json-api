package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class JsonApiDataDocumentRequest {

    private final JsonParser parser;
    private final DeserializationContext context;
    private final JsonNode rootNode;
    private final JsonNode dataNode;

}
