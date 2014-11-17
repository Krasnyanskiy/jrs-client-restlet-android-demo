package com.jaspersoft.jrs_client_restlet_android_demo.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "role", strict = false)
public class ClientRole {

    @Element(name = "name", required = false)
    private java.lang.String name;

    @Element(name = "externallyDefined", required = false)
    private boolean externallyDefined;

    @Element(name = "tenantId", required = false)
    private java.lang.String tenantId;

    public ClientRole() {

    }

    public ClientRole(String name, boolean externallyDefined, String tenantId) {
        this.name = name;
        this.externallyDefined = externallyDefined;
        this.tenantId = tenantId;
    }

    /**
     * Copy constructor
     *
     * @param role an old entity
     */
    public ClientRole(ClientRole role) {
        this(role.getName(), role.externallyDefined, role.getTenantId());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExternallyDefined() {
        return externallyDefined;
    }

    public void setExternallyDefined(boolean externallyDefined) {
        this.externallyDefined = externallyDefined;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String toString() {
        return "ClientRole{" +
                "name='" + name + '\'' +
                ", externallyDefined=" + externallyDefined +
                ", tenantId='" + tenantId + '\'' +
                '}';
    }
}
