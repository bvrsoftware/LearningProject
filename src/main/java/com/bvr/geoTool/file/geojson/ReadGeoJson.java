package com.bvr.geoTool.file.geojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.geotools.feature.FeatureCollection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadGeoJson {
    /**
     * Returns {@link FeatureCollection} of the geojson file.
     */
    public static FeatureCollection get(String filename) {
        FeatureCollection featureCollection = null;
        try {
            // File
            File file = new File(filename);
            featureCollection = new ObjectMapper().readValue(new FileInputStream(file), FeatureCollection.class);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        return featureCollection;
    }
}
