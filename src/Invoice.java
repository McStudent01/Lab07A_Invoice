public class Invoice
{
    private Header header;
    private LineItemsTable lineItemsTable;
    private Footer footer;

    public Invoice(Header header, LineItemsTable lineItemsTable, Footer footer)
    {
        this.header = header;
        this.lineItemsTable = lineItemsTable;
        this.footer = footer;
    }

    public double calculateTotalAmount()
    {
        return lineItemsTable.calculateTotal();
    }
}