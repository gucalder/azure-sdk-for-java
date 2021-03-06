/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for ApplicationGatewayBackendHealthServerHealth.
 */
public final class ApplicationGatewayBackendHealthServerHealth {
    /** Static value Unknown for ApplicationGatewayBackendHealthServerHealth. */
    public static final ApplicationGatewayBackendHealthServerHealth UNKNOWN = new ApplicationGatewayBackendHealthServerHealth("Unknown");

    /** Static value Up for ApplicationGatewayBackendHealthServerHealth. */
    public static final ApplicationGatewayBackendHealthServerHealth UP = new ApplicationGatewayBackendHealthServerHealth("Up");

    /** Static value Down for ApplicationGatewayBackendHealthServerHealth. */
    public static final ApplicationGatewayBackendHealthServerHealth DOWN = new ApplicationGatewayBackendHealthServerHealth("Down");

    /** Static value Partial for ApplicationGatewayBackendHealthServerHealth. */
    public static final ApplicationGatewayBackendHealthServerHealth PARTIAL = new ApplicationGatewayBackendHealthServerHealth("Partial");

    /** Static value Draining for ApplicationGatewayBackendHealthServerHealth. */
    public static final ApplicationGatewayBackendHealthServerHealth DRAINING = new ApplicationGatewayBackendHealthServerHealth("Draining");

    private String value;

    /**
     * Creates a custom value for ApplicationGatewayBackendHealthServerHealth.
     * @param value the custom value
     */
    public ApplicationGatewayBackendHealthServerHealth(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ApplicationGatewayBackendHealthServerHealth)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ApplicationGatewayBackendHealthServerHealth rhs = (ApplicationGatewayBackendHealthServerHealth) obj;
        if (value == null) {
            return rhs.value == null;
        } else {
            return value.equals(rhs.value);
        }
    }
}
