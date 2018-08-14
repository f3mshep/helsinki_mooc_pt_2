import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingBasket {

    private Map<String, Purchase> items = new HashMap<String, Purchase>();

    public void add(String product, int price){
        if (items.containsKey(product)){
            Purchase purchase = items.get(product);
            purchase.increaseAmount();
        } else {
            Purchase purchase = new Purchase(product, 1, price);
            items.put(product, purchase);
        }
    }

    public int price(){
        int total = 0;
        for (String product : items.keySet()){
            Purchase item = items.get(product);
            total += item.price();
        }
        return total;
    }

    public void print(){
        for (String product : items.keySet()){
            System.out.println(items.get(product));
        }
    }

}
