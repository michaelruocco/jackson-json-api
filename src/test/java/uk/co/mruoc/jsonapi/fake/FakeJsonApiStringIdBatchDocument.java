package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.JsonApiBatchDocument;
import uk.co.mruoc.jsonapi.JsonApiDataItem;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class FakeJsonApiStringIdBatchDocument extends JsonApiBatchDocument<FakeAttributes> {

    public FakeJsonApiStringIdBatchDocument(final FakeAttributes... attributes) {
        this(Arrays.asList(attributes));
    }

    public FakeJsonApiStringIdBatchDocument(final Collection<FakeAttributes> attributes) {
        super(toItems(attributes));
    }

    private static Collection<JsonApiDataItem<FakeAttributes>> toItems(Collection<FakeAttributes> collection) {
        return collection.stream()
                .map(attributes -> new FakeJsonApiDataItem(attributes.getId(), attributes))
                .collect(Collectors.toList());
    }

}
