package br.router.util.math;

public class GeoMath {
	
	public static final double R = 6371009;
	
	private GeoMath() {
		
	}
	
	public static double haversine(double lat1, double lng1, double lat2, double lng2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lng2 - lng1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
 
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }
	
	public static double distanceToLine(
				final double latPoint, final double lngPoint,
				final double latStart, final double lngStart,
				final double latEnd, final double lngEnd) {
        if (latStart == latEnd && lngStart == lngEnd) {
        	haversine(latPoint, lngPoint, latEnd, lngEnd);
        }

        final double s0lat = Math.toRadians(latPoint);
        final double s0lng = Math.toRadians(lngPoint);
        final double s1lat = Math.toRadians(latStart);
        final double s1lng = Math.toRadians(lngStart);
        final double s2lat = Math.toRadians(latEnd);
        final double s2lng = Math.toRadians(lngEnd);

        double s2s1lat = s2lat - s1lat;
        double s2s1lng = s2lng - s1lng;
        final double u = ((s0lat - s1lat) * s2s1lat + (s0lng - s1lng) * s2s1lng)
                / (s2s1lat * s2s1lat + s2s1lng * s2s1lng);
        if (u <= 0) {
            return haversine(latPoint, lngPoint, latStart, lngStart);
        }
        if (u >= 1) {
        	return haversine(latPoint, lngPoint, latEnd, lngEnd);
        }
        return haversine(
    		latPoint - latStart, lngPoint - lngStart, 
    		u * (latEnd - latStart), u * (lngEnd - lngStart)
    	);
}
}
