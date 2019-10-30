package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiDataItem;
import uk.co.mruoc.jsonapi.ApiDocument;

public class FakeApiDocument extends ApiDocument<FakeAttributes> {

    public FakeApiDocument(final FakeAttributes attributes) {
        this(new FakeApiDataItem(attributes));
    }

    public FakeApiDocument(final Object id, final FakeAttributes attributes) {
        super(new FakeApiDataItem(id, attributes));
    }

    public FakeApiDocument(final ApiDataItem<FakeAttributes> attributes) {
        super(attributes);
    }

}
