package introsde.project.data.soap.model;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateToXML {
	public static XMLGregorianCalendar GregorianCalendar(Date date
			//, TimeZone zone
			) {
	    XMLGregorianCalendar xmlGregorianCalendar = null;
	    GregorianCalendar gregorianCalendar = new GregorianCalendar();
	    gregorianCalendar.setTime(date);
	    //gregorianCalendar.setTimeZone(zone);
	    try {
	      DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();
	      xmlGregorianCalendar = dataTypeFactory.newXMLGregorianCalendar(gregorianCalendar);
	    }
	    catch (Exception e) {
	      System.out.println("Exception in conversion of Date to XMLGregorianCalendar" + e);
	    }
	    
	    return xmlGregorianCalendar;
	  }

}
