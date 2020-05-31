package uk.co.mruoc.jsonapi.error;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ApiBatchErrorDocument implements ApiErrorDocument {

    private final Collection<ApiError> errors;

    public ApiBatchErrorDocument(final ApiError... error) {
        this(Arrays.asList(error));
    }

    public ApiBatchErrorDocument(final Collection<ApiError> errors) {
        this.errors = errors;
    }

    @Override
    public Collection<ApiError> getErrors() {
        return errors;
    }

    @Override
    public String getStatus() {
        final List<String> distinctStatusValues = getDistinctStatusValues();
        if (distinctStatusValues.size() == 1) {
            return distinctStatusValues.get(0);
        }
        return "207";
    }

    private List<String> getDistinctStatusValues() {
        return errors.stream()
                .map(ApiError::getStatus)
                .distinct()
                .collect(Collectors.toList());
    }

}
