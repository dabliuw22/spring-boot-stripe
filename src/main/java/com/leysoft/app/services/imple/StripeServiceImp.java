package com.leysoft.app.services.imple;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.leysoft.app.services.inter.StripeService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Service
public class StripeServiceImp implements StripeService {
	
	@Value("${stripe.api.key}")
	private String stripeApiKey;
	
	@PostConstruct
	public void init() {
		Stripe.apiKey = this.stripeApiKey;
	}
	
	@Override
	public Charge charge(String stripeToken, Double amount) throws StripeException  {
		Map<String, Object> chargeParams = new HashMap<>();
		chargeParams.put("currency", "usd");
		chargeParams.put("amount", amount.intValue());
		chargeParams.put("source", stripeToken);
		return Charge.create(chargeParams);
	}
}
