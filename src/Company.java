import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Company {
    @XmlElement
    public String director;
    @XmlAttribute
    public String name;
    @XmlElement(name = "department")
    @XmlElementWrapper(name = "departments")
    public List<Department> departments;

    @Override
    public String toString() {
        return "Company{" +
                "director='" + director + '\'' +
                ", name='" + name + '\'' +
                ", departments=" + departments +
                '}';
    }
}
