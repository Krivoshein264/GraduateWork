package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ErrorOrder {
    private String code;
    private String message;
}
