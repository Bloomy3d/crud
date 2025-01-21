package request;

import service.PropertiesReader;

public class Endpoint {
    private final String url;
    private final String path;

    public Endpoint(String path) {
        this.url = PropertiesReader.getProperty("baseUrl");
        this.path = path;
    }

    public String getUrl() {
        String endpoint = url;
        if (this.path != null) {
            endpoint = endpoint + "/" + path;
        }
        return endpoint;
    }
}
