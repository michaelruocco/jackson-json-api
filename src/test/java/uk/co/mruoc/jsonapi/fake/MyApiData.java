package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiData;

public class MyApiData extends ApiData<FakeAttributes> {

    public MyApiData(final FakeAttributes attributes) {
        super("fake-attributes-type", attributes);
    }

}
