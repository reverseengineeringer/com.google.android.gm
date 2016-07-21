package com.google.android.gms.common.images;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import elu;
import elx;
import fnj;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class ImageManager
{
  public static final Object a = new Object();
  public static HashSet<Uri> b = new HashSet();
  private final Context c;
  private final Handler d;
  private final ExecutorService e;
  private final elu f;
  private final fnj g;
  private final Map<elx, ImageManager.ImageReceiver> h;
  private final Map<Uri, ImageManager.ImageReceiver> i;
  private final Map<Uri, Long> j;
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.images.ImageManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */