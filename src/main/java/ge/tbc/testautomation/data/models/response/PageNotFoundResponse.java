package ge.tbc.testautomation.data.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageNotFoundResponse {
	@JsonProperty("type")
	private String type;

	@JsonProperty("title")
	private String title;

	@JsonProperty("status")
	private int status;

	@JsonProperty("detail")
	private String detail;

	@JsonProperty("code")
	private String code;

	@JsonProperty("traceId")
	private String traceId;

	@JsonProperty("endpoint")
	private String endpoint;
}