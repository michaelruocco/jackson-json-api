package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Optional;

public class JsonApiDocumentSerializer<A, T extends JsonApiDocument<A>> extends StdSerializer<T> {

    private final Class<A> attributesType;

    public JsonApiDocumentSerializer(final Class<T> documentType, final Class<A> attributesType) {
        super(documentType);
        this.attributesType = attributesType;
    }

    @Override
    public void serialize(final T document, final JsonGenerator json, final SerializerProvider provider) throws IOException {
        json.writeStartObject();
        json.writeFieldName("data");
        json.writeStartObject();
        final Optional<String> id = document.getId();
        if (id.isPresent()) {
            json.writeStringField("id", id.get());
        }
        json.writeStringField("type", document.getType());
        json.writeFieldName("attributes");
        provider.defaultSerializeValue(attributesType.cast(document.getAttributes()), json);
        json.writeEndObject();
        json.writeEndObject();
    }

}
