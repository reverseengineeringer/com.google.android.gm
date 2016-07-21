import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public final class ean
  extends Fragment
{
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i;
    if (getActivity().getIntent().getExtras().getInt("tour-highest-version-seen") == -1)
    {
      i = 1;
      if (i == 0) {
        break label109;
      }
      i = dge.gh;
    }
    for (int j = dge.gg;; j = dge.gi)
    {
      paramBundle = getResources();
      paramLayoutInflater = paramLayoutInflater.inflate(dga.ab, paramViewGroup, false);
      ((TextView)paramLayoutInflater.findViewById(dfy.cF)).setText(paramBundle.getText(i));
      ((TextView)paramLayoutInflater.findViewById(dfy.cE)).setText(paramBundle.getText(j));
      rg.c(paramLayoutInflater.findViewById(dfy.aH), 2);
      return paramLayoutInflater;
      i = 0;
      break;
      label109:
      i = dge.gj;
    }
  }
}

/* Location:
 * Qualified Name:     ean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */