package petCareHub;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class PetMain{
    public static void main(String[] args) {
        MedicalRecordController recordController = new MedicalRecordController();
        CustomerController customerController = new CustomerController(recordController);
        ConsoleView consoleView = new ConsoleView();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("===애완동물진료관리시스템===");
            System.out.println("1. 신규 고객 정보 입력");
            System.out.println("2. 진료 기록 저장");
            System.out.println("3. 진료 기록 조회");
            System.out.println("4. 진료 기록 삭제");
            System.out.println("5. 종료");
            System.out.print("원하는 기능을 선택하세요:");
            int number = scanner.nextInt();
            //원하는 기능 선택
            switch (number){
                case 1:
                    Customer newCustomer = consoleView.newCustomerInfo();
                    String phoneNumber = newCustomer.getPhoneNumber();
                    if(customerController.isDuplicate(phoneNumber)){
                        consoleView.printMessage("이미 등록된 전화번호입니다.");
                    }else{
                        customerController.addCustomer(newCustomer);
                        consoleView.printMessage("고객 정보가 추가되었습니다.");
                    }
                    continue;
                case 2:
                    recordController.addRecord(consoleView.recordSave());
                    consoleView.printMessage("진료기록이 저장되었습니다.");
                    break;
                case 3:
                    phoneNumber = consoleView.inputPhoneNumber();
                    List<MedicalRecord> record = recordController.findRecord(phoneNumber);
                    List<Customer> customer = customerController.findCustomer(phoneNumber);

                    if(record == null){
                        consoleView.printMessage("해당 전화번호를 가진 진료 기록이 없습니다.");
                    }
                        consoleView.recoardPrint((Customer) customer, (MedicalRecord) record);
                case 4:
                    consoleView.printMessage("진료기록 정보가 삭제되었습니다.");
                    break;
                case 5:
                    consoleView.printMessage("프로그램을 종료합니다.");
                default:
                    consoleView.printMessage("잘못입력하였습니다.");
            }
        }
    }
}