package test.hw37;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.hw37.config.Config;
import test.hw37.dao.ReportDao;
import test.hw37.dao.impl.ReportJdbcDao;
import test.hw37.dao.impl.ReportJpaDao;
import test.hw37.service.ReportService;
@Log4j
public class SpringApplicationRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
        //context.scan("java.test.hw37");
       // context.refresh();
        ReportDao reportDao = context.getBean("reportJpaDao",ReportDao.class);
       // ReportDao reportDao2 = context.getBean("defaultReportDao",ReportDao.class);
       // ReportDao reportDao = context.getBean("reportJpaDao",ReportDao.class);
       ReportDao reportDao2 = context.getBean("reportJdbcDao",ReportDao.class);
        ReportService reportService = context.getBean(ReportService.class);
        log.info("dao - {}"+ reportDao);
        log.info("dao - {}"+ reportDao2);
        log.info("service - {}"+reportService);
        reportService.generateAndSave();        reportService.generateSomeAndSave();

        log.info("hello-" + ((ReportJdbcDao)reportDao2).getHello());
        log.info("hello-" + ((ReportJdbcDao)reportDao2).getMaxValue());
        log.info("hello-" + ((ReportJpaDao)reportDao).getMinValue());
    }
}
