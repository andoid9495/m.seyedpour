package com.example.sony1.Seyedpour;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by SONY1 on 7/25/2015.
 */
public class PhoneReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context contex,Intent intent)
    {
        Bundle extras=intent.getExtras();
        if(extras!=null)
        {
            String state=extras.getString(TelephonyManager.EXTRA_STATE);
            Log.d("PhoneReceiver", state);

            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                String phoneNumber=extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.d("PhoneReceiver",phoneNumber);
            }
        }
    }
}
