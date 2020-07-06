package com.spring.reactive.observable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Iter {
    /*
        에릭 마이어
        Iterable(pull) <---> Observable(push) (duality 상대성)

        pull 방식과 push 방식의 차이가 리액티브 프로그래밍의 시발점이다.
        옵저버패턴에 몇가지 문제를 해결하고, 용어들을 바꾼게 리액티브 프로그래밍이 되게된다.

        마이크로소프에서는 옵저버패턴에 문제를 지적.
        1. Complete?? 마지막 데이터를 알 수가 없음.
        2. Error? 옵저버에서 에러가 발생하면 옵저버블이 알수가 없다. (옵저버블에게 명시적으로 예외를 전달하는 API가 없음.)

     */

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (Iterator<Integer> iter = list.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next()); //pull
        }
    }
}
