package com.jaspersoft.jrs_client_restlet_android_demo.common;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class EntityConverter {

    private Serializer serializer;

    public EntityConverter() {
        serializer = new Persister();
    }

    public <T> T convert(String entity, Class<T> entityClass) throws Exception {
        T e = serializer.read(entityClass, entity, false);
        System.out.println(e);
        return e;
    }
}
