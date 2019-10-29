package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.JsonApiDataItem;
import uk.co.mruoc.jsonapi.JsonApiDocument;

public class FakeJsonApiDocument extends JsonApiDocument<FakeAttributes> {

    public FakeJsonApiDocument(final FakeAttributes attributes) {
        this(new FakeJsonApiDataItem(attributes));
    }

    public FakeJsonApiDocument(final Object id, final FakeAttributes attributes) {
        super(new FakeJsonApiDataItem(id, attributes));
    }

    public FakeJsonApiDocument(final JsonApiDataItem<FakeAttributes> attributes) {
        super(attributes);
    }

}
