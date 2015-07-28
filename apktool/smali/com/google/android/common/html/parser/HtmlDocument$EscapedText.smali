.class Lcom/google/android/common/html/parser/HtmlDocument$EscapedText;
.super Lcom/google/android/common/html/parser/HtmlDocument$Text;
.source "HtmlDocument.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/common/html/parser/HtmlDocument;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "EscapedText"
.end annotation


# instance fields
.field private final htmlText:Ljava/lang/String;

.field private text:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "htmlText"    # Ljava/lang/String;
    .param p2, "originalHtml"    # Ljava/lang/String;

    .prologue
    .line 468
    invoke-direct {p0, p2}, Lcom/google/android/common/html/parser/HtmlDocument$Text;-><init>(Ljava/lang/String;)V

    .line 469
    iput-object p1, p0, Lcom/google/android/common/html/parser/HtmlDocument$EscapedText;->htmlText:Ljava/lang/String;

    .line 470
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/common/html/parser/HtmlDocument$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Lcom/google/android/common/html/parser/HtmlDocument$1;

    .prologue
    .line 463
    invoke-direct {p0, p1, p2}, Lcom/google/android/common/html/parser/HtmlDocument$EscapedText;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public getText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 473
    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlDocument$EscapedText;->text:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 474
    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlDocument$EscapedText;->htmlText:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/common/base/StringUtil;->unescapeHTML(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/common/html/parser/HtmlDocument$EscapedText;->text:Ljava/lang/String;

    .line 476
    :cond_0
    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlDocument$EscapedText;->text:Ljava/lang/String;

    return-object v0
.end method
