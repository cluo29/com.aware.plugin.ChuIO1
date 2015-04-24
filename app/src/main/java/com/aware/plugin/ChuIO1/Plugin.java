package com.aware.plugin.ChuIO1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import com.aware.Aware;
import com.aware.Aware_Preferences;
import com.aware.plugin.ChuIO1.Provider.ChuIO1_Data;
import com.aware.providers.Accelerometer_Provider.Accelerometer_Data;
import com.aware.providers.Light_Provider.Light_Data;
import com.aware.providers.Magnetometer_Provider.Magnetometer_Data;
import com.aware.providers.Telephony_Provider.GSM_Data;
import com.aware.providers.Telephony_Provider.GSM_Neighbors_Data;
import com.aware.providers.Telephony_Provider.CDMA_Data;
import com.aware.providers.WiFi_Provider.WiFi_Data;
import com.aware.providers.Linear_Accelerometer_Provider.Linear_Accelerometer_Data;
import com.aware.utils.Aware_Plugin;
public class Plugin extends Aware_Plugin {
    public static final String ACTION_AWARE_PLUGIN_ChuIO1 = "ACTION_AWARE_PLUGIN_ChuIO1";
    public static final String EXTRA_A_VALUES_0 ="A_VALUES_0";
    public static final String EXTRA_A_VALUES_1 ="A_VALUES_1";
    public static final String EXTRA_A_VALUES_2 ="A_VALUES_2";
    public static final String EXTRA_L_VALUES_0 ="L_VALUES_0";
    public static final String EXTRA_M_VALUES_0 ="M_VALUES_0";
    public static final String EXTRA_M_VALUES_1 ="M_VALUES_1";
    public static final String EXTRA_M_VALUES_2 ="M_VALUES_2";
    public static final String EXTRA_GSMSTR_VALUES_0 ="GSMSTR_VALUES_0";
    public static final String EXTRA_GSMNSTR_VALUES_0 ="GSMNSTR_VALUES_0";
    public static final String EXTRA_CDMASTR_VALUES_0 ="CDMASTR_VALUES_0";
    public static final String EXTRA_WIFISTR_VALUES_0 ="WIFISTR_VALUES_0";
    public static final String EXTRA_LA_VALUES_0 ="LA_VALUES_0";
    public static final String EXTRA_LA_VALUES_1 ="LA_VALUES_1";
    public static final String EXTRA_LA_VALUES_2 ="LA_VALUES_2";
    private static double a_0 = 0;
    private static double a_1 = 0;
    private static double a_2 = 0;
    private static double l_0 = 0;
    private static double m_0 = 0;
    private static double m_1 = 0;
    private static double m_2 = 0;
    private static double gsmstr_0 = 0;
    private static double gsmnstr_0 = 0;
    private static double cdmastr_0 = 0;
    private static double wifistr_0 = 0;
    private static double la_0 = 0;
    private static double la_1 = 0;
    private static double la_2 = 0;
    public static ContextProducer context_producer;
    public Thread motion_thread = new Thread(){
        public void run(){
            while(true){
                Cursor Acceleration = getApplicationContext().getContentResolver().query(Accelerometer_Data.CONTENT_URI, null, null, null, Accelerometer_Data.TIMESTAMP + " DESC LIMIT 1");
                if(Acceleration!=null && Acceleration.moveToFirst()){
                    a_0 = Acceleration.getDouble(Acceleration.getColumnIndex(Accelerometer_Data.VALUES_0));
                    a_1 = Acceleration.getDouble(Acceleration.getColumnIndex(Accelerometer_Data.VALUES_1));
                    a_2 = Acceleration.getDouble(Acceleration.getColumnIndex(Accelerometer_Data.VALUES_2));
                }
                if( Acceleration != null && ! Acceleration.isClosed() ) {
                    Acceleration.close();
                }
                Cursor Light = getApplicationContext().getContentResolver().query(Light_Data.CONTENT_URI, null, null, null, Light_Data.TIMESTAMP + " DESC LIMIT 1");
                if(Light!=null && Light.moveToFirst()){
                    l_0 = Light.getDouble(Light.getColumnIndex(Light_Data.LIGHT_LUX));
                }
                if( Light != null && ! Light.isClosed() ) {
                    Light.close();
                }
                Cursor Magnetometer = getApplicationContext().getContentResolver().query(Magnetometer_Data.CONTENT_URI, null, null, null, Magnetometer_Data.TIMESTAMP + " DESC LIMIT 1");
                if(Magnetometer!=null && Magnetometer.moveToFirst()){
                    m_0 = Magnetometer.getDouble(Magnetometer.getColumnIndex(Magnetometer_Data.VALUES_0));
                    m_1 = Magnetometer.getDouble(Magnetometer.getColumnIndex(Magnetometer_Data.VALUES_1));
                    m_2 = Magnetometer.getDouble(Magnetometer.getColumnIndex(Magnetometer_Data.VALUES_2));
                }
                if( Magnetometer != null && ! Magnetometer.isClosed() ) {
                    Magnetometer.close();
                }

                Cursor GSM = getApplicationContext().getContentResolver().query(GSM_Data.CONTENT_URI, null, null, null, GSM_Data.TIMESTAMP + " DESC LIMIT 1");
                if(GSM!=null && GSM.moveToFirst()){
                    gsmstr_0 = GSM.getDouble(GSM.getColumnIndex(GSM_Data.SIGNAL_STRENGTH));
                }
                if( GSM != null && ! GSM.isClosed() ) {
                    GSM.close();
                }

                Cursor GSMN = getApplicationContext().getContentResolver().query(GSM_Neighbors_Data.CONTENT_URI, null, null, null, GSM_Neighbors_Data.TIMESTAMP + " DESC LIMIT 1");
                if(GSMN!=null && GSMN.moveToFirst()){
                    gsmnstr_0 = GSMN.getDouble(GSMN.getColumnIndex(GSM_Neighbors_Data.SIGNAL_STRENGTH));
                }
                if( GSMN != null && ! GSMN.isClosed() ) {
                    GSMN.close();
                }


                Cursor CDMASTR = getApplicationContext().getContentResolver().query(CDMA_Data.CONTENT_URI, null, null, null, CDMA_Data.TIMESTAMP + " DESC LIMIT 1");
                if(CDMASTR!=null && CDMASTR.moveToFirst()){
                    cdmastr_0 = CDMASTR.getDouble(CDMASTR.getColumnIndex(CDMA_Data.SIGNAL_STRENGTH));
                }
                if( CDMASTR != null && ! CDMASTR.isClosed() ) {
                    CDMASTR.close();
                }

                Cursor WIFISTR = getApplicationContext().getContentResolver().query(WiFi_Data.CONTENT_URI, null, null, null, WiFi_Data.TIMESTAMP + " DESC LIMIT 1");
                if(WIFISTR!=null && WIFISTR.moveToFirst()){
                    wifistr_0 = WIFISTR.getDouble(WIFISTR.getColumnIndex(WiFi_Data.RSSI));
                }
                if( WIFISTR != null && ! WIFISTR.isClosed() ) {
                    WIFISTR.close();
                }

                Cursor LA = getApplicationContext().getContentResolver().query(Linear_Accelerometer_Data.CONTENT_URI, null, null, null, Linear_Accelerometer_Data.TIMESTAMP + " DESC LIMIT 1");
                if(LA!=null && LA.moveToFirst()){
                    la_0 = LA.getDouble(LA.getColumnIndex(Linear_Accelerometer_Data.VALUES_0));
                    la_1 = LA.getDouble(LA.getColumnIndex(Linear_Accelerometer_Data.VALUES_1));
                    la_2 = LA.getDouble(LA.getColumnIndex(Linear_Accelerometer_Data.VALUES_2));
                }
                if( LA != null && !LA.isClosed() ) {
                    LA.close();
                }
                ContentValues data = new ContentValues();
                //require Provider.java here
                data.put(ChuIO1_Data.TIMESTAMP, System.currentTimeMillis());
                data.put(ChuIO1_Data.DEVICE_ID, Aware.getSetting(getApplicationContext(), Aware_Preferences.DEVICE_ID));
                data.put(ChuIO1_Data.A_VALUES_0,a_0);
                data.put(ChuIO1_Data.A_VALUES_1,a_1);
                data.put(ChuIO1_Data.A_VALUES_2,a_2);
                data.put(ChuIO1_Data.L_VALUES_0,l_0);
                data.put(ChuIO1_Data.M_VALUES_0,m_0);
                data.put(ChuIO1_Data.M_VALUES_1,m_1);
                data.put(ChuIO1_Data.M_VALUES_2,m_2);
                data.put(ChuIO1_Data.GSMSTR_VALUES_0,gsmstr_0);
                data.put(ChuIO1_Data.GSMNSTR_VALUES_0,gsmnstr_0);
                data.put(ChuIO1_Data.CDMASTR_VALUES_0,cdmastr_0);
                data.put(ChuIO1_Data.WIFISTR_VALUES_0,wifistr_0);
                data.put(ChuIO1_Data.LA_VALUES_0,la_0);
                data.put(ChuIO1_Data.LA_VALUES_1,la_1);
                data.put(ChuIO1_Data.LA_VALUES_2,la_2);
                getContentResolver().insert(ChuIO1_Data.CONTENT_URI, data);
                //Share context
                context_producer.onContext();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };




    @Override
    public void onCreate() {
        super.onCreate();
        TAG = "AWARE::Motion Meter";
        DEBUG = true;

        Intent aware = new Intent(this, Aware.class);
        startService(aware);
        CONTEXT_PRODUCER = new ContextProducer() {
            @Override
            public void onContext() {
                Intent context_motion_meter = new Intent();
                context_motion_meter.setAction(ACTION_AWARE_PLUGIN_ChuIO1);
                //take them out of AWARE providers
                context_motion_meter.putExtra(EXTRA_A_VALUES_0, a_0);
                context_motion_meter.putExtra(EXTRA_A_VALUES_1, a_1);
                context_motion_meter.putExtra(EXTRA_A_VALUES_2, a_2);
                context_motion_meter.putExtra(EXTRA_L_VALUES_0, l_0);
                context_motion_meter.putExtra(EXTRA_M_VALUES_0, m_0);
                context_motion_meter.putExtra(EXTRA_M_VALUES_1, m_1);
                context_motion_meter.putExtra(EXTRA_M_VALUES_2, m_2);
                context_motion_meter.putExtra(EXTRA_GSMSTR_VALUES_0, gsmstr_0);
                context_motion_meter.putExtra(EXTRA_GSMNSTR_VALUES_0, gsmnstr_0);
                context_motion_meter.putExtra(EXTRA_CDMASTR_VALUES_0, cdmastr_0);
                context_motion_meter.putExtra(EXTRA_WIFISTR_VALUES_0, wifistr_0);
                context_motion_meter.putExtra(EXTRA_LA_VALUES_0, la_0);
                context_motion_meter.putExtra(EXTRA_LA_VALUES_1, la_1);
                context_motion_meter.putExtra(EXTRA_LA_VALUES_2, la_2);

                sendBroadcast(context_motion_meter);
            }
        };
        context_producer = CONTEXT_PRODUCER;
        motion_thread.start();
    }
    public void onDestroy() {
        super.onDestroy();
    }
}