.class public Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;
.super Ljava/lang/Object;
.source "ComposeActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/compose/ComposeActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendOrSaveMessage"
.end annotation


# instance fields
.field final mAccount:Lcom/android/mail/providers/ReplyFromAccount;

.field final mRefMessageId:Ljava/lang/String;

.field final mRequestId:I

.field public final mSave:Z

.field final mValues:Landroid/content/ContentValues;


# direct methods
.method public constructor <init>(Lcom/android/mail/providers/ReplyFromAccount;Landroid/content/ContentValues;Ljava/lang/String;Z)V
    .locals 2
    .param p1, "account"    # Lcom/android/mail/providers/ReplyFromAccount;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "refMessageId"    # Ljava/lang/String;
    .param p4, "save"    # Z

    .prologue
    .line 1890
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1891
    iput-object p1, p0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mAccount:Lcom/android/mail/providers/ReplyFromAccount;

    .line 1892
    iput-object p2, p0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mValues:Landroid/content/ContentValues;

    .line 1893
    iput-object p3, p0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mRefMessageId:Ljava/lang/String;

    .line 1894
    iput-boolean p4, p0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mSave:Z

    .line 1895
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mValues:Landroid/content/ContentValues;

    invoke-virtual {v0}, Landroid/content/ContentValues;->hashCode()I

    move-result v0

    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v1

    xor-int/2addr v0, v1

    iput v0, p0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mRequestId:I

    .line 1896
    return-void
.end method


# virtual methods
.method requestId()I
    .locals 1

    .prologue
    .line 1899
    iget v0, p0, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->mRequestId:I

    return v0
.end method
