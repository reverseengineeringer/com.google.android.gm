.class Lcom/google/android/common/html/parser/HtmlDocument$UnescapedText;
.super Lcom/google/android/common/html/parser/HtmlDocument$Text;
.source "HtmlDocument.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/common/html/parser/HtmlDocument;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "UnescapedText"
.end annotation


# instance fields
.field protected final text:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "plainText"    # Ljava/lang/String;
    .param p2, "originalHtml"    # Ljava/lang/String;

    .prologue
    .line 449
    invoke-direct {p0, p2}, Lcom/google/android/common/html/parser/HtmlDocument$Text;-><init>(Ljava/lang/String;)V

    .line 450
    if-eqz p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 451
    iput-object p1, p0, Lcom/google/android/common/html/parser/HtmlDocument$UnescapedText;->text:Ljava/lang/String;

    .line 452
    return-void

    .line 450
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method synthetic constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/common/html/parser/HtmlDocument$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Lcom/google/android/common/html/parser/HtmlDocument$1;

    .prologue
    .line 442
    invoke-direct {p0, p1, p2}, Lcom/google/android/common/html/parser/HtmlDocument$UnescapedText;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public getText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 455
    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlDocument$UnescapedText;->text:Ljava/lang/String;

    return-object v0
.end method
