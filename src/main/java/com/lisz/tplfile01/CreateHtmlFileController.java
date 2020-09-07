package com.lisz.tplfile01;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController("/")
public class CreateHtmlFileController {
	@Autowired
	private Configuration tplConf;

	@GetMapping("create")
	public String create() throws Exception{
		System.out.println("create");
		// 获取模版对象
		Template template = tplConf.getTemplate("product.tpl");
		// 数据集合，用来填充模版占位符
		Map<String, Object> dataModel = new HashMap<>();
		// 文件都写到这儿
		String htmlFilePath = "/Users/shuzheng/Documents/dev";

		int id = 18;
		String name = "p1";
		double price = 100.00;
		File file = new File(htmlFilePath + "/product-" + id + ".html");
		Product product = new Product(id, name, price);

		if (file.exists()) {
			System.out.println("文件已存在，先删除");
			file.delete();
		}
		file.createNewFile();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));

		// 渲染模板
		dataModel.put("product", product);
		template.process(dataModel, writer);
		return "ok";
	}

}
