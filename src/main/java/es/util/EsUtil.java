package es.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EsUtil {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	public static byte[] getSource(Object o) throws IOException, IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		byte[] json = MAPPER.writeValueAsBytes(o);
		return json;
	}

	public static <T> List<T> getObjects(SearchResponse response, Class<T> valueType)
			throws JsonParseException, JsonMappingException, IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, IOException {
		List<T> res = new ArrayList<T>();
		for (SearchHit hit : response.getHits()) {
			res.add(getObject(hit, valueType));
		}
		return res;
	}

	public static <T> T getObject(SearchResponse response, Class<T> valueType)
			throws JsonParseException, JsonMappingException, IllegalArgumentException, IllegalAccessException,
			IOException, InvocationTargetException {
		for (SearchHit hit : response.getHits()) {
			return getObject(hit, valueType);
		}
		return null;
	}

	public static <T> T getObject(SearchHit hit, Class<T> valueType) throws JsonParseException, JsonMappingException,
			IOException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		T res = MAPPER.readValue(hit.getSourceAsString(), valueType);
		setId(res, valueType, hit.getId());
		return res;
	}

	public static <T> T getObject(GetResponse response, Class<T> valueType)
			throws JsonParseException, JsonMappingException, IllegalArgumentException, IllegalAccessException,
			IOException, InvocationTargetException {
		T res = MAPPER.readValue(response.getSourceAsString(), valueType);
		setId(res, valueType, response.getId());
		return res;
	}

	public static String getId(Object obj)
			throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
		for (Field field : obj.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(EsId.class)) {
				return BeanUtils.getProperty(obj, field.getName());
			}
		}
		return null;
	}

	public static String getType(Object obj) {
		return getType(obj.getClass());
	}

	public static String getType(Class<?> clazz) {
		return clazz.getAnnotation(EsType.class).value();
	}

	private static List<Field> getAllFields(Class<?> type) {
		List<Field> fields = new ArrayList<Field>();
		for (Class<?> c = type; c != null; c = c.getSuperclass()) {
			fields.addAll(Arrays.asList(c.getDeclaredFields()));
		}
		return fields;
	}

	private static void setId(Object res, Class<?> valueType, String value)
			throws IllegalAccessException, InvocationTargetException {
		for (Field field : getAllFields(valueType)) {
			if (field.isAnnotationPresent(EsId.class)) {
				BeanUtils.setProperty(res, field.getName(), value);
				break;
			}
		}
	}
}
