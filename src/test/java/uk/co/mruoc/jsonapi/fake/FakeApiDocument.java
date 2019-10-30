package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiData;
import uk.co.mruoc.jsonapi.ApiDocument;

public class FakeApiDocument extends ApiDocument<FakeAttributes> {

    public FakeApiDocument(final FakeAttributes attributes) {
        this(new FakeApiData(attributes));
    }

    public FakeApiDocument(final Object id, final FakeAttributes attributes) {
        super(new FakeApiData(id, attributes));
    }

    public FakeApiDocument(final ApiData<FakeAttributes> attributes) {
        super(attributes);
    }

}
