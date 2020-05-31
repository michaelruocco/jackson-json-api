package uk.co.mruoc.jsonapi.fake;

public class FakeApiDocumentWithId extends FakeApiDocument {

    public FakeApiDocumentWithId(final FakeDomainObject attributes) {
        super(new FakeApiDataWithId(attributes));
    }

}
