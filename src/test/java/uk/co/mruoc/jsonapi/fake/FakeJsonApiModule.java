package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.JsonApiDocumentFactory;
import uk.co.mruoc.jsonapi.JsonApiModule;

import java.util.function.Function;

public class FakeJsonApiModule extends JsonApiModule {

    public FakeJsonApiModule() {
        this(new JsonApiDocumentFactory.UuidIdParser());
    }

    public FakeJsonApiModule(final Function<String, Object> idParser) {
        setMixInAnnotation(FakeAttributes.class, FakeAttributesMixin.class);

        addDeserializer(FakeJsonApiBatchDocument.class, new FakeJsonApiBatchDocumentDeserializer(new FakeJsonApiBatchDocumentFactory(idParser)));
        addDeserializer(FakeJsonApiDocument.class, new FakeJsonApiDocumentDeserializer(new FakeJsonApiDocumentFactory(idParser)));

    }

}
