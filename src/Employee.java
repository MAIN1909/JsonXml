import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class Employee {
    @XmlAttribute
    int id;
    @XmlValue
    String name;

    @Override
    public String toString() {
        return "Employee{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';
    }
}