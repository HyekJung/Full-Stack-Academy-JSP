package petCareHub;

import java.util.List;
import java.util.Scanner;

public class ConsoleView{
    MedicalRecordController recordController = new MedicalRecordController();
    CustomerController customerController = new CustomerController(recordController);

    private Scanner scanner = new Scanner(System.in);

    // 1. 신규 고객 정보 입력
    public Customer newCustomerInfo(){
        System.out.println("신규 정보를 입력하세요.");
        System.out.print("전화번호: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("소유주 이름: ");
        String ownerName = scanner.nextLine();
        System.out.print("동물 이름: ");
        String petName = scanner.nextLine();
        System.out.print("주소: ");
        String address = scanner.nextLine();
        System.out.print("종류: ");
        String petKind = scanner.nextLine();
        System.out.print("출생년도: ");
        String birth = scanner.nextLine();
        return new Customer(phoneNumber, ownerName, petName, address, petKind, birth);
    }
    // 2. 진료 기록 저장
    public MedicalRecord recordSave(){
        System.out.println("원하는 기능을 선택하세요.");
        System.out.print("전화번호를 입력하세요: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("진료일을 입력하세요: ");
        String birth = scanner.nextLine();
        System.out.print("진료내용을 입력하세요: ");
        String content = scanner.nextLine();
        return new MedicalRecord(phoneNumber, birth, content);
    }
    // 3.4. 진료 기록 조회
    public String inputPhoneNumber(){
        System.out.print("전화번호를 입력하세요: ");
        String phoneNumber = scanner.nextLine();
        return phoneNumber;
    }
    // 3. 진료기록 출력
    public void recoardPrint(Customer customer, MedicalRecord record){
        System.out.println("["+customer.getPetName()+"]의 진료기록");
        System.out.println("진료일: "+record.getMedicalDate());
        System.out.println("진료내용: "+record.getMedicalContent());
        System.out.println("소유주 이름: "+customer.getOwnerName());
        System.out.println("동물 이름: "+customer.getPetName());
        System.out.println("주소: "+customer.getAddress());
        System.out.println("종류: "+customer.getPetKind());
        System.out.println("출생년도: "+customer.getBirth());
    }

    // 기능별 메세지 출력
    public void printMessage(String message){
        System.out.println(message);
    }
}

