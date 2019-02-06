import com.google.gson.Gson;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException, ParserConfigurationException, SAXException {
        String json = "";
        try (BufferedReader br = new BufferedReader(new FileReader(new File("company.json")))) {
            String s = null;
            while ((s = br.readLine()) != null) {
                json += s.trim();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Gson gson = new Gson();
        Company c = gson.fromJson(json, Company.class);
        System.out.println(c);
        System.out.println(json);
        String formedJson = gson.toJson(c);
        System.out.println(formedJson);

        JAXBContext context = JAXBContext.newInstance(Company.class);
        Unmarshaller um = context.createUnmarshaller();
        Marshaller m = context.createMarshaller();
        File f = new File("company.xml");
        f.createNewFile();
        m.marshal(c, f);
        String xml;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            //br.readLine();
            xml = br.readLine();
        }
        System.out.println(xml);

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser sax = factory.newSAXParser();
        DefaultHandler dh = new DefaultHandler() {

            boolean isInCorrectDepartment = false;
            boolean isInCorrectEmployee = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//                System.out.println("start");
                if ("department".equals(qName) && "Logistics".equals(attributes.getValue("name"))) {
                    isInCorrectDepartment = true;
                }
                if ("employee".equals(qName) && "2".equals(attributes.getValue("id"))) {
                    isInCorrectEmployee = true;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
//                System.out.println("end");
                if ("department".equals(qName)) {
                    isInCorrectDepartment = false;
                }
                if ("employee".equals(qName)) {
                    isInCorrectEmployee = false;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
//                System.out.println("ch");
                if (isInCorrectDepartment && isInCorrectEmployee) {
                    String result = "";
                    for (int i = start; i < start + length; i++) {
                        result += ch[i];
                    }
                    System.out.println(result);

                }
            }
        };
        sax.parse(f, dh);


    }
}
