package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.batch.ApiBatchDocument;
import uk.co.mruoc.jsonapi.ApiData;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class FakeApiStringIdBatchDocument extends ApiBatchDocument<FakeAttributes> {

    public FakeApiStringIdBatchDocument(final FakeAttributes... attributes) {
        this(Arrays.asList(attributes));
    }

    public FakeApiStringIdBatchDocument(final Collection<FakeAttributes> attributes) {
        super(toItems(attributes));
    }

    private static Collection<ApiData<FakeAttributes>> toItems(Collection<FakeAttributes> collection) {
        return collection.stream()
                .map(attributes -> new FakeApiData(attributes.getId(), attributes))
                .collect(Collectors.toList());
    }

}
