package uk.co.mruoc.jsonapi.fake;

import lombok.NoArgsConstructor;
import uk.co.mruoc.jsonapi.batch.ApiBatchDocument;
import uk.co.mruoc.jsonapi.ApiData;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@NoArgsConstructor(force = true)
public class FakeApiBatchDocument extends ApiBatchDocument<FakeDomainObject> {

    public FakeApiBatchDocument(final FakeDomainObject... attributes) {
        this(Arrays.asList(attributes));
    }

    public FakeApiBatchDocument(final Collection<FakeDomainObject> attributes) {
        super(toItems(attributes));
    }

    private static Collection<ApiData<FakeDomainObject>> toItems(Collection<FakeDomainObject> collection) {
        return collection.stream()
                .map(FakeApiData::new)
                .collect(Collectors.toList());
    }

}
