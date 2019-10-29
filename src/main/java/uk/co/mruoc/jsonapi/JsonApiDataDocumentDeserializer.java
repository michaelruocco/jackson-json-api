package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class JsonApiDataDocumentDeserializer<D extends JsonApiDocument, A> extends StdDeserializer<D> {

    private final JsonApiDocumentFactory<D> documentFactory;

    public JsonApiDataDocumentDeserializer(final Class<D> type,
                                           final JsonApiDocumentFactory<D> documentFactory) {
        super(type);
        this.documentFactory = documentFactory;
    }

    @Override
    public D deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        final JsonNode rootNode = parser.getCodec().readTree(parser);
        final JsonNode dataNode = rootNode.get("data");
        final JsonApiDataDocumentRequest request = JsonApiDataDocumentRequest.builder()
                .parser(parser)
                .context(context)
                .rootNode(rootNode)
                .dataNode(dataNode)
                .id(dataNode.get("id"))
                .type(dataNode.get("type").asText())
                .attributesNode(dataNode.get("attributes"))
                .build();
        return documentFactory.build(request);
    }

}
