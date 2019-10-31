package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiDocumentDeserializer;
import uk.co.mruoc.jsonapi.ApiDocumentFactory;

public class FakeApiBatchDocumentDeserializer extends ApiDocumentDeserializer<FakeApiBatchDocument> {

    public FakeApiBatchDocumentDeserializer(ApiDocumentFactory<FakeApiBatchDocument> documentFactory) {
        super(FakeApiBatchDocument.class, documentFactory);
    }

}
