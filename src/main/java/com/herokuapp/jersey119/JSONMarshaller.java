package com.herokuapp.jersey119;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import org.codehaus.jackson.map.ObjectMapper;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JSONMarshaller implements MessageBodyWriter<LinkedHashMap<String,Object>> {
	@Context
	protected Providers providers;
	
	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation annotations[], MediaType mediaType){
		return type == LinkedHashMap.class;
	}
	
	@Override
	public long getSize(
			 LinkedHashMap<String,Object> obj
			,Class<?> type
			,Type genericType
			,Annotation annotations[]
			,MediaType mediaType){
		return -1L;
	}
	
	@Override
	public void writeTo(LinkedHashMap<String,Object> target, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream outputStream)
			throws IOException, WebApplicationException {
		ObjectMapper mapper = new ObjectMapper();		
		mapper.writeValue(outputStream,target);
	}
}
