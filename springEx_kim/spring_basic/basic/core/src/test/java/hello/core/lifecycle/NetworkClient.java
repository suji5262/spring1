package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//public class NetworkClient implements InitializingBean, DisposableBean {
// InitializingBean(초기화 빈), DisposableBean()
public class NetworkClient {

    private String url;

    public NetworkClient() { // 디폴트 생성자
        System.out.println("생성자 호출, url = " + url);
//        connect();
//        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스를 시작 시 호출
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close = " + url);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception { // 초기화
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메세지");
//    } // 의존 관계 주입이 끝나면 호출해주겠다

//    @Override
//    public void destroy() throws Exception { // 소멸 지원
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }


    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
