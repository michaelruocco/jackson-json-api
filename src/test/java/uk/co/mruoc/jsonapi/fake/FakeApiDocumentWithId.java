package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiData;

public class FakeApiDocumentWithId extends FakeApiDocument {

    public FakeApiDocumentWithId(final FakeDomainObject attributes) {
        super(new FakeApiDataWithId(attributes));
    }

    public FakeApiDocumentWithId(final ApiData<FakeDomainObject> attributes) {
        super(attributes);
    }

}
