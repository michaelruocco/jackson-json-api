package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiData;
import uk.co.mruoc.jsonapi.ApiDocument;

public class FakeApiDocument extends ApiDocument<FakeDomainObject> {

    public FakeApiDocument(final FakeDomainObject attributes) {
        super(new FakeApiData(attributes));
    }

    public FakeApiDocument(final ApiData<FakeDomainObject> attributes) {
        super(attributes);
    }

}
