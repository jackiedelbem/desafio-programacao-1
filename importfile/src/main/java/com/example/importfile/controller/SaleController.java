package com.example.importfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.example.importfile.model.Sale;
import com.example.importfile.repository.SaleRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Controller
@RequestMapping("/")
public class SaleController {

	private SaleRepository saleRepository;


	@Autowired
	public SaleController( SaleRepository saleRepository) {
		this.saleRepository = saleRepository;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listSales(Model model) {
		List<Sale> listSales = saleRepository.findAll();
		if (listSales != null) {
			model.addAttribute("sales", listSales);
			Double total = 0d;
			for(Sale sale : listSales){
				total += sale.getItemPrice() * sale.getPurchaseCount();
			}
			model.addAttribute("total", total);
		}
		return "listSales";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String importFile(@PathVariable("file") MultipartFile file) {
		if (file.isEmpty()) {
			return "redirect:/";
		}
	
		BufferedReader br;
		try {

			InputStream is = file.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));

			String line = br.readLine();
			
			while ((line = br.readLine()) != null && !line.isEmpty()) { 
				String[] fields = line.split("\t"); 
				Sale sale = new Sale();
				sale.setPurchaserName(fields[0]); 
				sale.setItemDescription(fields[1]); 
				sale.setItemPrice(new Double(fields[2])); 
				sale.setPurchaseCount(Integer.parseInt(fields[3])); 
				sale.setMerchantAddress(fields[4]); 
				sale.setMerchantName(fields[5]); 
				
				this.saleRepository.saveAndFlush(sale);
			} 
			
			br.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());       
		}
		return "redirect:/";
	}

}
