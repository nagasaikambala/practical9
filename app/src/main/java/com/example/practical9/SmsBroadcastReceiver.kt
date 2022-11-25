package com.example.practical9

class SmsBroadcastReceiver {
    class SMSBroadcastReceiver : BroadcastReceiver() {

        interface Listner {
            fun onTextReceived(sPhoneNo: String?, sMsg: String?)
        } private var listner: Listner?
                = null
        fun setListner(lis: Listner) {
            listner = lis
        }
        override fun onReceive(context: Context, intent: Intent) { if
                                                                           (intent.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {
            var sPhoneNo = "" var sSMSBody = ""
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                for (smsMessage in Telephony.Sms.Intents.getMessagesFromIntent(intent)) { sPhoneNo
                    = smsMessage.displayOriginatingAddress sSMSBody += smsMessage.messageBody
                }
                if (listner != null) {
                    listner?.onTextReceived(sPhoneNo, sSMSBody)
                }
            }
        }

        }
    }

}