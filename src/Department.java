import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Department {
    @XmlAttribute
    public int id;
    @XmlElement
    public String manager;
    @XmlAttribute
    public String name;
    @XmlElement(name = "employee")
    @XmlElementWrapper(name = "employees")
    public List<Employee> employees;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}