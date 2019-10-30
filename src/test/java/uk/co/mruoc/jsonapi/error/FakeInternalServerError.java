package uk.co.mruoc.jsonapi.error;

import java.util.UUID;

class FakeInternalServerError extends InternalServerError {

    private static final UUID ID = UUID.fromString("74a8a129-a96b-4979-98c1-90d864dd47a4");
    private static final String DETAIL = "faked detail message";

    FakeInternalServerError() {
        super(ID, DETAIL);
    }

}
