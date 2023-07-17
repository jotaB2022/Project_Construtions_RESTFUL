package com.estudando.ProjectAPI.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class ModelMappers {

	public ModelMappers() {}

private static ModelMapper mapper = new ModelMapper();
	
	public static <O, D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}	
	
	public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<D>();
		for (Object o : origin) {
			destinationObjects.add(mapper.map(o, destination));
		}
		return destinationObjects;
	}
}
