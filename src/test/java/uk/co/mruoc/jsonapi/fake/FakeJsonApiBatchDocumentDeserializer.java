package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.JsonApiDataDocumentDeserializer;
import uk.co.mruoc.jsonapi.JsonApiDocumentFactory;

public class FakeJsonApiBatchDocumentDeserializer extends JsonApiDataDocumentDeserializer<FakeJsonApiBatchDocument, FakeAttributes> {

    public FakeJsonApiBatchDocumentDeserializer(JsonApiDocumentFactory<FakeJsonApiBatchDocument> documentFactory) {
        super(FakeJsonApiBatchDocument.class, documentFactory);
    }

}
