

@Service
public class InvoiceImp implements InvoiceService {

    @Autowire
    private InvoiceRepository invoiceRepository;


    @Override
    public Long saveIvoice(Invoice inv){
        util.calculate(inv);
        Long Id = invoiceRepository.save(inv).getId();
        return id;
    }

    @Override
    public void deleteIvoice(Long Id){
        Invoice inv = getOneInvoice(Id);
      repo.delete(inv);
    }

    public Optional<Invoice> getSingleInvoice(Long Id){
        return invoiceRepository.findById(Id);
    }

    public Invoice getOneInvoice(Long id){
        Invoice inv = invoiceRepository.findById(id)
                .orElseThrow(()->new InvoiceNotfoundException(new StringBuilder().append("product")
                        .append(id).append("' not exist").toString())
                );
        return inv;
    }

    public List<Invoice> getAllInvoices(){
        List<Invoice> list = invoiceRepository.findAll();
        list.sort((obj1,obj2)->obj1.getId().intValue()-obj2.getId().intValue());

        return list;
    }

    @Transactional
    public Integer updateInvoiceNumberById(String number , Long Id){
     if(!invoiceRepository.existsById(id)) {
         throw new InvoiceNotFoundException(
                 new StringBuffer()
                         .append("Invoice '")
                         .append(Id)
                         .append(" 'not exist")
                         .toString());
     }
      return  invoiceRepository.updateInvoiceNumberById(number,Id);
     }

    }

}
