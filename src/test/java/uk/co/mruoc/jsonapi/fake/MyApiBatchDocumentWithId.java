package uk.co.mruoc.jsonapi.fake;

import lombok.NoArgsConstructor;
import uk.co.mruoc.jsonapi.ApiDataWithId;
import uk.co.mruoc.jsonapi.batch.ApiBatchDocumentWithId;

import java.util.Collection;

@NoArgsConstructor(force = true)
public class MyApiBatchDocumentWithId extends ApiBatchDocumentWithId<Object, FakeAttributes> {

    public MyApiBatchDocumentWithId(final Collection<ApiDataWithId<Object, FakeAttributes>> data) {
        super(data);
    }

}
