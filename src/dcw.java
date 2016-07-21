import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import com.google.android.apps.work.common.richedittext.RichTextToolbar;

public final class dcw
  implements CompoundButton.OnCheckedChangeListener
{
  public dcw(RichTextToolbar paramRichTextToolbar) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    Object localObject3;
    Object localObject4;
    int k;
    int j;
    if (a.B)
    {
      i = paramCompoundButton.getId();
      if (a.b != null)
      {
        if (i != dch.g) {
          break label317;
        }
        a.b.c(paramBoolean);
      }
      if (i != dch.l) {
        break label396;
      }
      if (!paramBoolean) {
        break label386;
      }
      localObject2 = new StringBuilder(a.getResources().getText(dcj.j));
      if (a.h != null)
      {
        localObject3 = a;
        localObject4 = a.h;
        localObject4 = ((RadioGroup)localObject4).findViewById(((RadioGroup)localObject4).getCheckedRadioButtonId());
        if (localObject4 != null) {
          localObject1 = ((RichTextToolbar)localObject3).getResources().getString(dcj.f, new Object[] { ((View)localObject4).getContentDescription() });
        }
        if (localObject1 != null) {
          ((StringBuilder)localObject2).append(", ").append((String)localObject1);
        }
      }
      localObject1 = a;
      localObject3 = a.e;
      localObject2 = ((StringBuilder)localObject2).toString();
      if (d.isShowing()) {
        ((RichTextToolbar)localObject1).d();
      }
      k = paramCompoundButton;
      d.setContentView((View)localObject3);
      k = ((RichTextToolbar)localObject1).getResources().getDimensionPixelSize(dcf.b);
      i = paramCompoundButton.getWidth() / 2;
      j = ((View)localObject3).getMeasuredWidth() / 2;
      k = -(k + c.getHeight() + ((View)localObject3).getMeasuredHeight());
      d.showAsDropDown(paramCompoundButton, i - j, k);
      if (localObject2 != null) {
        dcc.a(a, (View)localObject3, (CharSequence)localObject2);
      }
      label304:
      a.b.w();
    }
    label317:
    label386:
    label396:
    do
    {
      do
      {
        return;
        if (i == dch.o)
        {
          a.b.d(paramBoolean);
          break;
        }
        if (i == dch.s)
        {
          a.b.e(paramBoolean);
          break;
        }
        if (i != dch.r) {
          break;
        }
        a.b.f(paramBoolean);
        break;
        a.d();
        break label304;
        if (i == dch.e)
        {
          if (paramBoolean)
          {
            localObject3 = new StringBuilder(a.getResources().getText(dcj.h));
            if (a.i != null)
            {
              localObject4 = a;
              localObject1 = a.i;
              View localView = ((RadioGroup)localObject1).findViewById(((RadioGroup)localObject1).getCheckedRadioButtonId());
              localObject1 = localObject2;
              if (localView != null) {
                localObject1 = ((RichTextToolbar)localObject4).getResources().getString(dcj.f, new Object[] { localView.getContentDescription() });
              }
              if (localObject1 != null) {
                ((StringBuilder)localObject3).append(", ").append((String)localObject1);
              }
            }
            localObject1 = a;
            localObject2 = a.f;
            localObject3 = ((StringBuilder)localObject3).toString();
            if (d.isShowing()) {
              ((RichTextToolbar)localObject1).d();
            }
            k = paramCompoundButton;
            d.setContentView((View)localObject2);
            k = ((RichTextToolbar)localObject1).getResources().getDimensionPixelSize(dcf.b);
            i = paramCompoundButton.getWidth() / 2;
            j = ((View)localObject2).getMeasuredWidth() / 2;
            k = -(k + c.getHeight() + ((View)localObject2).getMeasuredHeight());
            d.showAsDropDown(paramCompoundButton, i - j, k);
            if (localObject3 != null) {
              dcc.a(a, (View)localObject2, (CharSequence)localObject3);
            }
          }
          for (;;)
          {
            a.b.x();
            return;
            a.d();
          }
        }
      } while (i != dch.k);
      if (!paramBoolean) {
        break label831;
      }
      localObject1 = a;
      localObject2 = a.g;
      localObject3 = a.getResources().getText(dcj.i);
      if (d.isShowing()) {
        ((RichTextToolbar)localObject1).d();
      }
      k = paramCompoundButton;
      d.setContentView((View)localObject2);
      k = ((RichTextToolbar)localObject1).getResources().getDimensionPixelSize(dcf.b);
      i = paramCompoundButton.getWidth() / 2;
      j = ((View)localObject2).getMeasuredWidth() / 2;
      k = -(k + c.getHeight() + ((View)localObject2).getMeasuredHeight());
      d.showAsDropDown(paramCompoundButton, i - j, k);
    } while (localObject3 == null);
    dcc.a(a, (View)localObject2, (CharSequence)localObject3);
    return;
    label831:
    a.d();
  }
}

/* Location:
 * Qualified Name:     dcw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */