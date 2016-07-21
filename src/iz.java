import android.app.RemoteInput;
import android.app.RemoteInput.Builder;

final class iz
{
  static RemoteInput[] a(jb[] paramArrayOfjb)
  {
    if (paramArrayOfjb == null) {
      return null;
    }
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfjb.length];
    int i = 0;
    while (i < paramArrayOfjb.length)
    {
      jb localjb = paramArrayOfjb[i];
      arrayOfRemoteInput[i] = new RemoteInput.Builder(localjb.a()).setLabel(localjb.b()).setChoices(localjb.c()).setAllowFreeFormInput(localjb.d()).addExtras(localjb.e()).build();
      i += 1;
    }
    return arrayOfRemoteInput;
  }
}

/* Location:
 * Qualified Name:     iz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */