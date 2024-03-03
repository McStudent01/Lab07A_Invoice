import java.util.ArrayList;
import java.util.List;

public class LineItemsTable
{
    private List<LineItem> lineItems;

    public LineItemsTable()
    {
        this.lineItems = new ArrayList<>();
    }

    public void addLineItem(LineItem lineItem)
    {
        lineItems.add(lineItem);
    }

    public double calculateTotal()
    {
        double total = 0;
        for (LineItem item : lineItems)
        {
            total += item.calculateTotal();
        }
        return total;
    }
}