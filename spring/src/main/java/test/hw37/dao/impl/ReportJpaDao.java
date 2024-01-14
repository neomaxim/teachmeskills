package test.hw37.dao.impl;

import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import test.hw37.dao.ReportDao;
import test.hw37.model.Report;

@Log4j
@Component
//@Primary
public class ReportJpaDao implements ReportDao {

    @Getter
    @Value("${minValue}")
    private Integer minValue;

    @Override
    public void save(Report report) {
        log.info("Try to save as entity " + report);
    }
}
