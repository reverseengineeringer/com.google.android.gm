import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import com.android.mail.browse.ConversationMessage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

public class cah
  implements MenuItem.OnMenuItemClickListener, View.OnCreateContextMenuListener
{
  final Activity a;
  public cak b;
  private final byh c;
  private final boolean d;
  private final boolean e;
  
  public cah(Activity paramActivity, byh parambyh)
  {
    a = paramActivity;
    c = parambyh;
    paramActivity = a.getPackageManager();
    if (!paramActivity.queryIntentActivities(new Intent("android.intent.action.DIAL", Uri.parse("tel:")), 65536).isEmpty())
    {
      bool1 = true;
      d = bool1;
      if (paramActivity.queryIntentActivities(new Intent("android.intent.action.SENDTO", Uri.parse("smsto:")), 65536).isEmpty()) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      e = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  private static int a(int paramInt)
  {
    switch (cai.a[(paramInt - 1)])
    {
    default: 
      throw new IllegalStateException("Unexpected MenuType");
    case 1: 
      return buc.de;
    case 2: 
      return buc.aM;
    case 3: 
      return buc.eH;
    case 4: 
      return buc.aY;
    case 5: 
      return buc.eP;
    case 6: 
      return buc.r;
    case 7: 
      return buc.aO;
    case 8: 
      return buc.bl;
    case 9: 
      return buc.aN;
    case 10: 
      return buc.cz;
    }
    return buc.aL;
  }
  
  private final void a(String paramString, ContextMenu paramContextMenu)
  {
    MenuItem localMenuItem = paramContextMenu.findItem(a(cam.c));
    PackageManager localPackageManager = a.getPackageManager();
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    if (localPackageManager.resolveActivity(localIntent, 65536) != null) {}
    for (boolean bool = true;; bool = false)
    {
      localMenuItem.setVisible(bool);
      paramContextMenu.setHeaderTitle(paramString);
      paramContextMenu.findItem(a(cam.b)).setOnMenuItemClickListener(new cal(this, paramString, "copy_link"));
      paramContextMenu.findItem(a(cam.a)).setOnMenuItemClickListener(new can(this, new Intent("android.intent.action.VIEW", Uri.parse(paramString)), "open_link"));
      paramContextMenu.findItem(a(cam.c)).setOnMenuItemClickListener(new cao(this, paramString, "share_link"));
      return;
    }
  }
  
  private final void b(String paramString, ContextMenu paramContextMenu)
  {
    if (b != null) {}
    for (ConversationMessage localConversationMessage = b.b(paramString); localConversationMessage == null; localConversationMessage = null)
    {
      paramContextMenu.setGroupVisible(buc.d, false);
      return;
    }
    paramString = c.a(a, paramString, localConversationMessage);
    if (paramString == null)
    {
      paramContextMenu.setGroupVisible(buc.d, false);
      return;
    }
    paramContextMenu.findItem(buc.fI).setOnMenuItemClickListener(new can(this, paramString, "view_image"));
    paramContextMenu.setGroupVisible(buc.d, true);
  }
  
  public boolean a(WebView.HitTestResult paramHitTestResult)
  {
    return paramHitTestResult != null;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    boolean bool2 = true;
    paramView = ((WebView)paramView).getHitTestResult();
    if (!a(paramView)) {
      return;
    }
    int j = paramView.getType();
    switch (j)
    {
    default: 
      a.getMenuInflater().inflate(buf.p, paramContextMenu);
      i = 0;
    }
    while (i < paramContextMenu.size())
    {
      paramContextMenu.getItem(i).setOnMenuItemClickListener(this);
      i += 1;
      continue;
      buo.a().a("web_context_menu", "long_press", "unknown", 0L);
      return;
      buo.a().a("web_context_menu", "long_press", "edit_text", 0L);
      return;
    }
    String str1 = paramView.getExtra();
    int i = buc.e;
    if (j == 2)
    {
      bool1 = true;
      label164:
      paramContextMenu.setGroupVisible(i, bool1);
      i = buc.b;
      if (j != 4) {
        break label659;
      }
      bool1 = true;
      label188:
      paramContextMenu.setGroupVisible(i, bool1);
      i = buc.c;
      if (j != 3) {
        break label665;
      }
      bool1 = true;
      label212:
      paramContextMenu.setGroupVisible(i, bool1);
      i = buc.a;
      if ((j != 7) && (j != 8)) {
        break label671;
      }
      bool1 = true;
      label244:
      paramContextMenu.setGroupVisible(i, bool1);
      i = buc.d;
      bool1 = bool2;
      if (j != 5) {
        if (j != 8) {
          break label677;
        }
      }
    }
    label659:
    label665:
    label671:
    label677:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramContextMenu.setGroupVisible(i, bool1);
      switch (j)
      {
      case 6: 
      default: 
        return;
      case 2: 
        buo.a().a("web_context_menu", "long_press", "phone", 0L);
        try
        {
          paramContextMenuInfo = URLDecoder.decode(str1, Charset.defaultCharset().name());
          paramView = paramContextMenuInfo;
          if (paramContextMenuInfo.startsWith(" "))
          {
            paramView = paramContextMenuInfo;
            if (!paramContextMenuInfo.startsWith("  ")) {
              paramView = paramContextMenuInfo.replaceFirst(" ", "+");
            }
          }
        }
        catch (UnsupportedEncodingException paramView)
        {
          for (;;)
          {
            String str2;
            paramView = str1;
            continue;
            paramContextMenuInfo = new String(paramContextMenuInfo);
            continue;
            ((MenuItem)localObject).setVisible(false);
            continue;
            paramContextMenuInfo = new String("smsto:");
            continue;
            ((MenuItem)localObject).setVisible(false);
          }
        }
        paramContextMenu.setHeaderTitle(paramView);
        localObject = paramContextMenu.findItem(a(cam.d));
        if (!d) {
          break label702;
        }
        paramContextMenuInfo = String.valueOf("tel:");
        str2 = String.valueOf(str1);
        if (str2.length() == 0) {
          break label690;
        }
        paramContextMenuInfo = paramContextMenuInfo.concat(str2);
        ((MenuItem)localObject).setOnMenuItemClickListener(new can(this, new Intent("android.intent.action.DIAL", Uri.parse(paramContextMenuInfo)), "dial"));
        localObject = paramContextMenu.findItem(a(cam.e));
        if (!e) {
          break label727;
        }
        paramContextMenuInfo = String.valueOf(str1);
        if (paramContextMenuInfo.length() == 0) {
          break label714;
        }
        paramContextMenuInfo = "smsto:".concat(paramContextMenuInfo);
        ((MenuItem)localObject).setOnMenuItemClickListener(new can(this, new Intent("android.intent.action.SENDTO", Uri.parse(paramContextMenuInfo)), "sms"));
        paramContextMenuInfo = new Intent("android.intent.action.INSERT_OR_EDIT");
        paramContextMenuInfo.setType("vnd.android.cursor.item/contact");
        paramContextMenuInfo.putExtra("phone", paramView);
        paramContextMenu.findItem(a(cam.f)).setOnMenuItemClickListener(new can(this, paramContextMenuInfo, "add_contact"));
        paramContextMenu.findItem(a(cam.g)).setOnMenuItemClickListener(new cal(this, str1, "copy_phone"));
        return;
        bool1 = false;
        break label164;
        bool1 = false;
        break label188;
        bool1 = false;
        break label212;
        bool1 = false;
        break label244;
      }
    }
    label690:
    label702:
    label714:
    label727:
    buo.a().a("web_context_menu", "long_press", "email", 0L);
    paramContextMenu.setHeaderTitle(str1);
    paramView = String.valueOf("mailto:");
    paramContextMenuInfo = String.valueOf(str1);
    if (paramContextMenuInfo.length() != 0) {}
    for (paramView = paramView.concat(paramContextMenuInfo);; paramView = new String(paramView))
    {
      paramView = new Intent("android.intent.action.VIEW", Uri.parse(paramView));
      paramContextMenu.findItem(a(cam.h)).setOnMenuItemClickListener(new can(this, paramView, "send_email"));
      paramContextMenu.findItem(a(cam.i)).setOnMenuItemClickListener(new cal(this, str1, "copy_email"));
      return;
    }
    buo.a().a("web_context_menu", "long_press", "geo", 0L);
    paramContextMenu.setHeaderTitle(str1);
    paramView = "";
    try
    {
      paramContextMenuInfo = URLEncoder.encode(str1, Charset.defaultCharset().name());
      paramView = paramContextMenuInfo;
    }
    catch (UnsupportedEncodingException paramContextMenuInfo)
    {
      for (;;) {}
    }
    paramContextMenuInfo = paramContextMenu.findItem(a(cam.j));
    Object localObject = String.valueOf("geo:0,0?q=");
    paramView = String.valueOf(paramView);
    if (paramView.length() != 0) {}
    for (paramView = ((String)localObject).concat(paramView);; paramView = new String((String)localObject))
    {
      paramContextMenuInfo.setOnMenuItemClickListener(new can(this, new Intent("android.intent.action.VIEW", Uri.parse(paramView)), "view_map"));
      paramContextMenu.findItem(a(cam.k)).setOnMenuItemClickListener(new cal(this, str1, "copy_geo"));
      return;
    }
    buo.a().a("web_context_menu", "long_press", "src_anchor", 0L);
    a(str1, paramContextMenu);
    return;
    buo.a().a("web_context_menu", "long_press", "src_image_anchor", 0L);
    a(str1, paramContextMenu);
    b(str1, paramContextMenu);
    return;
    buo.a().a("web_context_menu", "long_press", "image", 0L);
    b(str1, paramContextMenu);
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return a.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:
 * Qualified Name:     cah
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */