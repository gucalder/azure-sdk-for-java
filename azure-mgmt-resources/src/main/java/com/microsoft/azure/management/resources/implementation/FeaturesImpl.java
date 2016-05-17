package com.microsoft.azure.management.resources.implementation;

import com.microsoft.azure.CloudException;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.management.resources.Features;
import com.microsoft.azure.management.resources.fluentcore.utils.PagedListConverter;
import com.microsoft.azure.management.resources.implementation.api.FeaturesInner;
import com.microsoft.azure.management.resources.Feature;
import com.microsoft.azure.management.resources.implementation.api.FeatureResultInner;
import java.io.IOException;

public final class FeaturesImpl
        implements Features {
    private final FeaturesInner client;

    public FeaturesImpl(final FeaturesInner client) {
        this.client = client;
    }

    @Override
    public PagedList<Feature> list() throws CloudException, IOException {
        PagedListConverter<FeatureResultInner, Feature> converter = new PagedListConverter<FeatureResultInner, Feature>() {
            @Override
            public Feature typeConvert(FeatureResultInner tenantInner) {
                return new FeatureImpl(tenantInner);
            }
        };
        return converter.convert(client.listAll().getBody());
    }

    @Override
    public InResourceProvider resourceProvider(String resourceProviderName) {
        return null;
    }
}