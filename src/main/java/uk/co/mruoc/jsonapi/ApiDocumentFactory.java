package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public interface ApiDocumentFactory<D> {

    D build(final ApiDataDocumentRequest request) throws IOException;

    static Optional<JsonNode> extractIdNode(final JsonNode dataNode) {
        return Optional.ofNullable(dataNode.get("id"));
    }

    static JsonNode extractTypeNode(final JsonNode dataNode) {
        return dataNode.get("type");
    }

    static JsonNode extractAttributesNode(final JsonNode dataNode) {
        return dataNode.get("attributes");
    }

    class StringIdParser implements Function<String, Object> {

        @Override
        public Object apply(final String value) {
            return value;
        }

    }

    class UuidIdParser implements Function<String, Object> {

        @Override
        public Object apply(final String value) {
            return UUID.fromString(value);
        }

    }

    class LongIdParser implements Function<String, Object> {

        @Override
        public Object apply(final String value) {
            return Long.parseLong(value);
        }

    }

}
