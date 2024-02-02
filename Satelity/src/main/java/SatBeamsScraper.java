import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class SatBeamsScraper {

    private static final String satBeamsURL = "https://www.satbeams.com/satellites";

    private static SatelliteMap satelliteMap = SatelliteMap.getInstance();

    public static void scrapSatellites(){

        try{
            Document doc = Jsoup.connect(satBeamsURL).get();
            Element table = doc.getElementById("sat_grid");

            Elements satTr = table.select("tr.class_tr");
            satTr.remove(0);
            for(Element currSatTr : satTr){
                Elements td = currSatTr.select("td");
                if(!td.get(2).text().equals("active")) continue;

                String satUrl = td.get(3).select("a").attr("href");

                String channelUrl = td.get(12).select("a").attr("href");

                ExecutorService executor = Executors.newFixedThreadPool(2);

                Callable<List<Channel>> task1 = () -> scrapChannelPage(channelUrl);
                Callable<Satellite> task2 = () -> scrapSatPage(satUrl);

                Future<List<Channel>> future1 = executor.submit(task1);
                Future<Satellite> future2 = executor.submit(task2);

                List<Channel> channelList = future1.get();
                Satellite sat = future2.get();
                executor.shutdown();

                if(sat == null) continue;
                sat.addChannelList(channelList);
                satelliteMap.addSatellite(sat);

            }


        }
        catch (IOException e){
            e.printStackTrace();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    private static Satellite scrapSatPage(String url){
        List<String> data = new ArrayList<>();
        try {
            Document satDoc = Jsoup.connect(satBeamsURL+url).get();
            Element table = satDoc.selectFirst("table.sat_grid1");
            Elements trs = table.select("tr");
            Element td = trs.get(1).selectFirst("td");

            String name = td.select("b:contains(Satellite Name:)").first().nextSibling().toString().trim();
            String status = td.select("b:contains(Status:)").first().nextSibling().toString().trim();
            String pos = td.select("b:contains(Position:)").first().nextSibling().toString().trim();

            Elements a = td.select("a");
            String norad = a.get(0).text().trim();
            String cosparNum = a.get(1).text();
            String operator = a.get(2).text();

            String launchDate = td.select("b:contains(Launch Date:)").first().nextSibling().toString().trim();

            String launchSite = a.get(3).text();
            String launchVehicle = a.get(4).text();

            String launchMass = td.select("b:contains(Launch mass (kg):)").first().nextSibling().toString().trim();
            String dryMass = td.select("b:contains(Dry mass (kg):)").first().nextSibling().toString().trim();
            if(!dryMass.matches("-?\\d+(\\.\\d+)?")){
                dryMass = "N/A";
            }

            String manufacturer = a.get(5).text();
            String modelBus;
            if(a.size() < 7){
                modelBus = td.select("b:contains(Model (bus):)").first().nextSibling().toString().trim();
            }
            else {
                modelBus = a.get(6).text();
            }

            String orbit = td.select("b:contains(Orbit:)").first().nextSibling().toString().trim();
            String expectedLifetime = td.select("b:contains(Expected lifetime:)").first().nextSibling().toString().trim();

            return new Satellite(name, status, pos, norad, cosparNum, operator, launchDate, launchSite, launchVehicle,
                                 launchMass, dryMass, manufacturer, modelBus, orbit, expectedLifetime);

        }
        catch (HttpStatusException e) {
            System.err.println("Błąd podczas łączenia z URL: " + e.getUrl());
            System.err.println("Kod statusu HTTP: " + e.getStatusCode());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<Channel> scrapChannelPage(String url){
        List<Channel> channelList = new ArrayList<>();
        try {
            Document channelDoc = Jsoup.connect("https://www.satbeams.com"+url).get();
            Element table = channelDoc.selectFirst("#channel_grid");
            Elements trs = table.select("tr");

            for(Element tr : trs){
                if (tr.hasClass("group_tr") || tr.hasClass("head_tr")) {
                    continue;
                }
                Elements td = tr.select("td");
                if(td.hasClass("not_found")){
                    continue;
                }
                String channel = td.get(2).select("span").text().trim();
                String type = td.get(3).text().trim();
                String encryption = td.get(4).text().trim();
                String packag = td.get(5).text().trim();
                String res = td.get(6).text().trim();
                String compression = td.get(7).text().trim();
                String vpid = td.get(8).text().trim();
                String apid = td.get(9).text().trim();
                String spid = td.get(10).text().trim();
                String owner = td.get(11).text().trim();
                String date = td.get(12).text().trim();

                channelList.add(new Channel(channel, type, encryption, packag, res, compression, vpid, apid, spid, owner, date));

                return channelList;
            }
        }
        catch (HttpStatusException e) {
        System.err.println("Błąd podczas łączenia z URL: " + e.getUrl());
        System.err.println("Kod statusu HTTP: " + e.getStatusCode());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return channelList;
    }

    public static void main(String[] args) {
        scrapSatellites();
    }
}
