package uk.co.mruoc.jsonapi.batch;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import uk.co.mruoc.jsonapi.ApiData;
import uk.co.mruoc.jsonapi.ApiDataWithId;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class ApiBatchDocumentWithId<I, T> {

    private final Collection<ApiDataWithId<I, T>> data;

    @SafeVarargs
    public ApiBatchDocumentWithId(final ApiDataWithId<I, T>... items) {
        this(Arrays.asList(items));
    }

    public Collection<T> getAttributes() {
        return data.stream()
                .map(ApiData::getAttributes)
                .collect(Collectors.toList());
    }

    public Collection<I> getIds() {
        return data.stream()
                .map(ApiDataWithId::getId)
                .collect(Collectors.toList());
    }

    public Optional<ApiDataWithId<I, T>> getDataById(final I id) {
        return data.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public Optional<ApiDataWithId<I, T>> getDataByIndex(final int index) {
        if (index >= data.size()) {
            return Optional.empty();
        }
        return Optional.of(IterableUtils.get(data, index));
    }

}
