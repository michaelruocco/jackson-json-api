package uk.co.mruoc.jsonapi.fake;

import lombok.NoArgsConstructor;
import uk.co.mruoc.jsonapi.ApiData;
import uk.co.mruoc.jsonapi.batch.ApiBatchDocument;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@NoArgsConstructor(force = true)
public class MyApiBatchDocument extends ApiBatchDocument<FakeAttributes> {

    public MyApiBatchDocument(final FakeAttributes... attributes) {
        this(Arrays.asList(attributes));
    }

    public MyApiBatchDocument(final Collection<FakeAttributes> attributes) {
        super(toData(attributes));
    }

    private static Collection<ApiData<FakeAttributes>> toData(final Collection<FakeAttributes> collection) {
        return collection.stream()
                .map(MyApiData::new)
                .collect(Collectors.toList());
    }

}
