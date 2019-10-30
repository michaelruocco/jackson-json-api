package uk.co.mruoc.jsonapi.batch;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import uk.co.mruoc.jsonapi.ApiData;

import java.util.Collection;
import java.util.stream.Collectors;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class ApiBatchDocument<T> {

    private final Collection<ApiData<T>> data;

    public Collection<T> getAttributes() {
        return data.stream()
                .map(ApiData::getAttributes)
                .collect(Collectors.toList());
    }

}
