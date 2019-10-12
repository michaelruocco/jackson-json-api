package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public abstract class AbstractJsonApiDocumentDeserializer<T extends JsonApiDocument> extends StdDeserializer<T> {

    protected AbstractJsonApiDocumentDeserializer(final Class<T> type) {
        super(type);
    }

    @Override
    public T deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        final JsonNode node = parser.getCodec().readTree(parser);
        final JsonNode data = JsonNodeExtractor.extractDataNode(node);
        final String jsonApiType = JsonNodeExtractor.extractJsonApiType(data);
        final JsonNode attributes = JsonNodeExtractor.extractAttributesNode(data);
        return toDocument(parser, attributes, jsonApiType);
    }

    protected abstract T toDocument(final JsonParser parser,
                                    final JsonNode attributesNode,
                                    final String jsonApiType) throws IOException;

}
