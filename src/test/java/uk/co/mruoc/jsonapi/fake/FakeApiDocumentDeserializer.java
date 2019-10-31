package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiDocumentDeserializer;
import uk.co.mruoc.jsonapi.ApiDocumentFactory;

public class FakeApiDocumentDeserializer extends ApiDocumentDeserializer<FakeApiDocument> {

    public FakeApiDocumentDeserializer(ApiDocumentFactory<FakeApiDocument> documentFactory) {
        super(FakeApiDocument.class, documentFactory);
    }

}
