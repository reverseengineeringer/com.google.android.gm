import com.google.android.gms.common.ConnectionResult;

public final class emx
  implements ejd
{
  public emx(emr paramemr) {}
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.b()) {
      a.a(null, emr.d(a));
    }
    while (emr.e(a) == null) {
      return;
    }
    emr.e(a).a(paramConnectionResult);
  }
  
  public final void b(ConnectionResult paramConnectionResult)
  {
    throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
  }
}

/* Location:
 * Qualified Name:     emx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */