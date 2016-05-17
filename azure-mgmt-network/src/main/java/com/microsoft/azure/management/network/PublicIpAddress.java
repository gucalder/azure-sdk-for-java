/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.management.network;

import com.microsoft.azure.management.network.implementation.api.PublicIPAddressInner;
import com.microsoft.azure.management.resources.fluentcore.arm.models.GroupableResource;
import com.microsoft.azure.management.resources.fluentcore.model.Creatable;
import com.microsoft.azure.management.resources.fluentcore.model.Refreshable;
import com.microsoft.azure.management.resources.fluentcore.model.Wrapper;

public interface PublicIpAddress extends
        GroupableResource,
        Refreshable<PublicIpAddress>,
        Wrapper<PublicIPAddressInner> {

    /***********************************************************
     * Getters
     ***********************************************************/
	String ipAddress();
	String leafDomainLabel();

    /**************************************************************
     * Fluent interfaces for provisioning
     **************************************************************/
	interface Definitions extends 
		DefinitionBlank,
		DefinitionWithGroup,
		DefinitionWithIpAddress,
		DefinitionWithLeafDomainLabel,
		DefinitionCreatable {}
	
	
    interface DefinitionBlank extends GroupableResource.DefinitionWithRegion<DefinitionWithGroup> {
    }

    interface DefinitionWithGroup extends GroupableResource.DefinitionWithGroup<DefinitionCreatable> {
    }

	public interface DefinitionWithIpAddress {
		/**
		 * Enables static IP address allocation. The actual IP address allocated for this resource by Azure can be obtained 
		 * after the provisioning process is complete from ipAddress().
		 * @return The next stage of the public IP address definition
		 */
		DefinitionCreatable withStaticIp();
		
		/**
		 * Enables dynamic IP address allocation.
		 * @return The next stage of the public IP address definition
		 */
		DefinitionCreatable withDynamicIp();
	}

	/**
	 * A public IP address definition allowing to specify the leaf domain label, if any
	 */
	public interface DefinitionWithLeafDomainLabel {
		/**
		 * Specifies the leaf domain label to associate with this public IP address. The fully qualified domain name (FQDN) 
		 * will be constructed automatically by appending the rest of the domain to this label.
		 * @param dnsName The leaf domain label to use. This must follow the required naming convention for leaf domain names.
		 * @return The next stage of the public IP address definition
		 */
		DefinitionCreatable withLeafDomainLabel(String dnsName);
		
		/**
		 * Ensures that no leaf domain label will be used. This means that this public IP address will not be associated with a domain name.
		 * @return The next stage of the public IP address definition
		 */
		DefinitionCreatable withoutLeafDomainLabel();
	}
	

    interface DefinitionCreatable extends 
    	Creatable<PublicIpAddress>,
    	DefinitionWithLeafDomainLabel,
    	DefinitionWithIpAddress {
    }
}
