import java.util.List;

public class Satellite {
    //SatBeams
    private String name;
    private String status;
    private String position;
    private int norad;
    private String cosparNum;
    private String operator;
    private String launchDate;
    private String launchSite;
    private String launchVehicle;
    private String launchMass;
    private String dryMass;
    private String manufacturer;
    private String modelBus;
    private String orbit;
    private String expectedLifetime;
    private List<Channel> channelList;

    //KingOfSat

    private int channelsNum = -1;
    private int freeToAirOnly = -1;
    private String declinationNow = "N/A";
    private String declinationMax = "N/A";

    //FlySat

    private String updateDate = "N/A";
    private String band = "N/A";

    public Satellite(String name, String status, String position, String norad, String cosparNum,
                     String operator, String launchDate, String launchSite, String launchVehicle,
                     String launchMass, String dryMass, String manufacturer, String modelBus,
                     String orbit, String expectedLifetime) {
        this.name = name;
        this.status = status;
        this.position = position;
        this.norad = Integer.parseInt(norad);
        this.cosparNum = cosparNum;
        this.operator = operator;
        this.launchDate = launchDate;
        this.launchSite = launchSite;
        this.launchVehicle = launchVehicle;
        this.launchMass = launchMass;
        this.dryMass = dryMass;
        this.manufacturer = manufacturer;
        this.modelBus = modelBus;
        this.orbit = orbit;
        this.expectedLifetime = expectedLifetime;
    }

    public void setChannelsNum(int channelsNum) {
        this.channelsNum = channelsNum;
    }

    public void addChannelList(List<Channel> list){
        this.channelList = list;
    }
    public void setFreeToAirOnly(int freeToAirOnly) {
        this.freeToAirOnly = freeToAirOnly;
    }

    public void setDeclinationNow(String declinationNow) {
        this.declinationNow = declinationNow;
    }

    public void setDeclinationMax(String declinationMax) {
        this.declinationMax = declinationMax;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getPosition() {
        return position;
    }

    public int getNorad() {
        return norad;
    }

    public String getCosparNum() {
        return cosparNum;
    }

    public String getOperator() {
        return operator;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public String getLaunchSite() {
        return launchSite;
    }

    public String getLaunchVehicle() {
        return launchVehicle;
    }

    public String getLaunchMass() {
        return launchMass;
    }

    public String getDryMass() {
        return dryMass;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelBus() {
        return modelBus;
    }

    public String getOrbit() {
        return orbit;
    }

    public String getExpectedLifetime() {
        return expectedLifetime;
    }

    public List<Channel> getChannelList() {
        return channelList;
    }

    public int getChannelsNum() {
        return channelsNum;
    }

    public int getFreeToAirOnly() {
        return freeToAirOnly;
    }

    public String getDeclinationNow() {
        return declinationNow;
    }

    public String getDeclinationMax() {
        return declinationMax;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public String getBand() {
        return band;
    }
}

