package ge.tbc.testautomation.data.models.response.page;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Breadcrumbs {
	@JsonProperty("$id")
	private String id;

	@JsonProperty("$type")
	private String metaType;

	@JsonProperty("$updatedAt")
	private String updatedAt;

	@JsonProperty("key")
	private String key;

	@JsonProperty("items")
	private List<ItemsItem> items;

	@JsonProperty("showBackground")
	private boolean showBackground;
}