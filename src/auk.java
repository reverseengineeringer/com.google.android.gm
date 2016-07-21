import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.android.email.activity.setup.MultilineSelectionGroup;
import java.util.Collection;
import java.util.Iterator;

public final class auk
  extends ats
  implements avw
{
  private MultilineSelectionGroup a;
  
  private final void a()
  {
    Button localButton = q;
    if (!a.b()) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  public final void e()
  {
    a();
  }
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == are.aW)
    {
      paramView = a;
      int i = a;
      if (i >= b)
      {
        int j = b;
        throw new IndexOutOfBoundsException(66 + "Attempted to get option " + i + " but max options is " + j);
      }
      paramView = (String)d[i].getTag();
      ((aul)getActivity()).c(paramView);
      return;
    }
    super.onClick(paramView);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = paramLayoutInflater.getContext().getApplicationContext();
    Object localObject = bam.c(paramBundle);
    paramViewGroup = a(paramLayoutInflater, paramViewGroup, arf.w, getArguments().getString("emailAddress"), true);
    a = ((MultilineSelectionGroup)paramViewGroup.findViewById(are.aG));
    a.a(((Collection)localObject).size());
    a.a(false);
    localObject = ((Collection)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      ban localban = (ban)((Iterator)localObject).next();
      if ((!E) && (bam.c(paramBundle, a)))
      {
        a.a(paramLayoutInflater, i, i + 1, b, null).setTag(a);
        i += 1;
      }
    }
    a.c = this;
    a();
    return paramViewGroup;
  }
  
  public final void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    a.a();
    a();
  }
}

/* Location:
 * Qualified Name:     auk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */