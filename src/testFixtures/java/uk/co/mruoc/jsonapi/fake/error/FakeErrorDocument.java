package uk.co.mruoc.jsonapi.fake.error;

import uk.co.mruoc.jsonapi.error.ApiSingleErrorDocument;

public class FakeErrorDocument extends ApiSingleErrorDocument {

    public FakeErrorDocument() {
        super(new FakeInternalServerError());
    }

}
