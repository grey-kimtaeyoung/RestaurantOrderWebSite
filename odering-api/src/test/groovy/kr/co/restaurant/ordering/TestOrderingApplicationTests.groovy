package kr.co.restaurant.ordering;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification;

@SpringBootTest
class TestOrderingApplicationTests extends Specification{

    def "Spock 테스트 입니다"(){
        // given: 테스트 하기 위한 기본 설정작업
        given:
        List<Integer> list = new ArrayList<>()

        // 테스트할 대상 코드를 실행
        when:
        list.add(2)

        // 테스트 결과 검증
        then:
        2==list.get(0)
    }
}
