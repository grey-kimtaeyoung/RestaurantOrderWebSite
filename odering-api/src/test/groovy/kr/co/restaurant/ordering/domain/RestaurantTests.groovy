package kr.co.restaurant.ordering.domain

import spock.lang.Specification

class RestaurantTests extends Specification {
    def "레스토랑 도메인 초기셋팅시 정상작동여부 확인"(){
        // 초기 변수 작업
        setup:
        def name = "Bob zip"
        def address = "Seoul"

        // 테스트할 대상 코드를 실행
        when:
        Restaurant restaurant = new Restaurant(name, address)

        // 테스트 결과 검증
        then:
        "Bob zip in Seoul" == restaurant.getInformation()
        "Bob zip" == restaurant.getName()
        "Seoul" == restaurant.getAddress()
    }
}
