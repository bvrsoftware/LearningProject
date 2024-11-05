package com.bvr.jts.agriculture;

import com.bvr.helper.FileReader;
import com.bvr.jts.helper.JTSCoreConversion;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class LineDistance {
    public static void main(String[] args) {
        BufferedReader br = FileReader.readCSVFile("/home/admin1/Downloads/output(1).csv");
        String line;
        List<Double[]> loctions = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                loctions.add(new Double[]{Double.parseDouble(split[1]), Double.parseDouble(split[0])});
            }
            Coordinate[] coordinates = JTSCoreConversion.locationToCoordinateArray(loctions);
            double distance = coordinates[0].distance(coordinates[coordinates.length - 1]);
            System.out.println(JTSCoreConversion.locationToMeterFormat(distance));
            GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();
            LineString lineString = geometryFactory.createLineString(coordinates);
            System.out.println(JTSCoreConversion.locationToMeterFormat(lineString.getLength()));
        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
    }
}
