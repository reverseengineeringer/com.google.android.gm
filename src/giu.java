import java.util.List;

public final class giu
{
  public static final gis A = new gip("/search");
  public static final gis B = new gip("/(document|spreadsheets|presentation)/?");
  public static final gis C = new gip("/(m?|my-drive)");
  public static final List<gis> D = new heh().c(a).a();
  public static final List<gis> E = new heh().c(b).c(c).c(d).c(e).c(f).c(g).c(h).c(i).c(j).c(k).b(D).c(l).c(m).c(n).c(o).c(p).c(q).c(r).c(s).c(t).c(u).c(v).c(w).c(x).c(y).c(z).c(C).c(A).c(B).a();
  public static final gis a = new giq("(/spreadsheet)?/(m|ccc|lv)", "key");
  public static final gis b = new gio("/(?:document|presentation)/d/([^/]+)/pub(?:$|\\?)", 1);
  public static final gis c = new gio("/spreadsheets/d/([^/]+)/pubhtml", 1);
  public static final gis d = new giq("/document/(m|edit|view)", "id");
  public static final gis e = new gio("/document/d/([^/]*).*", 1);
  public static final gis f = new giv("/(Doc|View)");
  public static final gis g = new giq("/presentation/askquestion", "qanda_s");
  public static final gis h = new giq("/(present|presentation)/(view|edit)", "id");
  public static final gis i = new gio("/presentation/d/([^/]*)(?:/askquestion\\b).*", 1);
  public static final gis j = new gio("/presentation/d/([^/]*).*", 1);
  public static final gis k = new giq("/drawings/(view|edit)", "id");
  public static final gis l = new gio("/spreadsheets/d/([^/]*)/.*", 1);
  public static final gis m = new gio("/forms/d/([^/]*).*", 1);
  public static final gis n = new giq("/folderview$", "id");
  public static final gis o = new gio("/folder/d/([^/]*).*", 1);
  public static final gis p = new gio("(?:/u/\\d+)?/folders/(?:.*/)*(.*)", 1);
  public static final gis q = new giw("^folders(/([^/]+))*(/([^/]+))");
  public static final gis r = new gio("/file/d/([^/]*).*", 1);
  public static final gis s = new giq("/(leaf|uc)", "id");
  public static final gis t = new giq("/open", "id");
  public static final gis u = new gix("/viewer", "srcid");
  public static final gis v = new gip("/(?:shared-with-me|incoming)");
  public static final gis w = new gip("/photos");
  public static final gis x = new gip("/recent");
  public static final gis y = new gip("/starred");
  public static final gis z = new gip("/trash");
}

/* Location:
 * Qualified Name:     giu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */