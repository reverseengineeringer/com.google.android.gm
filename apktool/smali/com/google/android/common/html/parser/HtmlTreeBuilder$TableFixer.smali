.class Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;
.super Ljava/lang/Object;
.source "HtmlTreeBuilder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/common/html/parser/HtmlTreeBuilder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "TableFixer"
.end annotation


# instance fields
.field private state:I

.field private tables:I

.field final synthetic this$0:Lcom/google/android/common/html/parser/HtmlTreeBuilder;


# direct methods
.method constructor <init>(Lcom/google/android/common/html/parser/HtmlTreeBuilder;)V
    .locals 1

    .prologue
    .line 184
    iput-object p1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->this$0:Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 186
    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    return-void
.end method

.method private ensureCellState()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 283
    iget v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->state:I

    if-eq v1, v3, :cond_0

    .line 284
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->this$0:Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    sget-object v2, Lcom/google/android/common/html/parser/HTML4;->TD_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    # invokes: Lcom/google/android/common/html/parser/HtmlTreeBuilder;->push(Lcom/google/android/common/html/parser/HTML$Element;)V
    invoke-static {v1, v2}, Lcom/google/android/common/html/parser/HtmlTreeBuilder;->access$000(Lcom/google/android/common/html/parser/HtmlTreeBuilder;Lcom/google/android/common/html/parser/HTML$Element;)V

    .line 286
    sget-object v1, Lcom/google/android/common/html/parser/HTML4;->TD_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/google/android/common/html/parser/HtmlDocument;->createTag(Lcom/google/android/common/html/parser/HTML$Element;Ljava/util/List;)Lcom/google/android/common/html/parser/HtmlDocument$Tag;

    move-result-object v0

    .line 287
    .local v0, "tdTag":Lcom/google/android/common/html/parser/HtmlDocument$Tag;
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->this$0:Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    # getter for: Lcom/google/android/common/html/parser/HtmlTreeBuilder;->tree:Lcom/google/android/common/html/parser/HtmlTree;
    invoke-static {v1}, Lcom/google/android/common/html/parser/HtmlTreeBuilder;->access$100(Lcom/google/android/common/html/parser/HtmlTreeBuilder;)Lcom/google/android/common/html/parser/HtmlTree;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/google/android/common/html/parser/HtmlTree;->addStartTag(Lcom/google/android/common/html/parser/HtmlDocument$Tag;)V

    .line 289
    iput v3, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->state:I

    .line 291
    .end local v0    # "tdTag":Lcom/google/android/common/html/parser/HtmlDocument$Tag;
    :cond_0
    return-void
.end method

.method private ensureTableState()V
    .locals 3

    .prologue
    .line 270
    iget v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    if-nez v1, :cond_0

    .line 271
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->this$0:Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    sget-object v2, Lcom/google/android/common/html/parser/HTML4;->TABLE_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    # invokes: Lcom/google/android/common/html/parser/HtmlTreeBuilder;->push(Lcom/google/android/common/html/parser/HTML$Element;)V
    invoke-static {v1, v2}, Lcom/google/android/common/html/parser/HtmlTreeBuilder;->access$000(Lcom/google/android/common/html/parser/HtmlTreeBuilder;Lcom/google/android/common/html/parser/HTML$Element;)V

    .line 273
    sget-object v1, Lcom/google/android/common/html/parser/HTML4;->TABLE_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/google/android/common/html/parser/HtmlDocument;->createTag(Lcom/google/android/common/html/parser/HTML$Element;Ljava/util/List;)Lcom/google/android/common/html/parser/HtmlDocument$Tag;

    move-result-object v0

    .line 275
    .local v0, "tableTag":Lcom/google/android/common/html/parser/HtmlDocument$Tag;
    iget-object v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->this$0:Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    # getter for: Lcom/google/android/common/html/parser/HtmlTreeBuilder;->tree:Lcom/google/android/common/html/parser/HtmlTree;
    invoke-static {v1}, Lcom/google/android/common/html/parser/HtmlTreeBuilder;->access$100(Lcom/google/android/common/html/parser/HtmlTreeBuilder;)Lcom/google/android/common/html/parser/HtmlTree;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/google/android/common/html/parser/HtmlTree;->addStartTag(Lcom/google/android/common/html/parser/HtmlDocument$Tag;)V

    .line 277
    iget v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    .line 279
    .end local v0    # "tableTag":Lcom/google/android/common/html/parser/HtmlDocument$Tag;
    :cond_0
    return-void
.end method


# virtual methods
.method finish()V
    .locals 3

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 264
    iget v0, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    invoke-static {v0}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 265
    iget v0, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->state:I

    if-nez v0, :cond_1

    :goto_1
    invoke-static {v1}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 266
    return-void

    :cond_0
    move v0, v2

    .line 264
    goto :goto_0

    :cond_1
    move v1, v2

    .line 265
    goto :goto_1
.end method

.method seeEndTag(Lcom/google/android/common/html/parser/HtmlDocument$EndTag;)V
    .locals 4
    .param p1, "endTag"    # Lcom/google/android/common/html/parser/HtmlDocument$EndTag;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 232
    invoke-virtual {p1}, Lcom/google/android/common/html/parser/HtmlDocument$EndTag;->getElement()Lcom/google/android/common/html/parser/HTML$Element;

    move-result-object v0

    .line 234
    .local v0, "element":Lcom/google/android/common/html/parser/HTML$Element;
    iget v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    if-lez v1, :cond_1

    invoke-virtual {v0}, Lcom/google/android/common/html/parser/HTML$Element;->getType()I

    move-result v1

    if-ne v1, v2, :cond_1

    .line 236
    sget-object v1, Lcom/google/android/common/html/parser/HTML4;->TD_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    invoke-virtual {v1, v0}, Lcom/google/android/common/html/parser/HTML$Element;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lcom/google/android/common/html/parser/HTML4;->TR_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    invoke-virtual {v1, v0}, Lcom/google/android/common/html/parser/HTML$Element;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lcom/google/android/common/html/parser/HTML4;->TH_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    invoke-virtual {v1, v0}, Lcom/google/android/common/html/parser/HTML$Element;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 240
    :cond_0
    iput v3, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->state:I

    .line 251
    :cond_1
    :goto_0
    return-void

    .line 242
    :cond_2
    sget-object v1, Lcom/google/android/common/html/parser/HTML4;->CAPTION_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    invoke-virtual {v1, v0}, Lcom/google/android/common/html/parser/HTML$Element;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 243
    iput v3, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->state:I

    goto :goto_0

    .line 245
    :cond_3
    sget-object v1, Lcom/google/android/common/html/parser/HTML4;->TABLE_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    invoke-virtual {v1, v0}, Lcom/google/android/common/html/parser/HTML$Element;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 246
    iget v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    if-lez v1, :cond_4

    move v1, v2

    :goto_1
    invoke-static {v1}, Lcom/google/android/common/base/X;->assertTrue(Z)V

    .line 247
    iget v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    .line 248
    iget v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    if-lez v1, :cond_5

    :goto_2
    iput v2, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->state:I

    goto :goto_0

    :cond_4
    move v1, v3

    .line 246
    goto :goto_1

    :cond_5
    move v2, v3

    .line 248
    goto :goto_2
.end method

.method seeTag(Lcom/google/android/common/html/parser/HtmlDocument$Tag;)V
    .locals 3
    .param p1, "tag"    # Lcom/google/android/common/html/parser/HtmlDocument$Tag;

    .prologue
    const/4 v2, 0x1

    .line 196
    invoke-virtual {p1}, Lcom/google/android/common/html/parser/HtmlDocument$Tag;->getElement()Lcom/google/android/common/html/parser/HTML$Element;

    move-result-object v0

    .line 197
    .local v0, "element":Lcom/google/android/common/html/parser/HTML$Element;
    invoke-virtual {v0}, Lcom/google/android/common/html/parser/HTML$Element;->getType()I

    move-result v1

    if-ne v1, v2, :cond_5

    .line 199
    sget-object v1, Lcom/google/android/common/html/parser/HTML4;->TABLE_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    invoke-virtual {v1, v0}, Lcom/google/android/common/html/parser/HTML$Element;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 200
    iget v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    if-lez v1, :cond_0

    .line 201
    invoke-direct {p0}, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->ensureCellState()V

    .line 203
    :cond_0
    iget v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    .line 204
    const/4 v1, 0x0

    iput v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->state:I

    .line 229
    :cond_1
    :goto_0
    return-void

    .line 208
    :cond_2
    invoke-direct {p0}, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->ensureTableState()V

    .line 211
    sget-object v1, Lcom/google/android/common/html/parser/HTML4;->TD_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    invoke-virtual {v1, v0}, Lcom/google/android/common/html/parser/HTML$Element;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    sget-object v1, Lcom/google/android/common/html/parser/HTML4;->TH_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    invoke-virtual {v1, v0}, Lcom/google/android/common/html/parser/HTML$Element;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 213
    :cond_3
    iput v2, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->state:I

    goto :goto_0

    .line 215
    :cond_4
    sget-object v1, Lcom/google/android/common/html/parser/HTML4;->CAPTION_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    invoke-virtual {v1, v0}, Lcom/google/android/common/html/parser/HTML$Element;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 216
    const/4 v1, 0x2

    iput v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->state:I

    goto :goto_0

    .line 220
    :cond_5
    iget v1, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    if-lez v1, :cond_1

    .line 224
    sget-object v1, Lcom/google/android/common/html/parser/HTML4;->FORM_ELEMENT:Lcom/google/android/common/html/parser/HTML$Element;

    invoke-virtual {v1, v0}, Lcom/google/android/common/html/parser/HTML$Element;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 225
    invoke-direct {p0}, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->ensureCellState()V

    goto :goto_0
.end method

.method seeText(Lcom/google/android/common/html/parser/HtmlDocument$Text;)V
    .locals 1
    .param p1, "textNode"    # Lcom/google/android/common/html/parser/HtmlDocument$Text;

    .prologue
    .line 256
    iget v0, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->tables:I

    if-lez v0, :cond_0

    iget v0, p0, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->state:I

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/google/android/common/html/parser/HtmlDocument$Text;->isWhitespace()Z

    move-result v0

    if-nez v0, :cond_0

    .line 259
    invoke-direct {p0}, Lcom/google/android/common/html/parser/HtmlTreeBuilder$TableFixer;->ensureCellState()V

    .line 261
    :cond_0
    return-void
.end method
