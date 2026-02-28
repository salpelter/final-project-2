package ge.tbc.testautomation.data.models.response.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ButtonsItem {
	@JsonProperty("$id")
	private String id;

	@JsonProperty("$type")
	private String metaType;

	@JsonProperty("$updatedAt")
	private String updatedAt;

	@JsonProperty("additionalInfo")
	private AdditionalInfo additionalInfo;

	@JsonProperty("size")
	private String size;

	@JsonProperty("key")
	private String key;

	@JsonProperty("label")
	private String label;

	@JsonProperty("type")
	private String type;

	@JsonProperty("link")
	private Link link;
}