


public class InvoiceRepository extends JpaRepository<Invoice, Long> {


    @Modifying
    @Query(UPDATE Invoice SET number=:number WHERE id=:id)
    Integer updateInvoiceNumberById(String Number, Long Id);

}
