public class Header
{
    private Business business;
    private InvoiceTitle invoiceTitle;

    public Header(Business business, InvoiceTitle invoiceTitle)
    {
        this.business = business;
        this.invoiceTitle = invoiceTitle;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public InvoiceTitle getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(InvoiceTitle invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }
}
