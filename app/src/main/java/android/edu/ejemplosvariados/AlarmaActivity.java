package android.edu.ejemplosvariados;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlarmaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarma);
        programarAlarma();

    }
    private void programarAlarma ()
    {
        Calendar calendar_actual = Calendar.getInstance();
        long tiempo = calendar_actual.getTimeInMillis() + 10000; //en 10 segundos saltara

        Intent intentAlarm = new Intent(this, AlarmaReceiver.class);

        PendingIntent pi = PendingIntent.getBroadcast(this, 100, intentAlarm, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        
        manager.set(AlarmManager.RTC_WAKEUP, tiempo, pi);

        SimpleDateFormat dateformatter = new SimpleDateFormat("E dd/MM/yyyy 'a las' hh:mm:ss");
        String mensaje = "Alarma programada para "+ dateformatter.format(tiempo);

        Toast.makeText(this, mensaje, Toast.LENGTH_LONG ).show();

    }

}

