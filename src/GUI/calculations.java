package GUI;

public class calculations extends setInventory {
    GUI g;
    int qty;


    public calculations(int qty,int itemValue) {

        super.setInventory(itemValue);
        this.qty = qty;
        this.g=g;

    }
    public int math() {
        int sum = qty * getItemValue();
        return sum;
    }

    public double itemGross(){
        double withoutTaxes = math()-(math()*.12);
        return withoutTaxes;
    }
    
    public double getVAT(){
        double vat = math()*.12;
        return vat;
    }
}
