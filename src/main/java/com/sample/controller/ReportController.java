package com.sample.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sample.service.TeacherService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class ReportController {

	@Autowired
	private TeacherService teacherService;

	@GetMapping("/teachers/pdf")
	public ResponseEntity<byte[]> generateTeacherReport() throws Exception, JRException {

		Resource resource = new ClassPathResource("reports/test.jrxml");
		File file = resource.getFile();

		JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(
				teacherService.getTeachers());
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream(file));

		HashMap<String, Object> map = new HashMap<String, Object>();

		JasperPrint report = JasperFillManager.fillReport(compileReport, map, jrBeanCollectionDataSource);

		byte[] data = JasperExportManager.exportReportToPdf(report);

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=report.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);

	}

}
