package com.jaspersoft.jrs_client_restlet_android_demo.service;

import android.os.AsyncTask;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.data.Preference;
import org.restlet.engine.Engine;
import org.restlet.engine.connector.HttpClientHelper;
import org.restlet.resource.ClientResource;

import java.io.IOException;

public class RetrieveResourceTaskService extends AsyncTask<String, Integer, String> {

    /** client constants **/
    private static Engine INSTANCE = Engine.getInstance();
    private static MediaType MEDIA_TYPE = new MediaType("application", "repository.semanticLayerDataSource+xml");


    /** result entity **/
    private String entity;


    protected String doInBackground(String... urls) {
        INSTANCE.getRegisteredClients().clear();
        INSTANCE.getRegisteredClients().add(new HttpClientHelper(null));

        ClientResource resource = new ClientResource(urls[0]);
        ChallengeScheme scheme = ChallengeScheme.HTTP_BASIC;
        ChallengeResponse auth = new ChallengeResponse(scheme, "superuser", "superuser");

        resource.setChallengeResponse(auth);
        resource.getClientInfo()
                .getAcceptedMediaTypes()
                .add(new Preference<MediaType>(MEDIA_TYPE));

        try {
            entity = resource.get(MEDIA_TYPE).getText();
        } catch (IOException ignored) {}

        return entity;
    }

    protected void onProgressUpdate(Integer... progress) {
    }
}


