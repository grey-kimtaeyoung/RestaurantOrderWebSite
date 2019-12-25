package kr.co.restaurant.ordering.domain

import spock.lang.Specification

class RestaurantTests extends Specification {
    def "temporary test"() {
        given:
        List<Integer> list = new ArrayList<>()
        when:
        list.add(1)
        then:
        2 == list.get(0)
    }

    def "temporary second test"() {
        given:
        List<Integer> list = new ArrayList<>()
        when:
        list.add(1)
        then:
        1 == list.get(0)
    }
}
