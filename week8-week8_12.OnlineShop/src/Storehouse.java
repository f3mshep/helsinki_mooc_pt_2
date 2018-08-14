import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Storehouse {

    private Map<String, Integer> stocks = new HashMap<String, Integer>();
    private Map<String, Integer> prices = new HashMap<String, Integer>();



    public Set<String> products(){
        Set<String> products = new HashSet<String>();
        for(String s : this.prices.keySet()){
            products.add(s);
        }
        return products;
    }


    public void addProduct(String product, int price, int stock){
        stocks.put(product, stock);
        prices.put(product, price);
    }

    public int price(String product){
        if (prices.get(product) == null){
            return -99;
        } else {
            return prices.get(product);
        }
    }

    public int stock(String product){
        Integer stock = stocks.get(product);
        if (stock == null) return 0;
        return stock;
    }

    public boolean take(String product){
        Integer stock = stocks.get(product);
        if (stock == null || stock == 0) return false;
        stocks.put(product, --stock);
        return true;
    }

}
