package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class DeleteOrder {
    private Long userId;
    private String orderId;
}
