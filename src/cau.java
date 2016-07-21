import android.app.Fragment;
import android.content.ContentValues;
import android.content.Intent;

public final class cau
  implements cum
{
  private boolean b = false;
  
  public cau(cas paramcas) {}
  
  public final void a()
  {
    if (!b) {
      a.a(false);
    }
  }
  
  public final void a(int paramInt)
  {
    b = true;
    cas localcas = a;
    switch (paramInt)
    {
    default: 
      cvm.d(cas.a, 36 + "selected option unknown: " + paramInt, new Object[0]);
      return;
    case 0: 
      Object localObject = new ContentValues(1);
      ((ContentValues)localObject).put("rsvp", Integer.valueOf(d));
      localObject = cbk.b(i.getActivity(), k, b, (ContentValues)localObject);
      i.startActivityForResult((Intent)localObject, 7);
      return;
    }
    localcas.c();
  }
}

/* Location:
 * Qualified Name:     cau
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */