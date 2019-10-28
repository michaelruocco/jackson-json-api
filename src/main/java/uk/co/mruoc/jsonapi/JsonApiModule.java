package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.databind.module.SimpleModule;
import uk.co.mruoc.jsonapi.error.JsonApiErrorDocument;
import uk.co.mruoc.jsonapi.error.JsonApiErrorDocumentMixin;
import uk.co.mruoc.jsonapi.error.JsonApiErrorItem;
import uk.co.mruoc.jsonapi.error.JsonApiErrorItemSerializer;

public class JsonApiModule extends SimpleModule {

    public JsonApiModule() {
        setMixInAnnotation(JsonApiDocument.class, JsonApiDocumentMixin.class);

        setMixInAnnotation(JsonApiErrorDocument.class, JsonApiErrorDocumentMixin.class);

        addSerializer(JsonApiErrorItem.class, new JsonApiErrorItemSerializer());
    }

}
