package com.bvr.jts.agriculture;

import com.bvr.helper.FileReader;
import com.bvr.jts.helper.JTSCoreConversion;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.operation.buffer.BufferOp;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class CircleArea {

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
            GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();
            Point point = geometryFactory.createPoint(coordinates[0]);
            BufferOp bufferOp = new BufferOp(point);
            bufferOp.setEndCapStyle(BufferOp.CAP_ROUND);
            Geometry resultGeometry = bufferOp.getResultGeometry(JTSCoreConversion.meterToLocationFormat(10));
            System.out.println(resultGeometry);
            System.out.println(JTSCoreConversion.locationToMeterFormat(resultGeometry.getLength()));
            System.out.println(JTSCoreConversion.locationAreaToMeterAreaFormat(resultGeometry.getArea()));
        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
    }
}
