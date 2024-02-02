import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
public class FlySatScraper {

    private static final String FlySatURL = "https://www.flysat.com/en/satellitelist";
    private static SatelliteMap satelliteMap = SatelliteMap.getInstance();
    public static void scrapSatellite(){

        try {
            Document doc = Jsoup.connect(FlySatURL).get();

            Element tbody = doc.select("tbody").get(10);

            Elements tables = tbody.select("table");

            for(Element table : tables){
                Elements trs = table.select("tr");
                trs.remove(0);
                for(Element tr : trs){
                    Elements tds = tr.select("td");

                    String name = tds.get(1).select("a").text();
                    String band;
                    String updateDate;
                    if(tds.size() > 5){
                        band = tds.get(4).text();
                        updateDate = tds.get(5).text();
                    }
                    else{
                        band = tds.get(3).text();
                        updateDate = tds.get(4).text();
                    }
                    if(satelliteMap.getSatelliteByName(name) == null) continue;
                    satelliteMap.getSatelliteByName(name).setBand(band);
                    satelliteMap.getSatelliteByName(name).setUpdateDate(updateDate);
                }

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        scrapSatellite();
    }
}
