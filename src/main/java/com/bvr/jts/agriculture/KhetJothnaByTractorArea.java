package com.bvr.jts.agriculture;

import com.bvr.helper.FileReader;
import com.bvr.jts.helper.JTSCoreConversion;
import com.tb.core.enums.DistanceUnit;
import com.tb.core.modal.AgricultureData;
import com.tb.core.util.AgricultureUtil;
import com.tb.core.util.CoreUtil;
import com.tb.core.util.GeoCalculator;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.locationtech.jts.geom.*;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KhetJothnaByTractorArea {
    public static final GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();

    public static void main(String[] args) {
        BufferedReader br = FileReader.readCSVFile("/home/admin1/Downloads/output(1).csv");
        String line;
        List<Double[]> loctions = new ArrayList<>();
        try {

            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                loctions.add(new Double[]{Double.parseDouble(split[1]), Double.parseDouble(split[0])});
            }
            System.out.println(loctions.size());
            long start, end;
//            start = System.currentTimeMillis();
//            Coordinate[] coordinates = JTSCoreConversion.locationToCoordinateArray(loctions);
//            LineString lineString = geometryFactory.createLineString(coordinates);
//            System.out.println(JTSCoreConversion.locationToMeterFormat(lineString.getLength()));
//            BufferOp bufferOp = new BufferOp(lineString);
//            bufferOp.setEndCapStyle(BufferOp.CAP_ROUND);
//            double v = JTSCoreConversion.meterToLocationFormat(5);
//            System.out.println(v);
//            Geometry resultGeometry = bufferOp.getResultGeometry(v);
//            System.out.println(resultGeometry);

//            System.out.println(JTSCoreConversion.locationAreaToMeterAreaFormat(resultGeometry.getArea()));

//            end = System.currentTimeMillis();
//            System.out.println("mere logic taking Time : " + (end - start));
            AgricultureUtil agricultureUtil = new AgricultureUtil();
            start = System.currentTimeMillis();
            AgricultureData area = agricultureUtil.getArea(loctions, 10);
            System.out.println(area.getArea());
            System.out.println(area.getGeometry());

//            System.out.println("Sir ke logic taking Time : " + (end - start));
//            Polygon bufferPolygon = doBufferOfLineString(loctions, 10);
//            LineString exteriorRing = bufferPolygon.getExteriorRing();
//            double totalArea = JTSCoreConversion.computeArea(Arrays.asList(exteriorRing.getCoordinates()));
//            for (int i = 0; i < bufferPolygon.getNumInteriorRing(); i++) {
//                LineString interiorRing = bufferPolygon.getInteriorRingN(i);
//                totalArea -= JTSCoreConversion.computeArea(Arrays.asList(interiorRing.getCoordinates()));
//            }
//            System.out.println("Area: " + totalArea);
//            System.out.println(bufferPolygon);
            end = System.currentTimeMillis();
            System.out.println("mere logic taking Time : " + (end - start));
//            }


        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
    }

    private static Polygon doBufferOfLineString(List<Double[]> locations, int distanceInMeter) {
        Coordinate prevCoor = new Coordinate(locations.get(0)[0], locations.get(0)[1]);

        Polygon[] geometries = new Polygon[locations.size() - 1];
        for (int i = 1; i < locations.size(); i++) {
            Coordinate nextCoor = new Coordinate(locations.get(i)[0], locations.get(i)[1]);
            Polygon polygon = createPolygon(prevCoor, nextCoor, distanceInMeter / 2);
//            System.out.println(polygon);
            geometries[i - 1] = polygon;
            prevCoor = nextCoor;

        }
        return (Polygon) geometryFactory.createGeometryCollection(geometries).buffer(0.0);
    }

    private static Polygon createPolygon(Coordinate prevCoor, Coordinate nextCoor, int distanceInMeter) {
        double angle = JTSCoreConversion.getAngle(prevCoor, nextCoor);
        List<Coordinate> coordinates = new ArrayList<>();
        double minusBearing = angle - 90;
        double plusBearing = angle + 90;
        if (plusBearing > 359.9) {
            plusBearing -= 360;
        }
        if (minusBearing < 0) {
            minusBearing += 360;
        }
        Coordinate startingPoint = JTSCoreConversion.getCoordinateByDistance(prevCoor.getY(), prevCoor.getX(), distanceInMeter, plusBearing);
        Coordinate point2 = JTSCoreConversion.getCoordinateByDistance(prevCoor.getY(), prevCoor.getX(), distanceInMeter, minusBearing);
        Coordinate point3 = JTSCoreConversion.getCoordinateByDistance(nextCoor.getY(), nextCoor.getX(), distanceInMeter, minusBearing);
        Coordinate point4 = JTSCoreConversion.getCoordinateByDistance(nextCoor.getY(), nextCoor.getX(), distanceInMeter, plusBearing);
        coordinates.add(startingPoint);
        coordinates.addAll(Arrays.asList(createArc(prevCoor.getX(), prevCoor.getY(), distanceInMeter, plusBearing, minusBearing, 16).getCoordinates()));
        coordinates.add(point2);
        coordinates.add(point3);
        coordinates.addAll(Arrays.asList(createArc(nextCoor.getX(), nextCoor.getY(), distanceInMeter, minusBearing, plusBearing, 16).getCoordinates()));
        coordinates.add(point4);
        coordinates.add(startingPoint);
        return geometryFactory.createPolygon(coordinates.toArray(new Coordinate[0]));
    }


    public static LineString createArc(double centerX, double centerY, double radius, double startAngle, double endAngle, int numPoints) {
        Coordinate[] coordinates = new Coordinate[numPoints + 1];

        double angleIncrement = endAngle > startAngle ? (endAngle - startAngle) : (startAngle - endAngle);
        angleIncrement /= numPoints;
        double angle = startAngle + angleIncrement;

        for (int i = 0; i <= numPoints; i++) {
            if (angle > 359.99) {
                angle -= 360;
            }
            coordinates[i] = JTSCoreConversion.getCoordinateByDistance(centerY, centerX, radius, angle);
            angle += angleIncrement;
        }

        return geometryFactory.createLineString(coordinates);
    }

    public static LineString createArcReverse(double centerX, double centerY, double radius, double startAngle, double endAngle, int numPoints) {
        Coordinate[] coordinates = new Coordinate[numPoints + 1];

        double angleIncrement = endAngle > startAngle ? (endAngle - startAngle) : (startAngle - endAngle);
        angleIncrement /= numPoints;
        double angle = startAngle + angleIncrement;

        for (int i = 0; i <= numPoints; i++) {
            if (angle > 359.99) {
                angle -= 360;
            }
            coordinates[i] = JTSCoreConversion.getCoordinateByDistance(centerY, centerX, radius, angle);
            angle += angleIncrement;
        }

        return geometryFactory.createLineString(coordinates);
    }
}
