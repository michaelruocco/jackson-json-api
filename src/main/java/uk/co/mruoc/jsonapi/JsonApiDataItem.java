package uk.co.mruoc.jsonapi;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Data
@RequiredArgsConstructor
public class JsonApiDataItem<T> {

    private final Object id;
    private final String type;
    private final T attributes;

    public JsonApiDataItem(final String type, final T attributes) {
        this(null, type, attributes);
    }

    public Optional<Object> getId() {
        return Optional.ofNullable(id);
    }

}
