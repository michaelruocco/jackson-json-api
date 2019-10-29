package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.JsonApiModule;

public class FakeJsonApiModule extends JsonApiModule {

    public FakeJsonApiModule() {
        setMixInAnnotation(FakeAttributes.class, FakeAttributesMixin.class);

        addDeserializer(FakeJsonApiDocument.class, new FakeJsonApiDocumentDeserializer());
    }

}
