package com.bvr.jts.helper;

import com.tb.core.enums.DistanceUnit;
import com.tb.core.util.CoreUtil;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.operation.buffer.BufferOp;
import org.locationtech.jts.operation.buffer.BufferParameters;
import org.locationtech.jts.operation.distance.DistanceOp;

import java.util.List;

import static java.lang.Math.*;
import static java.lang.Math.toDegrees;

public class JTSCoreConversion {

    public static final int EARTH_RADIUS_METER = 6371009;
    public static final GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();

    public static Coordinate[] locationToCoordinateArray(List<Double[]> longLat) {
        Coordinate[] coordinates = new Coordinate[longLat.size()];
        for (int i = 0; i < longLat.size(); i++)
            coordinates[i] = new Coordinate(longLat.get(i)[0], longLat.get(i)[1]);
        return coordinates;
    }

    public static double locationToMeterFormat(double value) {
        return value * 110000;
    }

    public static double meterToLocationFormat(double value) {
        return Math.sqrt(Math.pow(value / 111111, 2) + Math.pow(value / 111139, 2));
    }

    public static double locationAreaToMeterAreaFormat(double value) {
        // locationArea square To MeterArea square
        return value * Math.pow(111194.9, 2);
    }

    public static boolean isOverlappedGeometry(Geometry geometry1, Geometry geometry2) { //geometry1 cross both side
        return geometry1.intersects(geometry2);
    }

    public static boolean geometryContainsPoint(Geometry geometry, double lat, double lng) {
        return geometry.contains(geometryFactory.createPoint(new Coordinate(lng, lat)));
    }

    public static double getDistanceFromNearestGeometry(Geometry geometry, double lat, double lng) {
        if (geometry == null) {
            return -1;
        }
        Point p = geometryFactory.createPoint(new Coordinate(lng, lat));
        Coordinate nearestCoordinate = DistanceOp.nearestPoints(geometry, p)[0];
        return CoreUtil.calculateDistance(new double[]{lng, lat}, new double[]{nearestCoordinate.getX(), nearestCoordinate.getY()}, DistanceUnit.METER);
    }

    public static Geometry getBufferGeometry(Geometry geometry, int bufferParametersEndCapStyle, double distance, DistanceUnit distanceUnit) { // return in meters
        switch (distanceUnit) {
            case KILO_METER:
                distance *= 1000;
                break;
            case MILES:
                distance *= 1609.34;
                break;
            case NAUTICAL:
                distance *= 1852;
                break;
        }
        distance = meterToLocationFormat(distance);
        return BufferOp.bufferOp(geometry, distance, BufferParameters.DEFAULT_QUADRANT_SEGMENTS, bufferParametersEndCapStyle);
    }

    public static double calculateDistance(double latitude2, double longitude2, double latitude1, double longitude1) {
        if (latitude1 == latitude2 && longitude1 == longitude2)
            return 0.0;
        //all degree coordinate to Radians
        latitude1 = deg2rad(latitude1);
        longitude1 = deg2rad(longitude1);
        latitude2 = deg2rad(latitude2);
        longitude2 = deg2rad(longitude2);
        //Pythagoras Theorem
        double dLat = latitude2 - latitude1; // height(lambi)
        double dLng = longitude2 - longitude1; // base (adhar) , kand= ?,
        // Haversine formula
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(dLng / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return EARTH_RADIUS_METER * c;
    }

    /* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
    /* :: This function converts decimal degrees to radians : */
    /* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
    /* :: This function converts radians to decimal degrees : */
    /* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

    public static double getAngle(double latitude1, double longitude1, double latitude2, double longitude2) {
          return bearing(latitude1,longitude1,latitude2,longitude2);
    }
    private static double bearing(double startLat, double startLng, double endLat, double endLng) {
        double latitude1 = Math.toRadians(startLat);
        double latitude2 = Math.toRadians(endLat);
        double longDiff = Math.toRadians(endLng - startLng);
        double y = Math.sin(longDiff) * Math.cos(latitude2);
        double x = Math.cos(latitude1) * Math.sin(latitude2) - Math.sin(latitude1) * Math.cos(latitude2) * Math.cos(longDiff);
        return (Math.toDegrees(Math.atan2(y, x)) + 360) % 360;
    }

    public static double getAngle(double[] prePoint, double[] nextPoint) {
        return getAngle(prePoint[0], prePoint[1], nextPoint[0], nextPoint[1]);
    }

    public static double getAngle(Coordinate preCoordinate, Coordinate nextCoordinate) {
        return getAngle(preCoordinate.getY(), preCoordinate.getX(), nextCoordinate.getY(), nextCoordinate.getX());
    }

    public static double getAngle(double latitude, double longitude) {

        return rad2deg(Math.atan2(longitude, latitude));
    }

    public static Coordinate getCoordinateByDistance(double latitude, double longitude, double distanceInMeter, double bearing) {
        double radius = 6371009;
        bearing = toRadians(bearing);
        double lat1 = toRadians(latitude);
        double lon1 = toRadians(longitude);
        double lat2 = asin(Math.sin(lat1) * cos(distanceInMeter / radius) + cos(lat1) * sin(distanceInMeter / radius) * cos(bearing));
        double lon2 = lon1 + atan2(sin(bearing) * sin(distanceInMeter / radius) * cos(lat1), cos(distanceInMeter / radius) - sin(lat1) * sin(lat2));
        lat2 = toDegrees(lat2);
        lon2 = toDegrees(lon2);
        return new Coordinate(lon2, lat2);
    }

    /**
     * To find the area we will always call this method.
     *
     * @param path
     * @return
     */
    public static double computeArea(List<Coordinate> path) {
        return Math.abs(computeSignedArea(path));
    }

    private static double computeSignedArea(List<Coordinate> path) {
        return computeSignedArea(path, EARTH_RADIUS_METER);
    }

    private static double computeSignedArea(List<Coordinate> path, double radius) {
        int size = path.size();
        if (size < 3) {
            return 0;
        }
        double total = 0;
        Coordinate prev = path.get(size - 1);
        double prevTanLat = tan((PI / 2 - toRadians(prev.getY())) / 2);
        double prevLng = toRadians(prev.getX());
        // For each edge, accumulate the signed area of the triangle formed by the North Pole
        // and that edge ("polar triangle").
        for (Coordinate point : path) {
            double tanLat = tan((PI / 2 - toRadians(point.getY())) / 2);
            double lng = toRadians(point.getX());
            total += polarTriangleArea(tanLat, lng, prevTanLat, prevLng);
            prevTanLat = tanLat;
            prevLng = lng;
        }
        return total * (radius * radius);
    }

    private static double polarTriangleArea(double tan1, double lng1, double tan2, double lng2) {
        double deltaLng = lng1 - lng2;
        double t = tan1 * tan2;
        return 2 * atan2(t * sin(deltaLng), 1 + t * cos(deltaLng));
    }
    public static Polygon createCircle(double centerX, double centerY, double radius, double startAngle, double endAngle, int numPoints) {
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

        return geometryFactory.createPolygon(coordinates);
    }

}
