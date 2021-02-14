package Entity;

import lombok.Data;

@Data
public class Item {
    private String name;
    private String originalPrise;
    private String actualPrise;
    private String discount;
}
