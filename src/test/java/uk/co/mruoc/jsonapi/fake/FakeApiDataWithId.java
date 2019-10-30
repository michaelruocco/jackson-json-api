package uk.co.mruoc.jsonapi.fake;

import lombok.Getter;

@Getter
public class FakeApiDataWithId extends FakeApiData {

    private Object id;

    public FakeApiDataWithId(final FakeDomainObject attributes) {
        super(attributes);
        this.id = attributes.getId();
    }

}
