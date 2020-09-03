package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {

        //Given
        Invoice invoice = new Invoice("2020/09/02KP");

        Product domain = new Product("domain");
        Product server = new Product("server");
        Product printer = new Product("printer");

        Item itemDomain = new Item(domain, new BigDecimal(150), 1, new BigDecimal(150));
        Item itemServer = new Item(server, new BigDecimal(300), 1, new BigDecimal(300));
        Item itemPrinter = new Item(printer, new BigDecimal(400), 2, new BigDecimal(400));

        itemDomain.setInvoice(invoice);
        itemServer.setInvoice(invoice);
        itemPrinter.setInvoice(invoice);

        List<Item> items = new ArrayList<>();
        items.add(itemDomain);
        items.add(itemServer);
        items.add(itemPrinter);

        invoice.setItems(items);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        int itemSize = invoice.getItems().size();

        Invoice invoiceDataBase = invoiceDao.findById(invoiceId);

        //Than
        Assert.assertEquals(invoiceId, invoiceDataBase.getId());
        Assert.assertEquals(itemSize, invoiceDataBase.getItems().size());
        Assert.assertEquals(3, itemSize);

        //CleanUp
        //invoiceDao.deleteById(id);
    }
}
