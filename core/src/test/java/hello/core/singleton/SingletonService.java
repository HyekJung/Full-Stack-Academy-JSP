package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService(); //싱글톤 객체 생성

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){ //생성자(외부에서 객체 생성 못하게 막음)
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
