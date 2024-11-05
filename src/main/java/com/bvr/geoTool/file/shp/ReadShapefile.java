package com.bvr.geoTool.file.shp;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadShapefile {
    /**
     * Liefert ein {@link SimpleFeatureSource} von dem Shapefile, welches über
     * den angegeben Pfad gelesen wurde.
     */
    public static SimpleFeatureSource get(String filename) {
        SimpleFeatureSource features = null;
        try {
            // File
            File file = new File(filename);
            Map<String, Object> params = new HashMap<>();
            params.put("url", file.toURI().toURL());

            // Datastore
            DataStore dataStore = DataStoreFinder.getDataStore(params);
            String typeName = dataStore.getTypeNames()[0];

            // Read feature
            features = dataStore.getFeatureSource(typeName);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        return features;
    }
}
