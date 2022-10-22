package model;

public class Apartment{

    private String id;
    private int qRooms;
    private int qBathrooms;
    private boolean hasBalcony;
    private double monthlyCost;
    private String tenantId;
    private String ownerId;

    public Apartment(String id, int qRooms, int qBathrooms, boolean hasBalcony, double monthlyCost) {
        this.id = id;
        this.qRooms = qRooms;
        this.qBathrooms = qBathrooms;
        this.hasBalcony = hasBalcony;
        this.monthlyCost = monthlyCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getqRooms() {
        return qRooms;
    }

    public void setqRooms(int qRooms) {
        this.qRooms = qRooms;
    }

    public int getqBathrooms() {
        return qBathrooms;
    }

    public void setqBathrooms(int qBathrooms) {
        this.qBathrooms = qBathrooms;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    } 

    

}