package uk.co.mruoc.jsonapi.error;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class BadRequestError extends ApiError {

    private static final String STATUS = "400";

    public BadRequestError(final String detail) {
        this(UUID.randomUUID(), "Bad Request", detail);
    }

    public BadRequestError(final String title, final String detail) {
        this(UUID.randomUUID(), title, detail);
    }

    public BadRequestError(final UUID id, final String title, final String detail) {
        this(id, title, detail, Collections.emptyMap());
    }

    public BadRequestError(final UUID id, final String title, final String detail, final Map<String, Object> meta) {
        super(id, STATUS, title, detail, meta);
    }

}
