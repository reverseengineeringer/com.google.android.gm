.class public final Lcom/google/android/common/base/CharEscapers;
.super Ljava/lang/Object;
.source "CharEscapers.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/common/base/CharEscapers$JavascriptCharEscaper;,
        Lcom/google/android/common/base/CharEscapers$JavaCharEscaper;,
        Lcom/google/android/common/base/CharEscapers$FastCharEscaper;
    }
.end annotation


# static fields
.field private static final ASCII_HTML_ESCAPER:Lcom/google/android/common/base/CharEscaper;

.field private static final CPP_URI_ESCAPER:Lcom/google/android/common/base/Escaper;

.field private static final HEX_DIGITS:[C

.field private static final JAVASCRIPT_ESCAPER:Lcom/google/android/common/base/CharEscaper;

.field private static final JAVA_CHAR_ESCAPER:Lcom/google/android/common/base/CharEscaper;

.field private static final JAVA_STRING_ESCAPER:Lcom/google/android/common/base/CharEscaper;

.field private static final JAVA_STRING_UNICODE_ESCAPER:Lcom/google/android/common/base/CharEscaper;

.field private static final NULL_ESCAPER:Lcom/google/android/common/base/CharEscaper;

.field private static final PYTHON_ESCAPER:Lcom/google/android/common/base/CharEscaper;

.field private static final URI_ESCAPER:Lcom/google/android/common/base/Escaper;

.field private static final URI_ESCAPER_NO_PLUS:Lcom/google/android/common/base/Escaper;

.field private static final URI_PATH_ESCAPER:Lcom/google/android/common/base/Escaper;

.field private static final URI_QUERY_STRING_ESCAPER:Lcom/google/android/common/base/Escaper;

.field private static final URI_QUERY_STRING_ESCAPER_WITH_PLUS:Lcom/google/android/common/base/Escaper;

.field private static final XML_CONTENT_ESCAPER:Lcom/google/android/common/base/CharEscaper;

.field private static final XML_ESCAPER:Lcom/google/android/common/base/CharEscaper;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/16 v8, 0xd

    const/16 v7, 0xa

    const/16 v6, 0x9

    const/16 v5, 0x27

    const/16 v4, 0x22

    .line 40
    new-instance v0, Lcom/google/android/common/base/CharEscapers$1;

    invoke-direct {v0}, Lcom/google/android/common/base/CharEscapers$1;-><init>()V

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->NULL_ESCAPER:Lcom/google/android/common/base/CharEscaper;

    .line 106
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->newBasicXmlEscapeBuilder()Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    const-string v1, "&quot;"

    invoke-virtual {v0, v4, v1}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    const-string v1, "&apos;"

    invoke-virtual {v0, v5, v1}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/common/base/CharEscaperBuilder;->toEscaper()Lcom/google/android/common/base/CharEscaper;

    move-result-object v0

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->XML_ESCAPER:Lcom/google/android/common/base/CharEscaper;

    .line 133
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->newBasicXmlEscapeBuilder()Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/common/base/CharEscaperBuilder;->toEscaper()Lcom/google/android/common/base/CharEscaper;

    move-result-object v0

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->XML_CONTENT_ESCAPER:Lcom/google/android/common/base/CharEscaper;

    .line 428
    new-instance v0, Lcom/google/android/common/base/CharEscaperBuilder;

    invoke-direct {v0}, Lcom/google/android/common/base/CharEscaperBuilder;-><init>()V

    const-string v1, "&quot;"

    invoke-virtual {v0, v4, v1}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    const-string v1, "&#39;"

    invoke-virtual {v0, v5, v1}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    const/16 v1, 0x26

    const-string v2, "&amp;"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    const/16 v1, 0x3c

    const-string v2, "&lt;"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    const/16 v1, 0x3e

    const-string v2, "&gt;"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/common/base/CharEscaperBuilder;->toEscaper()Lcom/google/android/common/base/CharEscaper;

    move-result-object v0

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->ASCII_HTML_ESCAPER:Lcom/google/android/common/base/CharEscaper;

    .line 637
    new-instance v0, Lcom/google/android/common/base/PercentEscaper;

    const-string v1, "-_.*"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lcom/google/android/common/base/PercentEscaper;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->URI_ESCAPER:Lcom/google/android/common/base/Escaper;

    .line 640
    new-instance v0, Lcom/google/android/common/base/PercentEscaper;

    const-string v1, "-_.*"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/google/android/common/base/PercentEscaper;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->URI_ESCAPER_NO_PLUS:Lcom/google/android/common/base/Escaper;

    .line 643
    new-instance v0, Lcom/google/android/common/base/PercentEscaper;

    const-string v1, "-_.!~*\'()@:$&,;="

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/google/android/common/base/PercentEscaper;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->URI_PATH_ESCAPER:Lcom/google/android/common/base/Escaper;

    .line 646
    new-instance v0, Lcom/google/android/common/base/PercentEscaper;

    const-string v1, "-_.!~*\'()@:$,;/?:"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/google/android/common/base/PercentEscaper;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->URI_QUERY_STRING_ESCAPER:Lcom/google/android/common/base/Escaper;

    .line 649
    new-instance v0, Lcom/google/android/common/base/PercentEscaper;

    const-string v1, "-_.!~*\'()@:$,;/?:"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lcom/google/android/common/base/PercentEscaper;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->URI_QUERY_STRING_ESCAPER_WITH_PLUS:Lcom/google/android/common/base/Escaper;

    .line 692
    new-instance v0, Lcom/google/android/common/base/PercentEscaper;

    const-string v1, "!()*-._~,/:"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lcom/google/android/common/base/PercentEscaper;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->CPP_URI_ESCAPER:Lcom/google/android/common/base/Escaper;

    .line 714
    new-instance v0, Lcom/google/android/common/base/CharEscapers$JavaCharEscaper;

    new-instance v1, Lcom/google/android/common/base/CharEscaperBuilder;

    invoke-direct {v1}, Lcom/google/android/common/base/CharEscaperBuilder;-><init>()V

    const/16 v2, 0x8

    const-string v3, "\\b"

    invoke-virtual {v1, v2, v3}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const/16 v2, 0xc

    const-string v3, "\\f"

    invoke-virtual {v1, v2, v3}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const-string v2, "\\n"

    invoke-virtual {v1, v7, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const-string v2, "\\r"

    invoke-virtual {v1, v8, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const-string v2, "\\t"

    invoke-virtual {v1, v6, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const-string v2, "\\\""

    invoke-virtual {v1, v4, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const/16 v2, 0x5c

    const-string v3, "\\\\"

    invoke-virtual {v1, v2, v3}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/common/base/CharEscaperBuilder;->toArray()[[C

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/common/base/CharEscapers$JavaCharEscaper;-><init>([[C)V

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->JAVA_STRING_ESCAPER:Lcom/google/android/common/base/CharEscaper;

    .line 744
    new-instance v0, Lcom/google/android/common/base/CharEscapers$JavaCharEscaper;

    new-instance v1, Lcom/google/android/common/base/CharEscaperBuilder;

    invoke-direct {v1}, Lcom/google/android/common/base/CharEscaperBuilder;-><init>()V

    const/16 v2, 0x8

    const-string v3, "\\b"

    invoke-virtual {v1, v2, v3}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const/16 v2, 0xc

    const-string v3, "\\f"

    invoke-virtual {v1, v2, v3}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const-string v2, "\\n"

    invoke-virtual {v1, v7, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const-string v2, "\\r"

    invoke-virtual {v1, v8, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const-string v2, "\\t"

    invoke-virtual {v1, v6, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const-string v2, "\\\'"

    invoke-virtual {v1, v5, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const-string v2, "\\\""

    invoke-virtual {v1, v4, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const/16 v2, 0x5c

    const-string v3, "\\\\"

    invoke-virtual {v1, v2, v3}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/common/base/CharEscaperBuilder;->toArray()[[C

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/common/base/CharEscapers$JavaCharEscaper;-><init>([[C)V

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->JAVA_CHAR_ESCAPER:Lcom/google/android/common/base/CharEscaper;

    .line 770
    new-instance v0, Lcom/google/android/common/base/CharEscapers$2;

    invoke-direct {v0}, Lcom/google/android/common/base/CharEscapers$2;-><init>()V

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->JAVA_STRING_UNICODE_ESCAPER:Lcom/google/android/common/base/CharEscaper;

    .line 805
    new-instance v0, Lcom/google/android/common/base/CharEscaperBuilder;

    invoke-direct {v0}, Lcom/google/android/common/base/CharEscaperBuilder;-><init>()V

    const-string v1, "\\n"

    invoke-virtual {v0, v7, v1}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    const-string v1, "\\r"

    invoke-virtual {v0, v8, v1}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    const-string v1, "\\t"

    invoke-virtual {v0, v6, v1}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    const/16 v1, 0x5c

    const-string v2, "\\\\"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    const-string v1, "\\\""

    invoke-virtual {v0, v4, v1}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    const-string v1, "\\\'"

    invoke-virtual {v0, v5, v1}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/common/base/CharEscaperBuilder;->toEscaper()Lcom/google/android/common/base/CharEscaper;

    move-result-object v0

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->PYTHON_ESCAPER:Lcom/google/android/common/base/CharEscaper;

    .line 829
    new-instance v0, Lcom/google/android/common/base/CharEscapers$JavascriptCharEscaper;

    new-instance v1, Lcom/google/android/common/base/CharEscaperBuilder;

    invoke-direct {v1}, Lcom/google/android/common/base/CharEscaperBuilder;-><init>()V

    const-string v2, "\\x27"

    invoke-virtual {v1, v5, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const-string v2, "\\x22"

    invoke-virtual {v1, v4, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const/16 v2, 0x3c

    const-string v3, "\\x3c"

    invoke-virtual {v1, v2, v3}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const/16 v2, 0x3d

    const-string v3, "\\x3d"

    invoke-virtual {v1, v2, v3}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const/16 v2, 0x3e

    const-string v3, "\\x3e"

    invoke-virtual {v1, v2, v3}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const/16 v2, 0x26

    const-string v3, "\\x26"

    invoke-virtual {v1, v2, v3}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const/16 v2, 0x8

    const-string v3, "\\b"

    invoke-virtual {v1, v2, v3}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const-string v2, "\\t"

    invoke-virtual {v1, v6, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const-string v2, "\\n"

    invoke-virtual {v1, v7, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const/16 v2, 0xc

    const-string v3, "\\f"

    invoke-virtual {v1, v2, v3}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const-string v2, "\\r"

    invoke-virtual {v1, v8, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    const/16 v2, 0x5c

    const-string v3, "\\\\"

    invoke-virtual {v1, v2, v3}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/common/base/CharEscaperBuilder;->toArray()[[C

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/common/base/CharEscapers$JavascriptCharEscaper;-><init>([[C)V

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->JAVASCRIPT_ESCAPER:Lcom/google/android/common/base/CharEscaper;

    .line 1101
    const-string v0, "0123456789abcdef"

    invoke-virtual {v0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    sput-object v0, Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$100()[C
    .locals 1

    .prologue
    .line 29
    sget-object v0, Lcom/google/android/common/base/CharEscapers;->HEX_DIGITS:[C

    return-object v0
.end method

.method public static asciiHtmlEscaper()Lcom/google/android/common/base/CharEscaper;
    .locals 1

    .prologue
    .line 420
    sget-object v0, Lcom/google/android/common/base/CharEscapers;->ASCII_HTML_ESCAPER:Lcom/google/android/common/base/CharEscaper;

    return-object v0
.end method

.method private static newBasicXmlEscapeBuilder()Lcom/google/android/common/base/CharEscaperBuilder;
    .locals 3

    .prologue
    .line 846
    new-instance v0, Lcom/google/android/common/base/CharEscaperBuilder;

    invoke-direct {v0}, Lcom/google/android/common/base/CharEscaperBuilder;-><init>()V

    const/16 v1, 0x26

    const-string v2, "&amp;"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    const/16 v1, 0x3c

    const-string v2, "&lt;"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    const/16 v1, 0x3e

    const-string v2, "&gt;"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscape(CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    const/16 v1, 0x1d

    new-array v1, v1, [C

    fill-array-data v1, :array_0

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Lcom/google/android/common/base/CharEscaperBuilder;->addEscapes([CLjava/lang/String;)Lcom/google/android/common/base/CharEscaperBuilder;

    move-result-object v0

    return-object v0

    nop

    :array_0
    .array-data 2
        0x0s
        0x1s
        0x2s
        0x3s
        0x4s
        0x5s
        0x6s
        0x7s
        0x8s
        0xbs
        0xcs
        0xes
        0xfs
        0x10s
        0x11s
        0x12s
        0x13s
        0x14s
        0x15s
        0x16s
        0x17s
        0x18s
        0x19s
        0x1as
        0x1bs
        0x1cs
        0x1ds
        0x1es
        0x1fs
    .end array-data
.end method
