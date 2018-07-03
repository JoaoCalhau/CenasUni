/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasd.rest;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;

/**
 * Jersey REST client generated for REST resource:application
 * [customers/newFirst]<br>
 * USAGE:
 * <pre>
 *        NewJerseyClientFirst client = new NewJerseyClientFirst();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author João
 */
public class NewJerseyClientFirst {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:36764/tasd/";

    public NewJerseyClientFirst() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("customers/newFirst");
    }

    /**
     * @param id query parameter
     * @param first query parameter
     * @return response object (instance of responseType class)
     */
    public void putCustomer(String id, String first) throws ClientErrorException {
        String[] queryParamNames = new String[]{"id", "first"};
        String[] queryParamValues = new String[]{id, first};
        ;
        javax.ws.rs.core.Form form = getQueryOrFormParams(queryParamNames, queryParamValues);
        javax.ws.rs.core.MultivaluedMap<String, String> map = form.asMap();
        for (java.util.Map.Entry<String, java.util.List<String>> entry : map.entrySet()) {
            java.util.List<String> list = entry.getValue();
            String[] values = list.toArray(new String[list.size()]);
            webTarget = webTarget.queryParam(entry.getKey(), (Object[]) values);
        }
        webTarget.request().put(null);
    }

    private Form getQueryOrFormParams(String[] paramNames, String[] paramValues) {
        Form form = new javax.ws.rs.core.Form();
        for (int i = 0; i < paramNames.length; i++) {
            if (paramValues[i] != null) {
                form = form.param(paramNames[i], paramValues[i]);
            }
        }
        return form;
    }

    public void close() {
        client.close();
    }
    
}
