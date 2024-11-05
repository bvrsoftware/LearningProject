package com.bvr.geoTool.example;


import com.itextpdf.awt.geom.Point;
import org.geotools.data.DataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.referencing.CRS;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.referencing.FactoryException;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class Db_Violation {
    public SimpleFeatureType createFeatureType() throws FactoryException {
        SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
        builder.setName("db_violation");
        builder.setCRS(CRS.decode("EPSG:4326"));
        builder.add("the_geom", Point.class);
        builder.add("vehicle", String.class);
        builder.add("report_type", Integer.class);
        builder.add("id", String.class);
//        builder.add("date", Date.class);

        return builder.buildFeatureType();
    }

    public DataStore createDataStorage(SimpleFeatureType featureType, String storeFilePath) throws IOException {
        ShapefileDataStoreFactory shapefileDataStoreFactory = new ShapefileDataStoreFactory();
        File file = new File(storeFilePath);
        Map<String, Serializable> map = Collections.singletonMap("url", file.toURI().toURL());
        DataStore dataStore = shapefileDataStoreFactory.createNewDataStore(map);
        dataStore.createSchema(featureType);
        return dataStore;
    }

    public static void create_db_violation_shp(List<List<String>> csvFileData) {

    }
}
