package test.hw37.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import test.hw37.dao.ReportDao;
import test.hw37.model.Report;
import test.hw37.service.ReportService;

import java.util.List;
@Log4j

//@RequiredArgsConstructor
@Component
public class ReportServiceImpl implements ReportService {

    private  final ReportDao reportDao;
    private final String hello;
    private final ReportService self;
@Autowired
    public ReportServiceImpl(ReportDao reportDao, @Value("$(hello)")String hello, @Lazy ReportService reportService) {
        this.reportDao = reportDao;
        this.hello = hello;
        this.self = reportService;
    }

    public ReportServiceImpl(ReportDao reportDao) {
        this.reportDao = reportDao;
        this.hello = "hello";
        this.self = new ReportServiceImpl(reportDao,hello,null);
    }

    @Override
    public void generateAndSave() {
        Report report = new Report(1L,"Annual report");
        reportDao.save(report);

    }
    @Override
    public void generateSomeAndSave() {
    log.info("ReportServiceImpl#generateSomeAndSave Run");
        List<Report> reports = List.of(new Report(1L,"Annual report"),
                new Report(2L,"Montly report"),
                new Report(3L,"Daily report"));
        new Report(4L,hello);
        reports.forEach(reportDao::save);
        log.info(reportDao);
        log.info("ReportServiceImpl#generateSomeAndSave End");
    }
}
