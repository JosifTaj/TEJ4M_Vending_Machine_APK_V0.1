public class main {
PayPalConfiguration config = new PayPalConfiguration()
    .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX) // Set your environment
    .clientId("YOUR_CLIENT_ID"); // Replace with your PayPal Client ID

Intent intent = new Intent(this, PayPalService.class);
intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
startService(intent);

PayPalPayment payment = new PayPalPayment(new BigDecimal("10.00"), "USD", "Payment for XYZ", PayPalPayment.PAYMENT_INTENT_SALE);
Intent paymentIntent = new Intent(this, PaymentActivity.class);
paymentIntent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
paymentIntent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
startActivityForResult(paymentIntent, PAYPAL_REQUEST_CODE);

}
