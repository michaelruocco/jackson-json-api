package uk.co.mruoc.jsonapi.fake;

import lombok.NoArgsConstructor;
import uk.co.mruoc.jsonapi.ApiDocumentWithId;

@NoArgsConstructor(force = true)
public class MyApiDocumentWithId extends ApiDocumentWithId<Object, FakeAttributes> {

    public MyApiDocumentWithId(final Object id, final FakeAttributes attributes) {
        super(new MyApiDataWithId(id, attributes));
    }

}
