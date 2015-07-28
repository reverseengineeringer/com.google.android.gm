.class public Lcom/google/android/common/html/parser/HtmlDocument$Comment;
.super Lcom/google/android/common/html/parser/HtmlDocument$Node;
.source "HtmlDocument.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/common/html/parser/HtmlDocument;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Comment"
.end annotation


# instance fields
.field private final content:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    .line 282
    invoke-direct {p0}, Lcom/google/android/common/html/parser/HtmlDocument$Node;-><init>()V

    .line 283
    iput-object p1, p0, Lcom/google/android/common/html/parser/HtmlDocument$Comment;->content:Ljava/lang/String;

    .line 284
    return-void
.end method


# virtual methods
.method public accept(Lcom/google/android/common/html/parser/HtmlDocument$Visitor;)V
    .locals 0
    .param p1, "visitor"    # Lcom/google/android/common/html/parser/HtmlDocument$Visitor;

    .prologue
    .line 288
    invoke-interface {p1, p0}, Lcom/google/android/common/html/parser/HtmlDocument$Visitor;->visitComment(Lcom/google/android/common/html/parser/HtmlDocument$Comment;)V

    .line 289
    return-void
.end method

.method public getContent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 322
    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlDocument$Comment;->content:Ljava/lang/String;

    return-object v0
.end method
