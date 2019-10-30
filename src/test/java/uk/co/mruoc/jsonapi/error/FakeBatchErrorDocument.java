package uk.co.mruoc.jsonapi.error;

class FakeBatchErrorDocument extends ApiBatchErrorDocument {

    FakeBatchErrorDocument() {
        super(new FakeBadRequestErrorItem(),
                new FakeNotFoundErrorItem()
        );
    }

}
