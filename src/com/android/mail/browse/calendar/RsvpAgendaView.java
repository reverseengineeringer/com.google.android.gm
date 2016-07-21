package com.android.mail.browse.calendar;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentUris;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.provider.CalendarContract.Instances;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import btq;
import bze;
import car;
import com.android.mail.browse.MessageHeaderView;
import com.android.mail.providers.Event;
import com.android.mail.providers.Message;
import java.util.TimeZone;

public class RsvpAgendaView
  extends LinearLayout
  implements LoaderManager.LoaderCallbacks<Cursor>, bze
{
  static final String[] a = { "allDay", "begin", "title", "_sync_id", "ownerAccount", "event_id", "selfAttendeeStatus", "startDay", "endDay", "end" };
  public String b;
  public MessageHeaderView c;
  public Message d;
  public LoaderManager e;
  public btq f;
  public Integer g;
  public boolean h;
  
  public RsvpAgendaView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RsvpAgendaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RsvpAgendaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a()
  {
    h = true;
    e.initLoader(g.intValue(), Bundle.EMPTY, this);
  }
  
  public final void a(int paramInt)
  {
    a();
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = TimeZone.getDefault();
    paramInt = car.a(car.a(d.T.d, d.T.b, paramBundle), paramBundle);
    paramBundle = CalendarContract.Instances.CONTENT_BY_DAY_URI.buildUpon();
    ContentUris.appendId(paramBundle, paramInt);
    ContentUris.appendId(paramBundle, paramInt);
    return new CursorLoader(getContext(), paramBundle.build(), a, "visible=1", null, "startDay ASC, allDay DESC, startMinute ASC, endDay ASC, endMinute ASC");
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader) {}
}

/* Location:
 * Qualified Name:     com.android.mail.browse.calendar.RsvpAgendaView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */