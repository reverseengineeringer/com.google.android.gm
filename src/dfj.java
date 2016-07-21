import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import java.util.Random;
import java.util.Timer;

public final class dfj
  implements but
{
  private static final Random c = new Random();
  Context a;
  private String b;
  
  public final void a(int paramInt, String paramString)
  {
    if (!buo.b()) {
      return;
    }
    cvm.b("GmailAnalytics", "setCustomDim #%d val=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    czn.b().a(paramInt, paramString);
  }
  
  public final void a(Activity paramActivity)
  {
    int j = 0;
    if (!buo.b()) {}
    czn localczn;
    do
    {
      do
      {
        return;
        cvm.b("GmailAnalytics", "activityStart=%s", new Object[] { paramActivity.getClass().getName() });
        localczn = czn.a();
        localczn.a(paramActivity);
      } while (!a);
      localczn.c();
      if ((!l) && (c == 0))
      {
        int i;
        if (d != 0L)
        {
          i = j;
          if (d > 0L)
          {
            i = j;
            if (i.a() <= e + d) {}
          }
        }
        else
        {
          i = 1;
        }
        if (i != 0) {
          g.a();
        }
      }
      l = true;
      c += 1;
    } while (!b);
    dbm localdbm = g;
    String str1 = paramActivity.getClass().getCanonicalName();
    if (f.containsKey(str1)) {
      paramActivity = (String)f.get(str1);
    }
    for (;;)
    {
      localdbm.c(paramActivity);
      return;
      String str2 = h.a(str1);
      paramActivity = str2;
      if (str2 == null) {
        paramActivity = str1;
      }
      f.put(str1, paramActivity);
    }
  }
  
  public final void a(String paramString)
  {
    if (!buo.b()) {
      return;
    }
    cvm.b("GmailAnalytics", "sendView=%s", new Object[] { paramString });
    czn.b().c(paramString);
  }
  
  public final void a(String paramString1, int paramInt, String paramString2)
  {
    if (!buo.b()) {
      return;
    }
    String str2;
    if (paramInt == buc.x)
    {
      str1 = "archive";
      str2 = str1;
      if (str1 == null)
      {
        if (paramInt != dfy.at) {
          break label995;
        }
        str2 = "delete_ad";
      }
    }
    for (;;)
    {
      a(paramString1, str2, paramString2, 0L);
      return;
      if (paramInt == buc.dP)
      {
        str1 = "remove_folder";
        break;
      }
      if (paramInt == buc.aV)
      {
        str1 = "delete";
        break;
      }
      if (paramInt == buc.ba)
      {
        str1 = "discard_drafts";
        break;
      }
      if (paramInt == buc.bb)
      {
        str1 = "discard_outbox";
        break;
      }
      if (paramInt == buc.cA)
      {
        str1 = "mark important";
        break;
      }
      if (paramInt == buc.cB)
      {
        str1 = "mark not important";
        break;
      }
      if (paramInt == buc.cX)
      {
        str1 = "mute";
        break;
      }
      if (paramInt == buc.ea)
      {
        str1 = "report_spam";
        break;
      }
      if (paramInt == buc.cC)
      {
        str1 = "mark_not_spam";
        break;
      }
      if (paramInt == buc.ai)
      {
        str1 = "compose";
        break;
      }
      if (paramInt == buc.dO)
      {
        str1 = "refresh";
        break;
      }
      if (paramInt == buc.fs)
      {
        str1 = "toggle_drawer";
        break;
      }
      if (paramInt == buc.eG)
      {
        str1 = "settings";
        break;
      }
      if (paramInt == buc.bO)
      {
        str1 = "help";
        break;
      }
      if (paramInt == buc.bx)
      {
        str1 = "feedback";
        break;
      }
      if (paramInt == buc.ah)
      {
        str1 = "clear_search_history";
        break;
      }
      if (paramInt == buc.ag)
      {
        str1 = "clear_picture_approvals";
        break;
      }
      if (paramInt == buc.cT)
      {
        str1 = "move_to";
        break;
      }
      if (paramInt == buc.ac)
      {
        str1 = "change_folders";
        break;
      }
      if (paramInt == buc.cU)
      {
        str1 = "move_to_inbox";
        break;
      }
      if (paramInt == buc.br)
      {
        str1 = "empty_trash";
        break;
      }
      if (paramInt == buc.bp)
      {
        str1 = "empty_spam";
        break;
      }
      if (paramInt == 16908332)
      {
        str1 = "home";
        break;
      }
      if (paramInt == buc.cm)
      {
        str1 = "inside_conversation_unread";
        break;
      }
      if (paramInt == buc.dL)
      {
        str1 = "mark_read";
        break;
      }
      if (paramInt == buc.fx)
      {
        str1 = "mark_unread";
        break;
      }
      if (paramInt == buc.ft)
      {
        str1 = "toggle_read_unread";
        break;
      }
      if (paramInt == buc.eM)
      {
        str1 = "show_original";
        break;
      }
      if (paramInt == buc.o)
      {
        str1 = "add_attachment";
        break;
      }
      if (paramInt == buc.s)
      {
        str1 = "add_file_attachment";
        break;
      }
      if (paramInt == buc.t)
      {
        str1 = "add_photo_attachment";
        break;
      }
      if (paramInt == buc.q)
      {
        str1 = "add_cloud_attachment";
        break;
      }
      if (paramInt == buc.p)
      {
        str1 = "add_cc_bcc";
        break;
      }
      if (paramInt == buc.ei)
      {
        str1 = "save_draft";
        break;
      }
      if (paramInt == buc.eA)
      {
        str1 = "send_message";
        break;
      }
      if (paramInt == buc.aZ)
      {
        str1 = "compose_discard_draft";
        break;
      }
      if (paramInt == buc.ak)
      {
        str1 = "contact_picker";
        break;
      }
      if (paramInt == buc.em)
      {
        str1 = "search";
        break;
      }
      if (paramInt == buc.dx)
      {
        str1 = "print_all";
        break;
      }
      if (paramInt == buc.dz)
      {
        str1 = "print_message";
        break;
      }
      if (paramInt == buc.dZ)
      {
        str1 = "rendering_problem";
        break;
      }
      if (paramInt == buc.dY)
      {
        str1 = "rendering_improvement";
        break;
      }
      if ((paramInt == buc.eX) || (paramInt == buc.u))
      {
        str1 = "star";
        break;
      }
      if (paramInt == buc.dQ)
      {
        str1 = "unstar";
        break;
      }
      if (paramInt == buc.dR)
      {
        str1 = "reply";
        break;
      }
      if (paramInt == buc.dS)
      {
        str1 = "reply_all";
        break;
      }
      if (paramInt == buc.bG)
      {
        str1 = "forward";
        break;
      }
      if (paramInt == buc.bk)
      {
        str1 = "edit_draft";
        break;
      }
      if (paramInt == buc.eB)
      {
        str1 = "expand_message_details";
        break;
      }
      if ((paramInt == buc.aX) || (paramInt == buc.bP))
      {
        str1 = "collapse_message_details";
        break;
      }
      if (paramInt == buc.fC)
      {
        str1 = "message_upper_header";
        break;
      }
      if (paramInt == buc.cD)
      {
        str1 = "download_again";
        break;
      }
      if (paramInt == buc.cF)
      {
        str1 = "photo_save";
        break;
      }
      if (paramInt == buc.cG)
      {
        str1 = "photo_save_all";
        break;
      }
      if (paramInt == buc.cH)
      {
        str1 = "photo_share";
        break;
      }
      if (paramInt == buc.cI)
      {
        str1 = "photo_share_all";
        break;
      }
      if (paramInt == buc.cE)
      {
        str1 = "photo_print";
        break;
      }
      if (paramInt == buc.ej)
      {
        str1 = "photo_save_to_cloud";
        break;
      }
      if (paramInt == buc.eN)
      {
        str1 = "show_pictures";
        break;
      }
      if (paramInt == buc.fA)
      {
        str1 = "unsubscribe";
        break;
      }
      if (paramInt == buc.N)
      {
        str1 = "block_sender";
        break;
      }
      if (paramInt == buc.fv)
      {
        str1 = "unblock_sender";
        break;
      }
      if (paramInt == buc.eF)
      {
        str1 = "set_priority";
        break;
      }
      str1 = null;
      break;
      label995:
      if (paramInt == dfy.cj)
      {
        str2 = "star_ad";
      }
      else if (paramInt == dfy.aG)
      {
        str2 = "forward_ad";
      }
      else if (paramInt == dfy.bk)
      {
        str2 = "manage_accounts";
      }
      else
      {
        if (paramInt != dfy.cf) {
          break label1055;
        }
        str2 = "show_security_details";
      }
    }
    label1055:
    String str1 = String.valueOf(Integer.toHexString(paramInt));
    if (str1.length() != 0) {}
    for (str1 = "0x".concat(str1);; str1 = new String("0x"))
    {
      cvm.f("GmailAnalytics", "unrecognized menu item action: %s. Did you forget to add a new analytics string?", new Object[] { str1 });
      str2 = str1;
      break;
    }
  }
  
  public final void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    if (!buo.b()) {
      return;
    }
    cvm.b("GmailAnalytics", "sendTiming: cat=%s time=%d ms name=%s label=%s", new Object[] { paramString1, Long.valueOf(paramLong), paramString2, paramString3 });
    czn.b().a(paramString1, paramLong, paramString2, paramString3);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (!TextUtils.equals(b, paramString1))
    {
      b = paramString1;
      a("set_account", b(paramString1), paramString2, 0L);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if (!buo.b()) {
      return;
    }
    cvm.b("GmailAnalytics", "sendEvent: cat=%s action=%s label=%s value=%d", new Object[] { paramString1, paramString2, paramString3, Long.valueOf(paramLong) });
    czn.b().a(paramString1, paramString2, paramString3, Long.valueOf(paramLong));
  }
  
  public final boolean a()
  {
    return buo.a().a("sync_errors", 1);
  }
  
  public final boolean a(String paramString, int paramInt)
  {
    int i = paramInt;
    ContentResolver localContentResolver;
    String str;
    if (a != null)
    {
      localContentResolver = a.getContentResolver();
      str = String.valueOf("gmail_analytics_divisor_");
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {
        break label69;
      }
    }
    label69:
    for (paramString = str.concat(paramString);; paramString = new String(str))
    {
      i = ghz.a(localContentResolver, paramString, paramInt);
      if ((i != 0) && (c.nextInt(i) != 0)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public final String b(String paramString)
  {
    String str = cui.b(paramString);
    paramString = dyp.a(paramString, str);
    a(1, paramString);
    return dyp.b(str, paramString);
  }
  
  public final void b(Activity paramActivity)
  {
    if (!buo.b()) {}
    czn localczn;
    do
    {
      do
      {
        return;
        cvm.b("GmailAnalytics", "activityStop=%s", new Object[] { paramActivity.getClass().getName() });
        localczn = czn.a();
        localczn.a(paramActivity);
      } while (!a);
      c -= 1;
      c = Math.max(0, c);
      e = i.a();
    } while (c != 0);
    localczn.c();
    k = new czq(localczn);
    j = new Timer("waitForActivityStart");
    j.schedule(k, 1000L);
  }
  
  public final void b(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    a(paramString1, paramLong * 1000L, paramString2, paramString3);
  }
  
  public final boolean b()
  {
    return buo.a().a("mail_engine_sync", 200);
  }
}

/* Location:
 * Qualified Name:     dfj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */