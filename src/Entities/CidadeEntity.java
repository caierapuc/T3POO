package Entities;

public class CidadeEntity {
    private String município;
    private long ibge;
    private double latitude;
    private double longitude;
    private long total10;
    private long total11;
    private long total12;
    private long total13;
    private long total14;
    private long total15;
    private long total16;
    private long total17;
    private long total18;
    private long total19;
    private long total20;
    private long total21;

    public CidadeEntity(String município, long ibge, double latitude, double longitude, long total10, long total11,
            long total12, long total13, long total14, long total15, long total16, long total17, long total18,
            long total19, long total20, long total21) {
        this.município = município;
        this.ibge = ibge;
        this.latitude = latitude;
        this.longitude = longitude;
        this.total10 = total10;
        this.total11 = total11;
        this.total12 = total12;
        this.total13 = total13;
        this.total14 = total14;
        this.total15 = total15;
        this.total16 = total16;
        this.total17 = total17;
        this.total18 = total18;
        this.total19 = total19;
        this.total20 = total20;
        this.total21 = total21;
    }

    public String getMunicípio() {
        return município;
    }

    public long getIbge() {
        return ibge;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public long getTotal10() {
        return total10;
    }

    public long getTotal11() {
        return total11;
    }

    public long getTotal12() {
        return total12;
    }

    public long getTotal13() {
        return total13;
    }

    public long getTotal14() {
        return total14;
    }

    public long getTotal15() {
        return total15;
    }

    public long getTotal16() {
        return total16;
    }

    public long getTotal17() {
        return total17;
    }

    public long getTotal18() {
        return total18;
    }

    public long getTotal19() {
        return total19;
    }

    public long getTotal20() {
        return total20;
    }

    public long getTotal21() {
        return total21;
    }
}