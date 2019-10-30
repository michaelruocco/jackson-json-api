package uk.co.mruoc.jsonapi.fake;

import lombok.NoArgsConstructor;
import uk.co.mruoc.jsonapi.ApiDocument;

@NoArgsConstructor(force = true)
public class MyApiDocument extends ApiDocument<FakeAttributes> {

    public MyApiDocument(final FakeAttributes attributes) {
        super(new MyApiData(attributes));
    }

}
