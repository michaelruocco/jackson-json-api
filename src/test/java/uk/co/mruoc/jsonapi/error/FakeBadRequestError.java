package uk.co.mruoc.jsonapi.error;

import java.util.UUID;

class FakeBadRequestError extends BadRequestError {

    private static final UUID ID = UUID.fromString("a3d222ec-4dcd-4bc0-9838-734d6ae19c4d");
    private static final String TITLE = "Bad Request";
    private static final String DETAIL = "invalid json request";

    FakeBadRequestError() {
        super(ID, TITLE, DETAIL);
    }

}
