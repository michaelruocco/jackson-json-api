package uk.co.mruoc.jsonapi.fake.error;

import uk.co.mruoc.jsonapi.error.ApiBatchErrorDocument;

public class FakeBatchErrorDocument extends ApiBatchErrorDocument {

    public FakeBatchErrorDocument() {
        super(new FakeBadRequestError(),
                new FakeNotFoundError()
        );
    }

}
