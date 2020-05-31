package uk.co.mruoc.jsonapi.fake.error;

import uk.co.mruoc.jsonapi.error.NotFoundError;

import java.util.UUID;

public class FakeNotFoundError extends NotFoundError {

    private static final UUID ID = UUID.fromString("35f0e14b-269b-4d14-b5d9-a8dadf5efb64");
    private static final String TITLE = "Item Not Found";
    private static final String DETAIL = "item with id 123 not found";

    public FakeNotFoundError() {
        super(ID, TITLE, DETAIL);
    }

}
