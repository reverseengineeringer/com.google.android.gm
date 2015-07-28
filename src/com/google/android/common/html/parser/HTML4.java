package com.google.android.common.html.parser;

import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class HTML4
{
  public static final HTML.Attribute ABBR_ATTRIBUTE;
  public static final HTML.Element ABBR_ELEMENT;
  public static final HTML.Attribute ACCEPT_ATTRIBUTE;
  public static final HTML.Attribute ACCEPT_CHARSET_ATTRIBUTE;
  public static final HTML.Attribute ACCESSKEY_ATTRIBUTE;
  public static final HTML.Element ACRONYM_ELEMENT;
  public static final HTML.Attribute ACTION_ATTRIBUTE;
  public static final HTML.Element ADDRESS_ELEMENT;
  public static final HTML.Attribute ALIGN_ATTRIBUTE;
  public static final HTML.Attribute ALINK_ATTRIBUTE;
  public static final HTML.Attribute ALT_ATTRIBUTE;
  public static final HTML.Element APPLET_ELEMENT;
  public static final HTML.Attribute ARCHIVE_ATTRIBUTE;
  public static final HTML.Element AREA_ELEMENT;
  public static final HTML.Attribute AXIS_ATTRIBUTE;
  public static final HTML.Element A_ELEMENT;
  public static final HTML.Attribute BACKGROUND_ATTRIBUTE;
  public static final HTML.Element BASEFONT_ELEMENT;
  public static final HTML.Element BASE_ELEMENT;
  public static final HTML.Element BDO_ELEMENT;
  public static final HTML.Attribute BGCOLOR_ATTRIBUTE;
  public static final HTML.Element BIG_ELEMENT;
  public static final HTML.Element BLOCKQUOTE_ELEMENT;
  public static final HTML.Element BODY_ELEMENT;
  public static final HTML.Attribute BORDER_ATTRIBUTE;
  public static final HTML.Element BR_ELEMENT;
  public static final HTML.Element BUTTON_ELEMENT;
  public static final HTML.Element B_ELEMENT;
  public static final HTML.Element CAPTION_ELEMENT;
  public static final HTML.Attribute CELLPADDING_ATTRIBUTE;
  public static final HTML.Attribute CELLSPACING_ATTRIBUTE;
  public static final HTML.Element CENTER_ELEMENT;
  public static final HTML.Attribute CHAROFF_ATTRIBUTE;
  public static final HTML.Attribute CHARSET_ATTRIBUTE;
  public static final HTML.Attribute CHAR_ATTRIBUTE;
  public static final HTML.Attribute CHECKED_ATTRIBUTE;
  public static final HTML.Attribute CITE_ATTRIBUTE;
  public static final HTML.Element CITE_ELEMENT;
  public static final HTML.Attribute CLASSID_ATTRIBUTE;
  public static final HTML.Attribute CLASS_ATTRIBUTE;
  public static final HTML.Attribute CLEAR_ATTRIBUTE;
  public static final HTML.Attribute CODEBASE_ATTRIBUTE;
  public static final HTML.Attribute CODETYPE_ATTRIBUTE;
  public static final HTML.Attribute CODE_ATTRIBUTE;
  public static final HTML.Element CODE_ELEMENT;
  public static final HTML.Element COLGROUP_ELEMENT;
  public static final HTML.Attribute COLOR_ATTRIBUTE;
  public static final HTML.Attribute COLSPAN_ATTRIBUTE;
  public static final HTML.Attribute COLS_ATTRIBUTE;
  public static final HTML.Element COL_ELEMENT;
  public static final HTML.Attribute COMPACT_ATTRIBUTE;
  public static final HTML.Attribute CONTENT_ATTRIBUTE;
  public static final HTML.Attribute COORDS_ATTRIBUTE;
  public static final HTML.Attribute DATA_ATTRIBUTE;
  public static final HTML.Attribute DATETIME_ATTRIBUTE;
  public static final HTML.Element DD_ELEMENT;
  public static final HTML.Attribute DECLARE_ATTRIBUTE;
  public static final HTML.Attribute DEFER_ATTRIBUTE;
  public static final HTML.Element DEL_ELEMENT;
  public static final HTML.Element DFN_ELEMENT;
  public static final HTML.Attribute DIR_ATTRIBUTE;
  public static final HTML.Element DIR_ELEMENT;
  public static final HTML.Attribute DISABLED_ATTRIBUTE;
  public static final HTML.Element DIV_ELEMENT;
  public static final HTML.Element DL_ELEMENT;
  public static final HTML.Element DT_ELEMENT;
  public static final HTML.Element EM_ELEMENT;
  public static final HTML.Attribute ENCTYPE_ATTRIBUTE;
  public static final HTML.Attribute FACE_ATTRIBUTE;
  public static final HTML.Element FIELDSET_ELEMENT;
  public static final HTML.Element FONT_ELEMENT;
  public static final HTML.Element FORM_ELEMENT;
  public static final HTML.Attribute FOR_ATTRIBUTE;
  public static final HTML.Attribute FRAMEBORDER_ATTRIBUTE;
  public static final HTML.Element FRAMESET_ELEMENT;
  public static final HTML.Attribute FRAME_ATTRIBUTE;
  public static final HTML.Element FRAME_ELEMENT;
  public static final HTML.Element H1_ELEMENT;
  public static final HTML.Element H2_ELEMENT;
  public static final HTML.Element H3_ELEMENT;
  public static final HTML.Element H4_ELEMENT;
  public static final HTML.Element H5_ELEMENT;
  public static final HTML.Element H6_ELEMENT;
  public static final HTML.Attribute HEADERS_ATTRIBUTE;
  public static final HTML.Element HEAD_ELEMENT;
  public static final HTML.Attribute HEIGHT_ATTRIBUTE;
  public static final HTML.Attribute HREFLANG_ATTRIBUTE;
  public static final HTML.Attribute HREF_ATTRIBUTE;
  public static final HTML.Element HR_ELEMENT;
  public static final HTML.Attribute HSPACE_ATTRIBUTE;
  public static final HTML.Element HTML_ELEMENT;
  public static final HTML.Attribute HTTP_EQUIV_ATTRIBUTE;
  public static final HTML.Attribute ID_ATTRIBUTE;
  public static final HTML.Element IFRAME_ELEMENT;
  public static final HTML.Element IMG_ELEMENT;
  public static final HTML.Element INPUT_ELEMENT;
  public static final HTML.Element INS_ELEMENT;
  public static final HTML.Element ISINDEX_ELEMENT;
  public static final HTML.Attribute ISMAP_ATTRIBUTE;
  public static final HTML.Element I_ELEMENT;
  public static final HTML.Element KBD_ELEMENT;
  public static final HTML.Attribute LABEL_ATTRIBUTE;
  public static final HTML.Element LABEL_ELEMENT;
  public static final HTML.Attribute LANGUAGE_ATTRIBUTE;
  public static final HTML.Attribute LANG_ATTRIBUTE;
  public static final HTML.Element LEGEND_ELEMENT;
  public static final HTML.Attribute LINK_ATTRIBUTE;
  public static final HTML.Element LINK_ELEMENT;
  public static final HTML.Element LI_ELEMENT;
  public static final HTML.Attribute LONGDESC_ATTRIBUTE;
  public static final HTML.Element MAP_ELEMENT;
  public static final HTML.Attribute MARGINHEIGHT_ATTRIBUTE;
  public static final HTML.Attribute MARGINWIDTH_ATTRIBUTE;
  public static final HTML.Attribute MAXLENGTH_ATTRIBUTE;
  public static final HTML.Attribute MEDIA_ATTRIBUTE;
  public static final HTML.Element MENU_ELEMENT;
  public static final HTML.Element META_ELEMENT;
  public static final HTML.Attribute METHOD_ATTRIBUTE;
  public static final HTML.Attribute MULTIPLE_ATTRIBUTE;
  public static final HTML.Attribute NAME_ATTRIBUTE;
  public static final HTML.Element NOFRAMES_ELEMENT;
  public static final HTML.Attribute NOHREF_ATTRIBUTE;
  public static final HTML.Attribute NORESIZE_ATTRIBUTE;
  public static final HTML.Element NOSCRIPT_ELEMENT;
  public static final HTML.Attribute NOSHADE_ATTRIBUTE;
  public static final HTML.Attribute NOWRAP_ATTRIBUTE;
  public static final HTML.Attribute OBJECT_ATTRIBUTE;
  public static final HTML.Element OBJECT_ELEMENT;
  public static final HTML.Element OL_ELEMENT;
  public static final HTML.Attribute ONBLUR_ATTRIBUTE;
  public static final HTML.Attribute ONCHANGE_ATTRIBUTE;
  public static final HTML.Attribute ONCLICK_ATTRIBUTE;
  public static final HTML.Attribute ONDBLCLICK_ATTRIBUTE;
  public static final HTML.Attribute ONFOCUS_ATTRIBUTE;
  public static final HTML.Attribute ONKEYDOWN_ATTRIBUTE;
  public static final HTML.Attribute ONKEYPRESS_ATTRIBUTE;
  public static final HTML.Attribute ONKEYUP_ATTRIBUTE;
  public static final HTML.Attribute ONLOAD_ATTRIBUTE;
  public static final HTML.Attribute ONMOUSEDOWN_ATTRIBUTE;
  public static final HTML.Attribute ONMOUSEMOVE_ATTRIBUTE;
  public static final HTML.Attribute ONMOUSEOUT_ATTRIBUTE;
  public static final HTML.Attribute ONMOUSEOVER_ATTRIBUTE;
  public static final HTML.Attribute ONMOUSEUP_ATTRIBUTE;
  public static final HTML.Attribute ONRESET_ATTRIBUTE;
  public static final HTML.Attribute ONSELECT_ATTRIBUTE;
  public static final HTML.Attribute ONSUBMIT_ATTRIBUTE;
  public static final HTML.Attribute ONUNLOAD_ATTRIBUTE;
  public static final HTML.Element OPTGROUP_ELEMENT;
  public static final HTML.Element OPTION_ELEMENT;
  public static final HTML.Element PARAM_ELEMENT;
  public static final HTML.Element PRE_ELEMENT;
  public static final HTML.Attribute PROFILE_ATTRIBUTE;
  public static final HTML.Attribute PROMPT_ATTRIBUTE;
  public static final HTML.Element P_ELEMENT;
  public static final HTML.Element Q_ELEMENT;
  public static final HTML.Attribute READONLY_ATTRIBUTE;
  public static final HTML.Attribute REL_ATTRIBUTE;
  public static final HTML.Attribute REV_ATTRIBUTE;
  public static final HTML.Attribute ROWSPAN_ATTRIBUTE;
  public static final HTML.Attribute ROWS_ATTRIBUTE;
  public static final HTML.Attribute RULES_ATTRIBUTE;
  public static final HTML.Element SAMP_ELEMENT;
  public static final HTML.Attribute SCHEME_ATTRIBUTE;
  public static final HTML.Attribute SCOPE_ATTRIBUTE;
  public static final HTML.Element SCRIPT_ELEMENT;
  public static final HTML.Attribute SCROLLING_ATTRIBUTE;
  public static final HTML.Attribute SELECTED_ATTRIBUTE;
  public static final HTML.Element SELECT_ELEMENT;
  public static final HTML.Attribute SHAPE_ATTRIBUTE;
  public static final HTML.Attribute SIZE_ATTRIBUTE;
  public static final HTML.Element SMALL_ELEMENT;
  public static final HTML.Attribute SPAN_ATTRIBUTE;
  public static final HTML.Element SPAN_ELEMENT;
  public static final HTML.Attribute SRC_ATTRIBUTE;
  public static final HTML.Attribute STANDBY_ATTRIBUTE;
  public static final HTML.Attribute START_ATTRIBUTE;
  public static final HTML.Element STRIKE_ELEMENT;
  public static final HTML.Element STRONG_ELEMENT;
  public static final HTML.Attribute STYLE_ATTRIBUTE;
  public static final HTML.Element STYLE_ELEMENT;
  public static final HTML.Element SUB_ELEMENT;
  public static final HTML.Attribute SUMMARY_ATTRIBUTE;
  public static final HTML.Element SUP_ELEMENT;
  public static final HTML.Element S_ELEMENT;
  public static final HTML.Attribute TABINDEX_ATTRIBUTE;
  public static final HTML.Element TABLE_ELEMENT;
  public static final HTML.Attribute TARGET_ATTRIBUTE;
  public static final HTML.Element TBODY_ELEMENT;
  public static final HTML.Element TD_ELEMENT;
  public static final HTML.Element TEXTAREA_ELEMENT;
  public static final HTML.Attribute TEXT_ATTRIBUTE;
  public static final HTML.Element TFOOT_ELEMENT;
  public static final HTML.Element THEAD_ELEMENT;
  public static final HTML.Element TH_ELEMENT;
  public static final HTML.Attribute TITLE_ATTRIBUTE;
  public static final HTML.Element TITLE_ELEMENT;
  public static final HTML.Element TR_ELEMENT;
  public static final HTML.Element TT_ELEMENT;
  public static final HTML.Attribute TYPE_ATTRIBUTE;
  public static final HTML.Element UL_ELEMENT;
  public static final HTML.Attribute USEMAP_ATTRIBUTE;
  public static final HTML.Element U_ELEMENT;
  public static final HTML.Attribute VALIGN_ATTRIBUTE;
  public static final HTML.Attribute VALUETYPE_ATTRIBUTE = addAttribute("VALUETYPE", 3, new String[] { "data", "ref", "object" });
  public static final HTML.Attribute VALUE_ATTRIBUTE;
  public static final HTML.Element VAR_ELEMENT;
  public static final HTML.Attribute VERSION_ATTRIBUTE = addAttribute("VERSION");
  public static final HTML.Attribute VLINK_ATTRIBUTE = addAttribute("VLINK");
  public static final HTML.Attribute VSPACE_ATTRIBUTE = addAttribute("VSPACE");
  public static final HTML.Attribute WIDTH_ATTRIBUTE = addAttribute("WIDTH");
  private static final HashMap<String, HTML.Attribute> attributes;
  private static final HtmlWhitelist defaultWhitelist;
  private static final HashMap<String, HTML.Element> elements = ;
  
  static
  {
    attributes = Maps.newHashMap();
    defaultWhitelist = new HtmlWhitelist()
    {
      public HTML.Attribute lookupAttribute(String paramAnonymousString)
      {
        return HTML4.lookupAttribute(paramAnonymousString);
      }
      
      public HTML.Element lookupElement(String paramAnonymousString)
      {
        return HTML4.lookupElement(paramAnonymousString);
      }
    };
    A_ELEMENT = addElement("A", "", HTML.Element.Flow.INLINE);
    ABBR_ELEMENT = addElement("ABBR", "", HTML.Element.Flow.INLINE);
    ACRONYM_ELEMENT = addElement("ACRONYM", "", HTML.Element.Flow.INLINE);
    ADDRESS_ELEMENT = addElement("ADDRESS", "", HTML.Element.Flow.BLOCK);
    APPLET_ELEMENT = addElement("APPLET", "");
    AREA_ELEMENT = addElement("AREA", "E");
    B_ELEMENT = addElement("B", "", HTML.Element.Flow.INLINE);
    BASE_ELEMENT = addElement("BASE", "E");
    BASEFONT_ELEMENT = addElement("BASEFONT", "E");
    BDO_ELEMENT = addElement("BDO", "", HTML.Element.Flow.INLINE);
    BIG_ELEMENT = addElement("BIG", "", HTML.Element.Flow.INLINE);
    BLOCKQUOTE_ELEMENT = addElement("BLOCKQUOTE", "B", HTML.Element.Flow.BLOCK);
    BODY_ELEMENT = addElement("BODY", "O");
    BR_ELEMENT = addElement("BR", "EB", HTML.Element.Flow.INLINE);
    BUTTON_ELEMENT = addElement("BUTTON", "", HTML.Element.Flow.INLINE);
    CAPTION_ELEMENT = addTableElement("CAPTION", "", HTML.Element.Flow.NONE);
    CENTER_ELEMENT = addElement("CENTER", "B", HTML.Element.Flow.BLOCK);
    CITE_ELEMENT = addElement("CITE", "", HTML.Element.Flow.INLINE);
    CODE_ELEMENT = addElement("CODE", "", HTML.Element.Flow.INLINE);
    COL_ELEMENT = addTableElement("COL", "E", HTML.Element.Flow.NONE);
    COLGROUP_ELEMENT = addTableElement("COLGROUP", "O", HTML.Element.Flow.NONE);
    DD_ELEMENT = addElement("DD", "OB");
    DEL_ELEMENT = addElement("DEL", "");
    DFN_ELEMENT = addElement("DFN", "", HTML.Element.Flow.INLINE);
    DIR_ELEMENT = addElement("DIR", "B", HTML.Element.Flow.BLOCK);
    DIV_ELEMENT = addElement("DIV", "B", HTML.Element.Flow.BLOCK);
    DL_ELEMENT = addElement("DL", "B", HTML.Element.Flow.BLOCK);
    DT_ELEMENT = addElement("DT", "OB");
    EM_ELEMENT = addElement("EM", "", HTML.Element.Flow.INLINE);
    FIELDSET_ELEMENT = addElement("FIELDSET", "", HTML.Element.Flow.BLOCK);
    FONT_ELEMENT = addElement("FONT", "", HTML.Element.Flow.INLINE);
    FORM_ELEMENT = addElement("FORM", "B", HTML.Element.Flow.BLOCK);
    FRAME_ELEMENT = addElement("FRAME", "E");
    FRAMESET_ELEMENT = addElement("FRAMESET", "");
    H1_ELEMENT = addElement("H1", "B", HTML.Element.Flow.BLOCK);
    H2_ELEMENT = addElement("H2", "B", HTML.Element.Flow.BLOCK);
    H3_ELEMENT = addElement("H3", "B", HTML.Element.Flow.BLOCK);
    H4_ELEMENT = addElement("H4", "B", HTML.Element.Flow.BLOCK);
    H5_ELEMENT = addElement("H5", "B", HTML.Element.Flow.BLOCK);
    H6_ELEMENT = addElement("H6", "B", HTML.Element.Flow.BLOCK);
    HEAD_ELEMENT = addElement("HEAD", "OB");
    HR_ELEMENT = addElement("HR", "EB", HTML.Element.Flow.BLOCK);
    HTML_ELEMENT = addElement("HTML", "OB");
    I_ELEMENT = addElement("I", "", HTML.Element.Flow.INLINE);
    IFRAME_ELEMENT = addElement("IFRAME", "");
    IMG_ELEMENT = addElement("IMG", "E", HTML.Element.Flow.INLINE);
    INPUT_ELEMENT = addElement("INPUT", "E", HTML.Element.Flow.INLINE);
    INS_ELEMENT = addElement("INS", "");
    ISINDEX_ELEMENT = addElement("ISINDEX", "EB");
    KBD_ELEMENT = addElement("KBD", "", HTML.Element.Flow.INLINE);
    LABEL_ELEMENT = addElement("LABEL", "", HTML.Element.Flow.INLINE);
    LEGEND_ELEMENT = addElement("LEGEND", "");
    LI_ELEMENT = addElement("LI", "OB");
    LINK_ELEMENT = addElement("LINK", "E");
    MAP_ELEMENT = addElement("MAP", "", HTML.Element.Flow.INLINE);
    MENU_ELEMENT = addElement("MENU", "B", HTML.Element.Flow.BLOCK);
    META_ELEMENT = addElement("META", "E");
    NOFRAMES_ELEMENT = addElement("NOFRAMES", "B");
    NOSCRIPT_ELEMENT = addElement("NOSCRIPT", "", HTML.Element.Flow.BLOCK);
    OBJECT_ELEMENT = addElement("OBJECT", "", HTML.Element.Flow.INLINE);
    OL_ELEMENT = addElement("OL", "B", HTML.Element.Flow.BLOCK);
    OPTGROUP_ELEMENT = addElement("OPTGROUP", "");
    OPTION_ELEMENT = addElement("OPTION", "O");
    P_ELEMENT = addElement("P", "OB", HTML.Element.Flow.BLOCK);
    PARAM_ELEMENT = addElement("PARAM", "E");
    PRE_ELEMENT = addElement("PRE", "B", HTML.Element.Flow.BLOCK);
    Q_ELEMENT = addElement("Q", "", HTML.Element.Flow.INLINE);
    S_ELEMENT = addElement("S", "", HTML.Element.Flow.INLINE);
    SAMP_ELEMENT = addElement("SAMP", "", HTML.Element.Flow.INLINE);
    SCRIPT_ELEMENT = addElement("SCRIPT", "", HTML.Element.Flow.INLINE);
    SELECT_ELEMENT = addElement("SELECT", "", HTML.Element.Flow.INLINE);
    SMALL_ELEMENT = addElement("SMALL", "", HTML.Element.Flow.INLINE);
    SPAN_ELEMENT = addElement("SPAN", "", HTML.Element.Flow.INLINE);
    STRIKE_ELEMENT = addElement("STRIKE", "", HTML.Element.Flow.INLINE);
    STRONG_ELEMENT = addElement("STRONG", "", HTML.Element.Flow.INLINE);
    STYLE_ELEMENT = addElement("STYLE", "");
    SUB_ELEMENT = addElement("SUB", "", HTML.Element.Flow.INLINE);
    SUP_ELEMENT = addElement("SUP", "", HTML.Element.Flow.INLINE);
    TABLE_ELEMENT = addTableElement("TABLE", "B", HTML.Element.Flow.BLOCK);
    TBODY_ELEMENT = addTableElement("TBODY", "O", HTML.Element.Flow.NONE);
    TD_ELEMENT = addTableElement("TD", "OB", HTML.Element.Flow.NONE);
    TEXTAREA_ELEMENT = addElement("TEXTAREA", "", HTML.Element.Flow.INLINE);
    TFOOT_ELEMENT = addTableElement("TFOOT", "O", HTML.Element.Flow.NONE);
    TH_ELEMENT = addTableElement("TH", "OB", HTML.Element.Flow.NONE);
    THEAD_ELEMENT = addTableElement("THEAD", "O", HTML.Element.Flow.NONE);
    TITLE_ELEMENT = addElement("TITLE", "B");
    TR_ELEMENT = addTableElement("TR", "OB", HTML.Element.Flow.NONE);
    TT_ELEMENT = addElement("TT", "", HTML.Element.Flow.INLINE);
    U_ELEMENT = addElement("U", "", HTML.Element.Flow.INLINE);
    UL_ELEMENT = addElement("UL", "B", HTML.Element.Flow.BLOCK);
    VAR_ELEMENT = addElement("VAR", "", HTML.Element.Flow.INLINE);
    ABBR_ATTRIBUTE = addAttribute("ABBR");
    ACCEPT_ATTRIBUTE = addAttribute("ACCEPT");
    ACCEPT_CHARSET_ATTRIBUTE = addAttribute("ACCEPT-CHARSET");
    ACCESSKEY_ATTRIBUTE = addAttribute("ACCESSKEY");
    ACTION_ATTRIBUTE = addAttribute("ACTION", 1);
    ALIGN_ATTRIBUTE = addAttribute("ALIGN", 3, new String[] { "left", "center", "right", "justify", "char", "top", "bottom", "middle" });
    ALINK_ATTRIBUTE = addAttribute("ALINK");
    ALT_ATTRIBUTE = addAttribute("ALT");
    ARCHIVE_ATTRIBUTE = addAttribute("ARCHIVE", 1);
    AXIS_ATTRIBUTE = addAttribute("AXIS");
    BACKGROUND_ATTRIBUTE = addAttribute("BACKGROUND", 1);
    BGCOLOR_ATTRIBUTE = addAttribute("BGCOLOR");
    BORDER_ATTRIBUTE = addAttribute("BORDER");
    CELLPADDING_ATTRIBUTE = addAttribute("CELLPADDING");
    CELLSPACING_ATTRIBUTE = addAttribute("CELLSPACING");
    CHAR_ATTRIBUTE = addAttribute("CHAR");
    CHAROFF_ATTRIBUTE = addAttribute("CHAROFF");
    CHARSET_ATTRIBUTE = addAttribute("CHARSET");
    CHECKED_ATTRIBUTE = addAttribute("CHECKED", 4);
    CITE_ATTRIBUTE = addAttribute("CITE", 1);
    CLASS_ATTRIBUTE = addAttribute("CLASS");
    CLASSID_ATTRIBUTE = addAttribute("CLASSID", 1);
    CLEAR_ATTRIBUTE = addAttribute("CLEAR", 3, new String[] { "left", "all", "right", "none" });
    CODE_ATTRIBUTE = addAttribute("CODE");
    CODEBASE_ATTRIBUTE = addAttribute("CODEBASE", 1);
    CODETYPE_ATTRIBUTE = addAttribute("CODETYPE");
    COLOR_ATTRIBUTE = addAttribute("COLOR");
    COLS_ATTRIBUTE = addAttribute("COLS");
    COLSPAN_ATTRIBUTE = addAttribute("COLSPAN");
    COMPACT_ATTRIBUTE = addAttribute("COMPACT", 4);
    CONTENT_ATTRIBUTE = addAttribute("CONTENT");
    COORDS_ATTRIBUTE = addAttribute("COORDS");
    DATA_ATTRIBUTE = addAttribute("DATA", 1);
    DATETIME_ATTRIBUTE = addAttribute("DATETIME");
    DECLARE_ATTRIBUTE = addAttribute("DECLARE", 4);
    DEFER_ATTRIBUTE = addAttribute("DEFER", 4);
    DIR_ATTRIBUTE = addAttribute("DIR", 3, new String[] { "ltr", "rtl" });
    DISABLED_ATTRIBUTE = addAttribute("DISABLED", 4);
    ENCTYPE_ATTRIBUTE = addAttribute("ENCTYPE");
    FACE_ATTRIBUTE = addAttribute("FACE");
    FOR_ATTRIBUTE = addAttribute("FOR");
    FRAME_ATTRIBUTE = addAttribute("FRAME");
    FRAMEBORDER_ATTRIBUTE = addAttribute("FRAMEBORDER", 3, new String[] { "1", "0" });
    HEADERS_ATTRIBUTE = addAttribute("HEADERS");
    HEIGHT_ATTRIBUTE = addAttribute("HEIGHT");
    HREF_ATTRIBUTE = addAttribute("HREF", 1);
    HREFLANG_ATTRIBUTE = addAttribute("HREFLANG");
    HSPACE_ATTRIBUTE = addAttribute("HSPACE");
    HTTP_EQUIV_ATTRIBUTE = addAttribute("HTTP-EQUIV");
    ID_ATTRIBUTE = addAttribute("ID");
    ISMAP_ATTRIBUTE = addAttribute("ISMAP", 4);
    LABEL_ATTRIBUTE = addAttribute("LABEL");
    LANG_ATTRIBUTE = addAttribute("LANG");
    LANGUAGE_ATTRIBUTE = addAttribute("LANGUAGE");
    LINK_ATTRIBUTE = addAttribute("LINK");
    LONGDESC_ATTRIBUTE = addAttribute("LONGDESC", 1);
    MARGINHEIGHT_ATTRIBUTE = addAttribute("MARGINHEIGHT");
    MARGINWIDTH_ATTRIBUTE = addAttribute("MARGINWIDTH");
    MAXLENGTH_ATTRIBUTE = addAttribute("MAXLENGTH");
    MEDIA_ATTRIBUTE = addAttribute("MEDIA");
    METHOD_ATTRIBUTE = addAttribute("METHOD", 3, new String[] { "get", "post" });
    MULTIPLE_ATTRIBUTE = addAttribute("MULTIPLE", 4);
    NAME_ATTRIBUTE = addAttribute("NAME");
    NOHREF_ATTRIBUTE = addAttribute("NOHREF", 4);
    NORESIZE_ATTRIBUTE = addAttribute("NORESIZE", 4);
    NOSHADE_ATTRIBUTE = addAttribute("NOSHADE", 4);
    NOWRAP_ATTRIBUTE = addAttribute("NOWRAP", 4);
    OBJECT_ATTRIBUTE = addAttribute("OBJECT");
    ONBLUR_ATTRIBUTE = addAttribute("ONBLUR", 2);
    ONCHANGE_ATTRIBUTE = addAttribute("ONCHANGE", 2);
    ONCLICK_ATTRIBUTE = addAttribute("ONCLICK", 2);
    ONDBLCLICK_ATTRIBUTE = addAttribute("ONDBLCLICK", 2);
    ONFOCUS_ATTRIBUTE = addAttribute("ONFOCUS", 2);
    ONKEYDOWN_ATTRIBUTE = addAttribute("ONKEYDOWN", 2);
    ONKEYPRESS_ATTRIBUTE = addAttribute("ONKEYPRESS", 2);
    ONKEYUP_ATTRIBUTE = addAttribute("ONKEYUP", 2);
    ONLOAD_ATTRIBUTE = addAttribute("ONLOAD", 2);
    ONMOUSEDOWN_ATTRIBUTE = addAttribute("ONMOUSEDOWN", 2);
    ONMOUSEMOVE_ATTRIBUTE = addAttribute("ONMOUSEMOVE", 2);
    ONMOUSEOUT_ATTRIBUTE = addAttribute("ONMOUSEOUT", 2);
    ONMOUSEOVER_ATTRIBUTE = addAttribute("ONMOUSEOVER", 2);
    ONMOUSEUP_ATTRIBUTE = addAttribute("ONMOUSEUP", 2);
    ONRESET_ATTRIBUTE = addAttribute("ONRESET", 2);
    ONSELECT_ATTRIBUTE = addAttribute("ONSELECT", 2);
    ONSUBMIT_ATTRIBUTE = addAttribute("ONSUBMIT", 2);
    ONUNLOAD_ATTRIBUTE = addAttribute("ONUNLOAD", 2);
    PROFILE_ATTRIBUTE = addAttribute("PROFILE", 1);
    PROMPT_ATTRIBUTE = addAttribute("PROMPT");
    READONLY_ATTRIBUTE = addAttribute("READONLY", 4);
    REL_ATTRIBUTE = addAttribute("REL");
    REV_ATTRIBUTE = addAttribute("REV");
    ROWS_ATTRIBUTE = addAttribute("ROWS");
    ROWSPAN_ATTRIBUTE = addAttribute("ROWSPAN");
    RULES_ATTRIBUTE = addAttribute("RULES");
    SCHEME_ATTRIBUTE = addAttribute("SCHEME");
    SCOPE_ATTRIBUTE = addAttribute("SCOPE");
    SCROLLING_ATTRIBUTE = addAttribute("SCROLLING", 3, new String[] { "yes", "no", "auto" });
    SELECTED_ATTRIBUTE = addAttribute("SELECTED", 4);
    SHAPE_ATTRIBUTE = addAttribute("SHAPE");
    SIZE_ATTRIBUTE = addAttribute("SIZE");
    SPAN_ATTRIBUTE = addAttribute("SPAN");
    SRC_ATTRIBUTE = addAttribute("SRC", 1);
    STANDBY_ATTRIBUTE = addAttribute("STANDBY");
    START_ATTRIBUTE = addAttribute("START");
    STYLE_ATTRIBUTE = addAttribute("STYLE");
    SUMMARY_ATTRIBUTE = addAttribute("SUMMARY");
    TABINDEX_ATTRIBUTE = addAttribute("TABINDEX");
    TARGET_ATTRIBUTE = addAttribute("TARGET");
    TEXT_ATTRIBUTE = addAttribute("TEXT");
    TITLE_ATTRIBUTE = addAttribute("TITLE");
    TYPE_ATTRIBUTE = addAttribute("TYPE");
    USEMAP_ATTRIBUTE = addAttribute("USEMAP", 1);
    VALIGN_ATTRIBUTE = addAttribute("VALIGN", 3, new String[] { "top", "middle", "bottom", "baseline" });
    VALUE_ATTRIBUTE = addAttribute("VALUE");
  }
  
  private static HTML.Attribute addAttribute(String paramString)
  {
    return addAttribute(paramString, 0);
  }
  
  private static HTML.Attribute addAttribute(String paramString, int paramInt)
  {
    return addAttribute(paramString, paramInt, null);
  }
  
  private static HTML.Attribute addAttribute(String paramString, int paramInt, String[] paramArrayOfString)
  {
    String str = paramString.toLowerCase();
    paramString = null;
    if (paramArrayOfString != null)
    {
      paramString = new HashSet();
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramString.add(paramArrayOfString[i].toLowerCase());
        i += 1;
      }
      paramString = Collections.unmodifiableSet(paramString);
    }
    paramString = new HTML.Attribute(str, paramInt, paramString);
    attributes.put(str, paramString);
    return paramString;
  }
  
  private static HTML.Element addElement(String paramString1, String paramString2)
  {
    return addElement(paramString1, paramString2, HTML.Element.Flow.NONE);
  }
  
  private static HTML.Element addElement(String paramString1, String paramString2, HTML.Element.Flow paramFlow)
  {
    return addElement(paramString1, paramString2, paramFlow, 0);
  }
  
  private static HTML.Element addElement(String paramString1, String paramString2, HTML.Element.Flow paramFlow, int paramInt)
  {
    paramString1 = paramString1.toLowerCase();
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    int i = 0;
    if (i < paramString2.length())
    {
      switch (paramString2.charAt(i))
      {
      default: 
        throw new Error("Unknown element flag");
      case 'E': 
        bool3 = true;
      }
      for (;;)
      {
        i += 1;
        break;
        bool2 = true;
        continue;
        bool1 = true;
      }
    }
    paramString2 = new HTML.Element(paramString1, paramInt, bool3, bool2, bool1, paramFlow);
    elements.put(paramString1, paramString2);
    return paramString2;
  }
  
  private static HTML.Element addTableElement(String paramString1, String paramString2, HTML.Element.Flow paramFlow)
  {
    return addElement(paramString1, paramString2, paramFlow, 1);
  }
  
  public static HtmlWhitelist getWhitelist()
  {
    return defaultWhitelist;
  }
  
  public static HTML.Attribute lookupAttribute(String paramString)
  {
    return (HTML.Attribute)attributes.get(paramString.toLowerCase());
  }
  
  public static HTML.Element lookupElement(String paramString)
  {
    return (HTML.Element)elements.get(paramString.toLowerCase());
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HTML4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */