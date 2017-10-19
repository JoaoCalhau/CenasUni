/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so2.rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Jersey REST client generated for REST resource:application
 * [questionarios]<br>
 * USAGE:
 * <pre>
 *        NewJerseyClient client = new NewJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Daniel Reto
 */
public class NewJerseyClient {

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:9200/so2/";

    public NewJerseyClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("questionarios");
    }

    /**
     * @param responseType Class representing the response
     * @return response object (instance of responseType class)
     */
    public <T> T getQuestList_JSON(Class<T> responseType) throws UniformInterfaceException {
        return webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @return response object (instance of responseType class)
     */
    public <T> T getQuestList_XML(Class<T> responseType) throws UniformInterfaceException {
        return webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param index query parameter
     * @return response object (instance of responseType class)
     */
    public void deleteQuestList(String index) throws UniformInterfaceException {
        String[] queryParamNames = new String[]{"index"};
        String[] queryParamValues = new String[]{index};
        webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).delete();
    }

    /**
     * @param responseType Class representing the response
     * @param responderOuNao query parameter
     * @param requestEntity request data@return response object (instance of responseType class)
     */
    public void putQuestList_JSON(Object requestEntity, String responderOuNao) throws UniformInterfaceException {
        String[] queryParamNames = new String[]{"responderOuNao"};
        String[] queryParamValues = new String[]{responderOuNao};
        webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(requestEntity);
    }

    /**
     * @param responseType Class representing the response
     * @param responderOuNao query parameter
     * @param requestEntity request data@return response object (instance of responseType class)
     */
    public void putQuestList_XML(Object requestEntity, String responderOuNao) throws UniformInterfaceException {
        String[] queryParamNames = new String[]{"responderOuNao"};
        String[] queryParamValues = new String[]{responderOuNao};
        webResource.queryParams(getQueryOrFormParams(queryParamNames, queryParamValues)).type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(requestEntity);
    }

    private MultivaluedMap getQueryOrFormParams(String[] paramNames, String[] paramValues) {
        MultivaluedMap<String, String> qParams = new com.sun.jersey.api.representation.Form();
        for (int i = 0; i < paramNames.length; i++) {
            if (paramValues[i] != null) {
                qParams.add(paramNames[i], paramValues[i]);
            }
        }
        return qParams;
    }

    public void close() {
        client.destroy();
    }
    
}
