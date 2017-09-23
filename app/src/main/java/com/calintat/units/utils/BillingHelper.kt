package com.calintat.units.utils

import android.app.Activity
import com.android.billingclient.api.*
import com.calintat.units.R
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.toast

class BillingHelper(private val activity: Activity) : AnkoLogger, BillingClientStateListener, ConsumeResponseListener, PurchasesUpdatedListener {

    private val billingClient = BillingClient.newBuilder(activity).setListener(this).build()

    private val Int.isOK: Boolean get() = this == BillingClient.BillingResponse.OK

    init {

        billingClient.startConnection(this)
    }

    fun destroy() {

        if (billingClient.isReady) billingClient.endConnection()
    }

    fun makeDonation(sku: String) {

        val builder = BillingFlowParams.newBuilder().setSku(sku).setType(BillingClient.SkuType.INAPP)

        val responseCode = billingClient.launchBillingFlow(activity, builder.build())

        if (!responseCode.isOK) activity.toast(R.string.err_could_not_initiate_purchase)
    }

    override fun onBillingServiceDisconnected() {

        debug("Billing service disconnected")
    }

    override fun onBillingSetupFinished(resultCode: Int) {

        debug("Billing setup finished with status $resultCode")
    }

    override fun onConsumeResponse(responseCode: Int, purchaseToken: String?) {

        debug("Consumption operation finished with status $responseCode")

        if (responseCode.isOK) activity.toast(R.string.msg_thank_you_for_your_contribution)
    }

    override fun onPurchasesUpdated(responseCode: Int, purchases: MutableList<Purchase>?) {

        if (responseCode.isOK) purchases?.forEach { billingClient.consumeAsync(it.purchaseToken, this) }
    }
}