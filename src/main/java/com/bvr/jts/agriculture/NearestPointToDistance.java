package com.bvr.jts.agriculture;

import com.bvr.jts.helper.JTSCoreConversion;
//import com.tb.core.util.PolyLine.LineUtils;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.operation.buffer.BufferOp;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NearestPointToDistance {
    public static void main(String[] args) {
//        String encodePath = "y|ypC{tffOMIeBt@s@zBOXyAzEG\\o@vCi@dCAl@yAjF[tAFjFJtDKnBa@`DE`@k@vAGCKuFHu@kAjDW`D@\\fAhD@X{@vFWzAWpDIpAe@vDk@|DQr@k@dBMT";
//        List<Double[]> doubles = LineUtils.decodePolyline(encodePath, null);
        Coordinate[] coordinates = JTSCoreConversion.locationToCoordinateArray(null);
        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();
        LineString lineString = geometryFactory.createLineString(coordinates);
        System.out.println(coordinates.length);
        System.out.println(lineString);
        System.out.println(JTSCoreConversion.locationToMeterFormat(lineString.getLength()));
        BufferOp bufferOp = new BufferOp(geometryFactory.createPoint(coordinates[3]));
        bufferOp.setEndCapStyle(BufferOp.CAP_ROUND);
        Geometry resultGeometry = bufferOp.getResultGeometry(JTSCoreConversion.meterToLocationFormat(20));
        System.out.println(resultGeometry);
        BufferOp bufferOp1 = new BufferOp(geometryFactory.createPoint(coordinates[25]));
        bufferOp1.setEndCapStyle(BufferOp.CAP_SQUARE);
        Geometry resultGeometry1 = bufferOp1.getResultGeometry(JTSCoreConversion.meterToLocationFormat(10));
        System.out.println(resultGeometry1);
        Map<String, Geometry> geoFance = new TreeMap<>();
        geoFance.put("geo1", resultGeometry);
        geoFance.put("geo2", resultGeometry1);
        for (int i = 0; i < coordinates.length; i++) {
            Point point = geometryFactory.createPoint(coordinates[i]);
            geoFance.forEach((k, v) -> {
                if (v.contains(point)) {
                    System.out.println(k);
                }
            });
        }
    }
}
