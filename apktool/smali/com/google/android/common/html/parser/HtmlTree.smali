.class public Lcom/google/android/common/html/parser/HtmlTree;
.super Ljava/lang/Object;
.source "HtmlTree.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/common/html/parser/HtmlTree$2;,
        Lcom/google/android/common/html/parser/HtmlTree$DefaultPlainTextConverter;,
        Lcom/google/android/common/html/parser/HtmlTree$PlainTextPrinter;,
        Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverter;,
        Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;
    }
.end annotation


# static fields
.field private static final DEFAULT_CONVERTER_FACTORY:Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;

.field private static final logger:Ljava/util/logging/Logger;


# instance fields
.field private final begins:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private converterFactory:Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;

.field private final ends:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final nodes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/common/html/parser/HtmlDocument$Node;",
            ">;"
        }
    .end annotation
.end field

.field private parent:I

.field private plainText:Ljava/lang/String;

.field private stack:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private textPositions:[I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 89
    new-instance v0, Lcom/google/android/common/html/parser/HtmlTree$1;

    invoke-direct {v0}, Lcom/google/android/common/html/parser/HtmlTree$1;-><init>()V

    sput-object v0, Lcom/google/android/common/html/parser/HtmlTree;->DEFAULT_CONVERTER_FACTORY:Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;

    .line 117
    const-class v0, Lcom/google/android/common/html/parser/HtmlTree;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/google/android/common/html/parser/HtmlTree;->logger:Ljava/util/logging/Logger;

    return-void
.end method

.method constructor <init>()V
    .locals 1

    .prologue
    .line 122
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 97
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/common/html/parser/HtmlTree;->nodes:Ljava/util/List;

    .line 100
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    iput-object v0, p0, Lcom/google/android/common/html/parser/HtmlTree;->begins:Ljava/util/Stack;

    .line 101
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    iput-object v0, p0, Lcom/google/android/common/html/parser/HtmlTree;->ends:Ljava/util/Stack;

    .line 112
    sget-object v0, Lcom/google/android/common/html/parser/HtmlTree;->DEFAULT_CONVERTER_FACTORY:Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;

    iput-object v0, p0, Lcom/google/android/common/html/parser/HtmlTree;->converterFactory:Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;

    .line 123
    return-void
.end method

.method private addNode(Lcom/google/android/common/html/parser/HtmlDocument$Node;II)V
    .locals 2
    .param p1, "n"    # Lcom/google/android/common/html/parser/HtmlDocument$Node;
    .param p2, "begin"    # I
    .param p3, "end"    # I

    .prologue
    .line 955
    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlTree;->nodes:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 956
    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlTree;->begins:Ljava/util/Stack;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/Stack;->add(Ljava/lang/Object;)Z

    .line 957
    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlTree;->ends:Ljava/util/Stack;

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/Stack;->add(Ljava/lang/Object;)Z

    .line 958
    return-void
.end method

.method private convertToPlainText()V
    .locals 5

    .prologue
    .line 524
    iget-object v3, p0, Lcom/google/android/common/html/parser/HtmlTree;->plainText:Ljava/lang/String;

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/google/android/common/html/parser/HtmlTree;->textPositions:[I

    if-nez v3, :cond_0

    const/4 v3, 0x1

    :goto_0
    invoke-static {v3}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 526
    iget-object v3, p0, Lcom/google/android/common/html/parser/HtmlTree;->nodes:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v2

    .line 530
    .local v2, "numNodes":I
    add-int/lit8 v3, v2, 0x1

    new-array v3, v3, [I

    iput-object v3, p0, Lcom/google/android/common/html/parser/HtmlTree;->textPositions:[I

    .line 532
    iget-object v3, p0, Lcom/google/android/common/html/parser/HtmlTree;->converterFactory:Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;

    invoke-interface {v3}, Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;->createInstance()Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverter;

    move-result-object v0

    .line 534
    .local v0, "converter":Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverter;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    if-ge v1, v2, :cond_1

    .line 535
    iget-object v3, p0, Lcom/google/android/common/html/parser/HtmlTree;->textPositions:[I

    invoke-interface {v0}, Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverter;->getPlainTextLength()I

    move-result v4

    aput v4, v3, v1

    .line 536
    iget-object v3, p0, Lcom/google/android/common/html/parser/HtmlTree;->nodes:Ljava/util/List;

    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/common/html/parser/HtmlDocument$Node;

    iget-object v4, p0, Lcom/google/android/common/html/parser/HtmlTree;->ends:Ljava/util/Stack;

    invoke-virtual {v4, v1}, Ljava/util/Stack;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-interface {v0, v3, v1, v4}, Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverter;->addNode(Lcom/google/android/common/html/parser/HtmlDocument$Node;II)V

    .line 534
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 524
    .end local v0    # "converter":Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverter;
    .end local v1    # "i":I
    .end local v2    # "numNodes":I
    :cond_0
    const/4 v3, 0x0

    goto :goto_0

    .line 540
    .restart local v0    # "converter":Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverter;
    .restart local v1    # "i":I
    .restart local v2    # "numNodes":I
    :cond_1
    iget-object v3, p0, Lcom/google/android/common/html/parser/HtmlTree;->textPositions:[I

    invoke-interface {v0}, Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverter;->getPlainTextLength()I

    move-result v4

    aput v4, v3, v2

    .line 542
    invoke-interface {v0}, Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverter;->getPlainText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/google/android/common/html/parser/HtmlTree;->plainText:Ljava/lang/String;

    .line 553
    return-void
.end method


# virtual methods
.method addEndTag(Lcom/google/android/common/html/parser/HtmlDocument$EndTag;)V
    .locals 4
    .param p1, "t"    # Lcom/google/android/common/html/parser/HtmlDocument$EndTag;

    .prologue
    .line 926
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlTree;->nodes:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    .line 927
    .local v0, "nodenum":I
    iget v1, p0, Lcom/google/android/common/html/parser/HtmlTree;->parent:I

    invoke-direct {p0, p1, v1, v0}, Lcom/google/android/common/html/parser/HtmlTree;->addNode(Lcom/google/android/common/html/parser/HtmlDocument$Node;II)V

    .line 929
    iget v1, p0, Lcom/google/android/common/html/parser/HtmlTree;->parent:I

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    .line 930
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlTree;->ends:Ljava/util/Stack;

    iget v2, p0, Lcom/google/android/common/html/parser/HtmlTree;->parent:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/Stack;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 934
    :cond_0
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlTree;->stack:Ljava/util/Stack;

    invoke-virtual {v1}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    iput v1, p0, Lcom/google/android/common/html/parser/HtmlTree;->parent:I

    .line 935
    return-void
.end method

.method addSingularTag(Lcom/google/android/common/html/parser/HtmlDocument$Tag;)V
    .locals 2
    .param p1, "t"    # Lcom/google/android/common/html/parser/HtmlDocument$Tag;

    .prologue
    .line 939
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlTree;->nodes:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    .line 940
    .local v0, "nodenum":I
    invoke-direct {p0, p1, v0, v0}, Lcom/google/android/common/html/parser/HtmlTree;->addNode(Lcom/google/android/common/html/parser/HtmlDocument$Node;II)V

    .line 941
    return-void
.end method

.method addStartTag(Lcom/google/android/common/html/parser/HtmlDocument$Tag;)V
    .locals 3
    .param p1, "t"    # Lcom/google/android/common/html/parser/HtmlDocument$Tag;

    .prologue
    .line 915
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlTree;->nodes:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    .line 916
    .local v0, "nodenum":I
    const/4 v1, -0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/google/android/common/html/parser/HtmlTree;->addNode(Lcom/google/android/common/html/parser/HtmlDocument$Node;II)V

    .line 918
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlTree;->stack:Ljava/util/Stack;

    iget v2, p0, Lcom/google/android/common/html/parser/HtmlTree;->parent:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/Stack;->add(Ljava/lang/Object;)Z

    .line 919
    iput v0, p0, Lcom/google/android/common/html/parser/HtmlTree;->parent:I

    .line 920
    return-void
.end method

.method addText(Lcom/google/android/common/html/parser/HtmlDocument$Text;)V
    .locals 2
    .param p1, "t"    # Lcom/google/android/common/html/parser/HtmlDocument$Text;

    .prologue
    .line 948
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlTree;->nodes:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    .line 949
    .local v0, "nodenum":I
    invoke-direct {p0, p1, v0, v0}, Lcom/google/android/common/html/parser/HtmlTree;->addNode(Lcom/google/android/common/html/parser/HtmlDocument$Node;II)V

    .line 950
    return-void
.end method

.method finish()V
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 907
    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlTree;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->size()I

    move-result v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    invoke-static {v0}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 908
    iget v0, p0, Lcom/google/android/common/html/parser/HtmlTree;->parent:I

    const/4 v3, -0x1

    if-ne v0, v3, :cond_1

    :goto_1
    invoke-static {v1}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 909
    return-void

    :cond_0
    move v0, v2

    .line 907
    goto :goto_0

    :cond_1
    move v1, v2

    .line 908
    goto :goto_1
.end method

.method public getPlainText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 497
    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlTree;->plainText:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 498
    invoke-direct {p0}, Lcom/google/android/common/html/parser/HtmlTree;->convertToPlainText()V

    .line 500
    :cond_0
    iget-object v0, p0, Lcom/google/android/common/html/parser/HtmlTree;->plainText:Ljava/lang/String;

    return-object v0
.end method

.method public setPlainTextConverterFactory(Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;)V
    .locals 2
    .param p1, "factory"    # Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;

    .prologue
    .line 130
    if-nez p1, :cond_0

    .line 131
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "factory must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 133
    :cond_0
    iput-object p1, p0, Lcom/google/android/common/html/parser/HtmlTree;->converterFactory:Lcom/google/android/common/html/parser/HtmlTree$PlainTextConverterFactory;

    .line 134
    return-void
.end method

.method start()V
    .locals 1

    .prologue
    .line 901
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    iput-object v0, p0, Lcom/google/android/common/html/parser/HtmlTree;->stack:Ljava/util/Stack;

    .line 902
    const/4 v0, -0x1

    iput v0, p0, Lcom/google/android/common/html/parser/HtmlTree;->parent:I

    .line 903
    return-void
.end method
