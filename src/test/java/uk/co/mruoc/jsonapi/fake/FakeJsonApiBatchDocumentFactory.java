package uk.co.mruoc.jsonapi.fake;

import com.fasterxml.jackson.databind.JsonNode;
import uk.co.mruoc.jsonapi.JsonApiDataDocumentRequest;
import uk.co.mruoc.jsonapi.JsonApiDocumentFactory;
import uk.co.mruoc.jsonapi.fake.FakeAttributes.FakeAttributesBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

import static uk.co.mruoc.jsonapi.JsonApiDocumentFactory.extractAttributesNode;
import static uk.co.mruoc.jsonapi.JsonApiDocumentFactory.extractIdNode;

public class FakeJsonApiBatchDocumentFactory implements JsonApiDocumentFactory<FakeJsonApiBatchDocument> {

    private final Function<String, Object> idParser;

    public FakeJsonApiBatchDocumentFactory() {
        this(new UuidIdParser());
    }

    public FakeJsonApiBatchDocumentFactory(final Function<String, Object> idParser) {
        this.idParser = idParser;
    }

    @Override
    public FakeJsonApiBatchDocument build(JsonApiDataDocumentRequest request) {
        final JsonNode dataNode = request.getDataNode();
        final Collection<FakeAttributes> attributes = new ArrayList<>();
        for (final JsonNode dataItemNode : dataNode) {
            attributes.add(toAttributes(dataItemNode));
        }
        return new FakeJsonApiBatchDocument(attributes);
    }

    private FakeAttributes toAttributes(final JsonNode dataNode) {
        final Optional<JsonNode> idNode = extractIdNode(dataNode);
        final JsonNode attributesNode = extractAttributesNode(dataNode);
        final FakeAttributesBuilder builder = FakeAttributes.builder()
                .value1(attributesNode.get("value1").asText())
                .value2(attributesNode.get("value2").asText());
        idNode.ifPresent(node -> builder.id(idParser.apply(node.asText())));
        return builder.build();
    }

}
