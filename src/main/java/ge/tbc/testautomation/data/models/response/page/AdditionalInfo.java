package ge.tbc.testautomation.data.models.response.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AdditionalInfo {
	@JsonProperty("contentfulId?")
	private String contentfulId;

	@JsonProperty("trackId")
	private String trackId;
}