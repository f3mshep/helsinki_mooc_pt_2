public class Purchase {

    private String product;
    private int amount, unitPrice;

    public Purchase(String product, int amount, int unitPrice) {
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    public void increaseAmount(){
        this.amount++;
    }

    public int price(){
        return this.unitPrice * this.amount;
    }

    @Override
    public String toString() {
        return this.product + ": " + this.amount;
    }
}
