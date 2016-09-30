package es.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class ExtendableUserView {
	private String id;
	private String name;

	// and then "other" stuff:
	protected Map<String, Object> other = new HashMap<String, Object>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// "any getter" needed for serialization
	@JsonAnyGetter
	public Map<String, Object> any() {
		return other;
	}

	@JsonAnySetter
	public void set(String name, Object value) {
		other.put(name, value);
	}

	@Override
	public String toString() {
		return "ExtendableUserView [id=" + id + ", name=" + name + ", other=" + other + "]";
	}

}
