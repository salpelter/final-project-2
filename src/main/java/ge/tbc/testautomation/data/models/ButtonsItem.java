package ge.tbc.testautomation.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ButtonsItem {
	@JsonProperty("size")
	private String size;

	@JsonProperty("link")
	private Link link;

	@JsonProperty("additionalInfo")
	private AdditionalInfo additionalInfo;

	@JsonProperty("label")
	private String label;

	@JsonProperty("type")
	private String type;

	@JsonProperty("key")
	private String key;

	@JsonProperty("$id")
	private String id;

	@JsonProperty("$type")
	private String metaType;

	@JsonProperty("$updatedAt")
	private String updatedAt;
}