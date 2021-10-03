package com.gt.converter;

import com.gt.bean.computer;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class aliceConverter implements HttpMessageConverter<computer> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        if(mediaType != null) {
            return clazz.isAssignableFrom(computer.class) && mediaType.equals(new MediaType("application","alice"));
        }
        return clazz.isAssignableFrom(computer.class);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/alice");
    }

    @Override
    public computer read(Class<? extends computer> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(computer computer, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String data = "name:-->" + computer.getName() + ";number-->" + computer.getNumber() + ";price-->" + computer.getPrice();
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());
    }
}
