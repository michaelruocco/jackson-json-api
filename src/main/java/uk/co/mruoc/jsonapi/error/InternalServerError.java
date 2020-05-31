package uk.co.mruoc.jsonapi.error;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class InternalServerError extends ApiError {

    private static final String TITLE = "Internal Server Error";
    private static final int STATUS = 500;

    public InternalServerError(final String detail) {
        this(UUID.randomUUID(), detail);
    }

    public InternalServerError(final UUID id, final String detail) {
        this(id, detail, Collections.emptyMap());
    }

    public InternalServerError(final UUID id, final String detail, final Map<String, Object> meta) {
        super(id, STATUS, TITLE, detail, meta);
    }

}
