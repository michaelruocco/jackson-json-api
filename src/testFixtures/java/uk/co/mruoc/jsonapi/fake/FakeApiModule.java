package uk.co.mruoc.jsonapi.fake;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import uk.co.mruoc.jsonapi.ApiModule;

import java.util.Collections;
import java.util.function.Function;

public class FakeApiModule extends SimpleModule {

    public FakeApiModule(final Function<String, Object> idParser) {
        setMixInAnnotation(FakeDomainObject.class, FakeDomainObjectMixin.class);

        addDeserializer(FakeApiBatchDocument.class, new FakeApiBatchDocumentDeserializer(new FakeApiBatchDocumentFactory(idParser)));
        addDeserializer(FakeApiDocument.class, new FakeApiDocumentDeserializer(new FakeApiDocumentFactory(idParser)));
    }

    @Override
    public Iterable<? extends Module> getDependencies() {
        return Collections.singleton(new ApiModule());
    }

}
