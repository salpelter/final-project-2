package ge.tbc.testautomation.data.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PageResponse {
	@JsonProperty("$id")
	private String id;

	@JsonProperty("$type")
	private String metaType;

	@JsonProperty("$updatedAt")
	private String updatedAt;

	@JsonProperty("slug")
	private String slug;

	@JsonProperty("sectionComponents")
	private List<SectionComponentsItem> sectionComponents;

	@JsonProperty("breadcrumbs")
	private Breadcrumbs breadcrumbs;

	@JsonProperty("key")
	private String key;

	@JsonProperty("seo")
	private Seo seo;
}