package data;

import lombok.Data;

import java.util.Date;

@Data
public abstract class AbstractContract {
    private Integer id;
    private Date dateEnd;
    private Integer number;
    private Human owner;
}
