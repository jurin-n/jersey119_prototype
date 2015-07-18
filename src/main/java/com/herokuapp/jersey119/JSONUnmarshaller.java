package com.herokuapp.jersey119;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class JSONUnmarshaller implements MessageBodyReader<LinkedHashMap<String,Object>> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType) {
		return type == LinkedHashMap.class;
	}

	@Override
	public LinkedHashMap<String,Object> readFrom(Class<LinkedHashMap<String,Object>> type, Type genericType, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, String> HttpHeaders,
			InputStream entityStream) throws IOException, WebApplicationException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(entityStream, new TypeReference<LinkedHashMap<String,Object>>(){});
	}
}
