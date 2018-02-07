# Integración de Pasarela de Pagos Stripe con Spring Boot

En este proyecto se integra la pasarela de pagos de Stripe con Spring Boot, usando el recurso *checkout.js*.
[Stripe](URL "https://stripe.com/") es un servicio creado por desarrolladores para desarrolladores, permite a empresas o individuos recibir pagos através de internet y ofrece [bibliotecas del lado de cliente](URL "https://stripe.com/docs/quickstart") (JavaScript) como [bibliotecas del lado del servidor](URL "https://stripe.com/docs/api") (Java, Python, Ruby, .NET, PHP, Node.js, Go, etc). Los aspectos a tener en cuenta son los siguientes:

1. Crear una cuenta en [Stripe](URL "https://dashboard.stripe.com/register").

2. Iniciar sesión y dirigirnos a la [dashboard](URl "https://dashboard.stripe.com/test/dashboard"), en ella damos click a [API](URL "https://dashboard.stripe.com/account/apikeys"), donde podremos observar dos seciones, test y restricted API keys, la primera contendra las keys de prueba para testiar en un entorno de desarrollo y la segunda para puesta en producción.

3. Copiar las keys en el achivo *application.properties*:
```
	stripe.api.key=sk_test_XxXxXxXxXxXxXxXxXxXxXxXx
	stripe.public.key=pk_test_XxXxXxXxXxXxXxXxXxXxXxXx
```
4. La clase encargada de realizar el pago **Charge** es **StripeService**

5. Correr el proyecto.

6. Tarjetas para prueba, puede utilizar como CVC: 123, un mes y año vigentes:

	* 4242 4242 4242 4242 Visa
	* 4012 8888 8888 1881 Visa
	* 4000 0566 5566 5556 Visa (debit)
	* 5555 5555 5555 4444 MasterCard
	* 5200 8282 8282 8210 MasterCard (debit)
	* 5105 1051 0510 5100 MasterCard (prepaid)
	* 3782 8224 6310 005 American Express
	* 3714 4963 5398 431 American Express
	* 6011 1111 1111 1117 Discover
	* 6011 0009 9013 9424 Discover
	* 3056 9309 0259 04 Diners Club
	* 3852 0000 0232 37 Diners Club
	* 3530 1113 3330 0000 JCB
	* 3566 0020 2036 0505 JCB

