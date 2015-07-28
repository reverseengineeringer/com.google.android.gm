.class public Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;
.super Lcom/android/mail/browse/ConversationOverlayItem;
.source "ConversationViewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/ConversationViewAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "SuperCollapsedBlockItem"
.end annotation


# instance fields
.field private mEnd:I

.field private final mStart:I

.field final synthetic this$0:Lcom/android/mail/browse/ConversationViewAdapter;


# direct methods
.method private constructor <init>(Lcom/android/mail/browse/ConversationViewAdapter;II)V
    .locals 0
    .param p2, "start"    # I
    .param p3, "end"    # I

    .prologue
    .line 270
    iput-object p1, p0, Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-direct {p0}, Lcom/android/mail/browse/ConversationOverlayItem;-><init>()V

    .line 271
    iput p2, p0, Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;->mStart:I

    .line 272
    iput p3, p0, Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;->mEnd:I

    .line 273
    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/browse/ConversationViewAdapter;IILcom/android/mail/browse/ConversationViewAdapter$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/browse/ConversationViewAdapter;
    .param p2, "x1"    # I
    .param p3, "x2"    # I
    .param p4, "x3"    # Lcom/android/mail/browse/ConversationViewAdapter$1;

    .prologue
    .line 265
    invoke-direct {p0, p1, p2, p3}, Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;-><init>(Lcom/android/mail/browse/ConversationViewAdapter;II)V

    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Z)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "measureOnly"    # Z

    .prologue
    .line 290
    move-object v0, p1

    check-cast v0, Lcom/android/mail/browse/SuperCollapsedBlock;

    .line 291
    .local v0, "scb":Lcom/android/mail/browse/SuperCollapsedBlock;
    invoke-virtual {v0, p0}, Lcom/android/mail/browse/SuperCollapsedBlock;->bind(Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;)V

    .line 292
    return-void
.end method

.method public canPushSnapHeader()Z
    .locals 1

    .prologue
    .line 309
    const/4 v0, 0x1

    return v0
.end method

.method public createView(Landroid/content/Context;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "inflater"    # Landroid/view/LayoutInflater;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 282
    const v1, 0x7f040069

    const/4 v2, 0x0

    invoke-virtual {p2, v1, p3, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/SuperCollapsedBlock;

    .line 284
    .local v0, "scb":Lcom/android/mail/browse/SuperCollapsedBlock;
    iget-object v1, p0, Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;->this$0:Lcom/android/mail/browse/ConversationViewAdapter;

    # getter for: Lcom/android/mail/browse/ConversationViewAdapter;->mSuperCollapsedListener:Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;
    invoke-static {v1}, Lcom/android/mail/browse/ConversationViewAdapter;->access$800(Lcom/android/mail/browse/ConversationViewAdapter;)Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/SuperCollapsedBlock;->initialize(Lcom/android/mail/browse/SuperCollapsedBlock$OnClickListener;)V

    .line 285
    return-object v0
.end method

.method public getEnd()I
    .locals 1

    .prologue
    .line 304
    iget v0, p0, Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;->mEnd:I

    return v0
.end method

.method public getStart()I
    .locals 1

    .prologue
    .line 300
    iget v0, p0, Lcom/android/mail/browse/ConversationViewAdapter$SuperCollapsedBlockItem;->mStart:I

    return v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 277
    const/4 v0, 0x3

    return v0
.end method

.method public isContiguous()Z
    .locals 1

    .prologue
    .line 296
    const/4 v0, 0x1

    return v0
.end method
