package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.databind.module.SimpleModule;
import uk.co.mruoc.jsonapi.error.ApiErrorDocument;
import uk.co.mruoc.jsonapi.error.ApiErrorDocumentMixin;
import uk.co.mruoc.jsonapi.error.ApiErrorItem;
import uk.co.mruoc.jsonapi.error.ApiErrorItemSerializer;

public class ApiModule extends SimpleModule {

    public ApiModule() {
        setMixInAnnotation(ApiDocument.class, ApiDocumentMixin.class);
        setMixInAnnotation(ApiBatchDocument.class, ApiBatchDocumentMixin.class);
        setMixInAnnotation(ApiErrorDocument.class, ApiErrorDocumentMixin.class);

        setMixInAnnotation(ApiDataItem.class, ApiDataItemMixin.class);

        addSerializer(ApiErrorItem.class, new ApiErrorItemSerializer());
    }

}
