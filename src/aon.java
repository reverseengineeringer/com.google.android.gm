import android.app.DialogFragment;
import android.os.Bundle;
import java.util.Calendar;

public final class aon
{
  public aob a;
  public Calendar b;
  public DialogFragment c;
  public boolean d = false;
  private final aor e;
  private Calendar f;
  private int g = -1;
  
  public aon(aor paramaor)
  {
    e = paramaor;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l2 = -1L;
    if (c != null) {
      c.dismiss();
    }
    int i;
    if (g == -1)
    {
      i = Calendar.getInstance().getFirstDayOfWeek();
      if (!aom.a()) {
        break label204;
      }
      localObject1 = new aoo();
      localObject2 = new Bundle(3);
      ((Bundle)localObject2).putInt("year", paramInt1);
      ((Bundle)localObject2).putInt("month", paramInt2);
      ((Bundle)localObject2).putInt("day", paramInt3);
      ((aoo)localObject1).setArguments((Bundle)localObject2);
      b = new aop(e);
      a = a;
      localObject2 = b;
      if (localObject2 != null) {
        break label184;
      }
      l1 = -1L;
      label132:
      c = l1;
      localObject2 = f;
      if (localObject2 != null) {
        break label194;
      }
    }
    label184:
    label194:
    for (long l1 = l2;; l1 = ((Calendar)localObject2).getTimeInMillis())
    {
      d = l1;
      e = i;
      c = ((DialogFragment)localObject1);
      return;
      i = g;
      break;
      l1 = ((Calendar)localObject2).getTimeInMillis();
      break label132;
    }
    label204:
    Object localObject1 = new aoq(e);
    Object localObject2 = new aot();
    c = ((aow)localObject1);
    b.set(1, paramInt1);
    b.set(2, paramInt2);
    b.set(5, paramInt3);
    if ((i <= 0) || (i > 7)) {
      throw new IllegalArgumentException("Value must be between Calendar.SUNDAY and Calendar.SATURDAY");
    }
    e = i;
    if (d != null) {
      d.b();
    }
    if (b != null)
    {
      paramInt1 = b.get(1);
      if (f == null) {
        break label362;
      }
    }
    label362:
    for (paramInt2 = f.get(1);; paramInt2 = 2036)
    {
      if (paramInt2 > paramInt1) {
        break label369;
      }
      throw new IllegalArgumentException("Year end must be larger than year start");
      paramInt1 = 1970;
      break;
    }
    label369:
    f = paramInt1;
    g = paramInt2;
    if (d != null) {
      d.b();
    }
    a = a;
    ((aot)localObject2).a(b);
    ((aot)localObject2).b(f);
    i = d;
    c = ((DialogFragment)localObject2);
  }
  
  public final void a(DialogFragment paramDialogFragment)
  {
    if (c != null) {
      c.dismiss();
    }
    if ((paramDialogFragment instanceof aoo)) {
      b = new aop(e);
    }
    for (;;)
    {
      c = paramDialogFragment;
      return;
      if ((paramDialogFragment instanceof aot)) {
        c = new aoq(e);
      }
    }
  }
}

/* Location:
 * Qualified Name:     aon
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */