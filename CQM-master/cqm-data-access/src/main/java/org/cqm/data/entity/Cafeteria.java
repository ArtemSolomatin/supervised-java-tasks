package org.cqm.data.entity;


import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "Cafeterias")
@NamedQuery(name = "Cafeterias.getAll", query = "select c from Cafeteria c")
public class Cafeteria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "cqm_id_sequence")
    @Column(name = "cafe_id")
    private Integer cafeId;

    @Column(name = "name")
    private String cafeName;

    @Column(name = "address")
    private String cafeAddress;

    @Column(name = "work_hours")
    private String workHours;

    @Column(name = "photo")
    private byte[] photoByte;

    private byte[] encodeBase64 = new byte[0];

    private String base64DataString = "";

    public String getBase64DataString() {
        return base64DataString;
    }

    public void setBase64DataString(String base64DString) {
        this.base64DataString = base64DString;
    }

    public byte[] getEncodeBase64() {
        return encodeBase64;
    }

    public void setEncodeBase64(byte[] encodeBase64) {
        this.encodeBase64 = encodeBase64;
    }

    public Cafeteria(Integer cafeId, String cafeName, String cafeAddress, String workHours, byte[] photoByte) {
        this.cafeId = cafeId;
        this.cafeName = cafeName;
        this.cafeAddress = cafeAddress;
        this.workHours = workHours;
        this.photoByte = photoByte;
    }

    public Cafeteria() {

    }

    public Integer getCafeId() {
        return cafeId;
    }

    public void setCafeId(Integer cafeId) {
        this.cafeId = cafeId;
    }

    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    public String getCafeAddress() {
        return cafeAddress;
    }

    public void setCafeAddress(String cafeAddress) {
        this.cafeAddress = cafeAddress;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public byte[] getPhotoByte() {
        return photoByte;
    }

    public void setPhotoByte(byte[] photo) {
        this.photoByte = photo;
    }

    @Override
    public String toString() {
        return "Cafeteria{" +
                "cafeId=" + cafeId +
                ", cafeName='" + cafeName + '\'' +
                ", cafeAddress='" + cafeAddress + '\'' +
                ", workHours='" + workHours + '\'' +
                ", photoByte=" + Arrays.toString(photoByte) +
                ", encodeBase64=" + Arrays.toString(encodeBase64) +
                ", base64DataString='" + base64DataString + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cafeteria cafeteria = (Cafeteria) o;

        if (cafeId != null ? !cafeId.equals(cafeteria.cafeId) : cafeteria.cafeId != null) return false;
        if (cafeName != null ? !cafeName.equals(cafeteria.cafeName) : cafeteria.cafeName != null) return false;
        if (cafeAddress != null ? !cafeAddress.equals(cafeteria.cafeAddress) : cafeteria.cafeAddress != null)
            return false;
        if (workHours != null ? !workHours.equals(cafeteria.workHours) : cafeteria.workHours != null) return false;
        if (!Arrays.equals(photoByte, cafeteria.photoByte)) return false;
        if (!Arrays.equals(encodeBase64, cafeteria.encodeBase64)) return false;
        return base64DataString != null ? base64DataString.equals(cafeteria.base64DataString) : cafeteria.base64DataString == null;

    }

    @Override
    public int hashCode() {
        int result = cafeId != null ? cafeId.hashCode() : 0;
        result = 31 * result + (cafeName != null ? cafeName.hashCode() : 0);
        result = 31 * result + (cafeAddress != null ? cafeAddress.hashCode() : 0);
        result = 31 * result + (workHours != null ? workHours.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photoByte);
        result = 31 * result + Arrays.hashCode(encodeBase64);
        result = 31 * result + (base64DataString != null ? base64DataString.hashCode() : 0);
        return result;
    }
}
