package ge.tbc.testautomation.data.models.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Inputs {
	@JsonProperty("$id")
	private String id;

	@JsonProperty("$type")
	private String metaType;

	@JsonProperty("$updatedAt")
	private String updatedAt;

	@JsonProperty("mediaPosition")
	private String mediaPosition;

	@JsonProperty("buttons")
	private List<ButtonsItem> buttons;

	@JsonProperty("showBackground")
	private boolean showBackground;

	@JsonProperty("image")
	private Image image;

	@JsonProperty("key")
	private String key;

	@JsonProperty("title")
	private String title;

	@JsonProperty("showBodyText")
	private boolean showBodyText;

	@JsonProperty("bodyText")
	private String bodyText;

	@JsonProperty("showList")
	private boolean showList;

	@JsonProperty("list")
	private List<ListItem> list;

	@JsonProperty("showCaption")
	private boolean showCaption;

	@JsonProperty("cards")
	private List<CardsItem> cards;

	@JsonProperty("showButton")
	private boolean showButton;

	@JsonProperty("cardType")
	private String cardType;
}