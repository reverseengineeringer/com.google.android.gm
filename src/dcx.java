import android.content.res.Resources;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.google.android.apps.work.common.richedittext.RichTextToolbar;

public final class dcx
  implements RadioGroup.OnCheckedChangeListener
{
  public dcx(RichTextToolbar paramRichTextToolbar) {}
  
  public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i;
    if (a.B)
    {
      if (!paramRadioGroup.equals(a.h)) {
        break label208;
      }
      if (paramInt != dch.p) {
        break label130;
      }
      i = a.n;
      paramRadioGroup = paramRadioGroup.findViewById(paramInt);
      dcc.a(a.a, paramRadioGroup, a.getResources().getString(dcj.a, new Object[] { paramRadioGroup.getContentDescription() }));
      a.a(a.x, i);
      a.x.setChecked(false);
      if (a.b != null) {
        a.b.f(i);
      }
    }
    label130:
    label208:
    label458:
    do
    {
      do
      {
        return;
        if (paramInt == dch.f)
        {
          i = a.o;
          break;
        }
        if (paramInt == dch.n)
        {
          i = a.p;
          break;
        }
        if (paramInt == dch.t)
        {
          i = a.q;
          break;
        }
        if (paramInt == dch.m)
        {
          i = a.r;
          break;
        }
        i = -16777216;
        break;
        if (paramRadioGroup.equals(a.i))
        {
          if (paramInt == dch.D) {
            i = a.s;
          }
          for (;;)
          {
            paramRadioGroup = paramRadioGroup.findViewById(paramInt);
            dcc.a(a.a, paramRadioGroup, a.getResources().getString(dcj.a, new Object[] { paramRadioGroup.getContentDescription() }));
            a.a(a.y, i);
            a.y.setChecked(false);
            if (a.b == null) {
              break;
            }
            a.b.g(i);
            return;
            if (paramInt == dch.A) {
              i = a.t;
            } else if (paramInt == dch.C) {
              i = a.u;
            } else if (paramInt == dch.E) {
              i = a.v;
            } else if (paramInt == dch.B) {
              i = a.w;
            } else {
              i = -1;
            }
          }
        }
        if ((!paramRadioGroup.equals(a.z)) || (a.b == null)) {
          break label458;
        }
      } while ((paramInt == dch.h) || (paramInt == dch.c) || (paramInt == dch.b) || (paramInt != dch.d));
      return;
    } while ((!paramRadioGroup.equals(a.j)) || (a.b == null));
    if (paramInt == dch.v) {
      a.b.c("sans-serif");
    }
    for (;;)
    {
      paramRadioGroup = paramRadioGroup.findViewById(paramInt);
      dcc.a(a.a, paramRadioGroup, a.getResources().getString(dcj.a, new Object[] { paramRadioGroup.getContentDescription() }));
      a.A.setChecked(false);
      return;
      if (paramInt == dch.x) {
        a.b.c("serif");
      } else if (paramInt == dch.u) {
        a.b.c("sans-serif-condensed");
      }
    }
  }
}

/* Location:
 * Qualified Name:     dcx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */