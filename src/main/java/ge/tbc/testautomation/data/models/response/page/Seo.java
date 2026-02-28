package ge.tbc.testautomation.data.models.response.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Seo {
	@JsonProperty("$id")
	private String id;

	@JsonProperty("$type")
	private String metaType;

	@JsonProperty("$updatedAt")
	private String updatedAt;

	@JsonProperty("key")
	private String key;

	@JsonProperty("noFollow")
	private boolean noFollow;

	@JsonProperty("noIndex")
	private boolean noIndex;

	@JsonProperty("title")
	private String title;

	@JsonProperty("description")
	private String description;
}