package uk.co.mruoc.jsonapi;

import java.io.IOException;

public interface JsonApiDocumentFactory<D extends JsonApiDocument> {

    D build(final JsonApiDataDocumentRequest request) throws IOException;

}
