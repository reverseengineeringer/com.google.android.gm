import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ihl
{
  static final ihm a = new ihm(0, hfd.g(), hel.e());
  static final hel<String, ihm> b;
  static final hfd<String> c;
  public static final ihl d;
  private final hel<String, ihm> e;
  
  static
  {
    Object localObject1 = hel.e();
    hen localhen = hel.f();
    Object localObject3 = hfd.b("/");
    Object localObject6 = hfd.b("inherit");
    Object localObject2 = hfd.a("aliceblue", "antiquewhite", "aqua", "aquamarine", "azure", "beige", new String[] { "bisque", "black", "blanchedalmond", "blue", "blueviolet", "brown", "burlywood", "cadetblue", "chartreuse", "chocolate", "coral", "cornflowerblue", "cornsilk", "crimson", "cyan", "darkblue", "darkcyan", "darkgoldenrod", "darkgray", "darkgreen", "darkkhaki", "darkmagenta", "darkolivegreen", "darkorange", "darkorchid", "darkred", "darksalmon", "darkseagreen", "darkslateblue", "darkslategray", "darkturquoise", "darkviolet", "deeppink", "deepskyblue", "dimgray", "dodgerblue", "firebrick", "floralwhite", "forestgreen", "fuchsia", "gainsboro", "ghostwhite", "gold", "goldenrod", "gray", "green", "greenyellow", "honeydew", "hotpink", "indianred", "indigo", "ivory", "khaki", "lavender", "lavenderblush", "lawngreen", "lemonchiffon", "lightblue", "lightcoral", "lightcyan", "lightgoldenrodyellow", "lightgreen", "lightgrey", "lightpink", "lightsalmon", "lightseagreen", "lightskyblue", "lightslategray", "lightsteelblue", "lightyellow", "lime", "limegreen", "linen", "magenta", "maroon", "mediumaquamarine", "mediumblue", "mediumorchid", "mediumpurple", "mediumseagreen", "mediumslateblue", "mediumspringgreen", "mediumturquoise", "mediumvioletred", "midnightblue", "mintcream", "mistyrose", "moccasin", "navajowhite", "navy", "oldlace", "olive", "olivedrab", "orange", "orangered", "orchid", "palegoldenrod", "palegreen", "paleturquoise", "palevioletred", "papayawhip", "peachpuff", "peru", "pink", "plum", "powderblue", "purple", "red", "rosybrown", "royalblue", "saddlebrown", "salmon", "sandybrown", "seagreen", "seashell", "sienna", "silver", "skyblue", "slateblue", "slategray", "snow", "springgreen", "steelblue", "tan", "teal", "thistle", "tomato", "turquoise", "violet", "wheat", "white", "whitesmoke", "yellow", "yellowgreen" });
    Object localObject21 = hfd.a("dashed", "dotted", "double", "groove", "outset", "ridge", new String[] { "solid" });
    Object localObject22 = hfd.a("thick", "thin");
    Object localObject5 = hfd.a("hidden", "inherit", "inset", "invert", "medium", "none", new String[0]);
    hel localhel1 = hel.a("rgb(", "rgb()", "rgba(", "rgba()");
    Object localObject7 = hfd.a("inherit", "invert");
    Object localObject9 = hfd.a("hidden", "inherit", "inset", "none");
    hfd localhfd7 = hfd.a("inherit", "medium");
    Object localObject10 = hfd.a("clip", "ellipsis");
    hfd localhfd51 = hfd.a("behind", "center-left", "center-right", "far-left", "far-right", "left-side", new String[] { "leftwards", "right-side", "rightwards" });
    hfd localhfd2 = hfd.a("left", "right");
    hfd localhfd52 = hfd.a("center", "inherit");
    hfd localhfd53 = hfd.a("border-box", "contain", "content-box", "cover", "padding-box");
    hfd localhfd54 = hfd.a("no-repeat", "repeat-x", "repeat-y", "round", "space");
    hfd localhfd3 = hfd.a("bottom", "top");
    hfd localhfd55 = hfd.a(",", "/", "auto", "center", "fixed", "inherit", new String[] { "local", "none", "repeat", "scroll", "transparent" });
    hel localhel3 = hel.f().b("image(", "image()").b("linear-gradient(", "linear-gradient()").b("radial-gradient(", "radial-gradient()").b("repeating-linear-gradient(", "repeating-linear-gradient()").b("repeating-radial-gradient(", "repeating-radial-gradient()").b("rgb(", "rgb()").b("rgba(", "rgba()").b();
    hfd localhfd56 = hfd.a(",", "fixed", "local", "scroll");
    Object localObject20 = hfd.a("inherit", "transparent");
    hfd localhfd57 = hfd.a(",", "none");
    Object localObject14 = hel.a("image(", "image()", "linear-gradient(", "linear-gradient()", "radial-gradient(", "radial-gradient()", "repeating-linear-gradient(", "repeating-linear-gradient()", "repeating-radial-gradient(", "repeating-radial-gradient()");
    hfd localhfd58 = hfd.a(",", "center");
    hfd localhfd59 = hfd.a(",", "repeat");
    hfd localhfd60 = hfd.a("hidden", "inherit", "inset", "medium", "none", "transparent", new String[0]);
    Object localObject19 = hfd.a("collapse", "inherit", "separate");
    hfd localhfd35 = hfd.a("auto", "inherit");
    Object localObject18 = hfd.a(",", "inset", "none");
    Object localObject17 = hfd.a("both", "inherit", "none");
    hel localhel2 = hel.b("rect(", "rect()");
    hfd localhfd8 = hfd.a("none", "normal");
    hfd localhfd9 = hfd.a("inherit", "none");
    Object localObject15 = hfd.a("all-scroll", "col-resize", "crosshair", "default", "e-resize", "hand", new String[] { "help", "move", "n-resize", "ne-resize", "no-drop", "not-allowed", "nw-resize", "pointer", "progress", "row-resize", "s-resize", "se-resize", "sw-resize", "text", "vertical-text", "w-resize", "wait" });
    Object localObject16 = hfd.a(",", "auto", "inherit");
    hfd localhfd39 = hfd.a("ltr", "rtl");
    hfd localhfd40 = hfd.a("-moz-inline-box", "-moz-inline-stack", "block", "inline", "inline-block", "inline-table", new String[] { "list-item", "run-in", "table", "table-caption", "table-cell", "table-column", "table-column-group", "table-footer-group", "table-header-group", "table-row", "table-row-group" });
    hfd localhfd41 = hfd.a("above", "below", "higher", "level", "lower");
    hfd localhfd42 = hfd.a("hide", "show");
    hfd localhfd43 = hfd.a("100", "200", "300", "400", "500", "600", new String[] { "700", "800", "900", "bold", "bolder", "lighter" });
    hfd localhfd44 = hfd.a("large", "larger", "small", "smaller", "x-large", "x-small", new String[] { "xx-large", "xx-small" });
    hfd localhfd45 = hfd.a("caption", "icon", "menu", "message-box", "small-caption", "status-bar", new String[0]);
    hfd localhfd46 = hfd.a("cursive", "fantasy", "monospace", "sans-serif", "serif");
    hfd localhfd47 = hfd.a("italic", "oblique");
    hfd localhfd48 = hfd.a(",", "/", "inherit", "medium", "normal", "small-caps", new String[0]);
    hfd localhfd10 = hfd.a(",", "inherit");
    hfd localhfd49 = hfd.a("condensed", "expanded", "extra-condensed", "extra-expanded", "narrower", "semi-condensed", new String[] { "semi-expanded", "ultra-condensed", "ultra-expanded", "wider" });
    hfd localhfd11 = hfd.b("normal");
    hfd localhfd12 = hfd.a("inherit", "normal");
    hfd localhfd50 = hfd.a("inherit", "normal", "small-caps");
    hfd localhfd36 = hfd.a("armenian", "cjk-decimal", "decimal", "decimal-leading-zero", "disc", "disclosure-closed", new String[] { "disclosure-open", "ethiopic-numeric", "georgian", "hebrew", "hiragana", "hiragana-iroha", "japanese-formal", "japanese-informal", "katakana", "katakana-iroha", "korean-hangul-formal", "korean-hanja-formal", "korean-hanja-informal", "lower-alpha", "lower-greek", "lower-latin", "lower-roman", "simp-chinese-formal", "simp-chinese-informal", "square", "trad-chinese-formal", "trad-chinese-informal", "upper-alpha", "upper-latin", "upper-roman" });
    hfd localhfd37 = hfd.a("inside", "outside");
    hfd localhfd38 = hfd.a("circle", "inherit", "none");
    Object localObject13 = hfd.a("auto", "inherit", "none");
    Object localObject11 = hfd.a("auto", "hidden", "inherit", "scroll", "visible");
    Object localObject12 = hfd.a("no-content", "no-display");
    hfd localhfd34 = hfd.a("auto", "hidden", "scroll", "visible");
    Object localObject8 = hfd.a("always", "auto", "avoid", "inherit");
    hfd localhfd13 = hfd.a("auto", "avoid", "inherit");
    hfd localhfd14 = hfd.a("high", "low", "x-high", "x-low");
    hfd localhfd15 = hfd.a("auto", "inherit", "mix", "none", "repeat");
    hfd localhfd16 = hfd.a("absolute", "relative", "static");
    hfd localhfd17 = hfd.a("inherit", "none", "normal", "spell-out");
    hfd localhfd18 = hfd.a("always", "inherit", "once");
    hfd localhfd19 = hfd.a("continuous", "digits");
    hfd localhfd20 = hfd.a("code", "inherit", "none");
    hfd localhfd21 = hfd.a("fast", "faster", "slow", "slower", "x-fast", "x-slow", new String[0]);
    hfd localhfd22 = hfd.a("auto", "fixed", "inherit");
    hfd localhfd23 = hfd.a("center", "inherit", "justify");
    hfd localhfd24 = hfd.a("blink", "line-through", "overline", "underline");
    hfd localhfd25 = hfd.a("capitalize", "lowercase", "uppercase");
    hfd localhfd26 = hfd.a("suppress", "unrestricted");
    hfd localhfd27 = hfd.a("bidi-override", "embed");
    hfd localhfd28 = hfd.a("baseline", "middle", "sub", "super", "text-bottom", "text-top", new String[0]);
    hfd localhfd29 = hfd.a("collapse", "hidden", "inherit", "visible");
    hfd localhfd30 = hfd.a("child", "female", "male");
    hfd localhfd31 = hfd.a("loud", "silent", "soft", "x-loud", "x-soft");
    hfd localhfd32 = hfd.a("-moz-pre-wrap", "-o-pre-wrap", "-pre-wrap", "nowrap", "pre", "pre-line", new String[] { "pre-wrap" });
    hfd localhfd33 = hfd.a("break-word", "normal");
    Object localObject4 = hfd.b(",");
    hfd localhfd6 = hfd.a(",", "to");
    hfd localhfd4 = hfd.a("at", "closest-corner", "closest-side", "ellipse", "farthest-corner", "farthest-side", new String[0]);
    hfd localhfd5 = hfd.a(",", "center", "circle");
    hfd localhfd1 = hfd.a(",", "auto");
    localObject3 = new ihm(5, (hfd)localObject3, (hel)localObject1);
    localhen.b("-moz-border-radius", localObject3);
    ihm localihm1 = new ihm(5, hfd.g(), (hel)localObject1);
    localhen.b("-moz-border-radius-bottomleft", localihm1);
    localhen.b("-moz-opacity", new ihm(1, (hfd)localObject6, (hel)localObject1));
    localObject5 = new ihm(7, a(new hfd[] { localObject2, localObject21, localObject22, localObject5 }), localhel1);
    localhen.b("-moz-outline", localObject5);
    localObject7 = new ihm(2, a(new hfd[] { localObject7, localObject2 }), localhel1);
    localhen.b("-moz-outline-color", localObject7);
    localObject9 = new ihm(0, a(new hfd[] { localObject21, localObject9 }), (hel)localObject1);
    localhen.b("-moz-outline-style", localObject9);
    ihm localihm2 = new ihm(5, a(new hfd[] { localObject22, localhfd7 }), (hel)localObject1);
    localhen.b("-moz-outline-width", localihm2);
    localObject10 = new ihm(0, (hfd)localObject10, (hel)localObject1);
    localhen.b("-o-text-overflow", localObject10);
    localhen.b("azimuth", new ihm(5, a(new hfd[] { localhfd51, localhfd2, localhfd52 }), (hel)localObject1));
    localhen.b("background", new ihm(23, a(new hfd[] { localhfd2, localhfd53, localhfd54, localhfd3, localhfd55, localObject2 }), localhel3));
    localhen.b("background-attachment", new ihm(0, localhfd56, (hel)localObject1));
    localhen.b("background-color", new ihm(258, a(new hfd[] { localObject20, localObject2 }), localhel1));
    localhen.b("background-image", new ihm(16, localhfd57, (hel)localObject14));
    localhen.b("background-position", new ihm(5, a(new hfd[] { localhfd2, localhfd3, localhfd58 }), (hel)localObject1));
    localhen.b("background-repeat", new ihm(0, a(new hfd[] { localhfd54, localhfd59 }), (hel)localObject1));
    localObject21 = new ihm(7, a(new hfd[] { localhfd60, localObject2, localObject21, localObject22 }), localhel1);
    localhen.b("border", localObject21);
    localObject20 = new ihm(2, a(new hfd[] { localObject20, localObject2 }), localhel1);
    localhen.b("border-bottom-color", localObject20);
    localhen.b("border-collapse", new ihm(0, (hfd)localObject19, (hel)localObject1));
    localObject19 = new ihm(5, (hfd)localObject6, (hel)localObject1);
    localhen.b("border-spacing", localObject19);
    localObject22 = new ihm(5, localhfd35, (hel)localObject1);
    localhen.b("bottom", localObject22);
    localObject18 = new ihm(7, a(new hfd[] { localObject18, localObject2 }), localhel1);
    localhen.b("box-shadow", localObject18);
    localhen.b("caption-side", new ihm(0, a(new hfd[] { localhfd3, localObject6 }), (hel)localObject1));
    localhen.b("clear", new ihm(0, a(new hfd[] { localhfd2, localObject17 }), (hel)localObject1));
    localhen.b("clip", new ihm(0, localhfd35, localhel2));
    localhen.b("color", new ihm(258, a(new hfd[] { localObject6, localObject2 }), localhel1));
    localhen.b("content", new ihm(8, localhfd8, (hel)localObject1));
    localObject17 = new ihm(16, localhfd9, (hel)localObject1);
    localhen.b("cue", localObject17);
    localhen.b("cursor", new ihm(272, a(new hfd[] { localObject15, localObject16 }), (hel)localObject1));
    localhen.b("direction", new ihm(0, a(new hfd[] { localhfd39, localObject6 }), (hel)localObject1));
    localhen.b("display", new ihm(0, a(new hfd[] { localhfd9, localhfd40 }), (hel)localObject1));
    localhen.b("elevation", new ihm(5, a(new hfd[] { localhfd41, localObject6 }), (hel)localObject1));
    localhen.b("empty-cells", new ihm(0, a(new hfd[] { localhfd42, localObject6 }), (hel)localObject1));
    localhen.b("float", new ihm(0, a(new hfd[] { localhfd2, localhfd9 }), (hel)localObject1));
    localhen.b("font", new ihm(73, a(new hfd[] { localhfd43, localhfd44, localhfd45, localhfd46, localhfd47, localhfd48 }), (hel)localObject1));
    localhen.b("font-family", new ihm(72, a(new hfd[] { localhfd10, localhfd46 }), (hel)localObject1));
    localhen.b("font-size", new ihm(1, a(new hfd[] { localhfd44, localhfd7 }), (hel)localObject1));
    localhen.b("font-stretch", new ihm(0, a(new hfd[] { localhfd49, localhfd11 }), (hel)localObject1));
    localhen.b("font-style", new ihm(0, a(new hfd[] { localhfd47, localhfd12 }), (hel)localObject1));
    localhen.b("font-variant", new ihm(0, localhfd50, (hel)localObject1));
    localhen.b("font-weight", new ihm(0, a(new hfd[] { localhfd43, localhfd12 }), (hel)localObject1));
    localObject15 = new ihm(5, localhfd35, (hel)localObject1);
    localhen.b("height", localObject15);
    localObject16 = new ihm(5, localhfd12, (hel)localObject1);
    localhen.b("letter-spacing", localObject16);
    localhen.b("line-height", new ihm(1, localhfd12, (hel)localObject1));
    localhen.b("list-style", new ihm(16, a(new hfd[] { localhfd36, localhfd37, localhfd38 }), (hel)localObject14));
    localhen.b("list-style-image", new ihm(16, localhfd9, (hel)localObject14));
    localhen.b("list-style-position", new ihm(0, a(new hfd[] { localhfd37, localObject6 }), (hel)localObject1));
    localhen.b("list-style-type", new ihm(0, a(new hfd[] { localhfd36, localhfd38 }), (hel)localObject1));
    localObject14 = new ihm(1, localhfd35, (hel)localObject1);
    localhen.b("margin", localObject14);
    localObject13 = new ihm(1, (hfd)localObject13, (hel)localObject1);
    localhen.b("max-height", localObject13);
    localhen.b("opacity", new ihm(1, (hfd)localObject6, (hel)localObject1));
    localhen.b("overflow", new ihm(0, (hfd)localObject11, (hel)localObject1));
    localObject11 = new ihm(0, a(new hfd[] { localObject12, localhfd34 }), (hel)localObject1);
    localhen.b("overflow-x", localObject11);
    localObject12 = new ihm(1, (hfd)localObject6, (hel)localObject1);
    localhen.b("padding", localObject12);
    localObject8 = new ihm(0, a(new hfd[] { localhfd2, localObject8 }), (hel)localObject1);
    localhen.b("page-break-after", localObject8);
    localhen.b("page-break-inside", new ihm(0, localhfd13, (hel)localObject1));
    localhen.b("pitch", new ihm(5, a(new hfd[] { localhfd7, localhfd14 }), (hel)localObject1));
    localhen.b("play-during", new ihm(16, localhfd15, (hel)localObject1));
    localhen.b("position", new ihm(0, a(new hfd[] { localObject6, localhfd16 }), (hel)localObject1));
    localhen.b("quotes", new ihm(8, localhfd9, (hel)localObject1));
    localhen.b("speak", new ihm(0, localhfd17, (hel)localObject1));
    localhen.b("speak-header", new ihm(0, localhfd18, (hel)localObject1));
    localhen.b("speak-numeral", new ihm(0, a(new hfd[] { localObject6, localhfd19 }), (hel)localObject1));
    localhen.b("speak-punctuation", new ihm(0, localhfd20, (hel)localObject1));
    localhen.b("speech-rate", new ihm(5, a(new hfd[] { localhfd7, localhfd21 }), (hel)localObject1));
    localhen.b("table-layout", new ihm(0, localhfd22, (hel)localObject1));
    localhen.b("text-align", new ihm(0, a(new hfd[] { localhfd2, localhfd23 }), (hel)localObject1));
    localhen.b("text-decoration", new ihm(0, a(new hfd[] { localhfd9, localhfd24 }), (hel)localObject1));
    localhen.b("text-transform", new ihm(0, a(new hfd[] { localhfd9, localhfd25 }), (hel)localObject1));
    localhen.b("text-wrap", new ihm(0, a(new hfd[] { localhfd8, localhfd26 }), (hel)localObject1));
    localhen.b("unicode-bidi", new ihm(0, a(new hfd[] { localhfd12, localhfd27 }), (hel)localObject1));
    localhen.b("vertical-align", new ihm(5, a(new hfd[] { localhfd3, localObject6, localhfd28 }), (hel)localObject1));
    localhen.b("visibility", new ihm(0, localhfd29, (hel)localObject1));
    localhen.b("voice-family", new ihm(8, a(new hfd[] { localhfd10, localhfd30 }), (hel)localObject1));
    localhen.b("volume", new ihm(1, a(new hfd[] { localhfd7, localhfd31 }), (hel)localObject1));
    localhen.b("white-space", new ihm(0, a(new hfd[] { localhfd12, localhfd32 }), (hel)localObject1));
    localhen.b("word-wrap", new ihm(0, localhfd33, (hel)localObject1));
    localhen.b("zoom", new ihm(1, localhfd11, (hel)localObject1));
    localObject6 = new ihm(1, (hfd)localObject4, (hel)localObject1);
    localhen.b("rgb()", localObject6);
    localhen.b("image()", new ihm(18, a(new hfd[] { localObject2, localObject4 }), localhel1));
    localObject4 = new ihm(7, a(new hfd[] { localhfd2, localhfd3, localhfd6, localObject2 }), localhel1);
    localhen.b("linear-gradient()", localObject4);
    localObject2 = new ihm(7, a(new hfd[] { localhfd2, localhfd3, localObject2, localhfd4, localhfd5 }), localhel1);
    localhen.b("radial-gradient()", localObject2);
    localhen.b("rect()", new ihm(5, localhfd1, (hel)localObject1));
    localhen.b("-moz-border-radius-bottomright", localihm1);
    localhen.b("-moz-border-radius-topleft", localihm1);
    localhen.b("-moz-border-radius-topright", localihm1);
    localhen.b("-moz-box-shadow", localObject18);
    localhen.b("-webkit-border-bottom-left-radius", localihm1);
    localhen.b("-webkit-border-bottom-right-radius", localihm1);
    localhen.b("-webkit-border-radius", localObject3);
    localhen.b("-webkit-border-radius-bottom-left", localihm1);
    localhen.b("-webkit-border-radius-bottom-right", localihm1);
    localhen.b("-webkit-border-radius-top-left", localihm1);
    localhen.b("-webkit-border-radius-top-right", localihm1);
    localhen.b("-webkit-border-top-left-radius", localihm1);
    localhen.b("-webkit-border-top-right-radius", localihm1);
    localhen.b("-webkit-box-shadow", localObject18);
    localhen.b("border-bottom", localObject21);
    localhen.b("border-bottom-left-radius", localihm1);
    localhen.b("border-bottom-right-radius", localihm1);
    localhen.b("border-bottom-style", localObject9);
    localhen.b("border-bottom-width", localihm2);
    localhen.b("border-color", localObject20);
    localhen.b("border-left", localObject21);
    localhen.b("border-left-color", localObject20);
    localhen.b("border-left-style", localObject9);
    localhen.b("border-left-width", localihm2);
    localhen.b("border-radius", localObject3);
    localhen.b("border-right", localObject21);
    localhen.b("border-right-color", localObject20);
    localhen.b("border-right-style", localObject9);
    localhen.b("border-right-width", localihm2);
    localhen.b("border-style", localObject9);
    localhen.b("border-top", localObject21);
    localhen.b("border-top-color", localObject20);
    localhen.b("border-top-left-radius", localihm1);
    localhen.b("border-top-right-radius", localihm1);
    localhen.b("border-top-style", localObject9);
    localhen.b("border-top-width", localihm2);
    localhen.b("border-width", localihm2);
    localhen.b("cue-after", localObject17);
    localhen.b("cue-before", localObject17);
    localhen.b("left", localObject15);
    localhen.b("margin-bottom", localObject14);
    localhen.b("margin-left", localObject14);
    localhen.b("margin-right", localObject14);
    localhen.b("margin-top", localObject14);
    localhen.b("max-width", localObject13);
    localhen.b("min-height", localObject14);
    localhen.b("min-width", localObject14);
    localhen.b("outline", localObject5);
    localhen.b("outline-color", localObject7);
    localhen.b("outline-style", localObject9);
    localhen.b("outline-width", localihm2);
    localhen.b("overflow-y", localObject11);
    localhen.b("padding-bottom", localObject12);
    localhen.b("padding-left", localObject12);
    localhen.b("padding-right", localObject12);
    localhen.b("padding-top", localObject12);
    localhen.b("page-break-before", localObject8);
    localhen.b("pause", localObject19);
    localhen.b("pause-after", localObject19);
    localhen.b("pause-before", localObject19);
    localhen.b("pitch-range", localObject19);
    localhen.b("richness", localObject19);
    localhen.b("right", localObject15);
    localhen.b("stress", localObject19);
    localhen.b("text-indent", localObject19);
    localhen.b("text-overflow", localObject10);
    localhen.b("text-shadow", localObject18);
    localhen.b("top", localObject15);
    localhen.b("width", localObject14);
    localhen.b("word-spacing", localObject16);
    localhen.b("z-index", localObject22);
    localhen.b("rgba()", localObject6);
    localhen.b("repeating-linear-gradient()", localObject4);
    localhen.b("repeating-radial-gradient()", localObject2);
    b = localhen.b();
    localObject1 = hfd.a("-moz-border-radius", "-moz-border-radius-bottomleft", "-moz-border-radius-bottomright", "-moz-border-radius-topleft", "-moz-border-radius-topright", "-moz-box-shadow", new String[] { "-moz-outline", "-moz-outline-color", "-moz-outline-style", "-moz-outline-width", "-o-text-overflow", "-webkit-border-bottom-left-radius", "-webkit-border-bottom-right-radius", "-webkit-border-radius", "-webkit-border-radius-bottom-left", "-webkit-border-radius-bottom-right", "-webkit-border-radius-top-left", "-webkit-border-radius-top-right", "-webkit-border-top-left-radius", "-webkit-border-top-right-radius", "-webkit-box-shadow", "azimuth", "background", "background-attachment", "background-color", "background-image", "background-position", "background-repeat", "border", "border-bottom", "border-bottom-color", "border-bottom-left-radius", "border-bottom-right-radius", "border-bottom-style", "border-bottom-width", "border-collapse", "border-color", "border-left", "border-left-color", "border-left-style", "border-left-width", "border-radius", "border-right", "border-right-color", "border-right-style", "border-right-width", "border-spacing", "border-style", "border-top", "border-top-color", "border-top-left-radius", "border-top-right-radius", "border-top-style", "border-top-width", "border-width", "box-shadow", "caption-side", "color", "cue", "cue-after", "cue-before", "direction", "elevation", "empty-cells", "font", "font-family", "font-size", "font-stretch", "font-style", "font-variant", "font-weight", "height", "image()", "letter-spacing", "line-height", "linear-gradient()", "list-style", "list-style-image", "list-style-position", "list-style-type", "margin", "margin-bottom", "margin-left", "margin-right", "margin-top", "max-height", "max-width", "min-height", "min-width", "outline", "outline-color", "outline-style", "outline-width", "padding", "padding-bottom", "padding-left", "padding-right", "padding-top", "pause", "pause-after", "pause-before", "pitch", "pitch-range", "quotes", "radial-gradient()", "rect()", "repeating-linear-gradient()", "repeating-radial-gradient()", "rgb()", "rgba()", "richness", "speak", "speak-header", "speak-numeral", "speak-punctuation", "speech-rate", "stress", "table-layout", "text-align", "text-decoration", "text-indent", "text-overflow", "text-shadow", "text-transform", "text-wrap", "unicode-bidi", "vertical-align", "voice-family", "volume", "white-space", "width", "word-spacing", "word-wrap" });
    c = (hfd)localObject1;
    d = a((Iterable)localObject1);
  }
  
  private ihl(hel<String, ihm> paramhel)
  {
    if (paramhel == null) {
      throw new NullPointerException();
    }
    e = paramhel;
  }
  
  private static <T> hfd<T> a(hfd<T>... paramVarArgs)
  {
    hfe localhfe = hfd.h();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localhfe.b(paramVarArgs[i]);
      i += 1;
    }
    return localhfe.a();
  }
  
  public static ihl a(Iterable<? extends String> paramIterable)
  {
    hen localhen = hel.f();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      String str = (String)paramIterable.next();
      ihm localihm = (ihm)b.get(str);
      if (localihm == null) {
        throw new IllegalArgumentException(str);
      }
      localhen.b(str, localihm);
    }
    return new ihl(localhen.b());
  }
  
  public static ihl a(ihl... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs.length == 1) {
      return paramVarArgs[0];
    }
    LinkedHashMap localLinkedHashMap = hhk.d();
    int j = paramVarArgs.length;
    while (i < j)
    {
      localLinkedHashMap.putAll(e);
      i += 1;
    }
    return new ihl(hel.a(localLinkedHashMap));
  }
  
  final ihm a(String paramString)
  {
    Object localObject = ijj.a(paramString);
    paramString = (ihm)e.get(localObject);
    if (paramString != null) {
      return paramString;
    }
    label80:
    int i;
    if ((((String)localObject).length() != 0) && (((String)localObject).charAt(0) == '-')) {
      switch (((String)localObject).charAt(1))
      {
      default: 
        i = 0;
        label82:
        if (i != 0) {
          break;
        }
      }
    }
    for (paramString = null;; paramString = ((String)localObject).substring(i))
    {
      localObject = (ihm)e.get(paramString);
      paramString = (String)localObject;
      if (localObject != null) {
        break;
      }
      return a;
      if (((String)localObject).startsWith("-ms-"))
      {
        i = 4;
        break label82;
      }
      if (!((String)localObject).startsWith("-moz-")) {
        break label80;
      }
      i = 5;
      break label82;
      if (!((String)localObject).startsWith("-o-")) {
        break label80;
      }
      i = 3;
      break label82;
      if (!((String)localObject).startsWith("-webkit-")) {
        break label80;
      }
      i = 8;
      break label82;
    }
  }
}

/* Location:
 * Qualified Name:     ihl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */