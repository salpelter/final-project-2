package ge.tbc.testautomation.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CardsItem {
	@JsonProperty("$id")
	private String id;

	@JsonProperty("$type")
	private String metaType;

	@JsonProperty("$updatedAt")
	private String updatedAt;

	@JsonProperty("isBadgeGroupVisible")
	private boolean isBadgeGroupVisible;

	@JsonProperty("isCondensed")
	private boolean isCondensed;

	@JsonProperty("showLabel")
	private boolean showLabel;

	@JsonProperty("showTitle")
	private boolean showTitle;

	@JsonProperty("image")
	private Image image;

	@JsonProperty("key")
	private String key;

	@JsonProperty("showMedia")
	private boolean showMedia;

	@JsonProperty("showLogoAndText")
	private boolean showLogoAndText;

	@JsonProperty("bodyText")
	private String bodyText;

	@JsonProperty("link")
	private Link link;

	@JsonProperty("title")
	private String title;

	@JsonProperty("showTextWithIcon")
	private boolean showTextWithIcon;

	@JsonProperty("showBackground")
	private boolean showBackground;

	@JsonProperty("additionalInfo")
	private AdditionalInfo additionalInfo;

	@JsonProperty("showBodyText")
	private boolean showBodyText;
}