package com.aware.plugin.ChuIO1;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.aware.Aware;
import com.aware.plugin.ChuIO1.Provider.ChuIO1_Data;
import com.aware.utils.IContextCard;

public class ContextCard implements IContextCard {
    private static TextView Text_a_0;
    private static TextView Text_a_1;
    private static TextView Text_a_2;
    private static TextView Text_l_0;
    private static TextView Text_m_0;
    private static TextView Text_m_1;
    private static TextView Text_m_2;
    private static TextView Text_gsmstr_0;
    private static TextView Text_gsmnstr_0;
    private static TextView Text_cdmastr_0;
    private static TextView Text_wifistr_0;
    private static TextView Text_la_0;
    private static TextView Text_la_1;
    private static TextView Text_la_2;

    public ContextCard() {};

    public View getContextCard(Context context) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View card = inflater.inflate(R.layout.card, null);
        Text_a_0 = (TextView) card.findViewById(R.id.textView2);
        Text_a_1 = (TextView) card.findViewById(R.id.textView3);
        Text_a_2 = (TextView) card.findViewById(R.id.textView4);
        Text_l_0 = (TextView) card.findViewById(R.id.textView6);
        Text_m_0 = (TextView) card.findViewById(R.id.textView8);
        Text_m_1 = (TextView) card.findViewById(R.id.textView9);
        Text_m_2 = (TextView) card.findViewById(R.id.textView10);
        Text_gsmstr_0 = (TextView) card.findViewById(R.id.textView12);
        Text_gsmnstr_0 = (TextView) card.findViewById(R.id.textView14);
        Text_cdmastr_0 = (TextView) card.findViewById(R.id.textView16);
        Text_wifistr_0 = (TextView) card.findViewById(R.id.textView18);
        Text_la_0 = (TextView) card.findViewById(R.id.textView20);
        Text_la_1 = (TextView) card.findViewById(R.id.textView21);
        Text_la_2 = (TextView) card.findViewById(R.id.textView22);

        Cursor latest = context.getContentResolver().query(ChuIO1_Data.CONTENT_URI, null, null, null, ChuIO1_Data.TIMESTAMP + " DESC LIMIT 1");
        if (latest != null && latest.moveToFirst()) {
            Text_a_0.setText(String.format("%.1f", latest.getDouble(latest.getColumnIndex(ChuIO1_Data.A_VALUES_0))) + "m/s^2");
            Text_a_1.setText(String.format("%.1f", latest.getDouble(latest.getColumnIndex(ChuIO1_Data.A_VALUES_1))) + "m/s^2");
            Text_a_2.setText(String.format("%.1f", latest.getDouble(latest.getColumnIndex(ChuIO1_Data.A_VALUES_2))) + "m/s^2");
            Text_l_0.setText(String.format("%.1f", latest.getDouble(latest.getColumnIndex(ChuIO1_Data.L_VALUES_0))) + "lux");
            Text_m_0.setText(String.format("%.1f", latest.getDouble(latest.getColumnIndex(ChuIO1_Data.M_VALUES_0))) + "μT");
            Text_m_1.setText(String.format("%.1f", latest.getDouble(latest.getColumnIndex(ChuIO1_Data.M_VALUES_1))) + "μT)");
            Text_m_2.setText(String.format("%.1f", latest.getDouble(latest.getColumnIndex(ChuIO1_Data.M_VALUES_2))) + "μT");
            Text_gsmstr_0.setText(String.format("%.1f", latest.getDouble(latest.getColumnIndex(ChuIO1_Data.GSMSTR_VALUES_0))) + "asu");
            Text_gsmnstr_0.setText(String.format("%.1f", latest.getDouble(latest.getColumnIndex(ChuIO1_Data.GSMNSTR_VALUES_0))) + "asu");
            Text_cdmastr_0.setText(String.format("%.1f", latest.getDouble(latest.getColumnIndex(ChuIO1_Data.CDMASTR_VALUES_0))) + "dBm");
            Text_wifistr_0.setText(String.format("%.1f", latest.getDouble(latest.getColumnIndex(ChuIO1_Data.WIFISTR_VALUES_0))) + "dB");
            Text_la_0.setText(String.format("%.1f", latest.getDouble(latest.getColumnIndex(ChuIO1_Data.LA_VALUES_0))) + "m/s^2");
            Text_la_1.setText(String.format("%.1f", latest.getDouble(latest.getColumnIndex(ChuIO1_Data.LA_VALUES_1))) + "m/s^2");
            Text_la_2.setText(String.format("%.1f", latest.getDouble(latest.getColumnIndex(ChuIO1_Data.LA_VALUES_2))) + "m/s^2");

        } else {
            Text_a_0.setText("no data");
        }
        if (latest != null && !latest.isClosed()) latest.close();


        return card;
    }
}