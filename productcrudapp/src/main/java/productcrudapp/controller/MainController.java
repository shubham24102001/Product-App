package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.view.RedirectView;

import oracle.net.jdbc.TNSAddress.Address;
import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("//")
	public String home(Model model) {
		List<Product> products=productDao.getAllProducts();
		model.addAttribute("products",products);
		System.out.println("this is home page..");
		return "home";
	}	
	
	//show Add product form
	@RequestMapping("/add-product")
	public String addProduct(Model model) {
		
		model.addAttribute("title","Add Product");
		return "add-product-form";
	}
	
	//handle Add product Form
	
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleForm(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	//Delete product..Handler
	@RequestMapping("/delet/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		productDao.deleteProduct(productId);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/update/{productId}")
	public String updateProduct(@PathVariable("productId") int productId,Model model) {
		
		Product p=productDao.getProduct(productId);
		model.addAttribute("product", p);
		return "update_form";
	}

}
