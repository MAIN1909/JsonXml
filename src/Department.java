import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Department {
    @XmlAttribute
    int id;
    @XmlElement
    String manager;
    @XmlAttribute
    String name;
    @XmlElement(name = "employee")
    @XmlElementWrapper(name = "employees")
    List<Employee> employees;


    @Override
    public String toString() {
        return "Department  " +
                "id=" + id +
                ", name='" + name + "'" +
                ", manager='" + manager + "'" +
                ", employees:" + employees;
    }
}