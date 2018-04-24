package introsde.project.data.soap.endpoint;

import javax.xml.ws.Endpoint;

import introsde.project.data.soap.ws.UserImpl;

public class PeoplePublisher {
    public static String SERVER_URL = "http://localhost";
    public static String PORT = "6902";
    public static String BASE_URL = "/ws/database";

    public static String getEndpointURL() {
        return SERVER_URL+":"+PORT+BASE_URL;
    }

    public static void main(String[] args) {
        String endpointUrl = getEndpointURL();
        System.out.println("Starting recombee Service...");
        System.out.println("--> Published at = "+endpointUrl);
        Endpoint.publish(endpointUrl, new UserImpl());
    }
}
