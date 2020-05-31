package uk.co.mruoc.jsonapi.error;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class UnprocessableEntityError extends ApiError {

    private static final String STATUS = "422";

    public UnprocessableEntityError(final String title, final String detail) {
        this(UUID.randomUUID(), title, detail);
    }

    public UnprocessableEntityError(final UUID id, final String title, final String detail) {
        this(id, title, detail, Collections.emptyMap());
    }

    public UnprocessableEntityError(final UUID id, final String title, final String detail, final Map<String, Object> meta) {
        super(id, STATUS, title, detail, meta);
    }

}
