public class Product
{
    private int _id;
    private String _name;
    private double _price;
    private int _stock;
    private static int nextId = 1000;

    public Product(String name, double price, int stock)
    {
        _id = nextId++;

        if (name == null || name.trim().isEmpty())
        {
            _name = "Unknown";
        }
        else
        {
            _name = name.trim();
        }

        if (price > 0)
        {
            _price = price;
        }
        else
        {
            _price = 1.0;
        }

        if (stock >= 0)
        {
            _stock = stock;
        }
        else
        {
            _stock = 0;
        }
    }

    public int getId()
    {
        return _id;
    }

    public String getName()
    {
        return _name;
    }

    public double getPrice()
    {
        return _price;
    }

    public int getStock()
    {
        return _stock;
    }

    public boolean setName(String name)
    {
        if (name != null && !name.trim().isEmpty())
        {
            _name = name.trim();
            return true;
        }
        return false;
    }

    public boolean setPrice(double price)
    {
        if (price > 0)
        {
            _price = price;

            return true;
        }

        return false;
    }

    public boolean setStock(int stock)
    {
        if (stock >= 0)
        {
            _stock = stock;

            return true;
        }

        return false;
    }

    public boolean sell(int quantity)
    {
        if (quantity > 0 && quantity <= _stock)
        {
            _stock -= quantity;

            return true;
        }

        return false;
    }

    public String getInfo()
    {
        return "ID: " + _id + " | Name: " + _name + " | Price: " + _price + " | Stock: " + _stock;
    }

    public static int getNextId()
    {
        return nextId;
    }
}