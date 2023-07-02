package br.com.unifeicontabilidade.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DecimalFormat;

public class PercentSerializer extends JsonSerializer<Double> {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##'%'");

    @Override
    public void serialize(Double value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(decimalFormat.format(value * 100));
    }
}
