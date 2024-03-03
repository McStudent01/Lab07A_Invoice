import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoiceGUI extends JFrame
{
    private JTextField businessNameField;
    private JTextField addressField;
    private JTextField itemNameField;
    private JTextField quantityField;
    private JTextField priceField;
    private JTextArea displayArea;

    public InvoiceGUI()
    {
        setTitle("Invoice Entry");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents()
    {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel businessLabel = new JLabel("Business Name:");
        businessNameField = new JTextField();

        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField();

        JLabel itemLabel = new JLabel("Item:");
        itemNameField = new JTextField();

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField();

        JLabel priceLabel = new JLabel("Price:");
        priceField = new JTextField();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                displayInvoice();
            }
        });

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        mainPanel.add(businessLabel);
        mainPanel.add(businessNameField);
        mainPanel.add(addressLabel);
        mainPanel.add(addressField);
        mainPanel.add(itemLabel);
        mainPanel.add(itemNameField);
        mainPanel.add(quantityLabel);
        mainPanel.add(quantityField);
        mainPanel.add(priceLabel);
        mainPanel.add(priceField);
        mainPanel.add(submitButton);
        mainPanel.add(new JScrollPane(displayArea));

        add(mainPanel);
    }

    private void displayInvoice()
    {
        String businessName = businessNameField.getText();
        String address = addressField.getText();
        String itemName = itemNameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        double price = Double.parseDouble(priceField.getText());

        Business business = new Business(businessName, address);
        InvoiceTitle invoiceTitle = new InvoiceTitle("Your Invoice Title");
        LineItem lineItem = new LineItem(itemName, quantity, price);
        LineItemsTable lineItemsTable = new LineItemsTable();
        lineItemsTable.addLineItem(lineItem);
        Footer footer = new Footer(new AmountDue(lineItemsTable.calculateTotal()));

        Invoice invoice = new Invoice(new Header(business, invoiceTitle), lineItemsTable, footer);

        displayArea.setText("Business Name: " + business.getName() +
                "\nAddress: " + business.getAddress() +
                "\nItem: " + lineItem.getDescription() +
                "\nQuantity: " + lineItem.getQuantity() +
                "\nPrice: $" + lineItem.getPrice() +
                "\nTotal: $" + invoice.calculateTotalAmount());
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new InvoiceGUI();
            }
        });
    }
}
