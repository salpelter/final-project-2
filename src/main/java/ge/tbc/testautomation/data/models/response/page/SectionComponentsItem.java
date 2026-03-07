package ge.tbc.testautomation.data.models.response.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SectionComponentsItem {
	@JsonProperty("$id")
	private String id;

	@JsonProperty("$type")
	private String metaType;

	@JsonProperty("$updatedAt")
	private String updatedAt;

	@JsonProperty("key")
	private String key;

	@JsonProperty("type")
	private String type;

	@JsonProperty("inputs")
	private Inputs inputs;
}