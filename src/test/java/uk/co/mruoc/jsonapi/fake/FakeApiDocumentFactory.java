package uk.co.mruoc.jsonapi.fake;

import com.fasterxml.jackson.databind.JsonNode;
import uk.co.mruoc.jsonapi.ApiDocumentFactory;
import uk.co.mruoc.jsonapi.ApiDataDocumentRequest;
import uk.co.mruoc.jsonapi.fake.FakeAttributes.FakeAttributesBuilder;

import java.util.Optional;
import java.util.function.Function;

import static uk.co.mruoc.jsonapi.ApiDocumentFactory.extractAttributesNode;
import static uk.co.mruoc.jsonapi.ApiDocumentFactory.extractIdNode;

public class FakeApiDocumentFactory implements ApiDocumentFactory<FakeApiDocument> {

    private final Function<String, Object> idParser;

    public FakeApiDocumentFactory() {
        this(new UuidIdParser());
    }

    public FakeApiDocumentFactory(final Function<String, Object> idParser) {
        this.idParser = idParser;
    }

    @Override
    public FakeApiDocument build(ApiDataDocumentRequest request) {
        final FakeAttributes fakeAttributes = toAttributes(request);
        final FakeApiData item = new FakeApiData(fakeAttributes);
        return new FakeApiDocument(item);
    }

    private FakeAttributes toAttributes(final ApiDataDocumentRequest request) {
        final JsonNode dataNode = request.getDataNode();
        final Optional<JsonNode> idNode = extractIdNode(dataNode);
        final JsonNode attributesNode = extractAttributesNode(dataNode);
        final FakeAttributesBuilder builder = FakeAttributes.builder()
                .value1(attributesNode.get("value1").asText())
                .value2(attributesNode.get("value2").asText());
        idNode.ifPresent(node -> builder.id(idParser.apply(node.asText())));
        return builder.build();
    }

}
