

public interface InvoiceService {

    Long saveInvoice(Invoice SI);

    void updateInvoice(Invoice e);

    void deleteInvoice(Long id);

    Invoice getOneInvoice(Long Id);

    List<Invoice> getAllInvoices();

    boolean isInvoiceExist(Long id);

    Integer updateInvoiceNumberById(String Number , Long Id);
}
