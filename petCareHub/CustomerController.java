package petCareHub;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    // 회원
    private List<Customer> customers;
    // 진료기록
    private MedicalRecordController recordController;

    public CustomerController(MedicalRecordController recordController) {
        this.customers = new ArrayList<Customer>();
        this.recordController = recordController;
    }
    // 신규 고객 등록
    public void addCustomer(Customer newCustomer){
        customers.add(newCustomer);
    }
    // 고객 중복 확인
    public boolean isDuplicate(String phoneNumber){
        for(Customer customer : customers){
            if(customer.getPhoneNumber().equals(phoneNumber)){
                return true;
            }
        }
        return false;
    }
    //해당 고객 찾기
    public List<Customer> findCustomer(String phoneNumber){
        List<Customer> customerResult = new ArrayList<Customer>();
        for(Customer result: customers){
            if(result.getPhoneNumber().equals(phoneNumber)){
                customerResult.add(result);
                return customerResult;
            }
        }
        return null;
    }


}