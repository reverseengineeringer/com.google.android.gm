import android.os.Bundle;

final class jd
{
  static Bundle[] a(jb[] paramArrayOfjb)
  {
    if (paramArrayOfjb == null) {
      return null;
    }
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfjb.length];
    int i = 0;
    while (i < paramArrayOfjb.length)
    {
      jb localjb = paramArrayOfjb[i];
      Bundle localBundle = new Bundle();
      localBundle.putString("resultKey", localjb.a());
      localBundle.putCharSequence("label", localjb.b());
      localBundle.putCharSequenceArray("choices", localjb.c());
      localBundle.putBoolean("allowFreeFormInput", localjb.d());
      localBundle.putBundle("extras", localjb.e());
      arrayOfBundle[i] = localBundle;
      i += 1;
    }
    return arrayOfBundle;
  }
}

/* Location:
 * Qualified Name:     jd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */