package basic.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public void order(String name, int price){
        System.out.println("name = " + name +"price = "+price);
        this.price = price; // 여기서 문제 발생
    }

    /**문제 해결을 위해서는
     * private int price;  <- 공유 값 제거
     public void order(String name, int price){
     System.out.println("name = " + name +"price = "+price);
     return price;
    }
    */


    public int getPrice(){
        return price;
    }
}
