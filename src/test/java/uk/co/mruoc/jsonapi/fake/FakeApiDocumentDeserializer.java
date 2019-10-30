package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiDataDocumentDeserializer;
import uk.co.mruoc.jsonapi.ApiDocumentFactory;

public class FakeApiDocumentDeserializer extends ApiDataDocumentDeserializer<FakeApiDocument, FakeDomainObject> {

    public FakeApiDocumentDeserializer(ApiDocumentFactory<FakeApiDocument> documentFactory) {
        super(FakeApiDocument.class, documentFactory);
    }

}
