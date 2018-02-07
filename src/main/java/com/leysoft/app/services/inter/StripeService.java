 package com.leysoft.app.services.inter;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

public interface StripeService {
	
	public Charge charge(String stripeToken, Double amount) throws StripeException;
}