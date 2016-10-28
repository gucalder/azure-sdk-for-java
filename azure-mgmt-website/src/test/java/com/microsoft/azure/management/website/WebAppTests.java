/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.website;

import com.microsoft.azure.management.resources.ResourceGroup;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebAppTests extends AppServiceTestBase {
    private static final String RG_NAME = "javacsmrg319";
    private static final String WEBAPP_NAME = "java-webapp-319";
    private static ResourceGroup resourceGroup;

    @BeforeClass
    public static void setup() throws Exception {
        createClients();
    }

    @AfterClass
    public static void cleanup() throws Exception {
        //resourceManager.resourceGroups().deleteByName(RG_NAME);
    }

    @Test
    public void canCRUDWebApp() throws Exception {
        Domain domain = appServiceManager.domains().getByGroup(RG_NAME, "javatestpr319.com");
        WebApp webApp = appServiceManager.webApps().define(WEBAPP_NAME)
                .withRegion(Region.US_WEST)
                .withNewResourceGroup(RG_NAME)
                .withNewAppServicePlan("java-plan-323", AppServicePricingTier.STANDARD_S1)
                .defineHostNameBinding(domain, "test2.javatestpr319.com")
                    .withHostNameType(HostNameType.MANAGED)
                    .withHostNameDnsRecordType(CustomHostNameDnsRecordType.A)
                    .attach()
                .create();
        Assert.assertNotNull(webApp);
//        webApp.update()
//                .defineHostNameBinding("javatest.quarterquota.net")
//                .withHostNameType(HostNameType.VERIFIED)
//                .withHostNameDnsRecordType(CustomHostNameDnsRecordType.A)
//                .attach()
//                .enableSniSsl("javatest.quarterquota.net", "56DD1FF5F5FD02D829B6BC47DC5B733CA93492CF")
//                .apply();
    }
}