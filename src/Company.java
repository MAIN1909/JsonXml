import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Company {
    @XmlElement
    String director;
    @XmlAttribute
    String name;
    @XmlElement(name = "department")
    @XmlElementWrapper(name = "departments")
    List<Department> departments;


    @Override
    public String toString() {
        return "Company{" +
                "director='" + director + '\'' +
                ", name='" + name + '\'' +
                ", departments:" + departments
                ;
    }
}