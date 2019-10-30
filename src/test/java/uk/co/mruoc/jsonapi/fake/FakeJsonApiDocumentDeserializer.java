package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.JsonApiDataDocumentDeserializer;
import uk.co.mruoc.jsonapi.JsonApiDocumentFactory;

public class FakeJsonApiDocumentDeserializer extends JsonApiDataDocumentDeserializer<FakeJsonApiDocument, FakeAttributes> {

    public FakeJsonApiDocumentDeserializer(JsonApiDocumentFactory<FakeJsonApiDocument> documentFactory) {
        super(FakeJsonApiDocument.class, documentFactory);
    }

}
