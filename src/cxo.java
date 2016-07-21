import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader.OnLoadCompleteListener;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.DateUtils;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class cxo
  implements Loader.OnLoadCompleteListener<Cursor>, RemoteViewsService.RemoteViewsFactory
{
  CursorLoader a;
  private final Context b;
  private final bzn c;
  private final int d;
  private final Account e;
  private final int f;
  private final int g;
  private final Uri h;
  private final Uri i;
  private final String j;
  private final cxk k;
  private CursorLoader l;
  private Cursor m;
  private CursorLoader n;
  private cxp o;
  private int p;
  private boolean q;
  private boolean r = false;
  private final cxn s;
  private String t;
  private String u;
  
  public cxo(Context paramContext, Intent paramIntent, cxn paramcxn)
  {
    b = paramContext;
    c = new bzn(paramContext);
    d = paramIntent.getIntExtra("appWidgetId", 0);
    e = Account.a(paramIntent.getStringExtra("account"));
    f = paramIntent.getIntExtra("folder-type", 1);
    g = paramIntent.getIntExtra("folder-capabilities", 0);
    j = paramIntent.getStringExtra("folder-display-name");
    Uri localUri1 = (Uri)paramIntent.getParcelableExtra("folder-uri");
    Uri localUri2 = (Uri)paramIntent.getParcelableExtra("folder-conversation-list-uri");
    if ((localUri1 != null) && (localUri2 != null))
    {
      h = localUri1;
      i = localUri2;
    }
    for (;;)
    {
      k = new cxk(paramContext);
      s = paramcxn;
      return;
      paramIntent = Folder.a(paramIntent.getStringExtra("folder"));
      if (paramIntent != null)
      {
        h = c.b;
        i = h;
      }
      else
      {
        h = Uri.EMPTY;
        i = Uri.EMPTY;
        cxi.a(b, d, e, f, g, h, i, j);
      }
    }
  }
  
  private final int a()
  {
    for (;;)
    {
      synchronized (cxn.a)
      {
        if (m != null)
        {
          i1 = m.getCount();
          i1 = Math.min(i1, 25);
          return i1;
        }
      }
      int i1 = 0;
    }
  }
  
  private static SpannableString a(CharacterStyle[] paramArrayOfCharacterStyle, CharSequence paramCharSequence)
  {
    paramCharSequence = new SpannableString(paramCharSequence);
    if ((paramArrayOfCharacterStyle != null) && (paramArrayOfCharacterStyle.length > 0)) {
      paramCharSequence.setSpan(paramArrayOfCharacterStyle[0], 0, paramCharSequence.length(), 0);
    }
    return paramCharSequence;
  }
  
  private final SpannableStringBuilder a(List<SpannableString> paramList)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (Folder.e(g)) {
      localSpannableStringBuilder.append(bzt.a(c));
    }
    for (int i1 = 1;; i1 = 0)
    {
      Iterator localIterator = paramList.iterator();
      paramList = null;
      while (localIterator.hasNext())
      {
        SpannableString localSpannableString = (SpannableString)localIterator.next();
        if (localSpannableString == null)
        {
          cvm.e(cxn.b, "null sender while iterating over styledSenders", new Object[0]);
        }
        else
        {
          CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])localSpannableString.getSpans(0, localSpannableString.length(), CharacterStyle.class);
          String str1;
          if (c.D.equals(localSpannableString.toString()))
          {
            paramList = u;
            str1 = String.valueOf(localSpannableString);
            String str2 = u;
            paramList = a(arrayOfCharacterStyle, String.valueOf(paramList).length() + 0 + String.valueOf(str1).length() + String.valueOf(str2).length() + paramList + str1 + str2);
          }
          for (;;)
          {
            localSpannableStringBuilder.append(paramList);
            paramList = localSpannableString;
            break;
            if ((i1 == 0) && (localSpannableStringBuilder.length() > 0) && ((paramList == null) || (!c.D.equals(paramList.toString()))))
            {
              paramList = t;
              str1 = String.valueOf(localSpannableString);
              paramList = a(arrayOfCharacterStyle, String.valueOf(paramList).length() + 0 + String.valueOf(str1).length() + paramList + str1);
            }
            else
            {
              i1 = 0;
              paramList = localSpannableString;
            }
          }
        }
      }
      return localSpannableStringBuilder;
    }
  }
  
  private static boolean a(Cursor paramCursor)
  {
    return (paramCursor != null) && (!paramCursor.isClosed()) && (paramCursor.moveToFirst());
  }
  
  private final RemoteViews b()
  {
    RemoteViews localRemoteViews = new RemoteViews(b.getPackageName(), bue.au);
    Intent localIntent = cxa.a(b, h, e);
    localIntent.putExtra("from-widget", true);
    localRemoteViews.setTextViewText(buc.ct, b.getText(buj.fE));
    localRemoteViews.setOnClickFillInIntent(buc.fZ, localIntent);
    return localRemoteViews;
  }
  
  public final int getCount()
  {
    int i2 = 1;
    for (;;)
    {
      synchronized (cxn.a)
      {
        int i3 = a();
        if (m == null) {
          break label84;
        }
        i1 = m.getCount();
        if (i3 >= i1)
        {
          if (i3 >= p) {
            break label89;
          }
          break label78;
          q = bool;
          if (!q) {
            break label95;
          }
          i1 = i2;
          return i1 + i3;
        }
      }
      label78:
      boolean bool = true;
      continue;
      label84:
      int i1 = 0;
      continue;
      label89:
      bool = false;
      continue;
      label95:
      i1 = 0;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final RemoteViews getLoadingView()
  {
    RemoteViews localRemoteViews = new RemoteViews(b.getPackageName(), bue.au);
    localRemoteViews.setTextViewText(buc.ct, b.getText(buj.cR));
    return localRemoteViews;
  }
  
  public final RemoteViews getViewAt(int paramInt)
  {
    synchronized (cxn.a)
    {
      RemoteViews localRemoteViews;
      if ((m == null) || (m.isClosed()) || ((q) && (paramInt >= a())))
      {
        localRemoteViews = b();
        return localRemoteViews;
      }
      if (!m.moveToPosition(paramInt))
      {
        cvm.e(cxn.b, "Failed to move to position %d in the cursor.", new Object[] { Integer.valueOf(paramInt) });
        localRemoteViews = b();
        return localRemoteViews;
      }
    }
    Object localObject3 = new Conversation(m);
    Object localObject4 = new ArrayList();
    bzt.a(c, t, "", 25, (ArrayList)localObject4, null, null, e, Folder.e(g));
    localObject4 = a((List)localObject4);
    Object localObject7 = DateUtils.getRelativeTimeSpanString(b, e);
    int i1;
    cxk localcxk;
    Context localContext;
    cus localcus;
    Object localObject8;
    if ((f & 0x2) != 0)
    {
      i1 = 2;
      localcxk = k;
      localContext = b;
      localcus = new cus(h);
      localObject8 = ConversationItemView.a(b, d);
      if (j) {
        break label765;
      }
    }
    label377:
    label464:
    label543:
    label694:
    label701:
    label716:
    label765:
    for (paramInt = 1;; paramInt = 0)
    {
      Object localObject6 = ((Conversation)localObject3).d();
      Object localObject5 = localContext.getResources();
      int i4 = ((Resources)localObject5).getDimensionPixelSize(bua.af);
      int i3 = ((Resources)localObject5).getDimensionPixelSize(bua.ag);
      int i2;
      if (paramInt != 0)
      {
        i2 = cxk.e;
        localObject5 = cxk.a((CharSequence)localObject7, i4, i2);
        if (paramInt != 0) {
          ((SpannableStringBuilder)localObject5).setSpan(new StyleSpan(1), 0, ((CharSequence)localObject7).length(), 33);
        }
        localObject7 = Conversation.a(localContext, null, (String)localObject8);
        localObject8 = new SpannableStringBuilder((CharSequence)localObject7);
        if (paramInt != 0) {
          ((SpannableStringBuilder)localObject8).setSpan(new StyleSpan(1), 0, ((String)localObject7).length(), 33);
        }
        if (paramInt == 0) {
          break label694;
        }
        paramInt = cxk.b;
        ((SpannableStringBuilder)localObject8).setSpan(new ForegroundColorSpan(paramInt), 0, ((SpannableStringBuilder)localObject8).length(), 33);
        localObject7 = cxk.a((CharSequence)localObject8, i3, 0);
        localObject6 = new SpannableStringBuilder((CharSequence)localObject6);
        ((SpannableStringBuilder)localObject6).setSpan(new ForegroundColorSpan(cxk.c), 0, ((SpannableStringBuilder)localObject6).length(), 33);
        localObject8 = cxk.a((CharSequence)localObject6, i3, 0);
        if (!((Conversation)localObject3).c()) {
          break label701;
        }
        paramInt = bub.U;
        localObject6 = new RemoteViews(localContext.getPackageName(), bue.at);
        ((RemoteViews)localObject6).setTextViewText(buc.gb, (CharSequence)localObject4);
        ((RemoteViews)localObject6).setTextViewText(buc.fS, (CharSequence)localObject5);
        ((RemoteViews)localObject6).setTextViewText(buc.gd, (CharSequence)localObject7);
        ((RemoteViews)localObject6).setTextViewText(buc.gc, (CharSequence)localObject8);
        if (paramInt == 0) {
          break label716;
        }
        ((RemoteViews)localObject6).setViewVisibility(buc.fO, 0);
        ((RemoteViews)localObject6).setImageViewResource(buc.fO, paramInt);
        if (localContext.getResources().getBoolean(bty.b))
        {
          f = new cxl(localContext);
          f.a((Conversation)localObject3, localcus, i1);
          f.a((RemoteViews)localObject6);
        }
        switch (m)
        {
        }
      }
      for (;;)
      {
        ((RemoteViews)localObject6).setImageViewResource(buc.ga, paramInt);
        ((RemoteViews)localObject6).setViewVisibility(buc.ga, i1);
        localObject3 = cxa.a(b, (Conversation)localObject3, h, e);
        ((Intent)localObject3).putExtra("from-widget", true);
        ((RemoteViews)localObject6).setOnClickFillInIntent(buc.fR, (Intent)localObject3);
        return (RemoteViews)localObject6;
        i2 = cxk.d;
        break;
        paramInt = cxk.a;
        break label377;
        if (f)
        {
          paramInt = bub.aC;
          break label464;
          ((RemoteViews)localObject6).setViewVisibility(buc.fO, 8);
          break label543;
          paramInt = bub.aA;
          i1 = 0;
          continue;
          paramInt = bub.aI;
          i1 = 0;
          continue;
        }
        paramInt = 0;
        break label464;
        paramInt = -1;
        i1 = 8;
      }
      i1 = -1;
      break;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final boolean hasStableIds()
  {
    return false;
  }
  
  public final void onCreate()
  {
    cxn.a(b, d, e, h.toString());
    if (!s.a(b, d, e)) {
      cxi.a(b, d, e, f, g, h, i, j);
    }
    r = false;
    Uri localUri = i.buildUpon().appendQueryParameter("limit", Integer.toString(25)).appendQueryParameter("use_network", Boolean.FALSE.toString()).appendQueryParameter("all_notifications", Boolean.TRUE.toString()).build();
    Resources localResources = b.getResources();
    l = new CursorLoader(b, localUri, chh.k, null, null, null);
    l.registerListener(1, this);
    l.setUpdateThrottle(localResources.getInteger(bud.L));
    l.startLoading();
    t = localResources.getString(buj.eF);
    u = localResources.getString(buj.bt);
    a = new CursorLoader(b, h, chh.i, null, null, null);
    a.registerListener(0, this);
    o = new cxp(this, localResources.getInteger(bud.K));
    o.a();
    n = new CursorLoader(b, e.g, chh.d, null, null, null);
    n.registerListener(2, this);
    n.startLoading();
  }
  
  public final void onDataSetChanged()
  {
    o.a();
  }
  
  public final void onDestroy()
  {
    synchronized (cxn.a)
    {
      if (l != null)
      {
        l.reset();
        l.unregisterListener(this);
        l = null;
      }
      m = null;
      if (a != null)
      {
        a.reset();
        a.unregisterListener(this);
        a = null;
      }
      if (n != null)
      {
        n.reset();
        n.unregisterListener(this);
        n = null;
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     cxo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */