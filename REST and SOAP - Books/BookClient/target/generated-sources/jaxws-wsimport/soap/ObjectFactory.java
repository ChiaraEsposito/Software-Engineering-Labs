
package soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ClassNotFoundException_QNAME = new QName("http://warehousews.softeng.sapienza.it/", "ClassNotFoundException");
    private final static QName _GetBookSoap_QNAME = new QName("http://warehousews.softeng.sapienza.it/", "getBookSoap");
    private final static QName _GetBookSoapResponse_QNAME = new QName("http://warehousews.softeng.sapienza.it/", "getBookSoapResponse");
    private final static QName _SQLException_QNAME = new QName("http://warehousews.softeng.sapienza.it/", "SQLException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link Book.MapSellers }
     * 
     */
    public Book.MapSellers createBookMapSellers() {
        return new Book.MapSellers();
    }

    /**
     * Create an instance of {@link GetBookSoapResponse }
     * 
     */
    public GetBookSoapResponse createGetBookSoapResponse() {
        return new GetBookSoapResponse();
    }

    /**
     * Create an instance of {@link SQLException }
     * 
     */
    public SQLException createSQLException() {
        return new SQLException();
    }

    /**
     * Create an instance of {@link GetBookSoap }
     * 
     */
    public GetBookSoap createGetBookSoap() {
        return new GetBookSoap();
    }

    /**
     * Create an instance of {@link ClassNotFoundException }
     * 
     */
    public ClassNotFoundException createClassNotFoundException() {
        return new ClassNotFoundException();
    }

    /**
     * Create an instance of {@link Book.MapSellers.Entry }
     * 
     */
    public Book.MapSellers.Entry createBookMapSellersEntry() {
        return new Book.MapSellers.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehousews.softeng.sapienza.it/", name = "ClassNotFoundException")
    public JAXBElement<ClassNotFoundException> createClassNotFoundException(ClassNotFoundException value) {
        return new JAXBElement<ClassNotFoundException>(_ClassNotFoundException_QNAME, ClassNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookSoap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehousews.softeng.sapienza.it/", name = "getBookSoap")
    public JAXBElement<GetBookSoap> createGetBookSoap(GetBookSoap value) {
        return new JAXBElement<GetBookSoap>(_GetBookSoap_QNAME, GetBookSoap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookSoapResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehousews.softeng.sapienza.it/", name = "getBookSoapResponse")
    public JAXBElement<GetBookSoapResponse> createGetBookSoapResponse(GetBookSoapResponse value) {
        return new JAXBElement<GetBookSoapResponse>(_GetBookSoapResponse_QNAME, GetBookSoapResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SQLException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehousews.softeng.sapienza.it/", name = "SQLException")
    public JAXBElement<SQLException> createSQLException(SQLException value) {
        return new JAXBElement<SQLException>(_SQLException_QNAME, SQLException.class, null, value);
    }

}
