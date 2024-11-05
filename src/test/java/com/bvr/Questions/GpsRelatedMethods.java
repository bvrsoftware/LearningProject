package com.bvr.Questions;

public class GpsRelatedMethods {

    public static boolean is_location_in_same_direction(double lat1, double lon1, double lat2, double lon2, double lat3, double lon3, double threshold) {
        boolean flag = false;
        double bearing12 = bearing(lat1, lon1, lat2, lon2);
        double bearing23 = bearing(lat2, lon2, lat3, lon3);
        double diff = Math.abs(bearing23 - bearing12);
        System.out.println(diff);
        if (diff > 180) {
            diff = 360 - diff;
        }
        if (diff <= threshold) {
            flag = true;
        }
        return flag;
    }

    private static double bearing(double startLat, double startLng, double endLat, double endLng) {
        double latitude1 = Math.toRadians(startLat);
        double latitude2 = Math.toRadians(endLat);
        double longDiff = Math.toRadians(endLng - startLng);
        double y = Math.sin(longDiff) * Math.cos(latitude2);
        double x = Math.cos(latitude1) * Math.sin(latitude2) - Math.sin(latitude1) * Math.cos(latitude2) * Math.cos(longDiff);
        return (Math.toDegrees(Math.atan2(y, x)) + 360) % 360;
    }
}
