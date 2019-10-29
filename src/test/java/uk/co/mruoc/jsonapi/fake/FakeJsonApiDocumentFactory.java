package uk.co.mruoc.jsonapi.fake;

import com.fasterxml.jackson.databind.JsonNode;
import uk.co.mruoc.jsonapi.JsonApiDocumentFactory;
import uk.co.mruoc.jsonapi.JsonApiDataDocumentRequest;
import uk.co.mruoc.jsonapi.fake.FakeAttributes.FakeAttributesBuilder;

import java.util.UUID;

public class FakeJsonApiDocumentFactory implements JsonApiDocumentFactory<FakeJsonApiDocument> {

    @Override
    public FakeJsonApiDocument build(JsonApiDataDocumentRequest request) {
        final FakeAttributes fakeAttributes = toAttributes(request);
        final FakeJsonApiDataItem item = new FakeJsonApiDataItem(fakeAttributes);
        return new FakeJsonApiDocument(item);
    }

    private FakeAttributes toAttributes(final JsonApiDataDocumentRequest request) {
        final JsonNode attributesNode = request.getAttributesNode();
        FakeAttributesBuilder builder = FakeAttributes.builder()
                .value1(attributesNode.get("value1").asText())
                .value2(attributesNode.get("value2").asText());
        request.getId().ifPresent(idNode -> builder.id(UUID.fromString(idNode.asText())));
        return builder.build();
    }

}
