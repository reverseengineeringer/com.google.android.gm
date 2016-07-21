import android.app.Notification;

final class in
  implements ir
{
  final String a;
  final int b;
  final String c;
  final Notification d;
  
  public in(String paramString1, int paramInt, String paramString2, Notification paramNotification)
  {
    a = paramString1;
    b = paramInt;
    c = null;
    d = paramNotification;
  }
  
  public final void a(gl paramgl)
  {
    paramgl.a(a, b, c, d);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("NotifyTask[");
    localStringBuilder.append("packageName:").append(a);
    localStringBuilder.append(", id:").append(b);
    localStringBuilder.append(", tag:").append(c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     in
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */