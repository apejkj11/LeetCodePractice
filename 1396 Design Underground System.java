
//1396. Design Underground System
class UndergroundSystem {
    Map<String, Pair<Double, Double>> tripstat;
    Map<Integer, Pair<String, Integer>> checkin;
    public UndergroundSystem() {
        tripstat = new HashMap<>();
        checkin = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkin.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkindata = checkin.get(id);
        String start = checkindata.getKey();
        Integer starttime = checkindata.getValue();
        String route = start + "," + stationName;
        Pair<Double, Double> trip = tripstat.getOrDefault(route, new Pair<>(0.0, 0.0));
        Double tripduration = trip.getKey();
        Double triptimes = trip.getValue();
        Double tripd = tripduration + t - starttime;
        triptimes += 1;
        tripstat.put(route, new Pair<>(tripd, triptimes));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "," + endStation;
        Double tripduration = tripstat.get(route).getKey();
        Double totaltimes = tripstat.get(route).getValue();
        return tripduration/totaltimes;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */