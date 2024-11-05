package com.bvr.geoTool.file.csv;

import org.apache.commons.lang3.StringUtils;
import org.geotools.data.DataUtilities;
import org.geotools.feature.SchemaException;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ReadCsvWithGeotools {

    /**
     * Returns content of the csv file.
     */
    public static List<SimpleFeature> get(String filename) {
        List<SimpleFeature> features = new ArrayList<>();
        try {
            SimpleFeatureType TYPE = DataUtilities.createType("Location", "the_geom:Point:srid=4326,name:String,number:Integer");
            // Read file
            GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();
            SimpleFeatureBuilder featureBuilder = new SimpleFeatureBuilder(TYPE);
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                var line = reader.readLine();
                for (line = reader.readLine(); line != null; line = reader.readLine()) {
                    if (!line.trim().isEmpty()) {
                        // Parse columns
                        String tokens[] = line.split(",");
                        double latitude = getDoubleValue(tokens[2]);
                        double longitude = getDoubleValue(tokens[3]);
                        String name = tokens[1].trim().replaceAll("\"", "");
                        String id = tokens[10].trim().replaceAll("\"", "");
                        if (StringUtils.isNumeric(id)) {
                            Integer number = Integer.parseInt(id);
//                         Build feature
                            featureBuilder.add(geometryFactory.createPoint(new Coordinate(longitude, latitude)));
                            featureBuilder.add(name);
                            featureBuilder.add(number);
                            featureBuilder.add(number);
                            features.add(featureBuilder.buildFeature(String.valueOf(number)));
                        }
                    }
                }
            }
        } catch (IOException | SchemaException e) {
            e.fillInStackTrace();
        }
        return features;
    }

    private static double getDoubleValue(String value) {
        value = value.replaceAll("\"", "");
        double result = 0;
        try {
            result = NumberFormat.getInstance(Locale.getDefault()).parse(value).doubleValue();
        } catch (ParseException e) {
            e.fillInStackTrace();
        }
        return result;
    }
}
