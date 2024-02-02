import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
public class KingOfSatScraper {

    private static final String KingOfSatURL = "https://en.kingofsat.net/satellites.php";

    private static SatelliteMap satelliteMap = SatelliteMap.getInstance();

    public static void scrapSatellite(){
        try {
            Document doc = Jsoup.connect(KingOfSatURL).get();

            Element table = doc.selectFirst("tbody");
            Elements trs = table.select("tr");

            for(Element currTr : trs){
                Elements tds = currTr.select("td");
                String name = tds.get(1).select("a").text();

                int norad = Integer.parseInt(tds.get(2).text());

                int channelsNum = Integer.parseInt(tds.get(5).text());
                int freeToAirOnly = Integer.parseInt(tds.get(6).text());

                String declinationNow = tds.get(8).text();
                String declinationMax = tds.get(9).text();

                if(satelliteMap.getSatteliteByNorad(norad) == null) continue;
                satelliteMap.getSatteliteByNorad(norad).setChannelsNum(channelsNum);
                satelliteMap.getSatteliteByNorad(norad).setFreeToAirOnly(freeToAirOnly);
                satelliteMap.getSatteliteByNorad(norad).setDeclinationNow(declinationNow);
                satelliteMap.getSatteliteByNorad(norad).setDeclinationMax(declinationMax);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        scrapSatellite();
    }

}
