package com.jaspersoft.jrs_client_restlet_android_demo.dto;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "roles", strict = false)
public class ClientRoleCollection {

    @ElementList(inline = true, name = "role", required = false)
    private List<ClientRole> roles;

    public ClientRoleCollection() {
    }

    public ClientRoleCollection(List<ClientRole> roles) {
        this.roles = roles;
    }

    public List<ClientRole> getRoles() {
        return roles;
    }

    public void setRoles(List<ClientRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "ClientRoleCollection{" +
                "roles=" + roles +
                '}';
    }
}
