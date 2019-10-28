package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.JsonApiDataItem;
import uk.co.mruoc.jsonapi.JsonApiDocument;

public class FakeJsonApiDocument extends JsonApiDocument<FakeAttributes> {

    public FakeJsonApiDocument() {
        this(new FakeAttributes());
    }

    public FakeJsonApiDocument(final FakeAttributes attributes) {
        this("fake-attributes-type", attributes);
    }

    public FakeJsonApiDocument(final String type, final FakeAttributes attributes) {
        this(new JsonApiDataItem<>(type, attributes));
    }

    public FakeJsonApiDocument(final JsonApiDataItem<FakeAttributes> attributes) {
        super(attributes);
    }

}
