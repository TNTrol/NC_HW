package data;

import lombok.Data;

@Data
public class TelevisionContract extends AbstractContract{
    private String namePackage;

    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("MobilContract(id=" + getId() + ", dataEnd=" + getDateEnd() + ", number=" + getNumber() + ", owner=" + getOwner());
        str.append(", namePackage=" + namePackage + ")");
        return str.toString();
    }
}
