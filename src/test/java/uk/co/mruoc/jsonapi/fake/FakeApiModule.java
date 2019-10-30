package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiDocumentFactory;
import uk.co.mruoc.jsonapi.ApiModule;

import java.util.function.Function;

public class FakeApiModule extends ApiModule {

    public FakeApiModule() {
        this(new ApiDocumentFactory.UuidIdParser());
    }

    public FakeApiModule(final Function<String, Object> idParser) {
        setMixInAnnotation(FakeDomainObject.class, FakeDomainObjectMixin.class);

        addDeserializer(FakeApiBatchDocument.class, new FakeApiBatchDocumentDeserializer(new FakeApiBatchDocumentFactory(idParser)));
        addDeserializer(FakeApiDocument.class, new FakeApiDocumentDeserializer(new FakeApiDocumentFactory(idParser)));
    }

}
