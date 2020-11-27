package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class ApiDocumentDeserializer<D> extends StdDeserializer<D> {

    private final transient ApiDocumentFactory<D> documentFactory;

    public ApiDocumentDeserializer(final Class<D> type,
                                   final ApiDocumentFactory<D> documentFactory) {
        super(type);
        this.documentFactory = documentFactory;
    }

    @Override
    public D deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        final JsonNode rootNode = parser.getCodec().readTree(parser);
        final JsonNode dataNode = rootNode.get("data");
        final ApiDataDocumentRequest request = ApiDataDocumentRequest.builder()
                .parser(parser)
                .context(context)
                .rootNode(rootNode)
                .dataNode(dataNode)
                .build();
        return documentFactory.build(request);
    }

}
