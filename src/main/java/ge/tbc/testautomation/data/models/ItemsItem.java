package ge.tbc.testautomation.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ItemsItem {
	@JsonProperty("$id")
	private String id;

	@JsonProperty("$type")
	private String metaType;

	@JsonProperty("$updatedAt")
	private String updatedAt;

	@JsonProperty("isExternal")
	private boolean isExternal;

	@JsonProperty("key")
	private String key;

	@JsonProperty("target")
	private String target;

	@JsonProperty("label")
	private String label;

	@JsonProperty("url")
	private String url;
}