package uk.co.mruoc.jsonapi.fake;

public class FakeJsonApiDocumentWithId extends FakeJsonApiDocument {

    public FakeJsonApiDocumentWithId() {
        this(new DefaultFakeAttributes());
    }

    public FakeJsonApiDocumentWithId(final FakeAttributes attributes) {
        super(attributes.getId().toString(), attributes);
    }

}
