package uk.co.mruoc.jsonapi.error;

class FakeErrorDocument extends ApiSingleErrorDocument {

    FakeErrorDocument() {
        super(new FakeInternalServerErrorItem());
    }

}
