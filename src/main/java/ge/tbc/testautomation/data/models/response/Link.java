package ge.tbc.testautomation.data.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Link {
	@JsonProperty("$id")
	private String id;

	@JsonProperty("$type")
	private String type;

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