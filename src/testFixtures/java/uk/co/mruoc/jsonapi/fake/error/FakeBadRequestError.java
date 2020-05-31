package uk.co.mruoc.jsonapi.fake.error;

import uk.co.mruoc.jsonapi.error.BadRequestError;

import java.util.UUID;

public class FakeBadRequestError extends BadRequestError {

    private static final UUID ID = UUID.fromString("a3d222ec-4dcd-4bc0-9838-734d6ae19c4d");
    private static final String TITLE = "Bad Request";
    private static final String DETAIL = "invalid json request";

    public FakeBadRequestError() {
        super(ID, TITLE, DETAIL);
    }

}
