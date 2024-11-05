package com.bvr.jts.agriculture;

import com.bvr.helper.FileReader;
import com.bvr.jts.helper.JTSCoreConversion;
import com.tb.core.enums.DistanceUnit;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.operation.buffer.BufferParameters;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class PolygonArea {
    public static void main(String[] args) {
        BufferedReader br = FileReader.readCSVFile("/home/admin1/Downloads/output (1).csv");
        String line;
        List<Double[]> loctions = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                loctions.add(new Double[]{Double.parseDouble(split[1]), Double.parseDouble(split[0])});
            }
            Coordinate[] coordinates = JTSCoreConversion.locationToCoordinateArray(loctions);
            GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();
            LineString lineString = geometryFactory.createLineString(coordinates);
            System.out.println(JTSCoreConversion.locationToMeterFormat(lineString.getLength()));
            Geometry resultGeometry = JTSCoreConversion.getBufferGeometry(lineString, BufferParameters.CAP_SQUARE,10,DistanceUnit.METER);
            System.out.println(resultGeometry);
            System.out.println(JTSCoreConversion.locationToMeterFormat(resultGeometry.getLength()));
            System.out.println(JTSCoreConversion.locationAreaToMeterAreaFormat(resultGeometry.getArea()));
        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
    }
}
