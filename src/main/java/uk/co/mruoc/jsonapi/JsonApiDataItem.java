package uk.co.mruoc.jsonapi;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
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
