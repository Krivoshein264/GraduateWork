package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@ToString
@NoArgsConstructor
public class Tariffs {
    private Integer id;
    private String type;
    private String interestRate;
}
