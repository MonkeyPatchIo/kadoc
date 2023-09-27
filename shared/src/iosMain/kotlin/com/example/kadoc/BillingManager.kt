package com.example.kadoc

import platform.StoreKit.SKPaymentQueue
import platform.StoreKit.SKProduct
import platform.StoreKit.SKProductsRequest
import platform.StoreKit.SKProductsRequestDelegateProtocol
import platform.StoreKit.SKProductsResponse
import platform.darwin.NSObject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

actual class BillingManager {

    val isAuthorizedForPayments by lazy {
        SKPaymentQueue.canMakePayments()
    }
    actual suspend fun listProducts(identifiers: List<String>): List<String> = suspendCoroutine { cont ->
      val productRequest =  SKProductsRequest(identifiers.toSet())
        productRequest.setDelegate(object : NSObject(), SKProductsRequestDelegateProtocol {
        override fun productsRequest(
            request: SKProductsRequest,
            didReceiveResponse: SKProductsResponse
        ) {
            if (didReceiveResponse.products.isNotEmpty()) {
                val products = didReceiveResponse.products
                    .filterIsInstance<SKProduct>()
                    .map { (it as SKProduct).productIdentifier }
                cont.resume(products)
            }

            if (didReceiveResponse.invalidProductIdentifiers.isNotEmpty()) {
                cont.resumeWithException(
                    IllegalArgumentException(
                        "Invalid product identifiers: ${didReceiveResponse.invalidProductIdentifiers}"
                    )
                )
            }
        }
    })
        productRequest.start()
    }

}