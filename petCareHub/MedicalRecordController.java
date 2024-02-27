package petCareHub;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordController{
    //환자의 진료기록
    private List<MedicalRecord> records;
    public MedicalRecordController() {
        records = new ArrayList<>();
    }
    //진료기록을 추가하는 메서드
    public void addRecord(MedicalRecord newRecord){
        records.add(newRecord);
    }
    //진료기록을 삭제하는 메서드
    public void removeRecord(String phoneNumber){
        for(MedicalRecord record: records){
            if(record.getPhoneNumber().equals(records)){
                records.remove(record);
            }
        }
    }
    //진료기록을 찾는 메서드
    public List<MedicalRecord> findRecord(String phoneNumber){
        List<MedicalRecord> newRecord = new ArrayList<>();
        for(MedicalRecord record: records){
            if(record.getPhoneNumber().equals(phoneNumber)){
                newRecord.add(record);
            }
        }
        return newRecord;
    }
}