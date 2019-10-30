package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiBatchDocument;
import uk.co.mruoc.jsonapi.ApiDataItem;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class FakeApiBatchDocument extends ApiBatchDocument<FakeAttributes> {

    public FakeApiBatchDocument(final FakeAttributes... attributes) {
        this(Arrays.asList(attributes));
    }

    public FakeApiBatchDocument(final Collection<FakeAttributes> attributes) {
        super(toItems(attributes));
    }

    private static Collection<ApiDataItem<FakeAttributes>> toItems(Collection<FakeAttributes> collection) {
        return collection.stream()
                .map(attributes -> new FakeApiDataItem(attributes.getId(), attributes))
                .collect(Collectors.toList());
    }
}
