package uk.co.mruoc.jsonapi.fake;

import com.fasterxml.jackson.databind.JsonNode;
import uk.co.mruoc.jsonapi.JsonApiDocumentFactory;
import uk.co.mruoc.jsonapi.JsonApiDataDocumentRequest;
import uk.co.mruoc.jsonapi.fake.FakeAttributes.FakeAttributesBuilder;

import java.util.Optional;
import java.util.function.Function;

import static uk.co.mruoc.jsonapi.JsonApiDocumentFactory.extractAttributesNode;
import static uk.co.mruoc.jsonapi.JsonApiDocumentFactory.extractIdNode;

public class FakeJsonApiDocumentFactory implements JsonApiDocumentFactory<FakeJsonApiDocument> {

    private final Function<String, Object> idParser;

    public FakeJsonApiDocumentFactory() {
        this(new UuidIdParser());
    }

    public FakeJsonApiDocumentFactory(final Function<String, Object> idParser) {
        this.idParser = idParser;
    }

    @Override
    public FakeJsonApiDocument build(JsonApiDataDocumentRequest request) {
        final FakeAttributes fakeAttributes = toAttributes(request);
        final FakeJsonApiDataItem item = new FakeJsonApiDataItem(fakeAttributes);
        return new FakeJsonApiDocument(item);
    }

    private FakeAttributes toAttributes(final JsonApiDataDocumentRequest request) {
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
