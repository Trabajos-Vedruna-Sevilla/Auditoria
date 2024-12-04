package nexo.auditoria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryDTO {
	private String name;
    private String code;
    private String flag;
}
