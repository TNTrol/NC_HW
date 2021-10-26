package data;

import lombok.Data;

@Data
public class InternetContract extends AbstractContract{
    private Integer velocity;

    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("MobilContract(id=" + getId() + ", dataEnd=" + getDateEnd() + ", number=" + getNumber() + ", owner=" + getOwner());
        str.append(", velocity=" + velocity + ")");
        return str.toString();
    }
}
