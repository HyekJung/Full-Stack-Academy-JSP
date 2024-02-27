package petCareHub;

public class MedicalRecord{
    private String phoneNumber;
    private String medicalDate;
    private String medicalContent;

    public MedicalRecord(String phoneNumber, String medicalDate, String medicalContent) {
        this.phoneNumber = phoneNumber;
        this.medicalDate = medicalDate;
        this.medicalContent = medicalContent;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMedicalDate() {
        return medicalDate;
    }

    public void setMedicalDate(String medicalDate) {
        this.medicalDate = medicalDate;
    }

    public String getMedicalContent() {
        return medicalContent;
    }

    public void setMedicalContent(String medicalContent) {
        this.medicalContent = medicalContent;
    }
}