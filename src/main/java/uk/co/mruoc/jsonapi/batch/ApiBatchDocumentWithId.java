package uk.co.mruoc.jsonapi.batch;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import uk.co.mruoc.jsonapi.ApiData;
import uk.co.mruoc.jsonapi.ApiDataWithId;

import java.util.Collection;
import java.util.stream.Collectors;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class ApiBatchDocumentWithId<T> {

    private final Collection<ApiDataWithId<T>> data;

    public Collection<T> getAttributes() {
        return data.stream()
                .map(ApiData::getAttributes)
                .collect(Collectors.toList());
    }

}
