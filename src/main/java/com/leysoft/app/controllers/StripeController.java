package com.leysoft.app.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leysoft.app.models.Checkout;
import com.leysoft.app.models.Orden;
import com.leysoft.app.models.Producto;
import com.leysoft.app.services.inter.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
public class StripeController {
	
	@Value("${stripe.public.key}")
	private String stripePublicKey;
	
	@Autowired
	private StripeService stripeService;
	
	@GetMapping(value = "/checkout")
	public String checkout(Model model) {
		model.addAttribute("stripePublicKey", getPublicKey());
		model.addAttribute("checkout", getCheckout());
		model.addAttribute("currency", "usd");
		return "checkout";
	}
	
	@PostMapping(value = "/checkout")
	public String checkout(@RequestParam("stripeToken") String stripeToken, @RequestParam("stripeEmail") String stripeEmail,
			@RequestParam("amount") Double amount, Model model) throws StripeException, IOException {
		Charge charge = stripeService.charge(stripeToken, amount);
		model.addAttribute("id", charge.getId());
		model.addAttribute("status", charge.getStatus());
		return "success";
	}
	
	@ExceptionHandler(StripeException.class)
	public String handlerStripeError(Model model, StripeException e) {
		model.addAttribute("error", e.getMessage());
		return "failure";
	}
	
	@ExceptionHandler(IOException.class)
	public String handlerIOError(Model model, IOException e) {
		model.addAttribute("error", e.getMessage());
		return "failure";
	}
	
	private String getPublicKey() {
		return stripePublicKey;
	}
	
	private Checkout getCheckout() {
		Producto producto1 = new Producto();
		producto1.setId(new Long(1));
		producto1.setNombre("Producto1");
		producto1.setPrecio(10.2);
		
		Producto producto2 = new Producto();
		producto2.setId(new Long(2));
		producto2.setNombre("Producto2");
		producto2.setPrecio(5.5);
		
		Producto producto3 = new Producto();
		producto3.setId(new Long(3));
		producto3.setNombre("Producto3");
		producto3.setPrecio(15.0);
		
		Orden orden = new Orden();
		orden.addProducto(producto1);
		orden.addProducto(producto2);
		orden.addProducto(producto3);
		return new Checkout(orden);
	}
}