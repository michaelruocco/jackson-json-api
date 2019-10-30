package uk.co.mruoc.jsonapi;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Data
public class ApiBatchDocument<T> {

    private final Collection<ApiDataItem<T>> data;

    public Collection<T> getAttributes() {
        return data.stream()
                .map(ApiDataItem::getAttributes)
                .collect(Collectors.toList());
    }

}
