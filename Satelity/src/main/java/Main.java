import java.io.IOException;
import java.util.List;

public class Main {

    private static SatelliteMap satelliteMap = SatelliteMap.getInstance();
    public static void main(String[] args) {
        SatBeamsScraper.scrapSatellites();
        KingOfSatScraper.scrapSatellite();
        FlySatScraper.scrapSatellite();
        System.out.println(satelliteMap.getSatteliteByNorad(42801).getName());

        ExcelExporter exporter = new ExcelExporter();

        try{
            exporter.exportToExcel(satelliteMap, "satellites.xlsx");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
