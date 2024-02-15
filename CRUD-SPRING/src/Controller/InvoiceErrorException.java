

@RestControllerAdvice
public class InvoiceErrorHandler  {

    @ExceptionHandler(InvoiceNotFoundException.class)
public ResponseEntity<InvoiceNotFoundException> handleNotFound(InvoiceNotFoundException exception){

    return new ResponseEntity<InvoiceNotFoundException> (
            new InvoiceNotFoundException(
                    new Data(System.currentTimeMillis()).toString(),
                    "404- Not Found",
                    exception.getMessage()),
            HttpstStatus </yoastmark>NOT_FOUND);
}
}
