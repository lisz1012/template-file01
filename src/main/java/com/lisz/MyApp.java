package com.lisz;

import com.jfinal.kit.Kv;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import com.lisz.tplfile01.Seller;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

// 这个Enjoy比FM和velocity快3-4bei s
public class MyApp {
	public void createHtml() throws Exception {
		Engine engine = Engine.use();
		engine.setDevMode(true);
		// 使用 ClassPathSourceFactory 从 class path 与 jar 包中加载模板文件
		engine.setToClassPathSourceFactory();
		Template template = engine.getTemplate("templates/seller.tpl"); // 这里要写目录名，或者把templates当作参数传入上面

		int id = 10;
		String name = "lisz";
		Seller seller = new Seller(id, name);
		Kv kv = Kv.by("seller", seller);
		String filename = "/Users/shuzheng/Documents/dev/seller-" + id + ".html";

		template.render(kv, filename);
	}
}
