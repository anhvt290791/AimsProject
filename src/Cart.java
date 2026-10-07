public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
            return;
        }

        this.itemsOrdered[this.qtyOrdered] = dvd;
        this.qtyOrdered++;
        System.out.println("Added DVD sucessfully!");
        return;

    }

    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        int index = -1;
        for (int i = 0; i < this.qtyOrdered; i++) 
            if (this.itemsOrdered[i].equals(dvd)) {
                index = i;
            }

        if (index == -1) {
            System.out.println("No disc found!");
            return;
        }

        for (int i = index; i < this.qtyOrdered - 1; i++) {
            this.itemsOrdered[i] = this.itemsOrdered[i + 1];
        }

        this.qtyOrdered--;
        this.itemsOrdered[this.qtyOrdered] = null;
        
        System.out.println("Remove DVD sucessfully!");
        return;
    }
    
    // Get total cost
    public float totalCost(){
        float total = 0;
        for (int i = 0; i < this.qtyOrdered; i++){
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}