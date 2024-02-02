import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SatelliteMap {

    private static SatelliteMap instance;
    private Map<Integer, Satellite> satelliteMap;
    private Map<String, Integer> nameToNorad;

    private SatelliteMap(){
        satelliteMap = new HashMap<>();
        nameToNorad = new HashMap<>();
    }

    public static SatelliteMap getInstance(){
        if(instance == null){
            instance = new SatelliteMap();
        }

        return instance;
    }

    public void addSatellite(Satellite satellite){
        satelliteMap.put(satellite.getNorad(), satellite);
        nameToNorad.put(satellite.getName(), satellite.getNorad());
    }

    public List<Satellite> getSortedSatellites() {
        List<Satellite> sortedList = new ArrayList<>(satelliteMap.values());
        sortedList.sort(Comparator.comparingInt(Satellite::getNorad));
        return sortedList;
    }

        public Satellite getSatteliteByNorad(int norad){
        return satelliteMap.get(norad);
    }
    public Satellite getSatelliteByName(String name){
        return satelliteMap.get(nameToNorad.get(name));
    }

    public Collection<Satellite> getValues(){
        return satelliteMap.values();
    }

}
