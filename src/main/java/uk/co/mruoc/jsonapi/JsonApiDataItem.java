package uk.co.mruoc.jsonapi;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class JsonApiDataItem<T> {

    private final String id;
    private final String type;
    private final T attributes;

    public JsonApiDataItem(final String type, final T attributes) {
        this(null, type, attributes);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

}
