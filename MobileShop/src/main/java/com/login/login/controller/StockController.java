package com.login.login.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.login.login.entity.Stock;
import com.login.login.userdetails.StockService;

@Controller
public class StockController {
	@Autowired
	private StockService service;

		@GetMapping("/stockindex")
		public String viewHomePage(Model model) {			
			List<Stock> liststock = service.listAll();
			model.addAttribute("liststock", liststock);
			// System.out.print("Get / ");
			return "stockindex";
		}

		@GetMapping("/new") // add new button
		public String add(Model model) {
			model.addAttribute("stock", new Stock());
			return "new";
		}

		@RequestMapping(value = "/save", method = RequestMethod.POST) // save button
		public String saveStock(@ModelAttribute("stock") Stock stock) {
			service.save(stock);
			return "redirect:/stockindex";
		}

		@RequestMapping("/edit/{id}")
		public ModelAndView showEditStockPage(@PathVariable(name = "id") long id) {
			ModelAndView mav = new ModelAndView("new");
			Stock stock = service.get(id);
			mav.addObject("stock", stock);
			return mav;

		}

		@RequestMapping("/delete/{id}")
		public String deletestock(@PathVariable(name = "id") long id) {
			service.delete(id);
			return "redirect:/stockindex";
		}

	/*	@RequestMapping("/add/{id}")
		public String addproduct(@PathVariable(name = "id") long id, Model model) {
			Stock billingStock = service.get(id);
			model.addAttribute("billingStock", billingStock);
			service.save(billingStock);
			System.out.println(billingStock.getItem() + " " + billingStock.getPrice() + " " + billingStock.getQuantity());
			return "redirect:/stockindex";
		}*/
		@RequestMapping(value = "/billing", method = RequestMethod.GET)
		   public String index() 
	           {
		      return "billing";
		   }
		@GetMapping("/logoutpage")
		public String logout()
		{			
			return "index";
		}

}
	

