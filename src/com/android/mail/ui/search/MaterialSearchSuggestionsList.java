package com.android.mail.ui.search;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import buc;
import buo;
import but;
import cro;
import crq;
import crr;
import java.util.List;

public class MaterialSearchSuggestionsList
  extends LinearLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  public crr a;
  public String b;
  public ListView c;
  public cro d;
  
  public MaterialSearchSuggestionsList(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialSearchSuggestionsList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(String paramString)
  {
    if ((d != null) && (!TextUtils.equals(b, paramString)))
    {
      b = paramString;
      d.a(paramString);
    }
  }
  
  public void onClick(View paramView)
  {
    a.a(2, true);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    c = ((ListView)findViewById(buc.eu));
    c.setOnItemClickListener(this);
    if (d != null) {
      c.setAdapter(d);
    }
    findViewById(buc.et).setOnClickListener(this);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a.b();
    buo.a().b("search", paramInt, "clicked_suggestion_index", paramAdapterView);
    buo.a().a("search", "search_source", String.valueOf(paramAdapterView).concat("_suggestion"), 0L);
    a.a(d.d.get(paramInt)).a, "suggestion");
  }
  
  public void setVisibility(int paramInt)
  {
    if ((!isShown()) && (paramInt == 0)) {
      a(b);
    }
    super.setVisibility(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.search.MaterialSearchSuggestionsList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */