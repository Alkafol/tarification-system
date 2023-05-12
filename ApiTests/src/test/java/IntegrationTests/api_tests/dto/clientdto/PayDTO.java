package IntegrationTests.api_tests.dto.clientdto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayDTO {

	@JsonProperty("phoneNumber")
	private String phoneNumber;

	@JsonProperty("money")
	private int money;

	@JsonProperty("id")
	private String id;
}