package uk.co.mruoc.jsonapi.error;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ApiBatchErrorDocument implements ApiErrorDocument {

    private final Collection<ApiErrorItem> errors;

    public ApiBatchErrorDocument(final ApiErrorItem... error) {
        this(Arrays.asList(error));
    }

    public ApiBatchErrorDocument(final Collection<ApiErrorItem> errors) {
        this.errors = errors;
    }

    @Override
    public Collection<ApiErrorItem> getErrors() {
        return errors;
    }

    @Override
    public int getStatus() {
        final List<Integer> distinctStatusValues = getDistinctStatusValues();
        if (distinctStatusValues.size() == 1) {
            return distinctStatusValues.get(0);
        }
        return 207;
    }

    private List<Integer> getDistinctStatusValues() {
        return errors.stream()
                .map(ApiErrorItem::getStatus)
                .distinct()
                .collect(Collectors.toList());
    }

}
