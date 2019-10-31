package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.databind.module.SimpleModule;
import uk.co.mruoc.jsonapi.batch.ApiBatchDocument;
import uk.co.mruoc.jsonapi.batch.ApiBatchDocumentMixin;
import uk.co.mruoc.jsonapi.batch.ApiBatchDocumentWithId;
import uk.co.mruoc.jsonapi.error.ApiErrorDocument;
import uk.co.mruoc.jsonapi.error.ApiErrorDocumentMixin;
import uk.co.mruoc.jsonapi.error.ApiError;
import uk.co.mruoc.jsonapi.error.ApiErrorSerializer;

public class ApiModule extends SimpleModule {

    public ApiModule() {
        setMixInAnnotation(ApiDocument.class, ApiDocumentMixin.class);
        setMixInAnnotation(ApiDocumentWithId.class, ApiDocumentMixin.class);
        setMixInAnnotation(ApiBatchDocument.class, ApiBatchDocumentMixin.class);
        setMixInAnnotation(ApiBatchDocumentWithId.class, ApiBatchDocumentMixin.class);
        setMixInAnnotation(ApiErrorDocument.class, ApiErrorDocumentMixin.class);
        setMixInAnnotation(ApiData.class, ApiDataMixin.class);
        setMixInAnnotation(ApiDataWithId.class, ApiDataWithIdMixin.class);

        addSerializer(ApiError.class, new ApiErrorSerializer());
    }

}
