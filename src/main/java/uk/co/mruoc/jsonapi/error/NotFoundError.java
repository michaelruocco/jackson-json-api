package uk.co.mruoc.jsonapi.error;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class NotFoundError extends ApiError {

    private static final String STATUS = "404";

    public NotFoundError(final String title, final String detail) {
        this(UUID.randomUUID(), title, detail);
    }

    public NotFoundError(final UUID id, final String title, final String detail) {
        this(id, title, detail, Collections.emptyMap());
    }

    public NotFoundError(final UUID id, final String title, final String detail, final Map<String, Object> meta) {
        super(id, STATUS, title, detail, meta);
    }

}
