package com.bvr;


import com.bvr.Questions.GpsRelatedMethods;
import com.tb.core.enums.DistanceUnit;
import com.tb.core.util.AgricultureUtil;
import com.tb.core.util.CoreUtil;
import org.apache.poi.ss.formula.functions.T;
import org.geotools.data.DataUtilities;
import org.geotools.feature.SchemaException;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeImpl;
import org.geotools.referencing.CRS;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.referencing.FactoryException;

import java.io.IOException;
import java.util.List;

public class Testing {
    public static void main(String[] args) throws Exception {
//        List<List<String>> lists = ReadCsvWithApacheCommons.get("/home/admin1/Downloads/gps4.db_violation_report.csv");
//        System.out.println(lists.get(1));
//        List<SimpleFeature> simpleFeatures = ReadCsvWithGeotools.get("/home/admin1/Downloads/worldcities.csv");
//        FeatureCollection featureCollection = ReadGeoJson.get("/home/admin1/office/Database/gps4/db_violation_report.json");
//        System.out.println(JTSCoreConversion.calculateDistance(10, 20, 12, 22));
//        System.out.println(CoreUtil.calculateDistance(10, 20, 12, 22, DistanceUnit.METER));
//        System.out.println(JTSCoreConversion.getAngle(10, 20, 12, 22));
//        System.out.println(JTSCoreConversion.getCoordinateByDistance(10, 20, 12, 90));
//        System.out.println(JTSCoreConversion.createCircle(77.32914268970491,28.57273994581136, 100, 0,360,70));
        System.out.println(GpsRelatedMethods.is_location_in_same_direction(28.579733, 77.321827, 28.580105, 77.322350, 28.580411, 77.322664, 5));
    }

}
