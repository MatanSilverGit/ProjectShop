public class Store
{
    private String _storeName;
    private Product[] _products;
    private int[] _soldCount;
    private int _productCount;

    public Store(String storeName, int capacity)
    {
        if (storeName == null || storeName.trim().isEmpty())
        {
            _storeName = "Unnamed Store";
        }
        else
        {
            _storeName = storeName.trim();
        }

        _products = new Product[capacity];
        _soldCount = new int[capacity];
        _productCount = 0;
    }

    public String getStoreName()
    {
        return _storeName;
    }

    public int getProductCount()
    {
        return _productCount;
    }

    public boolean addProduct(Product product)
    {
        if (product == null || _productCount >= _products.length)
        {
            return false;
        }

        for (int i = 0; i < _productCount; i++)
        {
            if (_products[i].getId() == product.getId())
            {
                return false;
            }
        }

        _products[_productCount] = product;
        _soldCount[_productCount] = 0;
        _productCount++;
        return true;
    }

    public int findProductIndex(int id)
    {
        int foundIndex = -1;
        int i = 0;

        while (i < _productCount)
        {
            if (_products[i].getId() == id)
            {
                foundIndex = i;
                break;
            }

            i++;
        }

        return foundIndex;
    }

    public boolean sellProduct(int id, int quantity)
    {
        int index = findProductIndex(id);

        if (index == -1)
        {
            return false;
        }

        if (_products[index].sell(quantity))
        {
            _soldCount[index] += quantity;

            return true;
        }

        return false;
    }

    public void printAvailableProducts()
    {
        System.out.println("--- Available Products in " + _storeName + " ---");
        for (int i = 0; i < _productCount; i++)
        {
            if (_products[i].getStock() <= 0)
            {
                continue;
            }
            System.out.println(_products[i].getInfo());
        }
    }

    public void printSalesReport()
    {
        System.out.println("Sales report of: " + _storeName);

        for (int i = 0; i < _productCount; i++)
        {
            System.out.println(_products[i].getName() + " sold: " + _soldCount[i]);
        }
    }

    public int getTotalUnitsSold()
    {
        int total = 0;

        for (int i = 0; i < _productCount; i++)
        {
            total += _soldCount[i];
        }

        return total;
    }
}