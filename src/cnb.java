import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public final class cnb
  implements SensorEventListener
{
  private static boolean a;
  private final cnc b;
  private final Context c;
  private float d;
  private float e;
  private float f;
  
  public cnb(Context paramContext, cnc paramcnc)
  {
    c = paramContext;
    b = paramcnc;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    e = f;
    float f1 = values[0];
    float f2 = values[1];
    float f3 = values[2];
    f = ((float)Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3));
    d = (f - e + d * 0.9F);
    if (d > 8.5F) {
      a = true;
    }
    if ((a) && (d < 2.0F))
    {
      a = false;
      b.a();
    }
  }
}

/* Location:
 * Qualified Name:     cnb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */