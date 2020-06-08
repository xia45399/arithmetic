package arithmetic.other.lru;

public class Test {
    public static void main(String[] args) {
        Lru<String,String> lru= new Lru<>(3);

        lru.put("1","1");
        lru.put("2","2");
        lru.put("3","3");
        lru.get("2");


        LruV2<String,String> lruV2= new LruV2<>(3);
        lruV2.put("1","1");
        lruV2.put("2","2");
        lruV2.put("3","3");
        lruV2.put("4","4");
        lruV2.put("5","5");
        System.out.println();
    }
}
