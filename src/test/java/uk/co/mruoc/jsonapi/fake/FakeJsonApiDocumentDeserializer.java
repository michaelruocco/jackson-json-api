package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.JsonApiDataDocumentDeserializer;

public class FakeJsonApiDocumentDeserializer extends JsonApiDataDocumentDeserializer<FakeJsonApiDocument, FakeAttributes> {

    public FakeJsonApiDocumentDeserializer() {
        super(FakeJsonApiDocument.class, new FakeJsonApiDocumentFactory());
    }

}
