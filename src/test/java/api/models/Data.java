package api.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Data {
    private List<Tariffs> tariffs;
}
