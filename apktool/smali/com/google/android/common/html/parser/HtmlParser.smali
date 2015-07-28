.class public Lcom/google/android/common/html/parser/HtmlParser;
.super Ljava/lang/Object;
.source "HtmlParser.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/common/html/parser/HtmlParser$1;,
        Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;,
        Lcom/google/android/common/html/parser/HtmlParser$TagNameScanner;,
        Lcom/google/android/common/html/parser/HtmlParser$ParseStyle;,
        Lcom/google/android/common/html/parser/HtmlParser$State;
    }
.end annotation


# static fields
.field private static DEBUG:Z

.field public static final DEFAULT_WHITELIST:Lcom/google/android/common/html/parser/HtmlWhitelist;

.field static NEEDS_QUOTING_ATTRIBUTE_VALUE_REGEX:Ljava/util/regex/Pattern;

.field private static final TRUNCATED_ENTITY:Ljava/util/regex/Pattern;


# instance fields
.field private clipLength:I

.field private clipped:Z

.field private html:Ljava/lang/String;

.field private nodes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/common/html/parser/HtmlDocument$Node;",
            ">;"
        }
    .end annotation
.end field

.field private final preserveAll:Z

.field private final preserveValidHtml:Z

.field private state:Lcom/google/android/common/html/parser/HtmlParser$State;

.field private final unknownAttributes:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/common/html/parser/HTML$Attribute;",
            ">;"
        }
    .end annotation
.end field

.field private final unknownElements:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/common/html/parser/HTML$Element;",
            ">;"
        }
    .end annotation
.end field

.field private whitelists:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/common/html/parser/HtmlWhitelist;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 64
    const/4 v0, 0x0

    sput-boolean v0, Lcom/google/android/common/html/parser/HtmlParser;->DEBUG:Z

    .line 67
    invoke-static {}, Lcom/google/android/common/html/parser/HTML4;->getWhitelist()Lcom/google/android/common/html/parser/HtmlWhitelist;

    move-result-object v0

    sput-object v0, Lcom/google/android/common/html/parser/HtmlParser;->DEFAULT_WHITELIST:Lcom/google/android/common/html/parser/HtmlWhitelist;

    .line 175
    const-string v0, "[\"\'&<>=\\s]"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/common/html/parser/HtmlParser;->NEEDS_QUOTING_ATTRIBUTE_VALUE_REGEX:Ljava/util/regex/Pattern;

    .line 312
    const-string v0, "\\& \\#? [0-9a-zA-Z]{0,8} $"

    const/4 v1, 0x4

    invoke-static {v0, v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;I)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/common/html/parser/HtmlParser;->TRUNCATED_ENTITY:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 102
    sget-object v0, Lcom/google/android/common/html/parser/HtmlParser$ParseStyle;->NORMALIZE:Lcom/google/android/common/html/parser/HtmlParser$ParseStyle;

    invoke-direct {p0, v0}, Lcom/google/android/common/html/parser/HtmlParser;-><init>(Lcom/google/android/common/html/parser/HtmlParser$ParseStyle;)V

    .line 103
    return-void
.end method

.method public constructor <init>(Lcom/google/android/common/html/parser/HtmlParser$ParseStyle;)V
    .locals 4
    .param p1, "parseStyle"    # Lcom/google/android/common/html/parser/HtmlParser$ParseStyle;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 110
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 54
    const v0, 0x7fffffff

    iput v0, p0, Lcom/google/android/common/html/parser/HtmlParser;->clipLength:I

    .line 70
    new-array v0, v1, [Lcom/google/android/common/html/parser/HtmlWhitelist;

    sget-object v3, Lcom/google/android/common/html/parser/HtmlParser;->DEFAULT_WHITELIST:Lcom/google/android/common/html/parser/HtmlWhitelist;

    aput-object v3, v0, v2

    invoke-static {v0}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/common/html/parser/HtmlParser;->whitelists:Ljava/util/List;

    .line 593
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/common/html/parser/HtmlParser;->unknownElements:Ljava/util/HashMap;

    .line 599
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/common/html/parser/HtmlParser;->unknownAttributes:Ljava/util/HashMap;

    .line 111
    sget-object v0, Lcom/google/android/common/html/parser/HtmlParser$ParseStyle;->PRESERVE_ALL:Lcom/google/android/common/html/parser/HtmlParser$ParseStyle;

    if-ne p1, v0, :cond_2

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lcom/google/android/common/html/parser/HtmlParser;->preserveAll:Z

    .line 112
    iget-boolean v0, p0, Lcom/google/android/common/html/parser/HtmlParser;->preserveAll:Z

    if-nez v0, :cond_0

    sget-object v0, Lcom/google/android/common/html/parser/HtmlParser$ParseStyle;->PRESERVE_VALID:Lcom/google/android/common/html/parser/HtmlParser$ParseStyle;

    if-ne p1, v0, :cond_1

    :cond_0
    move v2, v1

    :cond_1
    iput-boolean v2, p0, Lcom/google/android/common/html/parser/HtmlParser;->preserveValidHtml:Z

    .line 113
    return-void

    :cond_2
    move v0, v2

    .line 111
    goto :goto_0
.end method

.method private addAttribute(Ljava/util/ArrayList;Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;II)V
    .locals 10
    .param p2, "scanner"    # Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;
    .param p3, "startPos"    # I
    .param p4, "endPos"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/common/html/parser/HtmlDocument$TagAttribute;",
            ">;",
            "Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;",
            "II)V"
        }
    .end annotation

    .prologue
    .line 966
    .local p1, "attributes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/common/html/parser/HtmlDocument$TagAttribute;>;"
    if-ge p3, p4, :cond_2

    const/4 v7, 0x1

    :goto_0
    invoke-static {v7}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 968
    invoke-virtual {p2}, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->getName()Ljava/lang/String;

    move-result-object v1

    .line 969
    .local v1, "name":Ljava/lang/String;
    if-eqz v1, :cond_3

    const/4 v7, 0x1

    :goto_1
    invoke-static {v7}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 970
    invoke-virtual {p0, v1}, Lcom/google/android/common/html/parser/HtmlParser;->lookupAttribute(Ljava/lang/String;)Lcom/google/android/common/html/parser/HTML$Attribute;

    move-result-object v0

    .line 973
    .local v0, "htmlAttribute":Lcom/google/android/common/html/parser/HTML$Attribute;
    invoke-virtual {p2}, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->getValue()Ljava/lang/String;

    move-result-object v6

    .line 975
    .local v6, "value":Ljava/lang/String;
    if-nez v0, :cond_4

    .line 977
    sget-boolean v7, Lcom/google/android/common/html/parser/HtmlParser;->DEBUG:Z

    if-eqz v7, :cond_0

    .line 978
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Unknown attribute: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/google/android/common/html/parser/HtmlParser;->debug(Ljava/lang/String;)V

    .line 980
    :cond_0
    iget-boolean v7, p0, Lcom/google/android/common/html/parser/HtmlParser;->preserveAll:Z

    if-eqz v7, :cond_1

    .line 981
    iget-object v7, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v7, p3, p4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 982
    .local v3, "original":Ljava/lang/String;
    invoke-direct {p0, v1}, Lcom/google/android/common/html/parser/HtmlParser;->lookupUnknownAttribute(Ljava/lang/String;)Lcom/google/android/common/html/parser/HTML$Attribute;

    move-result-object v7

    invoke-static {v7, v6, v3}, Lcom/google/android/common/html/parser/HtmlDocument;->createTagAttribute(Lcom/google/android/common/html/parser/HTML$Attribute;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$TagAttribute;

    move-result-object v7

    invoke-virtual {p1, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1051
    .end local v3    # "original":Ljava/lang/String;
    :cond_1
    :goto_2
    return-void

    .line 966
    .end local v0    # "htmlAttribute":Lcom/google/android/common/html/parser/HTML$Attribute;
    .end local v1    # "name":Ljava/lang/String;
    .end local v6    # "value":Ljava/lang/String;
    :cond_2
    const/4 v7, 0x0

    goto :goto_0

    .line 969
    .restart local v1    # "name":Ljava/lang/String;
    :cond_3
    const/4 v7, 0x0

    goto :goto_1

    .line 986
    .restart local v0    # "htmlAttribute":Lcom/google/android/common/html/parser/HTML$Attribute;
    .restart local v6    # "value":Ljava/lang/String;
    :cond_4
    if-nez v6, :cond_5

    const/4 v5, 0x0

    .line 987
    .local v5, "unescapedValue":Ljava/lang/String;
    :goto_3
    iget-boolean v7, p0, Lcom/google/android/common/html/parser/HtmlParser;->preserveAll:Z

    if-eqz v7, :cond_6

    .line 988
    iget-object v7, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v7, p3, p4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    invoke-static {v0, v5, v7}, Lcom/google/android/common/html/parser/HtmlDocument;->createTagAttribute(Lcom/google/android/common/html/parser/HTML$Attribute;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$TagAttribute;

    move-result-object v7

    invoke-virtual {p1, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 986
    .end local v5    # "unescapedValue":Ljava/lang/String;
    :cond_5
    invoke-static {v6}, Lcom/google/android/common/base/StringUtil;->unescapeHTML(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    goto :goto_3

    .line 990
    .restart local v5    # "unescapedValue":Ljava/lang/String;
    :cond_6
    iget-boolean v7, p0, Lcom/google/android/common/html/parser/HtmlParser;->preserveValidHtml:Z

    if-eqz v7, :cond_f

    .line 991
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 997
    .local v3, "original":Ljava/lang/StringBuilder;
    iget v7, p2, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->startNamePos:I

    if-gt p3, v7, :cond_8

    const/4 v7, 0x1

    :goto_4
    invoke-static {v7}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 998
    iget-object v7, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    iget v8, p2, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->startNamePos:I

    invoke-virtual {v7, p3, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    const-string v8, "\\S+"

    const-string v9, ""

    invoke-virtual {v7, v8, v9}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 1000
    .local v4, "originalPrefix":Ljava/lang/String;
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v7

    if-nez v7, :cond_7

    .line 1001
    const-string v4, " "

    .line 1003
    :cond_7
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1005
    if-nez v6, :cond_a

    .line 1008
    iget v7, p2, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->startNamePos:I

    if-ge v7, p4, :cond_9

    const/4 v7, 0x1

    :goto_5
    invoke-static {v7}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 1009
    iget-object v7, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    iget v8, p2, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->startNamePos:I

    invoke-virtual {v7, v8, p4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 1010
    .local v2, "nameEtc":Ljava/lang/String;
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->asciiHtmlEscaper()Lcom/google/android/common/base/CharEscaper;

    move-result-object v7

    invoke-virtual {v7, v2}, Lcom/google/android/common/base/CharEscaper;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1044
    .end local v2    # "nameEtc":Ljava/lang/String;
    :goto_6
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v0, v5, v7}, Lcom/google/android/common/html/parser/HtmlDocument;->createTagAttribute(Lcom/google/android/common/html/parser/HTML$Attribute;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$TagAttribute;

    move-result-object v7

    invoke-virtual {p1, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 997
    .end local v4    # "originalPrefix":Ljava/lang/String;
    :cond_8
    const/4 v7, 0x0

    goto :goto_4

    .line 1008
    .restart local v4    # "originalPrefix":Ljava/lang/String;
    :cond_9
    const/4 v7, 0x0

    goto :goto_5

    .line 1014
    :cond_a
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->asciiHtmlEscaper()Lcom/google/android/common/base/CharEscaper;

    move-result-object v7

    invoke-virtual {v7, v1}, Lcom/google/android/common/base/CharEscaper;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1019
    iget v7, p2, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->endNamePos:I

    iget v8, p2, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->startValuePos:I

    if-ge v7, v8, :cond_b

    const/4 v7, 0x1

    :goto_7
    invoke-static {v7}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 1020
    iget-object v7, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    iget v8, p2, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->endNamePos:I

    iget v9, p2, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->startValuePos:I

    invoke-virtual {v7, v8, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1023
    iget-boolean v7, p2, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->attrValueIsQuoted:Z

    if-eqz v7, :cond_c

    .line 1026
    const-string v7, "<"

    const-string v8, "&lt;"

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1040
    :goto_8
    iget v7, p2, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->endValuePos:I

    if-gt v7, p4, :cond_e

    const/4 v7, 0x1

    :goto_9
    invoke-static {v7}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 1041
    iget-object v7, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    iget v8, p2, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->endValuePos:I

    invoke-virtual {v7, v8, p4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_6

    .line 1019
    :cond_b
    const/4 v7, 0x0

    goto :goto_7

    .line 1030
    :cond_c
    sget-object v7, Lcom/google/android/common/html/parser/HtmlParser;->NEEDS_QUOTING_ATTRIBUTE_VALUE_REGEX:Ljava/util/regex/Pattern;

    invoke-virtual {v7, v6}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/regex/Matcher;->find()Z

    move-result v7

    if-eqz v7, :cond_d

    .line 1031
    const/16 v7, 0x22

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1032
    const-string v7, "\""

    const-string v8, "&quot;"

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1033
    const/16 v7, 0x22

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_8

    .line 1035
    :cond_d
    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_8

    .line 1040
    :cond_e
    const/4 v7, 0x0

    goto :goto_9

    .line 1047
    .end local v3    # "original":Ljava/lang/StringBuilder;
    .end local v4    # "originalPrefix":Ljava/lang/String;
    :cond_f
    invoke-static {v0, v5}, Lcom/google/android/common/html/parser/HtmlDocument;->createTagAttribute(Lcom/google/android/common/html/parser/HTML$Attribute;Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$TagAttribute;

    move-result-object v7

    invoke-virtual {p1, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_2
.end method

.method private addEndTag(Lcom/google/android/common/html/parser/HTML$Element;III)V
    .locals 9
    .param p1, "element"    # Lcom/google/android/common/html/parser/HTML$Element;
    .param p2, "startPos"    # I
    .param p3, "startAttributesPos"    # I
    .param p4, "endPos"    # I

    .prologue
    const/16 v8, 0x3e

    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 913
    if-eqz p1, :cond_0

    move v4, v5

    :goto_0
    invoke-static {v4}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 914
    iget-object v4, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v4, p2}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v7, 0x3c

    if-ne v4, v7, :cond_1

    move v4, v5

    :goto_1
    invoke-static {v4}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 915
    iget-object v4, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    add-int/lit8 v7, p2, 0x1

    invoke-virtual {v4, v7}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v7, 0x2f

    if-ne v4, v7, :cond_2

    move v4, v5

    :goto_2
    invoke-static {v4}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 917
    iget-boolean v4, p0, Lcom/google/android/common/html/parser/HtmlParser;->preserveAll:Z

    if-eqz v4, :cond_4

    .line 919
    if-ge p2, p4, :cond_3

    :goto_3
    invoke-static {v5}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 920
    iget-object v4, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v4, p2, p4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 921
    .local v0, "content":Ljava/lang/String;
    iget-object v4, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    invoke-static {p1, v0}, Lcom/google/android/common/html/parser/HtmlDocument;->createEndTag(Lcom/google/android/common/html/parser/HTML$Element;Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$EndTag;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 951
    .end local v0    # "content":Ljava/lang/String;
    :goto_4
    return-void

    :cond_0
    move v4, v6

    .line 913
    goto :goto_0

    :cond_1
    move v4, v6

    .line 914
    goto :goto_1

    :cond_2
    move v4, v6

    .line 915
    goto :goto_2

    :cond_3
    move v5, v6

    .line 919
    goto :goto_3

    .line 922
    :cond_4
    iget-boolean v4, p0, Lcom/google/android/common/html/parser/HtmlParser;->preserveValidHtml:Z

    if-eqz v4, :cond_8

    .line 925
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "</"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 931
    .local v3, "validContent":Ljava/lang/StringBuilder;
    if-ge p2, p3, :cond_6

    move v4, v5

    :goto_5
    invoke-static {v4}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 932
    iget-object v4, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    add-int/lit8 v7, p2, 0x2

    invoke-virtual {v4, v7, p3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 933
    .local v2, "tagName":Ljava/lang/String;
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->asciiHtmlEscaper()Lcom/google/android/common/base/CharEscaper;

    move-result-object v4

    invoke-virtual {v4, v2}, Lcom/google/android/common/base/CharEscaper;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 937
    if-gt p3, p4, :cond_7

    :goto_6
    invoke-static {v5}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 938
    iget-object v4, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v4, p3, p4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 939
    .local v1, "endOfTag":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-eq v4, v8, :cond_5

    .line 940
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v8}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 944
    :cond_5
    const-string v4, "\\S+.*>"

    const-string v5, ">"

    invoke-virtual {v1, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 946
    iget-object v4, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {p1, v5}, Lcom/google/android/common/html/parser/HtmlDocument;->createEndTag(Lcom/google/android/common/html/parser/HTML$Element;Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$EndTag;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .end local v1    # "endOfTag":Ljava/lang/String;
    .end local v2    # "tagName":Ljava/lang/String;
    :cond_6
    move v4, v6

    .line 931
    goto :goto_5

    .restart local v2    # "tagName":Ljava/lang/String;
    :cond_7
    move v5, v6

    .line 937
    goto :goto_6

    .line 949
    .end local v2    # "tagName":Ljava/lang/String;
    .end local v3    # "validContent":Ljava/lang/StringBuilder;
    :cond_8
    iget-object v4, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    invoke-static {p1}, Lcom/google/android/common/html/parser/HtmlDocument;->createEndTag(Lcom/google/android/common/html/parser/HTML$Element;)Lcom/google/android/common/html/parser/HtmlDocument$EndTag;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4
.end method

.method private addStartTag(Lcom/google/android/common/html/parser/HTML$Element;IIIIZLjava/util/ArrayList;)V
    .locals 7
    .param p1, "element"    # Lcom/google/android/common/html/parser/HTML$Element;
    .param p2, "startPos"    # I
    .param p3, "startAttributesPos"    # I
    .param p4, "endAttributesPos"    # I
    .param p5, "endPos"    # I
    .param p6, "isSingleTag"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/common/html/parser/HTML$Element;",
            "IIIIZ",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/common/html/parser/HtmlDocument$TagAttribute;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 849
    .local p7, "attributes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/common/html/parser/HtmlDocument$TagAttribute;>;"
    if-ge p2, p3, :cond_0

    const/4 v5, 0x1

    :goto_0
    invoke-static {v5}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 850
    if-gt p3, p4, :cond_1

    const/4 v5, 0x1

    :goto_1
    invoke-static {v5}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 851
    if-gt p4, p5, :cond_2

    const/4 v5, 0x1

    :goto_2
    invoke-static {v5}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 853
    iget-boolean v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->preserveAll:Z

    if-eqz v5, :cond_4

    .line 854
    iget-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v5, p2, p3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 855
    .local v1, "beforeAttrs":Ljava/lang/String;
    iget-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v5, p4, p5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 856
    .local v0, "afterAttrs":Ljava/lang/String;
    if-eqz p6, :cond_3

    invoke-static {p1, p7, v1, v0}, Lcom/google/android/common/html/parser/HtmlDocument;->createSelfTerminatingTag(Lcom/google/android/common/html/parser/HTML$Element;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$Tag;

    move-result-object v3

    .line 861
    .local v3, "tag":Lcom/google/android/common/html/parser/HtmlDocument$Tag;
    :goto_3
    iget-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    invoke-interface {v5, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 900
    .end local v0    # "afterAttrs":Ljava/lang/String;
    .end local v1    # "beforeAttrs":Ljava/lang/String;
    :goto_4
    return-void

    .line 849
    .end local v3    # "tag":Lcom/google/android/common/html/parser/HtmlDocument$Tag;
    :cond_0
    const/4 v5, 0x0

    goto :goto_0

    .line 850
    :cond_1
    const/4 v5, 0x0

    goto :goto_1

    .line 851
    :cond_2
    const/4 v5, 0x0

    goto :goto_2

    .line 856
    .restart local v0    # "afterAttrs":Ljava/lang/String;
    .restart local v1    # "beforeAttrs":Ljava/lang/String;
    :cond_3
    invoke-static {p1, p7, v1, v0}, Lcom/google/android/common/html/parser/HtmlDocument;->createTag(Lcom/google/android/common/html/parser/HTML$Element;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$Tag;

    move-result-object v3

    goto :goto_3

    .line 862
    .end local v0    # "afterAttrs":Ljava/lang/String;
    .end local v1    # "beforeAttrs":Ljava/lang/String;
    :cond_4
    iget-boolean v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->preserveValidHtml:Z

    if-eqz v5, :cond_c

    .line 867
    iget-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v5, p2}, Ljava/lang/String;->charAt(I)C

    move-result v5

    const/16 v6, 0x3c

    if-ne v5, v6, :cond_6

    const/4 v5, 0x1

    :goto_5
    invoke-static {v5}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 868
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v5, "<"

    invoke-direct {v1, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 869
    .local v1, "beforeAttrs":Ljava/lang/StringBuilder;
    iget-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    add-int/lit8 v6, p2, 0x1

    invoke-virtual {v5, v6, p3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 870
    .local v4, "tagName":Ljava/lang/String;
    invoke-static {}, Lcom/google/android/common/base/CharEscapers;->asciiHtmlEscaper()Lcom/google/android/common/base/CharEscaper;

    move-result-object v5

    invoke-virtual {v5, v4}, Lcom/google/android/common/base/CharEscaper;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 873
    add-int/lit8 v2, p5, -0x1

    .line 874
    .local v2, "endContentPos":I
    iget-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v5, v2}, Ljava/lang/String;->charAt(I)C

    move-result v5

    const/16 v6, 0x3e

    if-ne v5, v6, :cond_7

    const/4 v5, 0x1

    :goto_6
    invoke-static {v5}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 875
    if-eqz p6, :cond_5

    .line 876
    add-int/lit8 v2, v2, -0x1

    .line 877
    iget-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v5, v2}, Ljava/lang/String;->charAt(I)C

    move-result v5

    const/16 v6, 0x2f

    if-ne v5, v6, :cond_8

    const/4 v5, 0x1

    :goto_7
    invoke-static {v5}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 879
    :cond_5
    if-gt p4, v2, :cond_9

    const/4 v5, 0x1

    :goto_8
    invoke-static {v5}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 883
    if-ge p4, p5, :cond_a

    const/4 v5, 0x1

    :goto_9
    invoke-static {v5}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 884
    iget-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v5, p4, p5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 887
    .restart local v0    # "afterAttrs":Ljava/lang/String;
    if-eqz p6, :cond_b

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {p1, p7, v5, v0}, Lcom/google/android/common/html/parser/HtmlDocument;->createSelfTerminatingTag(Lcom/google/android/common/html/parser/HTML$Element;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$Tag;

    move-result-object v3

    .line 892
    .restart local v3    # "tag":Lcom/google/android/common/html/parser/HtmlDocument$Tag;
    :goto_a
    iget-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    invoke-interface {v5, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 867
    .end local v0    # "afterAttrs":Ljava/lang/String;
    .end local v1    # "beforeAttrs":Ljava/lang/StringBuilder;
    .end local v2    # "endContentPos":I
    .end local v3    # "tag":Lcom/google/android/common/html/parser/HtmlDocument$Tag;
    .end local v4    # "tagName":Ljava/lang/String;
    :cond_6
    const/4 v5, 0x0

    goto :goto_5

    .line 874
    .restart local v1    # "beforeAttrs":Ljava/lang/StringBuilder;
    .restart local v2    # "endContentPos":I
    .restart local v4    # "tagName":Ljava/lang/String;
    :cond_7
    const/4 v5, 0x0

    goto :goto_6

    .line 877
    :cond_8
    const/4 v5, 0x0

    goto :goto_7

    .line 879
    :cond_9
    const/4 v5, 0x0

    goto :goto_8

    .line 883
    :cond_a
    const/4 v5, 0x0

    goto :goto_9

    .line 887
    .restart local v0    # "afterAttrs":Ljava/lang/String;
    :cond_b
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {p1, p7, v5, v0}, Lcom/google/android/common/html/parser/HtmlDocument;->createTag(Lcom/google/android/common/html/parser/HTML$Element;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$Tag;

    move-result-object v3

    goto :goto_a

    .line 895
    .end local v0    # "afterAttrs":Ljava/lang/String;
    .end local v1    # "beforeAttrs":Ljava/lang/StringBuilder;
    .end local v2    # "endContentPos":I
    .end local v4    # "tagName":Ljava/lang/String;
    :cond_c
    if-eqz p6, :cond_d

    invoke-static {p1, p7}, Lcom/google/android/common/html/parser/HtmlDocument;->createSelfTerminatingTag(Lcom/google/android/common/html/parser/HTML$Element;Ljava/util/List;)Lcom/google/android/common/html/parser/HtmlDocument$Tag;

    move-result-object v3

    .line 898
    .restart local v3    # "tag":Lcom/google/android/common/html/parser/HtmlDocument$Tag;
    :goto_b
    iget-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    invoke-interface {v5, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_4

    .line 895
    .end local v3    # "tag":Lcom/google/android/common/html/parser/HtmlDocument$Tag;
    :cond_d
    invoke-static {p1, p7}, Lcom/google/android/common/html/parser/HtmlDocument;->createTag(Lcom/google/android/common/html/parser/HTML$Element;Ljava/util/List;)Lcom/google/android/common/html/parser/HtmlDocument$Tag;

    move-result-object v3

    goto :goto_b
.end method

.method static coalesceTextNodes(Ljava/util/List;)Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/common/html/parser/HtmlDocument$Node;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/common/html/parser/HtmlDocument$Node;",
            ">;"
        }
    .end annotation

    .prologue
    .line 253
    .local p0, "nodes":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/common/html/parser/HtmlDocument$Node;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v4

    invoke-direct {v2, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 255
    .local v2, "out":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/common/html/parser/HtmlDocument$Node;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newLinkedList()Ljava/util/LinkedList;

    move-result-object v3

    .line 257
    .local v3, "textNodes":Ljava/util/LinkedList;, "Ljava/util/LinkedList<Lcom/google/android/common/html/parser/HtmlDocument$Text;>;"
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/common/html/parser/HtmlDocument$Node;

    .line 258
    .local v1, "node":Lcom/google/android/common/html/parser/HtmlDocument$Node;
    instance-of v4, v1, Lcom/google/android/common/html/parser/HtmlDocument$Text;

    if-eqz v4, :cond_0

    .line 259
    check-cast v1, Lcom/google/android/common/html/parser/HtmlDocument$Text;

    .end local v1    # "node":Lcom/google/android/common/html/parser/HtmlDocument$Node;
    invoke-virtual {v3, v1}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 261
    .restart local v1    # "node":Lcom/google/android/common/html/parser/HtmlDocument$Node;
    :cond_0
    invoke-static {v3, v2}, Lcom/google/android/common/html/parser/HtmlParser;->mergeTextNodes(Ljava/util/LinkedList;Ljava/util/List;)V

    .line 262
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 265
    .end local v1    # "node":Lcom/google/android/common/html/parser/HtmlDocument$Node;
    :cond_1
    invoke-static {v3, v2}, Lcom/google/android/common/html/parser/HtmlParser;->mergeTextNodes(Ljava/util/LinkedList;Ljava/util/List;)V

    .line 266
    return-object v2
.end method

.method private static debug(Ljava/lang/String;)V
    .locals 1
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 1129
    sget-object v0, Ljava/lang/System;->err:Ljava/io/PrintStream;

    invoke-virtual {v0, p0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 1130
    return-void
.end method

.method private lookupUnknownAttribute(Ljava/lang/String;)Lcom/google/android/common/html/parser/HTML$Attribute;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 627
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object p1

    .line 628
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlParser;->unknownAttributes:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/common/html/parser/HTML$Attribute;

    .line 629
    .local v0, "result":Lcom/google/android/common/html/parser/HTML$Attribute;
    if-nez v0, :cond_0

    .line 630
    new-instance v0, Lcom/google/android/common/html/parser/HTML$Attribute;

    .end local v0    # "result":Lcom/google/android/common/html/parser/HTML$Attribute;
    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/google/android/common/html/parser/HTML$Attribute;-><init>(Ljava/lang/String;I)V

    .line 631
    .restart local v0    # "result":Lcom/google/android/common/html/parser/HTML$Attribute;
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlParser;->unknownAttributes:Ljava/util/HashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 633
    :cond_0
    return-object v0
.end method

.method private lookupUnknownElement(Ljava/lang/String;)Lcom/google/android/common/html/parser/HTML$Element;
    .locals 7
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 607
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object p1

    .line 608
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlParser;->unknownElements:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/common/html/parser/HTML$Element;

    .line 609
    .local v0, "result":Lcom/google/android/common/html/parser/HTML$Element;
    if-nez v0, :cond_0

    .line 610
    new-instance v0, Lcom/google/android/common/html/parser/HTML$Element;

    .end local v0    # "result":Lcom/google/android/common/html/parser/HTML$Element;
    const/4 v4, 0x1

    sget-object v6, Lcom/google/android/common/html/parser/HTML$Element$Flow;->NONE:Lcom/google/android/common/html/parser/HTML$Element$Flow;

    move-object v1, p1

    move v3, v2

    move v5, v2

    invoke-direct/range {v0 .. v6}, Lcom/google/android/common/html/parser/HTML$Element;-><init>(Ljava/lang/String;IZZZLcom/google/android/common/html/parser/HTML$Element$Flow;)V

    .line 616
    .restart local v0    # "result":Lcom/google/android/common/html/parser/HTML$Element;
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlParser;->unknownElements:Ljava/util/HashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 618
    :cond_0
    return-object v0
.end method

.method private static mergeTextNodes(Ljava/util/LinkedList;Ljava/util/List;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/LinkedList",
            "<",
            "Lcom/google/android/common/html/parser/HtmlDocument$Text;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/common/html/parser/HtmlDocument$Node;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 278
    .local p0, "textNodes":Ljava/util/LinkedList;, "Ljava/util/LinkedList<Lcom/google/android/common/html/parser/HtmlDocument$Text;>;"
    .local p1, "output":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/common/html/parser/HtmlDocument$Node;>;"
    invoke-virtual {p0}, Ljava/util/LinkedList;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_0

    .line 279
    invoke-virtual {p0}, Ljava/util/LinkedList;->size()I

    move-result v7

    const/4 v8, 0x1

    if-ne v7, v8, :cond_1

    .line 280
    invoke-virtual {p0}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    move-result-object v7

    invoke-interface {p1, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 303
    :cond_0
    :goto_0
    return-void

    .line 282
    :cond_1
    const/4 v3, 0x0

    .line 283
    .local v3, "combinedTextLen":I
    const/4 v1, 0x0

    .line 284
    .local v1, "combinedInputLen":I
    invoke-virtual {p0}, Ljava/util/LinkedList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/google/android/common/html/parser/HtmlDocument$Text;

    .line 285
    .local v6, "text":Lcom/google/android/common/html/parser/HtmlDocument$Text;
    invoke-virtual {v6}, Lcom/google/android/common/html/parser/HtmlDocument$Text;->getText()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    add-int/2addr v3, v7

    .line 286
    invoke-virtual {v6}, Lcom/google/android/common/html/parser/HtmlDocument$Text;->getOriginalHTML()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_2

    .line 287
    invoke-virtual {v6}, Lcom/google/android/common/html/parser/HtmlDocument$Text;->getOriginalHTML()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    add-int/2addr v1, v7

    goto :goto_1

    .line 290
    .end local v6    # "text":Lcom/google/android/common/html/parser/HtmlDocument$Text;
    :cond_3
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 291
    .local v2, "combinedText":Ljava/lang/StringBuilder;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 292
    .local v0, "combinedInput":Ljava/lang/StringBuilder;
    :cond_4
    :goto_2
    invoke-virtual {p0}, Ljava/util/LinkedList;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_5

    .line 293
    invoke-virtual {p0}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/google/android/common/html/parser/HtmlDocument$Text;

    .line 294
    .restart local v6    # "text":Lcom/google/android/common/html/parser/HtmlDocument$Text;
    invoke-virtual {v6}, Lcom/google/android/common/html/parser/HtmlDocument$Text;->getText()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 295
    invoke-virtual {v6}, Lcom/google/android/common/html/parser/HtmlDocument$Text;->getOriginalHTML()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_4

    .line 296
    invoke-virtual {v6}, Lcom/google/android/common/html/parser/HtmlDocument$Text;->getOriginalHTML()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 299
    .end local v6    # "text":Lcom/google/android/common/html/parser/HtmlDocument$Text;
    :cond_5
    if-lez v1, :cond_6

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 300
    .local v5, "originalInput":Ljava/lang/String;
    :goto_3
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7, v5}, Lcom/google/android/common/html/parser/HtmlDocument;->createText(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$Text;

    move-result-object v7

    invoke-interface {p1, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 299
    .end local v5    # "originalInput":Ljava/lang/String;
    :cond_6
    const/4 v5, 0x0

    goto :goto_3
.end method

.method private scanComment(II)I
    .locals 6
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    const/4 v5, -0x1

    .line 1061
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    const-string v2, "<!--"

    const/4 v3, 0x0

    const-string v4, "<!--"

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v1, p1, v2, v3, v4}, Ljava/lang/String;->regionMatches(ILjava/lang/String;II)Z

    move-result v1

    invoke-static {v1}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 1064
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    const-string v2, "-->"

    const-string v3, "<!--"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v3, p1

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v0

    .line 1065
    .local v0, "pos":I
    if-eq v0, v5, :cond_1

    .line 1066
    const-string v1, "-->"

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/2addr v0, v1

    .line 1077
    :goto_0
    iget-boolean v1, p0, Lcom/google/android/common/html/parser/HtmlParser;->preserveAll:Z

    if-eqz v1, :cond_0

    .line 1078
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    iget-object v2, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v2, p1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/common/html/parser/HtmlDocument;->createHtmlComment(Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$Comment;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1081
    :cond_0
    return v0

    .line 1069
    :cond_1
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    const/16 v2, 0x3e

    add-int/lit8 v3, p1, 0x4

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->indexOf(II)I

    move-result v0

    .line 1070
    if-eq v0, v5, :cond_2

    .line 1071
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1073
    :cond_2
    move v0, p2

    goto :goto_0
.end method


# virtual methods
.method lookupAttribute(Ljava/lang/String;)Lcom/google/android/common/html/parser/HTML$Attribute;
    .locals 4
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 824
    iget-object v2, p0, Lcom/google/android/common/html/parser/HtmlParser;->whitelists:Ljava/util/List;

    iget-object v3, p0, Lcom/google/android/common/html/parser/HtmlParser;->whitelists:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-interface {v2, v3}, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;

    move-result-object v1

    .line 825
    .local v1, "iter":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Lcom/google/android/common/html/parser/HtmlWhitelist;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/ListIterator;->hasPrevious()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 826
    invoke-interface {v1}, Ljava/util/ListIterator;->previous()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/common/html/parser/HtmlWhitelist;

    invoke-interface {v2, p1}, Lcom/google/android/common/html/parser/HtmlWhitelist;->lookupAttribute(Ljava/lang/String;)Lcom/google/android/common/html/parser/HTML$Attribute;

    move-result-object v0

    .line 827
    .local v0, "attr":Lcom/google/android/common/html/parser/HTML$Attribute;
    if-eqz v0, :cond_0

    .line 831
    .end local v0    # "attr":Lcom/google/android/common/html/parser/HTML$Attribute;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method lookupElement(Ljava/lang/String;)Lcom/google/android/common/html/parser/HTML$Element;
    .locals 4
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 805
    iget-object v2, p0, Lcom/google/android/common/html/parser/HtmlParser;->whitelists:Ljava/util/List;

    iget-object v3, p0, Lcom/google/android/common/html/parser/HtmlParser;->whitelists:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-interface {v2, v3}, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;

    move-result-object v1

    .line 806
    .local v1, "iter":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Lcom/google/android/common/html/parser/HtmlWhitelist;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/ListIterator;->hasPrevious()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 807
    invoke-interface {v1}, Ljava/util/ListIterator;->previous()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/common/html/parser/HtmlWhitelist;

    invoke-interface {v2, p1}, Lcom/google/android/common/html/parser/HtmlWhitelist;->lookupElement(Ljava/lang/String;)Lcom/google/android/common/html/parser/HTML$Element;

    move-result-object v0

    .line 808
    .local v0, "elem":Lcom/google/android/common/html/parser/HTML$Element;
    if-eqz v0, :cond_0

    .line 812
    .end local v0    # "elem":Lcom/google/android/common/html/parser/HTML$Element;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parse(Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument;
    .locals 9
    .param p1, "html"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 188
    iput-object p1, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    .line 191
    invoke-static {}, Lcom/google/common/collect/Lists;->newLinkedList()Ljava/util/LinkedList;

    move-result-object v5

    iput-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    .line 192
    sget-object v5, Lcom/google/android/common/html/parser/HtmlParser$State;->IN_TEXT:Lcom/google/android/common/html/parser/HtmlParser$State;

    iput-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->state:Lcom/google/android/common/html/parser/HtmlParser$State;

    .line 194
    iput-boolean v6, p0, Lcom/google/android/common/html/parser/HtmlParser;->clipped:Z

    .line 195
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    .line 196
    .local v2, "end":I
    iget v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->clipLength:I

    invoke-static {v5, v2}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 198
    .local v0, "clipEnd":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v2, :cond_7

    iget-boolean v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->clipped:Z

    if-nez v5, :cond_7

    .line 202
    sget-object v5, Lcom/google/android/common/html/parser/HtmlParser$1;->$SwitchMap$com$google$android$common$html$parser$HtmlParser$State:[I

    iget-object v8, p0, Lcom/google/android/common/html/parser/HtmlParser;->state:Lcom/google/android/common/html/parser/HtmlParser$State;

    invoke-virtual {v8}, Lcom/google/android/common/html/parser/HtmlParser$State;->ordinal()I

    move-result v8

    aget v5, v5, v8

    packed-switch v5, :pswitch_data_0

    .line 226
    new-instance v5, Ljava/lang/Error;

    const-string v6, "Unknown state!"

    invoke-direct {v5, v6}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v5

    .line 205
    :pswitch_0
    invoke-virtual {p0, v3, v0}, Lcom/google/android/common/html/parser/HtmlParser;->scanText(II)I

    move-result v4

    .line 206
    .local v4, "pos":I
    if-gt v4, v3, :cond_0

    iget-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->state:Lcom/google/android/common/html/parser/HtmlParser$State;

    sget-object v8, Lcom/google/android/common/html/parser/HtmlParser$State;->IN_TEXT:Lcom/google/android/common/html/parser/HtmlParser$State;

    if-eq v5, v8, :cond_1

    :cond_0
    move v5, v7

    :goto_1
    invoke-static {v5}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 229
    :goto_2
    move v3, v4

    .line 232
    iget v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->clipLength:I

    if-lt v4, v5, :cond_6

    move v5, v7

    :goto_3
    iput-boolean v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->clipped:Z

    goto :goto_0

    :cond_1
    move v5, v6

    .line 206
    goto :goto_1

    .line 210
    .end local v4    # "pos":I
    :pswitch_1
    invoke-virtual {p0, v3, v2}, Lcom/google/android/common/html/parser/HtmlParser;->scanTag(II)I

    move-result v4

    .line 211
    .restart local v4    # "pos":I
    if-le v4, v3, :cond_2

    move v5, v7

    :goto_4
    invoke-static {v5}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    goto :goto_2

    :cond_2
    move v5, v6

    goto :goto_4

    .line 215
    .end local v4    # "pos":I
    :pswitch_2
    invoke-direct {p0, v3, v2}, Lcom/google/android/common/html/parser/HtmlParser;->scanComment(II)I

    move-result v4

    .line 216
    .restart local v4    # "pos":I
    sget-object v5, Lcom/google/android/common/html/parser/HtmlParser$State;->IN_TEXT:Lcom/google/android/common/html/parser/HtmlParser$State;

    iput-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->state:Lcom/google/android/common/html/parser/HtmlParser$State;

    .line 217
    if-le v4, v3, :cond_3

    move v5, v7

    :goto_5
    invoke-static {v5}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    goto :goto_2

    :cond_3
    move v5, v6

    goto :goto_5

    .line 221
    .end local v4    # "pos":I
    :pswitch_3
    invoke-virtual {p0, v3, v2}, Lcom/google/android/common/html/parser/HtmlParser;->scanCDATA(II)I

    move-result v4

    .line 222
    .restart local v4    # "pos":I
    if-gt v4, v3, :cond_4

    iget-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->state:Lcom/google/android/common/html/parser/HtmlParser$State;

    sget-object v8, Lcom/google/android/common/html/parser/HtmlParser$State;->IN_CDATA:Lcom/google/android/common/html/parser/HtmlParser$State;

    if-eq v5, v8, :cond_5

    :cond_4
    move v5, v7

    :goto_6
    invoke-static {v5}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    goto :goto_2

    :cond_5
    move v5, v6

    goto :goto_6

    :cond_6
    move v5, v6

    .line 232
    goto :goto_3

    .line 235
    .end local v4    # "pos":I
    :cond_7
    iget-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    invoke-static {v5}, Lcom/google/android/common/html/parser/HtmlParser;->coalesceTextNodes(Ljava/util/List;)Ljava/util/List;

    move-result-object v5

    iput-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    .line 237
    new-instance v1, Lcom/google/android/common/html/parser/HtmlDocument;

    iget-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    invoke-direct {v1, v5}, Lcom/google/android/common/html/parser/HtmlDocument;-><init>(Ljava/util/List;)V

    .line 238
    .local v1, "doc":Lcom/google/android/common/html/parser/HtmlDocument;
    const/4 v5, 0x0

    iput-object v5, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    .line 239
    const/4 p1, 0x0

    .line 240
    return-object v1

    .line 202
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method scanCDATA(II)I
    .locals 10
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v4, 0x0

    .line 1090
    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    iget-object v2, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/google/android/common/html/parser/HtmlDocument$Tag;

    .line 1091
    .local v9, "tag":Lcom/google/android/common/html/parser/HtmlDocument$Tag;
    invoke-virtual {v9}, Lcom/google/android/common/html/parser/HtmlDocument$Tag;->getElement()Lcom/google/android/common/html/parser/HTML$Element;

    move-result-object v7

    .line 1092
    .local v7, "element":Lcom/google/android/common/html/parser/HTML$Element;
    sget-object v0, Lcom/google/android/common/html/parser/HTML4;->SCRIPT_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    invoke-virtual {v0, v7}, Lcom/google/android/common/html/parser/HTML$Element;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/google/android/common/html/parser/HTML4;->STYLE_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    invoke-virtual {v0, v7}, Lcom/google/android/common/html/parser/HTML$Element;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_0
    move v0, v1

    :goto_0
    invoke-static {v0}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 1095
    move v8, p1

    .local v8, "pos":I
    :goto_1
    if-ge v8, p2, :cond_1

    .line 1096
    add-int/lit8 v0, v8, 0x2

    if-ge v0, p2, :cond_4

    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v0, v8}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v2, 0x3c

    if-ne v0, v2, :cond_4

    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    add-int/lit8 v2, v8, 0x1

    invoke-virtual {v0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v2, 0x2f

    if-ne v0, v2, :cond_4

    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    add-int/lit8 v2, v8, 0x2

    invoke-virtual {v7}, Lcom/google/android/common/html/parser/HTML$Element;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v7}, Lcom/google/android/common/html/parser/HTML$Element;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    invoke-virtual/range {v0 .. v5}, Ljava/lang/String;->regionMatches(ZILjava/lang/String;II)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1106
    :cond_1
    if-le v8, p1, :cond_2

    .line 1107
    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v0, p1, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/common/html/parser/HtmlDocument;->createCDATA(Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$CDATA;

    move-result-object v6

    .line 1109
    .local v6, "cdata":Lcom/google/android/common/html/parser/HtmlDocument$CDATA;
    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    invoke-interface {v0, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1112
    .end local v6    # "cdata":Lcom/google/android/common/html/parser/HtmlDocument$CDATA;
    :cond_2
    sget-object v0, Lcom/google/android/common/html/parser/HtmlParser$State;->IN_TAG:Lcom/google/android/common/html/parser/HtmlParser$State;

    iput-object v0, p0, Lcom/google/android/common/html/parser/HtmlParser;->state:Lcom/google/android/common/html/parser/HtmlParser$State;

    .line 1113
    return v8

    .end local v8    # "pos":I
    :cond_3
    move v0, v4

    .line 1092
    goto :goto_0

    .line 1095
    .restart local v8    # "pos":I
    :cond_4
    add-int/lit8 v8, v8, 0x1

    goto :goto_1
.end method

.method scanTag(II)I
    .locals 21
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 644
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    move/from16 v0, p1

    invoke-virtual {v2, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v4, 0x3c

    if-ne v2, v4, :cond_1

    const/4 v2, 0x1

    :goto_0
    invoke-static {v2}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 648
    add-int/lit8 v13, p1, 0x1

    .line 652
    .local v13, "nameStart":I
    sget-object v2, Lcom/google/android/common/html/parser/HtmlParser$State;->IN_TEXT:Lcom/google/android/common/html/parser/HtmlParser$State;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->state:Lcom/google/android/common/html/parser/HtmlParser$State;

    .line 655
    const/4 v12, 0x0

    .line 656
    .local v12, "isEndTag":Z
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v2, v13}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v4, 0x2f

    if-ne v2, v4, :cond_0

    .line 657
    const/4 v12, 0x1

    .line 658
    add-int/lit8 v13, v13, 0x1

    .line 662
    :cond_0
    new-instance v17, Lcom/google/android/common/html/parser/HtmlParser$TagNameScanner;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    move-object/from16 v0, v17

    invoke-direct {v0, v2}, Lcom/google/android/common/html/parser/HtmlParser$TagNameScanner;-><init>(Ljava/lang/String;)V

    .line 663
    .local v17, "tagNameScanner":Lcom/google/android/common/html/parser/HtmlParser$TagNameScanner;
    move-object/from16 v0, v17

    move/from16 v1, p2

    invoke-virtual {v0, v13, v1}, Lcom/google/android/common/html/parser/HtmlParser$TagNameScanner;->scanName(II)I

    move-result v7

    .line 664
    .local v7, "pos":I
    invoke-virtual/range {v17 .. v17}, Lcom/google/android/common/html/parser/HtmlParser$TagNameScanner;->getTagName()Ljava/lang/String;

    move-result-object v16

    .line 665
    .local v16, "tagName":Ljava/lang/String;
    const/4 v3, 0x0

    .line 666
    .local v3, "element":Lcom/google/android/common/html/parser/HTML$Element;
    if-nez v16, :cond_7

    .line 670
    if-nez v12, :cond_3

    .line 672
    const-string v4, "<"

    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->preserveAll:Z

    if-eqz v2, :cond_2

    const-string v2, "<"

    :goto_1
    invoke-static {v4, v2}, Lcom/google/android/common/html/parser/HtmlDocument;->createText(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$Text;

    move-result-object v18

    .line 673
    .local v18, "text":Lcom/google/android/common/html/parser/HtmlDocument$Text;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    move-object/from16 v0, v18

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 674
    sget-object v2, Lcom/google/android/common/html/parser/HtmlParser$State;->IN_TEXT:Lcom/google/android/common/html/parser/HtmlParser$State;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->state:Lcom/google/android/common/html/parser/HtmlParser$State;

    .line 793
    .end local v13    # "nameStart":I
    .end local v18    # "text":Lcom/google/android/common/html/parser/HtmlDocument$Text;
    :goto_2
    return v13

    .line 644
    .end local v3    # "element":Lcom/google/android/common/html/parser/HTML$Element;
    .end local v7    # "pos":I
    .end local v12    # "isEndTag":Z
    .end local v16    # "tagName":Ljava/lang/String;
    .end local v17    # "tagNameScanner":Lcom/google/android/common/html/parser/HtmlParser$TagNameScanner;
    :cond_1
    const/4 v2, 0x0

    goto :goto_0

    .line 672
    .restart local v3    # "element":Lcom/google/android/common/html/parser/HTML$Element;
    .restart local v7    # "pos":I
    .restart local v12    # "isEndTag":Z
    .restart local v13    # "nameStart":I
    .restart local v16    # "tagName":Ljava/lang/String;
    .restart local v17    # "tagNameScanner":Lcom/google/android/common/html/parser/HtmlParser$TagNameScanner;
    :cond_2
    const/4 v2, 0x0

    goto :goto_1

    .line 678
    :cond_3
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->preserveAll:Z

    if-eqz v2, :cond_4

    .line 679
    const-string v2, ""

    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lcom/google/android/common/html/parser/HtmlParser;->lookupUnknownElement(Ljava/lang/String;)Lcom/google/android/common/html/parser/HTML$Element;

    move-result-object v3

    .line 695
    :cond_4
    :goto_3
    const/4 v8, 0x0

    .line 696
    .local v8, "isSingleTag":Z
    const/4 v9, 0x0

    .line 697
    .local v9, "attributes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/common/html/parser/HtmlDocument$TagAttribute;>;"
    move v5, v7

    .line 698
    .local v5, "allAttributesStartPos":I
    move v6, v7

    .line 699
    .local v6, "nextAttributeStartPos":I
    new-instance v10, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-direct {v10, v2}, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;-><init>(Ljava/lang/String;)V

    .line 700
    .local v10, "attributeScanner":Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;
    :goto_4
    move/from16 v0, p2

    if-ge v7, v0, :cond_5

    .line 701
    move v15, v7

    .line 702
    .local v15, "startPos":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v2, v7}, Ljava/lang/String;->charAt(I)C

    move-result v11

    .line 705
    .local v11, "ch":C
    add-int/lit8 v2, v7, 0x1

    move/from16 v0, p2

    if-ge v2, v0, :cond_9

    const/16 v2, 0x2f

    if-ne v11, v2, :cond_9

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    add-int/lit8 v4, v7, 0x1

    invoke-virtual {v2, v4}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v4, 0x3e

    if-ne v2, v4, :cond_9

    .line 706
    const/4 v8, 0x1

    .line 707
    add-int/lit8 v7, v7, 0x1

    .line 755
    .end local v11    # "ch":C
    .end local v15    # "startPos":I
    :cond_5
    move/from16 v0, p2

    if-ne v7, v0, :cond_14

    .line 756
    move/from16 v0, p1

    move/from16 v1, p2

    if-ge v0, v1, :cond_12

    const/4 v2, 0x1

    :goto_5
    invoke-static {v2}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 757
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    move/from16 v0, p1

    move/from16 v1, p2

    invoke-virtual {v2, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v19

    .line 758
    .local v19, "textNodeContent":Ljava/lang/String;
    const/4 v14, 0x0

    .line 759
    .local v14, "originalContent":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->preserveAll:Z

    if-eqz v2, :cond_13

    .line 760
    move-object/from16 v14, v19

    .line 767
    :cond_6
    :goto_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    move-object/from16 v0, v19

    invoke-static {v0, v14}, Lcom/google/android/common/html/parser/HtmlDocument;->createEscapedText(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$Text;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move/from16 v13, p2

    .line 768
    goto :goto_2

    .line 682
    .end local v5    # "allAttributesStartPos":I
    .end local v6    # "nextAttributeStartPos":I
    .end local v8    # "isSingleTag":Z
    .end local v9    # "attributes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/common/html/parser/HtmlDocument$TagAttribute;>;"
    .end local v10    # "attributeScanner":Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;
    .end local v14    # "originalContent":Ljava/lang/String;
    .end local v19    # "textNodeContent":Ljava/lang/String;
    :cond_7
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/google/android/common/html/parser/HtmlParser;->lookupElement(Ljava/lang/String;)Lcom/google/android/common/html/parser/HTML$Element;

    move-result-object v3

    .line 683
    if-nez v3, :cond_4

    .line 684
    sget-boolean v2, Lcom/google/android/common/html/parser/HtmlParser;->DEBUG:Z

    if-eqz v2, :cond_8

    .line 686
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unknown element: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, v16

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/common/html/parser/HtmlParser;->debug(Ljava/lang/String;)V

    .line 688
    :cond_8
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->preserveAll:Z

    if-eqz v2, :cond_4

    .line 689
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v1}, Lcom/google/android/common/html/parser/HtmlParser;->lookupUnknownElement(Ljava/lang/String;)Lcom/google/android/common/html/parser/HTML$Element;

    move-result-object v3

    goto/16 :goto_3

    .line 710
    .restart local v5    # "allAttributesStartPos":I
    .restart local v6    # "nextAttributeStartPos":I
    .restart local v8    # "isSingleTag":Z
    .restart local v9    # "attributes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/common/html/parser/HtmlDocument$TagAttribute;>;"
    .restart local v10    # "attributeScanner":Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;
    .restart local v11    # "ch":C
    .restart local v15    # "startPos":I
    :cond_9
    const/16 v2, 0x3e

    if-eq v11, v2, :cond_5

    .line 715
    if-eqz v12, :cond_b

    const/16 v2, 0x3c

    if-ne v2, v11, :cond_b

    .line 719
    if-eqz v3, :cond_a

    .line 720
    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-direct {v0, v3, v1, v5, v7}, Lcom/google/android/common/html/parser/HtmlParser;->addEndTag(Lcom/google/android/common/html/parser/HTML$Element;III)V

    .line 722
    :cond_a
    sget-object v2, Lcom/google/android/common/html/parser/HtmlParser$State;->IN_TEXT:Lcom/google/android/common/html/parser/HtmlParser$State;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->state:Lcom/google/android/common/html/parser/HtmlParser$State;

    move v13, v7

    .line 723
    goto/16 :goto_2

    .line 726
    :cond_b
    invoke-static {v11}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 728
    add-int/lit8 v7, v7, 0x1

    .line 751
    :cond_c
    :goto_7
    if-le v7, v15, :cond_11

    const/4 v2, 0x1

    :goto_8
    invoke-static {v2}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    goto/16 :goto_4

    .line 731
    :cond_d
    invoke-virtual {v10}, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->reset()V

    .line 732
    move/from16 v0, p2

    invoke-virtual {v10, v7, v0}, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->scanName(II)I

    move-result v7

    .line 733
    if-le v7, v15, :cond_10

    const/4 v2, 0x1

    :goto_9
    invoke-static {v2}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 736
    invoke-virtual {v10}, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->getName()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_c

    .line 737
    move/from16 v0, p2

    invoke-virtual {v10, v7, v0}, Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;->scanValue(II)I

    move-result v7

    .line 740
    if-eqz v3, :cond_f

    .line 741
    if-nez v9, :cond_e

    .line 742
    new-instance v9, Ljava/util/ArrayList;

    .end local v9    # "attributes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/common/html/parser/HtmlDocument$TagAttribute;>;"
    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 744
    .restart local v9    # "attributes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/common/html/parser/HtmlDocument$TagAttribute;>;"
    :cond_e
    move-object/from16 v0, p0

    invoke-direct {v0, v9, v10, v6, v7}, Lcom/google/android/common/html/parser/HtmlParser;->addAttribute(Ljava/util/ArrayList;Lcom/google/android/common/html/parser/HtmlParser$AttributeScanner;II)V

    .line 746
    :cond_f
    move v6, v7

    goto :goto_7

    .line 733
    :cond_10
    const/4 v2, 0x0

    goto :goto_9

    .line 751
    :cond_11
    const/4 v2, 0x0

    goto :goto_8

    .line 756
    .end local v11    # "ch":C
    .end local v15    # "startPos":I
    :cond_12
    const/4 v2, 0x0

    goto/16 :goto_5

    .line 761
    .restart local v14    # "originalContent":Ljava/lang/String;
    .restart local v19    # "textNodeContent":Ljava/lang/String;
    :cond_13
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->preserveValidHtml:Z

    if-eqz v2, :cond_6

    .line 764
    const/16 v2, 0x3c

    invoke-static {v2}, Lcom/google/android/common/base/CharMatcher;->is(C)Lcom/google/android/common/base/CharMatcher;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    move/from16 v0, p1

    move/from16 v1, p2

    invoke-virtual {v4, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    const-string v20, "&lt;"

    move-object/from16 v0, v20

    invoke-virtual {v2, v4, v0}, Lcom/google/android/common/base/CharMatcher;->replaceFrom(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v14

    goto/16 :goto_6

    .line 772
    .end local v14    # "originalContent":Ljava/lang/String;
    .end local v19    # "textNodeContent":Ljava/lang/String;
    :cond_14
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v2, v7}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v4, 0x3e

    if-ne v2, v4, :cond_16

    const/4 v2, 0x1

    :goto_a
    invoke-static {v2}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 773
    add-int/lit8 v7, v7, 0x1

    .line 777
    if-eqz v3, :cond_15

    .line 778
    if-eqz v12, :cond_17

    .line 779
    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-direct {v0, v3, v1, v5, v7}, Lcom/google/android/common/html/parser/HtmlParser;->addEndTag(Lcom/google/android/common/html/parser/HTML$Element;III)V

    :cond_15
    :goto_b
    move v13, v7

    .line 793
    goto/16 :goto_2

    .line 772
    :cond_16
    const/4 v2, 0x0

    goto :goto_a

    .line 783
    :cond_17
    sget-object v2, Lcom/google/android/common/html/parser/HTML4;->SCRIPT_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    invoke-virtual {v2, v3}, Lcom/google/android/common/html/parser/HTML$Element;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_18

    sget-object v2, Lcom/google/android/common/html/parser/HTML4;->STYLE_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    invoke-virtual {v2, v3}, Lcom/google/android/common/html/parser/HTML$Element;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_19

    .line 784
    :cond_18
    sget-object v2, Lcom/google/android/common/html/parser/HtmlParser$State;->IN_CDATA:Lcom/google/android/common/html/parser/HtmlParser$State;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/google/android/common/html/parser/HtmlParser;->state:Lcom/google/android/common/html/parser/HtmlParser$State;

    :cond_19
    move-object/from16 v2, p0

    move/from16 v4, p1

    .line 787
    invoke-direct/range {v2 .. v9}, Lcom/google/android/common/html/parser/HtmlParser;->addStartTag(Lcom/google/android/common/html/parser/HTML$Element;IIIIZLjava/util/ArrayList;)V

    goto :goto_b
.end method

.method scanText(II)I
    .locals 13
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 323
    move v6, p1

    .local v6, "pos":I
    :goto_0
    if-ge v6, p2, :cond_1

    .line 324
    iget-object v8, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v8, v6}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 325
    .local v0, "ch":C
    const/16 v8, 0x3c

    if-ne v0, v8, :cond_6

    add-int/lit8 v8, v6, 0x1

    if-ge v8, p2, :cond_6

    .line 327
    iget-object v8, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    add-int/lit8 v9, v6, 0x1

    invoke-virtual {v8, v9}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 328
    const/16 v8, 0x2f

    if-eq v0, v8, :cond_0

    invoke-static {v0}, Ljava/lang/Character;->isLetter(C)Z

    move-result v8

    if-nez v8, :cond_0

    const/16 v8, 0x21

    if-eq v0, v8, :cond_0

    const/16 v8, 0x3f

    if-ne v0, v8, :cond_6

    .line 331
    :cond_0
    iget-object v8, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    add-int/lit8 v9, v6, 0x1

    const-string v10, "!--"

    const/4 v11, 0x0

    const/4 v12, 0x3

    invoke-virtual {v8, v9, v10, v11, v12}, Ljava/lang/String;->regionMatches(ILjava/lang/String;II)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 332
    sget-object v8, Lcom/google/android/common/html/parser/HtmlParser$State;->IN_COMMENT:Lcom/google/android/common/html/parser/HtmlParser$State;

    iput-object v8, p0, Lcom/google/android/common/html/parser/HtmlParser;->state:Lcom/google/android/common/html/parser/HtmlParser$State;

    .line 341
    .end local v0    # "ch":C
    :cond_1
    :goto_1
    if-le v6, p1, :cond_4

    .line 342
    move v1, v6

    .line 343
    .local v1, "finalPos":I
    iget-object v8, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v8, p1, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 345
    .local v2, "htmlTail":Ljava/lang/String;
    iget v8, p0, Lcom/google/android/common/html/parser/HtmlParser;->clipLength:I

    if-ne v6, v8, :cond_2

    iget v8, p0, Lcom/google/android/common/html/parser/HtmlParser;->clipLength:I

    iget-object v9, p0, Lcom/google/android/common/html/parser/HtmlParser;->html:Ljava/lang/String;

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v9

    if-ge v8, v9, :cond_2

    .line 352
    sget-object v8, Lcom/google/android/common/html/parser/HtmlParser;->TRUNCATED_ENTITY:Ljava/util/regex/Pattern;

    invoke-virtual {v8, v2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v4

    .line 353
    .local v4, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v4}, Ljava/util/regex/Matcher;->find()Z

    move-result v8

    if-eqz v8, :cond_2

    .line 354
    invoke-virtual {v4}, Ljava/util/regex/Matcher;->start()I

    move-result v3

    .line 357
    .local v3, "matchStart":I
    add-int v1, p1, v3

    .line 358
    const/4 v8, 0x0

    invoke-virtual {v2, v8, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 362
    .end local v3    # "matchStart":I
    .end local v4    # "matcher":Ljava/util/regex/Matcher;
    :cond_2
    if-le v1, p1, :cond_4

    .line 363
    const/4 v5, 0x0

    .line 364
    .local v5, "originalHtml":Ljava/lang/String;
    iget-boolean v8, p0, Lcom/google/android/common/html/parser/HtmlParser;->preserveAll:Z

    if-eqz v8, :cond_7

    .line 365
    move-object v5, v2

    .line 376
    :cond_3
    :goto_2
    invoke-static {v2, v5}, Lcom/google/android/common/html/parser/HtmlDocument;->createEscapedText(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/common/html/parser/HtmlDocument$Text;

    move-result-object v7

    .line 377
    .local v7, "textnode":Lcom/google/android/common/html/parser/HtmlDocument$Text;
    iget-object v8, p0, Lcom/google/android/common/html/parser/HtmlParser;->nodes:Ljava/util/List;

    invoke-interface {v8, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 380
    .end local v1    # "finalPos":I
    .end local v2    # "htmlTail":Ljava/lang/String;
    .end local v5    # "originalHtml":Ljava/lang/String;
    .end local v7    # "textnode":Lcom/google/android/common/html/parser/HtmlDocument$Text;
    :cond_4
    return v6

    .line 334
    .restart local v0    # "ch":C
    :cond_5
    sget-object v8, Lcom/google/android/common/html/parser/HtmlParser$State;->IN_TAG:Lcom/google/android/common/html/parser/HtmlParser$State;

    iput-object v8, p0, Lcom/google/android/common/html/parser/HtmlParser;->state:Lcom/google/android/common/html/parser/HtmlParser$State;

    goto :goto_1

    .line 323
    :cond_6
    add-int/lit8 v6, v6, 0x1

    goto/16 :goto_0

    .line 366
    .end local v0    # "ch":C
    .restart local v1    # "finalPos":I
    .restart local v2    # "htmlTail":Ljava/lang/String;
    .restart local v5    # "originalHtml":Ljava/lang/String;
    :cond_7
    iget-boolean v8, p0, Lcom/google/android/common/html/parser/HtmlParser;->preserveValidHtml:Z

    if-eqz v8, :cond_3

    .line 373
    const/16 v8, 0x3c

    invoke-static {v8}, Lcom/google/android/common/base/CharMatcher;->is(C)Lcom/google/android/common/base/CharMatcher;

    move-result-object v8

    const-string v9, "&lt;"

    invoke-virtual {v8, v2, v9}, Lcom/google/android/common/base/CharMatcher;->replaceFrom(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v5

    goto :goto_2
.end method
