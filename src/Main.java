public class Main
{
    public static void main(String[] args)
    {
        Store store = new Store("Silver", 3);

        Product notebook = new Product("Notebook", 12.5, 3);
        Product pen = new Product("Pen", 4.0, 2);
        Product bottle = new Product("Bottle", 30.0, 0);

        boolean addedNotebook = store.addProduct(notebook);
        boolean addedPen = store.addProduct(pen);
        boolean addedBottle = store.addProduct(bottle);

        System.out.println("Notebook check: " + addedNotebook);
        System.out.println("Pen check: " + addedPen);
        System.out.println("Bottle check: " + addedBottle);

        Product ruler = new Product("Ruler", 5.0, 10);
        boolean addedRuler = store.addProduct(ruler);
        System.out.println("Add Ruler check: " + addedRuler);

        System.out.println();

        boolean soldNotebook = store.sellProduct(notebook.getId(), 2);
        System.out.println("Sell 2 Notebooks check: " + soldNotebook);

        boolean soldPenFail = store.sellProduct(pen.getId(), 3);
        System.out.println("Sell 3 Pens check: " + soldPenFail);

        boolean soldPenSuccess = store.sellProduct(pen.getId(), 2);
        System.out.println("Sell 2 Pens check: " + soldPenSuccess);

        System.out.println();

        double priceBefore = notebook.getPrice();
        boolean priceChanged = notebook.setPrice(-5);
        System.out.println(priceChanged);
        System.out.println("Notebook price before: " + priceBefore + ", price after: " + notebook.getPrice());

        System.out.println();

        store.printAvailableProducts();

        System.out.println();

        store.printSalesReport();
        System.out.println("Total units sold: " + store.getTotalUnitsSold());

        System.out.println();

        System.out.println("Product IDs:");
        System.out.println("Notebook ID: " + notebook.getId());
        System.out.println("Pen ID: " + pen.getId());
        System.out.println("Bottle ID: " + bottle.getId());
        System.out.println("Ruler ID: " + ruler.getId());
        System.out.println("NextID: " + Product.getNextId());
    }
}