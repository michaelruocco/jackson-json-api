package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiDocumentWithId;

public class FakeApiDocumentWithId extends ApiDocumentWithId<Object, FakeDomainObject> {

    public FakeApiDocumentWithId(final FakeDomainObject attributes) {
        super(new FakeApiDataWithId(attributes));
    }

}
