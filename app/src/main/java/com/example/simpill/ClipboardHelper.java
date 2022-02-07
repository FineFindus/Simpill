package com.example.simpill;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

public class ClipboardHelper {

    public void copyAddressToClipboard(Context context, int cryptoNumber) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService((Context.CLIPBOARD_SERVICE));
        ClipData clipData = null;

        String toastMessage = "";

        switch (cryptoNumber) {
            case 1:
                clipData = ClipData.newPlainText("btcAddress", context.getString(R.string.bitcoin_address));
                toastMessage = context.getString(R.string.btc_address_copied);
                break;
            case 2:
                clipData = ClipData.newPlainText("xmrAddress", context.getString(R.string.monero_address));
                toastMessage = context.getString(R.string.xmr_address_copied);
                break;
            case 3:
                clipData = ClipData.newPlainText("pndAddress", context.getString(R.string.pandacoin_address));
                toastMessage = context.getString(R.string.pnd_address_copied);
                break;
        }
        clipboardManager.setPrimaryClip(clipData);
        new Toasts().showCustomToast(context, toastMessage);
    }
}
