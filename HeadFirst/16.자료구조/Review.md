# 자료구조

    자바에서는 정렬도 한방에 컷

- 자바의 컬렉션

  - TreeSet : 정렬된 상태로 유지하고, 중복이 안되게 들어간다.
  - HashMap : 값,쌍으로 저장하고 접근가능하게 해줌
  - LinkedList : 중간에 원소를 추가 삭제하는 작업을 더빠르게 처리
  - HashSet : 중복된 원소가 없고, 어떤 원소를 빠르게 찾아줌
  - LinkedHashMap : hashMap 과 동일하지만 순서가 있음

- 주크박스에 컬렉션 sort 추가하기 -[예제코드](./Jukebox1.java);

## 하지만 이름이 아닌 Song 객체를 정렬하고싶은데 ?

- collections.sort(list) 는 에러가 발생 뭘 우선순위로 정렬할지 안정해줌
- sort 메서드를 파보자

```java
public static <T extends Comparable<? super T>>void sort(List<T> list){....}
```

- 제네릭 과 형 안전성
  - <타입을 지정해 준다면 ?> 안정성이 보장되어 객체의 형태가 유지가됨
- 제네릭 메소드 사용 법
  - public <T extends Animal> void takeThinkgs(ArrayList<T> list)
  - 이렇게 도 된다 ? 와우 소쿨

```java
public <T extends Animal> void takeThings(ArrayList<T> list)
public void takeThings(ArraysList<Animal> list)
// 이 2 코드는 명확 히 다르다.
```

## 다시 위에서 Song 객체 정렬시 에러가 발생했다.

- sort 의 메서드를 다시 살펴보면

```java
public static <T extends Comparable<? super T>>void sort(List<T> list)
```

- ? Comparable 은 인터페이스인데 ? 어떻게 확장이 가능하죠 ?
  - 제네릭에서의 extends 는 확장 또는 구현을 의미한다.
- 그러면 ? Song 클래스는 Comparable 을 구현하면 되는거군요 ?

```java
public interface Comparable<T>{
    int compareTo(T o);
}
public compareTo(T o) 리턴값 객체보다 작으면 음수, 크면 양의 정수를 리턴함
// in Song Class
public int compareTo(Song s){
    return title.compareTo(s.getTitle);
    // 주어지는 객체 song 과 현재의 객체의 song 타이틀을 비교
}
```

- 되긴했는데 이름 말고 다른걸로도 하고싶으면 코드가 기하급수적으로 늘어나는데요?
  - sort(List<T> list, Comparator<? super T>) 라는 게 있음

#### Comparator 사용법

    - sort(List o,Comparator c)  호출시 Comparator compareTo 호출

- [예제코드](./Jukebox5.java)

```java
//simple ex
// In Jukebox5 class {...
    class ArtistCompare implements Comparaotr<Song>{
        public int compareTo(Song one,Song two){
            return one.getArtist().compareTo(two.getArtist())
        }
    }
// ....
//}
```

### 정렬은 되는데 중복이 되는데요 ?

    - List 대신 Set 을 사용하자.

- 컬렉션 api 요약
- Collection(Interace)
- Set(Interface) List(Interface)
- SortedSet(Interface)
- TreeSet LinkedHashSet HashSet ArrayList LinkedList Vector

- Map(Interface)
- SortedMap(Interface)
- TreeMap HashMap LinkedHashMap HashTable

- Set 에서 중복을 확인하는방법 ?
  - hashCode() 와 equals 를 비교
- [예제코드](./Song.java)

```java
// simple ex
public boolean equals(Object aSong){
    Song s = (Song) aSong;
    return getTitle().equals(s.getTitle());
}
public int hashCode(){
    return title.hashCode();
}
```

### TreeSet 을 이용하려면 Comparable or Comparator 가 필요하다.

    - 객체에서 Comparable 을 구현해서 compareTo 를 오버라이드 하던가
    - TreeSet 을 선언할때 인자로 Comparator 를 보내준다.

## 와일드카드

```java
public void takeAnimals(ArrayList<? extends Animal> animals){...}

// 똑같은기능 을 하는 제네릭
public <T extends Animal> void takeThing(ArrayList<T> list)

public void takeThing(ArrayList<? extends Animal> list)
```
