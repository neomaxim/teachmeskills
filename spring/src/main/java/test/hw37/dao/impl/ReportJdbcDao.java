package test.hw37.dao.impl;

import lombok.Data;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import test.hw37.dao.ReportDao;
import test.hw37.model.Report;
@Data
@Log4j
@Component
@Scope("prototype")
public class ReportJdbcDao implements ReportDao {

    @Getter
    @Value("${hello}")
    private String hello;

    @Getter
   @Value("${maxValue}")
    private Integer maxValue;

    @Override
    public void save(Report report) {
      log.info("Try to save report"+report);
    }
}
