package com.dev.invoice.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.invoice.rest.entity.Invoice;
import com.dev.invoice.rest.exception.InvoiceNotFoundException;
import com.dev.invoice.rest.service.IInvoiceService;
import com.dev.invoice.rest.util.InvoiceUtil;

@RestController
@RequestMapping("/api")

@RestController
@RequestMapping("online")
// @CrossOrigin(origins = "http://localhost:4200") //Required in case of Angular Client
public class InvoiceRestController {

    @Autowired
    private InvoiceService service;

    @Autowired
    private InvoiceUtil util;

    /**
     * Takes Invoice Object as input and returns save Status as ResponseEntity<String>
     */
    public ResponseEntity<?>saveInvoice(@pathparam )

    @PostMapping("/invoices")
    public ResponseEntity<String> saveInvoice(@RequestBody Invoice inv){
        ResponseEntity<String> resp = null;
        try{
            Long id = service.saveInvoice(inv);
            resp= new ResponseEntity<String>(
                    "Invoice '"+id+"' created",HttpStatus.CREATED); //201-created
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseEntity<String>(
                    "Unable to save Invoice",
                    HttpStatus.INTERNAL_SERVER_ERROR); //500-Internal Server Error
        }
        return resp;
    }

    /**
     * To retrieve all Invoices, returns data retrieval Status as ResponseEntity<?>
     */
    @GetMapping("/invoices")
    public ResponseEntity<?> getAllInvoices() {
        ResponseEntity<?> resp=null;
        try {
            List<Invoice> list= service.getAllInvoices();
            resp= new ResponseEntity<List<Invoice>>(list,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseEntity<String>(
                    "Unable to get Invoice",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resp;
    }
    @GetMappping("/invoices")
    public ResponseEntity<?> getAllInvoices(){
        ResponseEntity<?> responseEntity = null;
        try {
            List<Invoices> list = service.getAllInvoices();
            responseEntity = new ResponseEntity<>(list,HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace;
            responseEntity = new ResponseEntity<>("UNABLE TO GET INVOICES" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * To retrieve one Invoice by providing id, returns Invoice object & Status as ResponseEntity<?>
     */
    @GetMapping("/invoices/{id}")
    public ResponseEntity<?> getOneInvoice(@PathVariable Long id){
        ResponseEntity<?> resp= null;
        try {
            Invoice inv= service.getOneInvoice(id);
            resp= new ResponseEntity<Invoice>(inv,HttpStatus.OK);
        }catch (InvoiceNotFoundException nfe) {
            throw nfe;
        }catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseEntity<String>(
                    "Unable to find Invoice",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resp;
    }

    /**
     * To delete one Invoice by providing id, returns Status as ResponseEntity<String>
     */
    @DeleteMapping("/invoices/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Long id){

        ResponseEntity<String> resp= null;
        try {
            service.deleteInvoice(id);
            resp= new ResponseEntity<String> (
                    "Invoice '"+id+"' deleted",HttpStatus.OK);

        } catch (InvoiceNotFoundException nfe) {
            throw nfe;
        } catch (Exception e) {
            e.printStackTrace();
            resp= new ResponseEntity<String>(
                    "Unable to delete Invoice", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }

    /**
     * To modify one Invoice by providing id, updates Invoice object & returns Status as ResponseEntity<String>
     */
    /*@PutMapping("/invoices/{id}")
    public ResponseEntity<String> updateInvoice(@PathVariable Long id, @RequestBody Invoices invoices){
        ResponseEntity<?> res = null;
        try {
            Invoice inv = service.getOneInvoice(id);
            util.copyNonNullValues(invoices,inv);
            service.updateInvoice(inv);
            res = new ResponseEntity<>(HttpStatus.RESET_CONTENT);
        }catch (InvoiceNotFoundException ex){
            throw ex;
        } catch (Exception e) {
            e.printStackTrack();
            res =new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
      return res;
    }*/

    @PutMapping("/invoices/{id}")
    public ResponseEntity<String> updateInvoices(@PathVariable Long id, @requestBody Invoices invoices){
        ResponseEntity<String> responseEntity = null;
        try {
            Invoices inv = service.getOneInvoice(id);
            util.copyNonNullValues(invoices,inv);
            service.updateInvoice(inv);
            responseEntity =new ResponseEntity<>("Update Invoices", HttpStatus.RESET_CONTENT);
        }catch (InvoiceNotFoundException ex){
            throw ex;
        }catch (Exception e){
            e.printStackTrace;
            responseEntity = new ResponseEntity<>("Can't Update Invoices", 500, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    /**
     * To update one Invoice just like where clause condition, updates Invoice object & returns Status as ResponseEntity<String>
     */
    @PatchMapping("/invoices/{id}/{number}")
    public ResponseEntity<String> updateInvoiceNumberById(@PathVariable (@value ="Id") Long Id , @PathVariable String Number){
        ResponseEntity<String> responseEntity = null;
        try {
            service.updateInvoiceNumberById(number,Id);
            responseEntity = new ResponseEntity<String>("Invoice '"+number+"' Updated",HttpStatus.PARTIAL_CONTENT);
        } catch (InvoiceNotFound ex) {
            throw ex;
        }catch (Exception e) {
           e.printStackTrace;
           responseEntity = new ResponseEntity<String>("Unable to update Invoice",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

   /* @PatchMapping("/invoices/{id}/{number}")
    public ResponseEntity<String> updateInvoiceNumberById(
            @PathVariable Long id,
            @PathVariable String number
    )
    {
        ResponseEntity<String> resp = null;
        try {
            service.updateInvoiceNumberById(number, id);
            resp = new ResponseEntity<String>(
                    "Invoice '"+number+"' Updated",
                    HttpStatus.PARTIAL_CONTENT); //206- Reset-Content(PUT)
        } catch(InvoiceNotFoundException pne) {
            throw pne; // re-throw exception to handler
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseEntity<String>(
                    "Unable to Update Invoice",
                    HttpStatus.INTERNAL_SERVER_ERROR); //500-ISE
        }
        return resp;
    }*/
}