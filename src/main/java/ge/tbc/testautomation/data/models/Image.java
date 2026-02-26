package ge.tbc.testautomation.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Image {
	@JsonProperty("$id")
	private String id;

	@JsonProperty("$type")
	private String metaType;

	@JsonProperty("alt")
	private String alt;

	@JsonProperty("desc")
	private String desc;

	@JsonProperty("src")
	private String src;
}