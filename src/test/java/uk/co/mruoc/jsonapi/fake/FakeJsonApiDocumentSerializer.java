package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.JsonApiDocumentSerializer;

public class FakeJsonApiDocumentSerializer extends JsonApiDocumentSerializer<FakeAttributes, FakeJsonApiDocument> {

    public FakeJsonApiDocumentSerializer() {
        super(FakeJsonApiDocument.class, FakeAttributes.class);
    }

}
