package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiDataDocumentDeserializer;
import uk.co.mruoc.jsonapi.ApiDocumentFactory;

public class FakeApiBatchDocumentDeserializer extends ApiDataDocumentDeserializer<FakeApiBatchDocument, FakeDomainObject> {

    public FakeApiBatchDocumentDeserializer(ApiDocumentFactory<FakeApiBatchDocument> documentFactory) {
        super(FakeApiBatchDocument.class, documentFactory);
    }

}
