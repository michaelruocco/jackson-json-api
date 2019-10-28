package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.JsonApiDataItem;
import uk.co.mruoc.jsonapi.JsonApiDocument;

public class FakeJsonApiDocumentWithId extends FakeJsonApiDocument {

    public FakeJsonApiDocumentWithId() {
        this(new FakeAttributes());
    }

    private FakeJsonApiDocumentWithId(final FakeAttributes attributes) {
        super(new JsonApiDataItem<>(attributes.getId().toString(), "fake-attributes-type", attributes));
    }

}
