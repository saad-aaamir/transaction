package org.rak.transaction.unit.transaction;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.rak.transaction.TransactionApplication;
import org.rak.transaction.exception.ApplicationException;
import org.rak.transaction.interfaces.BusinessService;
import org.rak.transaction.interfaces.Mapper;
import org.rak.transaction.interfaces.RequestValidator;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService implements BusinessService<TransactionDto> {

    private final RequestValidator<TransactionDto> validator;
    private final Mapper<TransactionDto, Transaction> mapper;
    private final TransactionRepository repository;


    public TransactionService(RequestValidator<TransactionDto> validator, Mapper<TransactionDto, Transaction> mapper, TransactionRepository repository) {
        this.validator = validator;
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public TransactionDto getByUuid(String uuid) {
        return null;
    }

    @Override
    public TransactionDto create(TransactionDto dto) {
        return Optional.ofNullable(dto)
                .filter(validator::validateRequest)
                .map(mapper::toEntity)
                .map(repository::save)
                .map(mapper::toDto)
                .orElseThrow(() -> new ApplicationException("100-001", "Unable to create"));
    }

    @Override
    public TransactionDto update(TransactionDto dto, String id) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }

    public List<TransactionDto> getAllByStudentId(String studentId) {
        return repository.findAllByStudentId(studentId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public String testJasper() {
        PaymentReceiptJasperDTO paymentReceiptJasperDTO = PaymentReceiptJasperDTO.builder()
                .studentName("hamza")
                .studentGrade("10")
                .guardianName("shahrukh")
                .feeType("Tution")
                .amount("10.00")
                .contactEmail("contact@skiply.com")
                .studentId("12345")
                .cardType("MasterCard")
                .cardNumber("893712083012")
                .txnRefNo("81720380")
                .txnDate("20-01-2024, 8:28 PM")
                .build();
        return generatePDFPaymentReceipt(paymentReceiptJasperDTO, "test", "/templates/paymentReceipt.jrxml");
    }

    String generatePDFPaymentReceipt(PaymentReceiptJasperDTO paymentReceiptJasperDTO, String fileName, String template) {
        JRDataSource dataSource = new JRBeanCollectionDataSource(Collections.singletonList(paymentReceiptJasperDTO));
        InputStream inputStream = TransactionApplication.class.getResourceAsStream(template);

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

            File pdf = File.createTempFile(fileName, ".pdf");
            JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(pdf));
            Path path = Paths.get(pdf.toURI());
            return path.toUri().toURL().toString();

        } catch (IOException | JRException e) {
            throw new ApplicationException("", e.getMessage());
        }
    }
}
